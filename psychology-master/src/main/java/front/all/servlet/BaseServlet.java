package front.all.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 替换HttpServlet，根据请求的最后一段路径来进行方法分发
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的路径
        String uri = req.getRequestURI();
        //获取最后一段路径（方法名）
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);

        //执行方法
        //获取UserService等字节码对象Class
        Class<? extends BaseServlet> cls = this.getClass();
        //获取Method对象
        try {
            Method method = cls.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //执行方法
    }
}
