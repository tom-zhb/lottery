package com.bc.lottery.utils;


import com.bc.lottery.utils.mapper.JsonMapper;

public class MyTest {

    public static void main(String[] args) {
        JsonMapper jsonMapper = JsonMapper.defaultMapper();
        String json = "";

//        JSON.parseObject(text, clazz, FastjsonSeriAndDeseri.deseriInstance(), new Feature[0]);



//
//        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));

        /*LinkedHashMap<String, String> jsonMap = JSON.parseObject(jsonStr, new TypeReference<LinkedHashMap<String, String>>(){});
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }*/

//        System.out.println(map.get("msg").toString());

//        Map<String,Object> map = jsonMapper.fromJson(json, Map.class);

//        LinkedHashMap<String,Object> map2 = (LinkedHashMap<String, Object>) map.get("msg");



//        LinkedHashMap<String, Object> map3 = (LinkedHashMap<String, Object>) map2.get("data"); //jsonMapper.fromJson(map2.get("data").toString(), Map.class);
//        System.out.println(jsonMapper.toJson(map3));


//        map3.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));


//        LinkedHashMap<String, Object> map4 = (LinkedHashMap<String, Object>) map3.get("sn_data");

//        LinkedHashMap<String, Object> map5 = (LinkedHashMap<String, Object>) map4.get(map3.get("sn").toString());

//        System.out.println(map5.get("page_index"));

//        map4.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));



//        System.out.println(map4.get("page_index"));
//        Map<String, Object> map2 = jsonMapper.fromJson(map.get("msg").toString(), Map.class);
//        map2.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        /*

        Map<String, Object> map3 = jsonMapper.fromJson(map2.get("data").toString(), Map.class);

        if (map3.get("type").toString().equals("user")) {
//            return;
        }

        if (map3.get("type").toString().equals("board")) { //ppt的要存入
//            return;
            Map<String, Object> map4 = jsonMapper.fromJson(map3.get("sn_data").toString(), Map.class);
            map4.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        }*/

        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(System.currentTimeMillis()/1000L));
        System.out.println(date);
    }
}
