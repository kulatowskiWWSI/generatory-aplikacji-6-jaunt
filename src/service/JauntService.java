package service;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.UserAgent;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class JauntService {

    CopyOnWriteArrayList<Element> list = new CopyOnWriteArrayList<>();

    public CopyOnWriteArrayList<Element> findAllElementsByUrl(String url)
    {
        list.clear();
        try {
            UserAgent userAgent = new UserAgent();
            userAgent.visit(url);

            System.out.println(userAgent.getLocation());
            System.out.println(userAgent.getSource());

            List<Element> elements = userAgent.doc.getChildElements();

            for (Element ele : elements)
            {
                list.add(ele);
            }

            for(Element ele : list)
            {
                if(ele.getChildElements().size()>0){
                    List<Element> childEle = new ArrayList<>();
                    childEle.addAll(ele.getChildElements());
                    CopyOnWriteArrayList<Element> childCopy = new CopyOnWriteArrayList<>();
                    childEle.forEach(childCopy::add);

                    addElements(list,childCopy);
                }
            }

            list.forEach(e -> {
                System.out.println(e.getName());
            });

            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addElements(CopyOnWriteArrayList<Element> elements, CopyOnWriteArrayList<Element> child)
    {
        for(Element ele : child)
        {
            elements.add(ele);
            if(ele.getChildElements().size()>0){
                List<Element> childEle = new ArrayList<>();
                childEle.addAll(ele.getChildElements());
                CopyOnWriteArrayList<Element> childCopy = new CopyOnWriteArrayList<>();
                childEle.forEach(childCopy::add);

                addElements(elements, childCopy);
            }
        }
    }


}
