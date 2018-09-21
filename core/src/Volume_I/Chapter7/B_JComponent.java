package Volume_I.Chapter7;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Star Yang on 2017/1/18.
 */
public class B_JComponent {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame2 frame = new MyFrame2();
                frame.setTitle("JComponent");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame2 extends JFrame{
    public MyFrame2(){
        this.add(new MyComponent());
        pack();
    }

}

class MyComponent extends JComponent{
    private static final int MESSAGE_X = 75;
    private static final int MESSAGE_Y = 100;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g){
        g.drawString("Merry Christmas****",MESSAGE_X , MESSAGE_Y);
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
