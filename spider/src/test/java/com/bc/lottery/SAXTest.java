package com.bc.lottery;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

public class SAXTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String strXML = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
                "                <row  expect=\"180917059\" opencode=\"1,4,6\" opentime=\"2018-09-17 18:50:00\" \n" +
                "              /><row  expect=\"180917058\" opencode=\"3,3,5\" opentime=\"2018-09-17 18:40:00\" \n" +
                "              /><row  expect=\"180917057\" opencode=\"5,1,2\" opentime=\"2018-09-17 18:30:00\" \n" +
                "              /><row  expect=\"180917056\" opencode=\"5,6,1\" opentime=\"2018-09-17 18:20:00\" \n" +
                "              /><row  expect=\"180917055\" opencode=\"3,2,2\" opentime=\"2018-09-17 18:10:00\" \n" +
                "              /><row  expect=\"180917054\" opencode=\"6,3,3\" opentime=\"2018-09-17 18:00:00\" \n" +
                "              /><row  expect=\"180917053\" opencode=\"2,1,1\" opentime=\"2018-09-17 17:50:00\" \n" +
                "              /><row  expect=\"180917052\" opencode=\"4,2,1\" opentime=\"2018-09-17 17:40:00\" \n" +
                "              /><row  expect=\"180917051\" opencode=\"2,1,4\" opentime=\"2018-09-17 17:30:00\" \n" +
                "              /><row  expect=\"180917050\" opencode=\"3,3,3\" opentime=\"2018-09-17 17:20:00\" \n" +
                "              /><row  expect=\"180917049\" opencode=\"3,6,4\" opentime=\"2018-09-17 17:10:00\" \n" +
                "              /><row  expect=\"180917048\" opencode=\"5,5,1\" opentime=\"2018-09-17 17:00:00\" \n" +
                "              /><row  expect=\"180917047\" opencode=\"2,3,3\" opentime=\"2018-09-17 16:50:00\" \n" +
                "              /><row  expect=\"180917046\" opencode=\"2,6,1\" opentime=\"2018-09-17 16:40:00\" \n" +
                "              /><row  expect=\"180917045\" opencode=\"3,1,3\" opentime=\"2018-09-17 16:30:00\" \n" +
                "              /><row  expect=\"180917044\" opencode=\"5,1,3\" opentime=\"2018-09-17 16:20:00\" \n" +
                "              /><row  expect=\"180917043\" opencode=\"1,5,4\" opentime=\"2018-09-17 16:10:00\" \n" +
                "              /><row  expect=\"180917042\" opencode=\"6,1,2\" opentime=\"2018-09-17 16:00:00\" \n" +
                "              /><row  expect=\"180917041\" opencode=\"5,2,5\" opentime=\"2018-09-17 15:50:00\" \n" +
                "              /><row  expect=\"180917040\" opencode=\"3,1,3\" opentime=\"2018-09-17 15:40:00\" \n" +
                "              /><row  expect=\"180917039\" opencode=\"4,4,4\" opentime=\"2018-09-17 15:30:00\" \n" +
                "              /><row  expect=\"180917038\" opencode=\"5,5,6\" opentime=\"2018-09-17 15:20:00\" \n" +
                "              /><row  expect=\"180917037\" opencode=\"4,5,5\" opentime=\"2018-09-17 15:10:00\" \n" +
                "              /><row  expect=\"180917036\" opencode=\"2,3,2\" opentime=\"2018-09-17 15:00:00\" \n" +
                "              /><row  expect=\"180917035\" opencode=\"5,1,3\" opentime=\"2018-09-17 14:50:00\" \n" +
                "              /><row  expect=\"180917034\" opencode=\"3,5,6\" opentime=\"2018-09-17 14:40:00\" \n" +
                "              /><row  expect=\"180917033\" opencode=\"3,6,5\" opentime=\"2018-09-17 14:30:00\" \n" +
                "              /><row  expect=\"180917032\" opencode=\"5,4,3\" opentime=\"2018-09-17 14:20:00\" \n" +
                "              /><row  expect=\"180917031\" opencode=\"1,4,4\" opentime=\"2018-09-17 14:10:00\" \n" +
                "              /><row  expect=\"180917030\" opencode=\"4,2,3\" opentime=\"2018-09-17 14:00:00\" \n" +
                "              /><row  expect=\"180917029\" opencode=\"2,1,6\" opentime=\"2018-09-17 13:50:00\" \n" +
                "              /><row  expect=\"180917028\" opencode=\"5,4,4\" opentime=\"2018-09-17 13:40:00\" \n" +
                "              /><row  expect=\"180917027\" opencode=\"3,5,1\" opentime=\"2018-09-17 13:30:00\" \n" +
                "              /><row  expect=\"180917026\" opencode=\"2,2,2\" opentime=\"2018-09-17 13:20:00\" \n" +
                "              /><row  expect=\"180917025\" opencode=\"2,4,4\" opentime=\"2018-09-17 13:10:00\" \n" +
                "              /><row  expect=\"180917024\" opencode=\"5,6,2\" opentime=\"2018-09-17 13:00:00\" \n" +
                "              /><row  expect=\"180917023\" opencode=\"6,1,2\" opentime=\"2018-09-17 12:50:00\" \n" +
                "              /><row  expect=\"180917022\" opencode=\"1,5,5\" opentime=\"2018-09-17 12:40:00\" \n" +
                "              /><row  expect=\"180917021\" opencode=\"1,6,1\" opentime=\"2018-09-17 12:30:00\" \n" +
                "              /><row  expect=\"180917020\" opencode=\"3,3,3\" opentime=\"2018-09-17 12:20:00\" \n" +
                "              /><row  expect=\"180917019\" opencode=\"2,2,6\" opentime=\"2018-09-17 12:10:00\" \n" +
                "              /><row  expect=\"180917018\" opencode=\"2,3,1\" opentime=\"2018-09-17 12:00:00\" \n" +
                "              /><row  expect=\"180917017\" opencode=\"6,3,2\" opentime=\"2018-09-17 11:50:00\" \n" +
                "              /><row  expect=\"180917016\" opencode=\"2,4,3\" opentime=\"2018-09-17 11:40:00\" \n" +
                "              /><row  expect=\"180917015\" opencode=\"1,2,4\" opentime=\"2018-09-17 11:30:00\" \n" +
                "              /><row  expect=\"180917014\" opencode=\"4,1,3\" opentime=\"2018-09-17 11:20:00\" \n" +
                "              /><row  expect=\"180917013\" opencode=\"6,6,2\" opentime=\"2018-09-17 11:10:00\" \n" +
                "              /><row  expect=\"180917012\" opencode=\"4,5,5\" opentime=\"2018-09-17 11:00:00\" \n" +
                "              /><row  expect=\"180917011\" opencode=\"5,1,4\" opentime=\"2018-09-17 10:50:00\" \n" +
                "              /><row  expect=\"180917010\" opencode=\"3,3,1\" opentime=\"2018-09-17 10:40:00\" \n" +
                "              /><row  expect=\"180917009\" opencode=\"4,4,2\" opentime=\"2018-09-17 10:30:00\" \n" +
                "              /><row  expect=\"180917008\" opencode=\"3,3,4\" opentime=\"2018-09-17 10:20:00\" \n" +
                "              /><row  expect=\"180917007\" opencode=\"5,4,5\" opentime=\"2018-09-17 10:10:00\" \n" +
                "              /><row  expect=\"180917006\" opencode=\"6,6,3\" opentime=\"2018-09-17 10:00:00\" \n" +
                "              /><row  expect=\"180917005\" opencode=\"2,3,4\" opentime=\"2018-09-17 09:50:00\" \n" +
                "              /><row  expect=\"180917004\" opencode=\"6,4,2\" opentime=\"2018-09-17 09:40:00\" \n" +
                "              /><row  expect=\"180917003\" opencode=\"2,2,1\" opentime=\"2018-09-17 09:30:00\" \n" +
                "              /><row  expect=\"180917002\" opencode=\"4,4,2\" opentime=\"2018-09-17 09:20:00\" \n" +
                "              /><row  expect=\"180917001\" opencode=\"4,1,1\" opentime=\"2018-09-17 09:10:00\" \n" +
                "              /></xml>";

        // 获取SAXParserFactory实例
        SAXParserFactory factory=SAXParserFactory .newInstance();
        //获取SAXParse的实例
        try {
            SAXParser parser=factory.newSAXParser();
            //创建SAXParserHandler对象
            WubaiwanParserHandler handler=new WubaiwanParserHandler();

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

}