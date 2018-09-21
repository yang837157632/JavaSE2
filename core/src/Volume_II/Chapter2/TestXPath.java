package Volume_II.Chapter2;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Created by Star Yang on 2017/5/16.
 */
public class TestXPath {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("E:\\IDEA\\Workspace\\core\\Resource\\xml\\XPathClass.xml");

        List list = document.selectNodes("/AAA/BBB[1]/CCC[1]/DDD");
        Element element = (Element) list.get(0);
        System.out.println(element.getTextTrim());

        Element bbb = (Element) document.selectSingleNode("/AAA/BBB[last()]");
        Attribute id = bbb.attribute("id");
        System.out.println(id.getValue());
    }
}
