package com.bc.lottery;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class SpiderTest implements PageProcessor {
      // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
      private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

      @Override
      public Site getSite() {
         // TODO Auto-generated method stub
         return site;
     }

     @Override
    public void process(Page page) {
         String strXML = page.getRawText();
         // 获取SAXParserFactory实例
         SAXParserFactory factory=SAXParserFactory .newInstance();
         //获取SAXParse的实例
         try {
             SAXParser parser=factory.newSAXParser();
             //创建SAXParserHandler对象
             SAXParserHandler handler=new SAXParserHandler();

             StringReader sr = new StringReader(strXML);
             InputSource is = new InputSource(sr);
             parser.parse(is, handler);

         } catch (ParserConfigurationException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (SAXException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

    }

     @Test
    public void test(){
         Spider.create(new SpiderTest()).addUrl("https://kaijiang.500.com/static/info/kaijiang/xml/hbk3/20180918.xml").run();
     }
 }