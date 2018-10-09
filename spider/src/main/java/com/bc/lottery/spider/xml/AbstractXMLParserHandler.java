package com.bc.lottery.spider.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractXMLParserHandler<T> extends DefaultHandler {
    private final List<T> dataList = new ArrayList<>();

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    /**
     * 用来标识解析结束
     *
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

    /**
     * 解析xml元素,每到开始标签都会调用下面这个方法
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        int num = attributes.getLength();
        if (num > 0) {
            try {
                dataList.add(parseField(getFields(), attributes));
            } catch (ParseException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract String[] getFields();

    public List<T> getDataList() {
        return dataList;
    }

    public abstract T parseField(String[] fields, Attributes attributes) throws ParseException, IllegalAccessException, InstantiationException;

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    /**
     * @param ch     char[] ch代表整个xml文档的内容
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println(value);
        }
    }
}
