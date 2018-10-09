package com.bc.lottery.spider.pipeline;

import com.bc.lottery.common.enums.LotteryTypeEnum;
import com.bc.lottery.common.service.KuaiSanService;
import com.bc.lottery.common.utils.GenericsUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

@Component
public class DBPipleline implements Pipeline {

    @Autowired
    KuaiSanService kuaiSanService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<Map<String, Object>> dataList = resultItems.get("data");
        LotteryTypeEnum type = resultItems.get("lotteryType");
        if (CollectionUtils.isNotEmpty(dataList)) {
            if (type instanceof LotteryTypeEnum.KuaiSan) {
                kuaiSanService.save(type, dataList);
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println(GenericsUtils.getSuperClassGenricType(KuaiSan.class));
         System.out.println(GenericsUtils.getSuperClassGenricType(DBPipleline.class));
        //System.out.println(new GetGeneric<KuaiSan>(){}.getTClass());
//        if (type.equals(KuaiSan.class)) {
//        }
    }
}
