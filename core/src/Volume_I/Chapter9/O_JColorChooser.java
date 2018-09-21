package Volume_I.Chapter9;

import Volume_I.Chapter9.Info.ColorPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class O_JColorChooser {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame15 frame = new MyFrame15();
                frame.setTitle("JColorChooser");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame15 extends JFrame{
    public MyFrame15(){
        add(new ColorPanel());
        setSize(400 ,300);
    }
}
