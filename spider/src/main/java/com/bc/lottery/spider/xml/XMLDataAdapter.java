package com.bc.lottery.spider.xml;

import org.apache.commons.collections.CollectionUtils;
import us.codecraft.webmagic.ResultItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XMLDataAdapter implements ResultItemsAdapter<List<Map<String, Object>>> {

    @Override
    public List<ResultItems> convertResultItems(List<Map<String, Object>> list) {
        List<ResultItems> resultItemsList = null;
        if (CollectionUtils.isNotEmpty(list)) {
            resultItemsList = new ArrayList<>();
            ResultItems items = new ResultItems();
            for (Map<String, Object> map : list) {
                if (map != null) {
                    map.forEach((k, v) -> {
                        items.put(k, v);
                    });
                    resultItemsList.add(items);
                }
            }
        }
        return resultItemsList;
    }
}
