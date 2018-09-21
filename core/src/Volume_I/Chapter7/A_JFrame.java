package Volume_I.Chapter7;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Star Yang on 2017/1/18.
 */
public class A_JFrame {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame myFrame = new MyFrame();
                myFrame.setTitle("JFrame");
                myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                myFrame.setVisible(true);
            }
        });

    }
}

class MyFrame extends JFrame{
    public MyFrame(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        this.setSize(width/2 , height/2);
        this.setLocationByPlatform(true);
        Image img = new ImageIcon("out/production/core/img/2.jpg").getImage();
        this.setIconImage(img);
    }
}
