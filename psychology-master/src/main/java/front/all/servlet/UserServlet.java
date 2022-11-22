package front.all.servlet;


import com.alibaba.fastjson.JSON;
import front.all.pojo.Users;
import front.all.service.UserService;
import front.all.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/login/*")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    public void getUsersByUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Users users = userService.getUsersByUsername(username);
        resp.setContentType("text/html;charset=utf-8");
        System.out.println(username);
        System.out.println(password);
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

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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


    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> list = userService.selectAll();
        String jsonString = JSON.toJSONString(list);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


    public void deletename(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println(username);

        Map map = new HashMap();
        userService.deletename(username);
        map.put("msg","删除成功！");

        String json = JSON.toJSONString(map);
        resp.getWriter().write(json);
    }


    public void change(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int identify = Integer.parseInt(req.getParameter("identify"));
        resp.setContentType("text/html;charset=utf-8");

        Map map = new HashMap();
        userService.change(username,password,identify,name);
        map.put("msg","修改成功！");

        String json = JSON.toJSONString(map);
        resp.getWriter().write(json);
    }

}
