package com.bc.lottery;

import org.junit.Test;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafter@gmai.com <br>
 */
public class JsonPathSelectorTest {

    private String text = "{ \"store\": {\n" +
            "    \"book\": [ \n" +
            "      { \"category\": \"reference\",\n" +
            "        \"author\": \"Nigel Rees\",\n" +
            "        \"title\": \"Sayings of the Century\",\n" +
            "        \"price\": 8.95\n" +
            "      },\n" +
            "      { \"category\": \"fiction\",\n" +
            "        \"author\": \"Evelyn Waugh\",\n" +
            "        \"title\": \"Sword of Honour\",\n" +
            "        \"price\": 12.99,\n" +
            "        \"isbn\": \"0-553-21311-3\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"bicycle\": {\n" +
            "      \"color\": \"red\",\n" +
            "      \"price\": 19.95\n" +
            "    }\n" +
            "  }\n" +
            "}";

    @Test
    public void testJsonPath() {
    	System.out.println("需要解析的json:"+text);

        JsonPathSelector jsonPathSelector = new JsonPathSelector("$.store.book[*].author");
        String select = jsonPathSelector.select(text);
        List<String> list = jsonPathSelector.selectList(text);

        assertThat(select).isEqualTo("Nigel Rees");
        assertThat(list).contains("Nigel Rees","Evelyn Waugh");

        jsonPathSelector = new JsonPathSelector("$.store.book[?(@.category == 'reference')]");
        list = jsonPathSelector.selectList(text);
        select = jsonPathSelector.select(text);

        System.out.println("select方法的结果:\t"+select);
        System.out.println("selectList方法的结果:\t"+list);

        assertThat(select).isEqualTo("{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"}");
        assertThat(list).contains("{\"author\":\"Nigel Rees\",\"price\":8.95,\"category\":\"reference\",\"title\":\"Sayings of the Century\"}");
    }
}