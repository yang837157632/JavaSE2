package Volume_II.Chapter2;

import org.w3c.dom.*;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Field;

/**
 * Created by Star Yang on 2017/5/7.
 */
public class B_Xml {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFileChooser chooser  = new JFileChooser("read");
                chooser.showOpenDialog(null);
                File file = chooser.getSelectedFile();
                JFrame frame = new FontFrame(file);
                frame.setTitle("XML GridBag Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class FontFrame extends JFrame{
    private GridBagPane gridbag;
    private JComboBox<String> face;
    private JComboBox<String> size;
    private JCheckBox bold;
    private JCheckBox italic;

    public FontFrame(File file) {
        gridbag = new GridBagPane(file);
        add(gridbag);

        face = (JComboBox<String>)gridbag.get("face");
        size = (JComboBox<String>) gridbag.get("size");
        bold = (JCheckBox) gridbag.get("bold");
        italic = (JCheckBox) gridbag.get("italic");

        face.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Serif", "SansSerif" , "Monospaced" , "Dialog" , "DialogInput"
        }));

        size.setModel(new DefaultComboBoxModel<String>(new String[]{
                "8" , "10" , "12" , "15" , "18" , "24" , "36" , "48"
        }));

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSample();
            }
        };

        face.addActionListener(listener);
        size.addActionListener(listener);
        bold.addActionListener(listener);
        italic.addActionListener(listener);
        setSample();
        pack();
    }

    public void setSample(){
        String fontFace = face.getItemAt(face.getSelectedIndex());
        int fontSize = Integer.parseInt(size.getItemAt(size.getSelectedIndex()));
        JTextArea sample = (JTextArea) gridbag.get("sample");
        int fontStyle = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0);
        sample.setFont(new Font(fontFace , fontStyle , fontSize));
        sample.repaint();
    }
}

class GridBagPane extends JPanel{
    private GridBagConstraints constraints;

    public GridBagPane(File file) {
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            if(file.toString().contains("-schema")){
                factory.setNamespaceAware(true);
                final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
                final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
                factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            }
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            parseGridbag(document.getDocumentElement());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Component get(String name){
        Component[] components = getComponents();
        for (int i=0;i<components.length;i++){
            if(components[i].getName().equals(name))
                return components[i];
        }
        return null;
    }

    private void parseGridbag(Element e){
        NodeList rows = e.getChildNodes();
        for(int i=0;i<rows.getLength();i++){
            Element row = (Element) rows.item(i);
            NodeList cells = row.getChildNodes();
            for(int j=0;j<cells.getLength();j++){
                Element cell = (Element) cells.item(j);
                parseCell(cell , i ,j);
            }
        }
    }

    private void parseCell(Element e, int r, int c){
        String value = e.getAttribute("gridx");
        if(value.length() == 0){
            if(c==0) constraints.gridx = 0;
            else constraints.gridx += constraints.gridwidth;
        }else constraints.gridx = Integer.parseInt(value);

        value = e.getAttribute("gridy");
        if(value.length() == 0) constraints.gridy = r;
        else constraints.gridy = Integer.parseInt(value);

        constraints.gridwidth = Integer.parseInt(e.getAttribute("gridwidth"));
        constraints.gridheight = Integer.parseInt(e.getAttribute("gridheight"));
        constraints.weightx = Integer.parseInt(e.getAttribute("weightx"));
        constraints.weighty = Integer.parseInt(e.getAttribute("weighty"));
        constraints.ipadx = Integer.parseInt(e.getAttribute("ipadx"));
        constraints.ipady = Integer.parseInt(e.getAttribute("ipady"));

        Class<GridBagConstraints> cl = GridBagConstraints.class;

        try{
            String name = e.getAttribute("fill");
            Field f = cl.getField(name);
            constraints.fill = f.getInt(cl);

            name = e.getAttribute("anchor");
            f = cl.getField(name);
            constraints.anchor = f.getInt(cl);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        Component component = (Component)parseBean((Element)e.getFirstChild());
        add(component , constraints);
    }

    private Object parseBean(Element e){
        try{
            NodeList children = e.getChildNodes();
            Element classElement = (Element) children.item(0);
            String className = ((Text)classElement.getFirstChild()).getData();

            Class<?> cl = Class.forName(className);

            Object obj = cl.newInstance();

            if(obj instanceof Component) ((Component)obj).setName(e.getAttribute("id"));

            for(int i=1;i<children.getLength();i++){
                Node propertyElement  = children.item(i);
                Element nameElement = (Element) propertyElement.getFirstChild();
                String propertyName = ((Text)nameElement.getFirstChild()).getData();

                Element valueElement = (Element) propertyElement.getLastChild();
                Object value = parseValue(valueElement);
                BeanInfo beanInfo = Introspector.getBeanInfo(cl);
                PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
                boolean done = false;
                for(int j=0;!done&&j<descriptors.length;j++){
                    if(descriptors[j].getName().equals(propertyName)){
                        descriptors[j].getWriteMethod().invoke(obj, value);
                        done = true;
                    }
                }
            }
            return obj;
        }catch (Exception ex){
            ex.printStackTrace();
            return  null;
        }
    }

    private Object parseValue(Element e){
        Element child = (Element) e.getFirstChild();
        if(child.getTagName().equals("bean")) return parseBean(child);
        String text = ((Text)child.getFirstChild()).getData();
        if(child.getTagName().equals("int")) return new Integer(text);
        else if(child.getTagName().equals("boolean")) return  new Boolean(text);
        else if(child.getTagName().equals("string")) return text;
        else return null;
    }
}
