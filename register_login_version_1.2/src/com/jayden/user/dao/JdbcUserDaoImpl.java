package com.jayden.user.dao;

import com.jayden.user.domain.User;
import com.jayden.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDaoImpl implements UserDao {
    private Connection conn = JdbcUtils.getConnection();
    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO user VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public User findUser(String username) {
        User user = null;
        try{
            String sql = "SELECT * FROM user WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
