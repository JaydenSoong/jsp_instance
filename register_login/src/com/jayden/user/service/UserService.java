package com.jayden.user.service;

import com.jayden.user.dao.UserDao;
import com.jayden.user.domain.User;
import com.jayden.user.exception.UserExistException;
import org.dom4j.DocumentException;


public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 注册方法
     * @param user, 用来注册的用户
     * @throws UserExistException
     */
    public void register(User user) throws UserExistException{
        if (userDao.findUser(user.getUsername()) == null){
            userDao.addUser(user);
        } else {
            throw new UserExistException("用户名 “" + user.getUsername() + "” 已经被注册过了");
        }
    }
}
