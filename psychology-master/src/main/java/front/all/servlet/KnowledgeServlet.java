package front.all.servlet;

import com.alibaba.fastjson.JSON;
import front.all.pojo.Knowledge;
import front.all.service.KnowledgeService;
import front.all.service.impl.KnowledgeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/knowledge/*")
public class KnowledgeServlet extends BaseServlet {
    private KnowledgeService knowledgeService = new KnowledgeServiceImpl();

    public void getKnowledgeByContent(HttpServletRequest req,HttpServletResponse resp)throws ServletException ,IOException{

        String searchStr=req.getParameter("searchStr"); //传过来的关键字

        List<Knowledge> list=knowledgeService.getKnowledgeByContent(searchStr);
        resp.setContentType("text/html;charset=utf-8");

        System.out.println(searchStr);  //打印显示


        //判断
        String json=JSON.toJSONString(list);
        resp.getWriter().write(json);
    }

    public void addKnowledge(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        String content_title=req.getParameter("content_title");
        String content=req.getParameter("content");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println(content_title);
        System.out.println(content);
        Map map=new HashMap();
        if(knowledgeService.getKnowledgeByContent(content)==null){
            Knowledge knowledge=new Knowledge();
            knowledge.setContent_title(content_title);
            knowledge.setContent(content);
            knowledgeService.addKnowledge(content_title,content);
            map.put("msg","添加成功!");
            map.put("msg","添加成功!");
        }else{
            map.put("msg","添加失败!");
        }
        String json=JSON.toJSONString(map);
        resp.getWriter().write(json);
    }

    public void selectAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        List<Knowledge> list=knowledgeService.selectAll();
        String jsonString =JSON.toJSONString(list);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void deleteKnowledge(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        String content_title=req.getParameter("content_title");
        String content=req.getParameter("content");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println(content_title);
        System.out.println(content);
        Map map=new HashMap();
        knowledgeService.deleteKnowledge(content_title);
        map.put("msg","删除成功！");

        String json=JSON.toJSONString(map);
        resp.getWriter().write(json);
    }

    public void changeKnowledge(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        String new_title=req.getParameter("new_title");
        String content_title=req.getParameter("content_title");
        String content=req.getParameter("content");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println(content_title);
        System.out.println(content);
        Map map=new HashMap();
        knowledgeService.changeKnowledge(content_title,content,new_title);
        map.put("msg","修改成功!");

        String json=JSON.toJSONString(map);
        resp.getWriter().write(json);
    }
}
