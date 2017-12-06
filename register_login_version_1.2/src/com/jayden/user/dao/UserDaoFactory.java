package com.jayden.user.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {
    private static Properties props = null;
    static {
        try {
            // 通过类加载器的 getResourceAsStream() 来获取流
            InputStream in = UserDaoFactory.class.getClassLoader().getResourceAsStream("UserDao.properties");
            props = new Properties();
            // 加载流
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return 返回一个具体的 UserDao 对象
     */
    public static UserDao getUserdao() {
        try {
            Class clazz = Class.forName(props.getProperty("com.jayden.user.dao.UserDao"));
            return (UserDao) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
