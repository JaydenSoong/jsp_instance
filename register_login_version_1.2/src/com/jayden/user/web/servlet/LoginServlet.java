package com.jayden.user.web.servlet;

import com.jayden.user.domain.User;
import com.jayden.user.exception.UserException;
import com.jayden.user.service.UserService;
import com.jayden.utils.bean.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
/**
 * 处理 login.jsp 的请求
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    // 依赖于 UserService
    private UserService service = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理请求编码和响应编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 将请求域中的表单数据封装成一个 map
        Map<String, String[]> map = request.getParameterMap();
        // 通过 CommonUtils 的 toBean 方法，将 map 转换成 User。这里需要保证 map 的 key 与表单的参数名相同。
        User user = CommonUtils.toBean(map, User.class);
        try {
            // 若没有异常，完成登录
            User _user = service.login(user);
            // 将服务类的登录方法返回的 user 信息 保存到 session 中。（登录都需要这么做）
            request.getSession().setAttribute("UserSession", _user);
            // 页面重定向到首页。
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (UserException e) {
            // 当捕获到异常后，将异常信息保存到 request 域中。
            request.setAttribute("wrong", e.getMessage());
            // 请求转发到 login.jsp 错误信息将在那里得到显示。
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
