package com.bc.lottery.spider;

import com.bc.lottery.common.enums.LotteryTypeEnum;
import com.bc.lottery.spider.pipeline.DBPipleline;
import com.bc.lottery.spider.process.WubaiwanPageProcessor;
import com.bc.lottery.spider.url.KuaiSanURLS;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class SpiderBoot {

    private static SpiderBoot spiderBoot;

    @Autowired
    KuaiSanURLS kuaiSanURLS;

    //通过@PostConstruct实现初始化bean之前进行的操作
    @PostConstruct
    public void init() {
        spiderBoot = this;
        spiderBoot.kuaiSanURLS = this.kuaiSanURLS;
    }

    public static SpiderBoot getInstance() {
        return spiderBoot;
    }

    private String geneURL(String url, String today) {
        return String.format(url, today);
    }

    public void kuaisanStart() {
        String today = DateFormatUtils.format(new Date(), "yyyyMMdd");

        Spider.create(new WubaiwanPageProcessor(LotteryTypeEnum.KuaiSan.HUBEI)).
                addPipeline(new DBPipleline()).
                addUrl(geneURL(kuaiSanURLS.getHubei(), today)).run();

//        Spider.create(new WubaiwanPageProcessor(LotteryTypeEnum.KuaiSan.HEBEI)).
//                addPipeline(new DBPipleline()).
//                addUrl(geneURL(kuaiSanURLS.getHebei(), today)).run();
    }

}
