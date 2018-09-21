package Volume_I.Chapter7;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Star Yang on 2017/1/18.
 */
public class C_Graphics {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame3 frame = new MyFrame3();
                frame.setTitle("Graphics");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame3 extends JFrame{
    public MyFrame3(){
        this.add(new MyComponent3());
        pack();
    }
}

class MyComponent3 extends JComponent{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        double left = 100;
        double top = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rectangle2D = new Rectangle2D.Double(left, top, width, height);
        g2.draw(rectangle2D);

        Ellipse2D ellipse2D = new Ellipse2D.Double();
        ellipse2D.setFrame(rectangle2D);
        g2.draw(ellipse2D);

        g2.draw(new Line2D.Double(left, top, left + width, top + height));

        double centerX = rectangle2D.getCenterX();
        double centerY = rectangle2D.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH , DEFAULT_HEIGHT);
    }
}
