package Volume_I.Chapter8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by Star Yang on 2017/1/29.
 */
public class D_Mouse {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame4 frame = new MyFrame4();
                frame.setTitle("Mouse");
                frame.setSize(300,400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame4 extends JFrame{
    public MyFrame4(){
        add(new MyComponent4());
    }
}

class MyComponent4 extends JComponent{
    private static final int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public MyComponent4(){
        squares = new ArrayList<Rectangle2D>();
        current = null;
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        for(Rectangle2D rectangle2D: squares){
            g2.draw(rectangle2D);
        }
    }

    public Rectangle2D find(Point2D point2D){
        for(Rectangle2D rectangle2D: squares){
            if(rectangle2D.contains(point2D)){
                return rectangle2D;
            }
        }
        return null;
    }

    public void add(Point2D point2D){
        double x= point2D.getX();
        double y=point2D.getY();

        current = new Rectangle2D.Double(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D rectangle2D){
        if(rectangle2D==null) return;
        if(rectangle2D==current) current = null;
        squares.remove(rectangle2D);
        repaint();
    }

    private class MouseHandler extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event) {
            current = find(event.getPoint());
            if(current==null){
                add(event.getPoint());
            }
        }

        @Override
        public void mouseClicked(MouseEvent event) {
            if(event.getClickCount()>=2){
                current = find(event.getPoint());
                if(current!=null){
                    remove(current);
                }
            }
        }
    }

    private class MouseMotionHandler extends MouseMotionAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
            if(find(e.getPoint())==null){
                setCursor(Cursor.getDefaultCursor());
            }else{
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(current!=null){
                int x = e.getX();
                int y = e.getY();
                current.setFrame(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
                repaint();
            }
        }
    }
}
