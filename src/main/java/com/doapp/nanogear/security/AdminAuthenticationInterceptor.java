package com.doapp.nanogear.security;

import com.doapp.nanogear.model.data.Users;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Kiểm tra xác thực ở đây
        // Nếu xác thực thành công, return true; nếu không, có thể chuyển hướng đến login;
        HttpSession session = request.getSession();
        Object loggedInUser = session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            Users user = (Users) loggedInUser; // Cast loggedInUser về Users object
            String userRoleValue = user.getRole();
            if ("ADMIN".equalsIgnoreCase(userRoleValue)) {
                return true;
            }
            return false;
        } else {
            // Người dùng chưa đăng nhập, chuyển hướng về trang đăng nhập hoặc xử lý khác
            response.sendRedirect("/login");
            return false;
        }
    }
}

