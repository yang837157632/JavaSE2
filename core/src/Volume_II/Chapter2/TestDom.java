package Volume_II.Chapter2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

/**
 * Created by Star Yang on 2017/5/15.
 */
public class TestDom {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("E:\\IDEA\\Workspace\\core\\Resource\\xml\\DomClass.xml");
        System.out.println(document);

//        list(document);
//        read(document);
//        add(document);
//        delete(document);
        update(document);
    }

    public static void update(Document document) throws TransformerException {
        Element student = (Element) document.getElementsByTagName("student").item(0);
        Element name = (Element) student.getElementsByTagName("name").item(0);
        name.setTextContent("Fire");
        name.setAttribute("sex" ,"M");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document),  new StreamResult("E:\\IDEA\\Workspace\\core\\Resource\\xml\\DomClass.xml"));

    }

    public static void delete(Document document) throws TransformerException {
        Element student = (Element) document.getElementsByTagName("student").item(0);
        student.removeAttribute("sex");

        Element student2 = (Element) document.getElementsByTagName("student").item(4);
        student2.getParentNode().removeChild(student2);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document) , new StreamResult("E:\\IDEA\\Workspace\\core\\Resource\\xml\\DomClass.xml"));
    }

    public static void add(Document document) throws TransformerException {
        Element newStu = document.createElement("student");
        newStu.setAttribute("sex" , "M");

        Element newName = document.createElement("name");
        newName.setTextContent("Mars");
        Element newAge = document.createElement("age");
        newAge.setTextContent("20");
        Element newIntro = document.createElement("intro");
        newIntro.setTextContent("Red Planet");
        newStu.appendChild(newName);
        newStu.appendChild(newAge);
        newStu.appendChild(newIntro);

        document.getDocumentElement().appendChild(newStu);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document) , new StreamResult("E:\\IDEA\\Workspace\\core\\Resource\\xml\\DomClass.xml"));

    }

    public static void read(Document document){
        NodeList nodeList = document.getElementsByTagName("student");
        Element student = (Element) nodeList.item(0);
        System.out.println(student.getAttribute("sex"));
        Element age = (Element) student.getElementsByTagName("age").item(0);
        System.out.println(age.getTextContent());
    }

    public static void list(Node node){
        if(node.getNodeType()==node.ELEMENT_NODE)
            System.out.println("name : "+node.getNodeName());
        NodeList nodeList = node.getChildNodes();
        for(int i=0;i<nodeList.getLength();i++){
            Node n = nodeList.item(i);
            list(n);
        }
    }
}
