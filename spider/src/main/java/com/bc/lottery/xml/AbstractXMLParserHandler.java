package com.bc.lottery.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AbstractXMLParserHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    //用来标识解析结束
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

    //解析xml元素,每到开始标签都会调用下面这个方法
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        // 调用defaultHandler类的startElement方法
        super.startElement(uri, localName, qName, attributes);
        // row  expect="180917059" opencode="1,4,6" opentime="2018-09-17 18:50:00
        int num = attributes.getLength();//返回book元素下属性的个数
        if (num > 0) {
            String expect = attributes.getValue("expect");
            String opencode = attributes.getValue("opencode");
            String opentime = attributes.getValue("opentime");

            System.out.println("expect:" + expect);
            System.out.println("opencode:" + opencode);
            System.out.println("opentime:" + opentime);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // 调用defaultHandler类的startElement方法
        super.endElement(uri, localName, qName);
    }

    @Override
    //char[] ch代表整个book.xml文档的内容
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println(value);
        }
    }
}
