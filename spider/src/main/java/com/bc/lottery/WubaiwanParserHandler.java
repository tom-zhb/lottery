package com.bc.lottery;

import com.bc.lottery.xml.AbstractXMLParserHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class WubaiwanParserHandler extends AbstractXMLParserHandler {

    @Override
    protected String[] setFields() {
        return new String[]{"expect", "opencode", "opentime"};
    }
}