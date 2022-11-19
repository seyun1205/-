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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println(username);
        System.out.println(password);
        Map map = new HashMap();
        if(userService.getUsersByUsername(username)==null){
                Users user =new Users();
                user.setUsername(username);
                user.setPassword(password);
                user.setIdentify(1);
                userService.add(user);
                map.put("msg","注册成功！");
        }
        else{
            map.put("msg","用户名已存在！");
        }
        String json = JSON.toJSONString(map);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
