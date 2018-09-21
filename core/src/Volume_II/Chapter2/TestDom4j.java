package Volume_II.Chapter2;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Star Yang on 2017/5/15.
 */
public class TestDom4j {
    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("E:\\IDEA\\Workspace\\core\\Resource\\xml\\Dom4jClass.xml"));

//        list(document.getRootElement());
//        read(document);
//        add(document);
//        delete(document);
        update(document);
    }

    public static void update(Document document) throws IOException {
        List<Element> students = document.getRootElement().elements("student");
        for(Element student : students){
            Element age = student.element("age");
            age.setText("" + (Integer.parseInt(age.getText()) + 3));
            Element name = student.element("name");
            name.addAttribute("b23" , "abc");
            name.addAttribute("nickname" ,"weekday");
        }

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream(new File("E:\\IDEA\\Workspace\\core\\Resource\\xml\\Dom4jClass.xml")),outputFormat);
        writer.write(document);
        writer.close();
    }

    public static void delete(Document document) throws IOException {
        Element student = document.getRootElement().element("student");
        student.getParent().remove(student);

        Element name = document.getRootElement().element("student").element("name");
        name.remove(name.attribute("nickname"));

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");

        XMLWriter writer = new XMLWriter(new FileOutputStream(new File("E:\\IDEA\\Workspace\\core\\Resource\\xml\\Dom4jClass.xml")),outputFormat);
        writer.write(document);
        writer.close();
    }

    public static void add(Document document) throws IOException {
        Element newStu = DocumentHelper.createElement("student");
        Element newName = DocumentHelper.createElement("name");
        newName.addAttribute("nickname" , "Fri");
        newName.setText("Friday");
        Element newAge = DocumentHelper.createElement("age");
        newAge.setText("32");
        Element newIntro = DocumentHelper.createElement("intro");
        newIntro.setText("Looking for the weekend");
        newStu.add(newName);
        newStu.add(newAge);
        newStu.add(newIntro);
        document.getRootElement().add(newStu);

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");

        XMLWriter writer = new XMLWriter(new FileOutputStream(new File("E:\\IDEA\\Workspace\\core\\Resource\\xml\\Dom4jClass.xml")) , outputFormat);
        writer.write(document);
        writer.close();
    }

    public static void read(Document document){
        Element root = document.getRootElement();
        Element student = (Element) root.elements("student").get(0);
        Element name = student.element("name");
        System.out.println(name.getTextTrim() +" : " + name.attributeValue("nickname"));

    }

    public static void list(Element element){
        System.out.println(element.getName() + " : " + element.getTextTrim());
        Iterator iterator = element.elementIterator();
        while (iterator.hasNext()){
            Element ele = (Element) iterator.next();
            list(ele);
        }
    }
}
