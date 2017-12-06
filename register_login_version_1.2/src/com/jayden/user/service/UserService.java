package com.jayden.user.service;

import com.jayden.user.dao.UserDao;
import com.jayden.user.dao.UserDaoFactory;
import com.jayden.user.domain.User;
import com.jayden.user.exception.UserException;

/**
 * 服务类，真正的业务逻辑
 */
public class UserService {
    // 通过 UserDaoFactory 返回 实现了 UserDao 接口的对象。
    private UserDao userDao = UserDaoFactory.getUserdao();

    /**
     * 注册方法，若数据库中没有给定用户的用户名，说明可以注册，调用 userDao 的添加用户方法，完成注册。
     * 否则，抛出带异常信息的自定义异常，以便 registerServlet 显示信息。
     * @param user, 用来注册的用户
     * @throws UserException, 用户名已经被注册
     */
    public void register(User user) throws UserException {
        if (userDao.findUser(user.getUsername()) == null){
            userDao.addUser(user);
        } else {
            throw new UserException("用户名 “" + user.getUsername() + "” 已经被注册过了");
        }
    }

    /**
     * 登录方法，根据获取到的用户的用户名，在数据库中查询。若查询结果为 null, 说明输入的用户是不存在的，抛出自定义异常。
     * 否则，判断输入的密码是否查询到用户的密码是否相同，若不同，则密码错误。若密码也正确，则返回查询到的用户。
     * @param user, 登录的用户
     * @return 查找到的 user
     * @throws UserException，用户名或密码错误
     */
    public User login(User user) throws UserException {
        User _user = userDao.findUser(user.getUsername());
        if (_user == null) throw new UserException("用户名错误");
        if (!_user.getPassword().equals(user.getPassword())) throw new UserException("密码错误");
        return _user;
    }
}
