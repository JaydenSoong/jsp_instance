package com.jayden.user.web.servlet;

import com.jayden.user.domain.User;
import com.jayden.user.exception.UserExistException;
import com.jayden.user.service.UserService;
import com.jayden.utils.bean.CommonUtils;

import java.io.IOException;
import java.util.Map;

@javax.servlet.annotation.WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    private UserService service = new UserService();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取到注册表单参数组成的 Map
        Map<String, String[]> map = request.getParameterMap();
        // 将 Map 通过自定义工具直接转成 User 对象
        User user = CommonUtils.toBean(map, com.jayden.user.domain.User.class);
        // 添加用户
        try {
            service.register(user);
            response.getWriter().write("注册成功");
        } catch (UserExistException e) {
            request.setAttribute("userExist", e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
