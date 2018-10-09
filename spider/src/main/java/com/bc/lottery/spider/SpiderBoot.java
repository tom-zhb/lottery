package com.bc.lottery.spider;

import com.bc.lottery.common.enums.LotteryTypeEnum;
import com.bc.lottery.spider.pipeline.DBPipleline;
import com.bc.lottery.spider.process.WubaiwanPageProcessor;
import us.codecraft.webmagic.Spider;

public class SpiderBoot {

    public static void start() {
        Spider.create(new WubaiwanPageProcessor(LotteryTypeEnum.KuaiSan.HUBEI)).
                addPipeline(new DBPipleline()).
                addUrl("https://kaijiang.500.com/static/info/kaijiang/xml/hbk3/20180918.xml").run();
    }


}
