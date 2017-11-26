package com.jayden.user.dao;

import com.jayden.user.domain.User;
import com.jayden.utils.dom4j.Dom4jUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class UserDao {
    //private final File file = new File("db/users.xml");
    private final String path = "db/users.xml";

    public void addUser(User user){
        // 得到 users.xml 的 document
        Document document = Dom4jUtils.getDocument(path);
        //SAXReader reader = new SAXReader();
        //Document document = reader.read(file);
        // 得到根节点
        Element root = document.getRootElement();

        /* 添加用户 */
        // 创建用户节点
        Element newuser = root.addElement("user");
        // 创建用户名
        newuser.addElement("username").addText(user.getUsername());
        // 创建密码
        newuser.addElement("password").addText(user.getPassword());

        // 回写
        Dom4jUtils.xmlWriters(path, document);
    }

    public User findUser(String username){
        // 得到 users.xml 的 document
        Document document = Dom4jUtils.getDocument(path);
        //SAXReader reader = new SAXReader();
        //Document document = reader.read(file);
        // 得到所有的 username 节点
        List<Node> nodes = document.selectNodes("//username");

        // 遍历
        for (Node node : nodes){
            // 查询到
            if (username.equals(node.getText())) {
                // 找到父节点
                Element userNode = node.getParent();
                // 创建将要返回的 user
                User user = new User();
                user.setUsername(username);
                user.setPassword(userNode.element("password").getText());
                // 返回 user
                return user;
            }
        }
        // 没有找到，返回 null
        return null;
    }
}
