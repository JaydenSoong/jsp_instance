package com.jayden.user.dao;

import com.jayden.user.domain.User;

public interface UserDao {
    void addUser(User user);
    User findUser(String username);
}
