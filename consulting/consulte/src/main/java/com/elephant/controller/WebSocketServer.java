package com.elephant.controller;

import com.alibaba.fastjson.JSON;
import com.elephant.entity.CounselorRecords;
import com.elephant.mapper.CounselorRecordsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 */
@Component
@ServerEndpoint("/websocket/{account}")
public class WebSocketServer {

    private CounselorRecordsMapper counselorRecordsMapper;
    private static ApplicationContext applicationContext;
    public static Map<String, WebSocketServer> clients = new HashMap<String, WebSocketServer>();
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    public static Integer onlineCount = 0;
    private Session session;
    public String account;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        WebSocketServer.applicationContext = applicationContext;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("account") String account) {
        this.account = account;
        this.session = session;
        addOnlineCount();
        clients.put(account, this);
        log.warn("已连接:" + account);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        //解析message
        Map<String, Object> msgMap = (Map<String, Object>) JSON.parse(message);
        String sendId = String.valueOf(msgMap.get("sendId"));
        String receiverId = String.valueOf(msgMap.get("receiverId"));
        String msgBody = String.valueOf(msgMap.get("message"));
        //存储记录
        counselorRecordsMapper = applicationContext.getBean(CounselorRecordsMapper.class);
        CounselorRecords counselorRecords = new CounselorRecords();
        counselorRecords.setMessage(msgBody);
        counselorRecords.setFromUserId(Long.parseLong(sendId));
        counselorRecords.setToUserId(Long.parseLong(receiverId));
        counselorRecords.setCreateTime(LocalDateTime.now().toString());
        counselorRecordsMapper.insert(counselorRecords);
        //广播信息
        if (clients.containsKey(receiverId)) {
            clients.get(receiverId).session.getBasicRemote().sendText(message);
        } else {
            msgMap.put("autoMsg", "自动回复:您好,我暂时有事不在线~,上线以后会给您回复");
            message = JSON.toJSONString(msgMap);
        }
        clients.get(sendId).session.getBasicRemote().sendText(message);
    }

    @OnClose
    public void onClose() {
        clients.remove(account);
        subOnlineCount();
        log.warn("断开" + account);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    public static synchronized Map<String, WebSocketServer> getClients() {
        return clients;
    }

    public static synchronized Integer getOnlineCount() {
        return onlineCount;
    }

}
