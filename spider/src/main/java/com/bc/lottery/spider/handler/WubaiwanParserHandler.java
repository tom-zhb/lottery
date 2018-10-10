package com.bc.lottery.spider.handler;

import com.bc.lottery.spider.xml.AbstractXMLParserHandler;
import org.apache.commons.lang3.ArrayUtils;
import org.xml.sax.Attributes;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WubaiwanParserHandler extends AbstractXMLParserHandler<Map<String, Object>> {

    @Override
    protected String[] getFields() {
        return new String[]{"expect", "opencode", "opentime"};
    }

    @Override
    public Map<String, Object> parseField(String[] fields, Attributes attributes) throws ParseException, IllegalAccessException, InstantiationException {
        Map<String, Object> map = null;
        if (ArrayUtils.isNotEmpty(fields)) {
            map = new HashMap<>();
            map.put("issue", attributes.getValue(getFields()[0]));
            map.put("number", attributes.getValue(getFields()[1]));
            map.put("openTime", attributes.getValue(getFields()[2]));
            //kuaiSan = (HubeiKS) GenericsUtils.getSuperClassGenricType(getClass()).newInstance();
          /*  for (String field : fields) {
                if (StringUtils.isNoneBlank(field)) {
                    kuaiSan.setIssue(attributes.getValue(getFields()[0]));
                    kuaiSan.setNumber(attributes.getValue(getFields()[1]));
                    kuaiSan.setOpenTime(DateUtils.parseDate(attributes.getValue(getFields()[2]),
                            "yyyy-MM-dd HH:mm:ss"));
                }
            }*/
        }
        return map;
    }
}