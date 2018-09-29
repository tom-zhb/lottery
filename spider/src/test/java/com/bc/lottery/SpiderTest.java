package com.bc.lottery;

import com.bc.lottery.domain.lottery.HubeiKS;
import com.bc.lottery.url.KuaiSanURLS;
import com.bc.lottery.utils.mapper.JsonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiderTest implements PageProcessor {
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        try {
            // 获取SAXParserFactory实例
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // 创建SAXParserHandler对象
            WubaiwanKuaisanParserHandler handler = new WubaiwanKuaisanParserHandler();
            factory.newSAXParser().parse(new InputSource(new StringReader(page.getRawText())), handler);
            List<HubeiKS> kuaiSanList = handler.getDataList();
            page.putField("data", kuaiSanList);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    KuaiSanURLS kuaiSanURLS;

    @Test
    public void test() {
        /*Spider.create(new SpiderTest())
                .addPipeline(new DBPipleline<KuaiSan>()).
                addUrl("https://kaijiang.500.com/static/info/kaijiang/xml/hbk3/20180918.xml").run();*/

        System.out.println("========================================" + JsonMapper.defaultMapper().toJson(kuaiSanURLS.getHebei()) + "========================================");
    }
}