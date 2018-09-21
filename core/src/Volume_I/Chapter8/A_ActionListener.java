package Volume_I.Chapter8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/19.
 */
public class A_ActionListener {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame frame = new MyFrame();
                frame.setTitle("ActionListener");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame extends JFrame{
    private JPanel panel;
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    public MyFrame(){
        this.setSize(DEFAULT_WIDTH , DEFAULT_HEIGHT);
        panel = new JPanel();
        add(panel);

        JButton yellowButton = new JButton("YELLOE");
        JButton redButton = new JButton("RED");
        JButton greenButton = new JButton("GREEN");

        ColorAction yellowListener = new ColorAction(Color.YELLOW);
        ColorAction redListener = new ColorAction(Color.RED);
        ColorAction greenListener = new ColorAction(Color.GREEN);

        yellowButton.addActionListener(yellowListener);
        redButton.addActionListener(redListener);
        greenButton.addActionListener(greenListener);

        panel.add(yellowButton);
        panel.add(redButton);
        panel.add(greenButton);
    }

    private class ColorAction implements ActionListener{
        private Color bgcolor;

        public ColorAction( Color color){
            bgcolor = color;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(bgcolor);
        }
    }
}
