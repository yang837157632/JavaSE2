package Volume_I.Chapter7;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Star Yang on 2017/1/18.
 */
public class D_Font {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame4 frame = new MyFrame4();
                frame.setTitle("Font");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame4 extends JFrame{
    public MyFrame4(){
        add(new MyComponent4());
        pack();
    }
}

class MyComponent4 extends JComponent{
    private static final int DEFAULT_WIDTH =500;
    private static final int DEFAULT_HEIGHT =300;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        String message = "Happy New Year";
        Font font = new Font("Serif", Font.BOLD,36);
        g2.setFont(font);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(message , context);

        double x = (getWidth() - bounds.getWidth())/2;
        double y = (getHeight() - bounds.getHeight())/2;

        double ascent = -bounds.getY();
        double baseY = y + ascent;

        g2.drawString(message,(int)x,(int)baseY);

        g2.setPaint(Color.RED);
        g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));
        Rectangle2D rectangle2D = new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
        g2.draw(rectangle2D);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH , DEFAULT_HEIGHT);
    }
}
