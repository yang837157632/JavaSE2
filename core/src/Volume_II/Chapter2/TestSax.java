package Volume_II.Chapter2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by Star Yang on 2017/5/15.
 */
public class TestSax {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse("E:\\IDEA\\Workspace\\core\\Resource\\xml\\SaxClass.xml" , new MyDeafultHandler());
    }
}

class MyDeafultHandler extends DefaultHandler {

    private boolean flag = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document......");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Element : " + qName);
        if("name".equals(qName) || "age".equals(qName))
            flag = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String name = new String(ch, start, length);
        if (!"".equals(name.trim()) && flag){
            flag = false;
            System.out.println(name);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Element : " + qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document......");
    }
}