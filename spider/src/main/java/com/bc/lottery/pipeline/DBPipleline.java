package com.bc.lottery.pipeline;

import com.bc.lottery.domain.lottery.HubeiKS;
import com.bc.lottery.domain.lottery.KuaiSan;
import com.bc.lottery.service.KuaiSanService;
import com.bc.lottery.utils.GenericsUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

@Component
public class DBPipleline<T> implements Pipeline {

    @Autowired
    KuaiSanService kuaiSanService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<T> dataList = resultItems.get("data");
        if (CollectionUtils.isNotEmpty(dataList)) {
            //Class type =  new GetGeneric<T>().getTClass();
            /*if (type.equals(KuaiSan.class)) {
                *//*for () {
                    kuaiSanService.save();
                }*//*
            }*/
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
