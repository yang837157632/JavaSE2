package Volume_I.Chapter7;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Star Yang on 2017/1/19.
 */
public class E_Image {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame5 frame = new MyFrame5();
                frame.setTitle("Image");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame5 extends JFrame{
    public MyFrame5(){
        add(new MyComponent5());
        pack();
    }
}

class MyComponent5 extends JComponent{
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;
    private Image image;

    public MyComponent5(){
        image = new ImageIcon("out/production/core/img/1.gif").getImage();
    }

    public void paintComponent(Graphics g){
        if(image==null) return;
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        g.drawImage(image ,0,0,null);

        for(int i=0;i*imageWidth<=getWidth();i++){
            for (int j=0;j*imageHeight<=getHeight();j++){
                if(i+j>0){
                    g.copyArea(0,0,imageWidth,imageHeight,i*imageWidth,j*imageHeight);
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH , DEFAULT_HEIGHT);
    }
}

