package Volume_I.Chapter9;

import Volume_I.Chapter9.Info.ButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class K_JOptionPane {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame11 frame = new MyFrame11();
                frame.setTitle("JOptionPane");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame11 extends JFrame{
    private ButtonPanel typePanel;
    private ButtonPanel messageTypePanel;
    private ButtonPanel messagePanel;
    private ButtonPanel optionTypePanel;
    private ButtonPanel optionsPanel;
    private ButtonPanel inputPanel;

    private String messageString = "Message";
    private Icon messageIcon = new ImageIcon("out/production/core/img/1.gif");
    private Object messageObject = new Date();
    private Component messageComponent = new SampleComponent();

    public MyFrame11(){
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2,3));

        typePanel = new ButtonPanel("Type","Message","Confirm","Option","Input");
        messageTypePanel = new ButtonPanel("Message Type","ERROR_MESSAGE","INFORMATION_MESSAGE","WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE");
        messagePanel = new ButtonPanel("Message","String","Icon","Component","Other","Object[]");
        optionTypePanel = new ButtonPanel("Confirm","DEFAULT_OPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION");
        optionsPanel = new ButtonPanel("Options","String[]","Icon[]","Object[]");
        inputPanel = new ButtonPanel("Input","Text field","Combo Box");
        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionsPanel);
        gridPanel.add(inputPanel);

        JPanel showPanel = new JPanel();
        JButton showButton = new JButton("Show");
        showButton.addActionListener(new showAction());
        showPanel.add(showButton);

        add(gridPanel,BorderLayout.CENTER);
        add(showPanel,BorderLayout.SOUTH);
        pack();
    }

    public Object getMessage(){
        String s = messagePanel.getSelection();
        if(s.equals("String")) return messageString;
        else if(s.equals("Icon")) return messageIcon;
        else if (s.equals("Component")) return messageComponent;
        else if(s.equals("Object[]")) return new Object[]{messageString,messageIcon,messageComponent,messageObject};
        else if(s.equals("Other")) return messageObject;
        else return null;
    }

    public Object[] getOptions(){
        String s = optionsPanel.getSelection();
        if(s.equals("String[]")) return new String[]{"Red","Green","Blue"};
        else if(s.equals("Icon[]")) return new Icon[]{new ImageIcon("out/production/core/img/3.gif"),
                new ImageIcon("out/production/core/img/4.gif"),new ImageIcon("out/production/core/img/5.gif")};
        else if(s.equals("Object[]")) return new Object[]{messageString,messageIcon,messageComponent,messageObject};
        else return null;
    }

    public int getType(ButtonPanel panel){
        String s = panel.getSelection();
        try{
            return JOptionPane.class.getField(s).getInt(null);
            //获取 int 类型或另一个通过扩展转换可以转换为 int 类型的基本类型的静态或实例字段的值。
        }catch(Exception e){
            return -1;
        }
    }

    private class showAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(typePanel.getSelection().equals("Confirm"))
                JOptionPane.showConfirmDialog(MyFrame11.this,getMessage(),"Title",getType(optionTypePanel),getType(messageTypePanel));
            else if(typePanel.getSelection().equals("Input")){
                if(inputPanel.getSelection().equals("Text field")){
                    JOptionPane.showInputDialog(MyFrame11.this,getMessage(),"Title",getType(messageTypePanel));
                }else{
                    JOptionPane.showInputDialog(MyFrame11.this,getMessage(),"Title",getType(messageTypePanel),
                            null,new String[]{"Red","Green","Blue"},"Blue");
                }
            }else if(typePanel.getSelection().equals("Message"))
                JOptionPane.showMessageDialog(MyFrame11.this,getMessage(),"Title",getType(messageTypePanel));
            else if(typePanel.getSelection().equals("Option"))
                JOptionPane.showOptionDialog(MyFrame11.this,getMessage(),"Title",getType(optionTypePanel),
                        getType(messageTypePanel),null,getOptions(),getOptions()[0]);
        }
    }
}

class SampleComponent extends JComponent{
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Rectangle2D rect = new Rectangle2D.Double(0,0,getWidth()-1,getHeight()-1);
        g2.setPaint(Color.YELLOW);
        g2.fill(rect);
        g2.setPaint(Color.BLUE);
        g2.draw(rect);
    }

    public Dimension getPreferredSize(){
        return new Dimension(10,10);
    }
}