package com.bc.lottery.utils;

import java.util.Date;

public class StudentsJsonTest {

    /*public static void main(String[] args) {
        JsonMapper jsonMapper = JsonMapper.defaultMapper();
        String json = "{\"type\":\"user\",\"action\":\"mouse\",\"is_open\":true,\"role\":\"2\",\"uid\":null,\"is_all\":true,\"user_info\":{\"students\":{\"9267\":{\"has_mouse_access\":true},\"9268\":{\"has_mouse_access\":true},\"15882\":{\"has_mouse_access\":true}}}}";

        LinkedHashMap<String, Object> tmp = jsonMapper.fromJson(json, LinkedHashMap.class);
        LinkedHashMap<String, Object> studentsMap = Maps.newLinkedHashMap();

        LinkedHashMap<String, Object> map2 = (LinkedHashMap<String, Object>) tmp.get("user_info");
        LinkedHashMap<String, Object> map3 = (LinkedHashMap<String, Object>) map2.get("students");

        map3.forEach((k, v) -> {

            if (studentsMap.get(k) == null) {
                studentsMap.put(k, v);
            } else {
                LinkedHashMap<String, Object> studentsMapTmp = (LinkedHashMap<String, Object>) studentsMap.get(k);

                LinkedHashMap<String, Object> map3tmp = (LinkedHashMap<String, Object>) v;

                map3tmp.forEach((tk, tv) -> {
                    studentsMapTmp.put(tk, tv);
                });

                studentsMap.put(k, studentsMapTmp);
            }

        });

        System.out.println(studentsMap);

    }*/

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
    }

}
