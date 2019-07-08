package com.juju.common.util;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;

public class XMLReaderUtil {
    public static Document getDocFromXML(String path) {

        File f = new File(path);

        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = null;
        Document dt = null;
        try {
            // 返回documentBuilderFactory对象
            dbf = DocumentBuilderFactory.newInstance();
            // 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
            db = dbf.newDocumentBuilder();
            // 得到一个DOM并返回给document对象
            dt = db.parse(f);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dt;
    }

    public static Document getDocFromXML(InputStream is) {
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = null;
        Document dt = null;
        try {
            // 返回documentBuilderFactory对象
            dbf = DocumentBuilderFactory.newInstance();
            // 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
            db = dbf.newDocumentBuilder();

            //去掉dtd校验
            db.setEntityResolver(new IgnoreDTDEntityResolver());

            // 得到一个DOM并返回给document对象
            dt = db.parse(is);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dt;
    }
}
