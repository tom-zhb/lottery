package com.bc.lottery;

import com.bc.lottery.pipeline.DBPipleline;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

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
            WubaiwanParserHandler handler = new WubaiwanParserHandler();
            factory.newSAXParser().parse(new InputSource(new StringReader(page.getRawText())), handler);
            System.out.println(handler.getFieldValues().toString());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        Spider.create(new SpiderTest()).addPipeline(new DBPipleline()).
                addUrl("https://kaijiang.500.com/static/info/kaijiang/xml/hbk3/20180918.xml").run();
    }
}