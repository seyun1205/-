package front.all.servlet;


import com.alibaba.fastjson.JSON;
import front.all.pojo.Users;
import front.all.service.UserService;
import front.all.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Users users = userService.getUsersByUsername(username);
        resp.setContentType("text/html;charset=utf-8");
        Map map = new HashMap();
        if(users==null){
            map.put("msg","用户名不存在！");
        }
        else if(!users.getPassword().equals(password)){
            map.put("msg","密码错误！");
        }
        else {
            map.put("msg", "登录成功！");
            map.put("user",users);
        }
        String json = JSON.toJSONString(map);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
