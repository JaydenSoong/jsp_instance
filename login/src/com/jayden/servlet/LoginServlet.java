package com.jayden.servlet;

import com.jayden.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码
        response.setCharacterEncoding("utf-8");
        // 从表单参数中得到数据，并封装成 User 对象
        User user = new User(request.getParameter("username"), request.getParameter("password"));

        // 处理逻辑
        if (user.getName().equals("Jayden") && user.getPass().equals("123456")) {
            // 验证通过，将 user 对象保存到 session 中。
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // 新建 cookie
            Cookie cookie = new Cookie("cname", user.getName());
            // 保存一天
            cookie.setMaxAge(60*60*24);
            // 将用户名保存在 cookie 中
            response.addCookie(cookie );

            // 重定向到登录成功页面
            response.setHeader("Location", "/login/succ1.jsp");
            response.setStatus(302);
        } else {
            // 验证失败，将错误信息保存到 request 域中。
            request.setAttribute("msg", "用户名或密码错误!");
            // 请求转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
