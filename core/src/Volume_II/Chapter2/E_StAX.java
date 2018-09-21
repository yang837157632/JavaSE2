package Volume_II.Chapter2;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by myang on 5/22/2017.
 */
public class E_StAX {
    public static void main(String[] args) throws IOException, XMLStreamException {
        System.out.println("Please input");
        Scanner scanner = new Scanner(System.in);
        String urlString = scanner.nextLine();
        if (urlString == null || "".equals(urlString)) {
            urlString = "http://www.w3c.org";
        }
        System.out.println("*******************"+urlString+"---------");
        System.setProperty("http.proxyHost", "proxy.sgp.hp.com");
        System.setProperty("http.proxyPort", "8080");
        URL url = new URL(urlString);
        InputStream in = url.openStream();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(in);
        while(parser.hasNext()){
            int event = parser.next();
            if(event == XMLStreamConstants.START_ELEMENT){
                if(parser.getLocalName().equals("a")){
                    String href = parser.getAttributeValue(null,"href");
                    if(href!=null)
                        System.out.println(href);
                }
            }
        }
    }
}