package com.example.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 17-4-13.
 */
public class WXUtils {

    /**
     * xml转成map
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String,String> map=new HashMap<String,String>();
        SAXReader reader=new SAXReader();
        InputStream ins=request.getInputStream();
        Document doc=reader.read(ins);
        Element root=doc.getRootElement();
        List<Element> list=root.elements();
        for(Element e:list){
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }
}
