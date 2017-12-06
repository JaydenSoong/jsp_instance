package com.jayden.user.web.servlet;

import com.jayden.user.domain.User;
import com.jayden.user.exception.UserException;
import com.jayden.user.service.UserService;
import com.jayden.utils.bean.CommonUtils;

import java.io.IOException;
import java.util.Map;

/**
 * 处理 register.jsp 的请求
 */
@javax.servlet.annotation.WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    // 依赖于 UserService
    private UserService service = new UserService();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 处理请求编码各响应编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取到注册表单参数组成的 Map
        Map<String, String[]> map = request.getParameterMap();
        // 将 Map 通过自定义工具直接转成 User 对象
        User user = CommonUtils.toBean(map, com.jayden.user.domain.User.class);
        // 添加用户
        try {
            // 若没有异常，调用 UserService 的 register 方法，完成注册
            service.register(user);
            // 响应显示注册成功
            response.getWriter().write("注册成功");
        } catch (UserException e) {
            // 当捕获到异常后，将异常信息存储到 request 域中
            request.setAttribute("userExist", e.getMessage());
            // 请求转发到 register.jsp 中。异常信息将在那里得到显示
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
