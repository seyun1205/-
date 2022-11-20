package front.all.servlet;

import com.alibaba.fastjson.JSON;
import front.all.pojo.Comment;
import front.all.pojo.Users;
import front.all.service.CommentService;
import front.all.service.impl.CommentServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/comment/*")
public class CommentServlet extends BaseServlet {
    private CommentService commentService = new CommentServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Comment> list = commentService.selectAll();
        String jsonString = JSON.toJSONString(list);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        String username = req.getParameter("username");
        String nickname = req.getParameter("nickname");
        String content = req.getParameter("content");
        String ctime = req.getParameter("ctime");
        long datee = Long.valueOf(ctime);
        Date date = new Date(datee);
        System.out.println(date);
        resp.setContentType("text/html;charset=utf-8");
        Map map = new HashMap();

        Comment comment =new Comment();
        comment.setUsername(username);
        comment.setNickname(nickname);
        comment.setContent(content);
        comment.setCtime(date);
        commentService.add(comment);
        map.put("msg","发表成功！");

        String json = JSON.toJSONString(map);
        resp.getWriter().write(json);
    }
}
