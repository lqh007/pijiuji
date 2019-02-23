package com.pijiuji.util;

import com.pijiuji.bean.Pjj;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapTrunBean {

    public static Map<String,Object> beanToMap(Object object){
        Map map = new HashMap();
        if (object == null) {
            return map;
        }
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(),field.get(object));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
