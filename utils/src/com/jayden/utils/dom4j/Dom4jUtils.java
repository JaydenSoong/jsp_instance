package com.jayden.utils.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 自定义 dom4j 的工具类
 */
public class Dom4jUtils {

    /**
     * 得到 Document
     * @param path, 想要得到哪个 xml 文件的根元素
     * @return Document
     */
    public static Document getDocument(String path){
        try {
            // 创建解析器
            SAXReader reader = new SAXReader();
            // 解析文件
            return reader.read(path);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取根元素
     * @param path, 想要获取哪个 xml 文件的根元素
     * @return Root Element
     */
    public static Element getRoot(String path){
        Document document = getDocument(path);
        return document.getRootElement();
    }

    /**
     * 回写方法
     * @param path, 将要写入到的位置
     * @param document, 需要被写入的 document
     */
    public static void xmlWriters(String path, Document document){
        // 声明 XMLWriter
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileOutputStream(path), OutputFormat.createPrettyPrint());
            // 回写
            writer.write(document);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关流
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
