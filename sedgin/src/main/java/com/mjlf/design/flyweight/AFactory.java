package com.mjlf.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AFactory
 * @Author mjlft
 * @Date 2020/11/25 18:06
 * @Version 1.0
 * @Description TODO
 */
public class AFactory {

    private Map<String, WebSite> map = new HashMap<>();

    public WebSite getWebSite(String type){
        if(!map.containsKey(type)){
            map.put(type, new NetWebSite(type));
        }
        return map.get(type);
    }

    public void showNum(){
        System.out.println("数量" + map.size());
    }
}
