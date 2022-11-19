package front.all.servlet;

import com.alibaba.fastjson.JSON;
import front.all.pojo.Question;
import front.all.pojo.Users;
import front.all.service.QuestionService;
import front.all.service.UserService;
import front.all.service.impl.QuestionServiceImpl;
import front.all.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/test2")
public class QuestionServlet extends HttpServlet {
    private QuestionService questionService = new QuestionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Question> list = questionService.selectAll();
        String jsonString = JSON.toJSONString(list);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
