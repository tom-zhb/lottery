package com.bc.lottery.spider.process;

import com.bc.lottery.common.enums.LotteryTypeEnum;
import com.bc.lottery.spider.handler.WubaiwanParserHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

public class WubaiwanPageProcessor implements PageProcessor {
    private LotteryTypeEnum lotteryTypeEnum;

    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public WubaiwanPageProcessor(LotteryTypeEnum lotteryTypeEnum) {
        this.lotteryTypeEnum = lotteryTypeEnum;
    }

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
            page.putField("data", handler.getDataList());
            page.putField("lotteryType", lotteryTypeEnum);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
