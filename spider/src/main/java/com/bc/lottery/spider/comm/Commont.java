package com.bc.lottery.spider.comm;

import com.bc.lottery.common.service.KuaiSanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Commont {
    @Autowired
    KuaiSanService kuaiSanService;

    public void say() {
        System.out.println(kuaiSanService);
    }
}
