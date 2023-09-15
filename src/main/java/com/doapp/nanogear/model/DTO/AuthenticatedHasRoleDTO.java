package com.doapp.nanogear.model.DTO;

import javax.servlet.http.HttpSession;

public class AuthenticatedHasRoleDTO {
    public boolean isAuthenticatedAndHasRole(HttpSession session, String requiredRole) {
        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        if (session.getAttribute("loggedInUser") == null) {
            return false;
        }
        // Lấy thông tin về vai trò từ session hoặc cơ sở dữ liệu
        String userRole = (String) session.getAttribute("userRole"); // "userRole" thuộc tính chứa vai trò trong session
        // Kiểm tra vai trò của người dùng
        return userRole != null && userRole.equals(requiredRole);
    }
}
