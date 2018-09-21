package Volume_I.Chapter8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/19.
 */
public class B_PlatFrame {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame2 frame = new MyFrame2();
                frame.setTitle("UI PlatFrame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame2 extends JFrame{
    private JPanel panel;
    private final static int DEFAULT_WIDTH = 600;
    private final static int DEFAULT_HEIGHT = 400;

    public MyFrame2(){
        panel = new JPanel();
        add(panel);
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info: infos){
            makeButton(info.getName(),info.getClassName());
        }
    }

    void makeButton(String name , final String platName){
        JButton button  = new JButton(name);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    UIManager.setLookAndFeel(platName);
                    SwingUtilities.updateComponentTreeUI(MyFrame2.this);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
}
