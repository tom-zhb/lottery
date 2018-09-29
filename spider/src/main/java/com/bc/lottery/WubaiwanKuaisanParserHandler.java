package com.bc.lottery;

import com.bc.lottery.domain.lottery.HubeiKS;
import com.bc.lottery.utils.GenericsUtils;
import com.bc.lottery.xml.AbstractXMLParserHandler;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.xml.sax.Attributes;

import java.text.ParseException;

public class WubaiwanKuaisanParserHandler extends AbstractXMLParserHandler<HubeiKS> {

    @Override
    protected String[] getFields() {
        return new String[]{"expect", "opencode", "opentime"};
    }

    @Override
    public HubeiKS parseField(String[] fields, Attributes attributes) throws ParseException, IllegalAccessException, InstantiationException {
        HubeiKS kuaiSan = null;
        if (ArrayUtils.isNotEmpty(fields)) {
            kuaiSan = (HubeiKS) GenericsUtils.getSuperClassGenricType(getClass()).newInstance();
            for (String field : fields) {
                if (StringUtils.isNoneBlank(field)) {
                    kuaiSan.setIssue(attributes.getValue(getFields()[0]));
                    kuaiSan.setNumber(attributes.getValue(getFields()[1]));
                    kuaiSan.setOpenTime(DateUtils.parseDate(attributes.getValue(getFields()[2]),
                            "yyyy-MM-dd HH:mm:ss"));
                }
            }
        }
        return (HubeiKS) kuaiSan;
    }
}