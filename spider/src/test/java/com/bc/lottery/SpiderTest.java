package com.bc.lottery;

import com.bc.lottery.common.enums.LotteryTypeEnum;
import com.bc.lottery.spider.pipeline.DBPipleline;
import com.bc.lottery.spider.process.WubaiwanPageProcessor;
import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpiderTest {

//    @Autowired
//    KuaiSanURLS kuaiSanURLS;

    @Test
    public void test() {
        Spider.create(new WubaiwanPageProcessor(LotteryTypeEnum.KuaiSan.HUBEI)).
                addPipeline(new DBPipleline()).
                addUrl("https://kaijiang.500.com/static/info/kaijiang/xml/hbk3/20180918.xml").run();

        //System.out.println("========================================" + JsonMapper.defaultMapper().toJson(kuaiSanURLS.getHebei()) + "========================================");
    }
}