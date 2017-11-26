package com.jayden.utils.bean;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

public class CommonUtils {
    /**
     * 生成 32 位长的不重复的大写字符串
     * @Author Jayden
     * @Date 2017/11/21 0:22
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static <T> T toBean(Map map, Class<T> clazz) {
        try {
            // 创建指定类型的 javaBean 对象
            T bean = clazz.newInstance();
            // 把 map 封装到 JavaBean 中
            BeanUtils.populate(bean, map);
            // 返回 javaBean
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
