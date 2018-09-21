package Volume_I.Chapter9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Star Yang on 2017/1/30.
 */
public class I_JToolBar {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame9 frame = new MyFrame9();
                frame.setTitle("JToolBar");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame9 extends JFrame{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;
    private JPanel panel;

    public MyFrame9(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        panel = new JPanel();
        add(panel);

        Action red = new ColorAction("RED",new ImageIcon("out/production/core/img/3.gif"), Color.RED);
        Action green = new ColorAction("GREEN",new ImageIcon("out/production/core/img/4.gif"),Color.GREEN);
        Action blue = new ColorAction("BlUE",new ImageIcon("out/production/core/img/5.gif"),Color.BLUE);
        JToolBar toolBar = new JToolBar("Change Color",SwingConstants.VERTICAL);
        toolBar.add(red);
        toolBar.add(green);
        toolBar.add(blue);
        toolBar.addSeparator();
        toolBar.add(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(toolBar, BorderLayout.WEST);
    }

    public class ColorAction extends AbstractAction{
        private Color color;

        public ColorAction(String name, Icon icon, Color color) {
            super(name, icon);
            this.color = color;
            putValue(Action.SHORT_DESCRIPTION,"Change Color to "+name );
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(color);
        }
    }
}
