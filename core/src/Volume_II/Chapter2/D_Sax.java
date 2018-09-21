package Volume_II.Chapter2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Star Yang on 2017/5/19.
 */
public class D_Sax {
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        System.out.print("Please input :");
        String s = new Scanner(System.in).nextLine();
        String url;
        if(s.length()==0){
            url = "http://www.w3c.org";
            System.out.println("Using " +url);
        }else url = s;

        DefaultHandler handler = new DefaultHandler(){
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if(localName.equals("a") && attributes!=null){
                    for(int i=0;i<attributes.getLength();i++){
                        String aname = attributes.getLocalName(i);
                        if (aname.equals("href"))
                            System.out.println(attributes.getValue(i)+"******\t" + i);
                    }
                }
            }
        };

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true);
        saxParserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd",false);
        SAXParser saxParser = saxParserFactory.newSAXParser();
        InputStream inputStream = new URL(url).openStream();
        saxParser.parse(inputStream,handler);
    }
}
