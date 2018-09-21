package Volume_I.Chapter11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/2/15.
 */
public class F_Debugger {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new DebuggerFrame();
                frame.setTitle("Debugger");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class DebuggerFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    public DebuggerFrame(){
        setSize(DEFAULT_WIDTH , DEFAULT_HEIGHT);
        JPanel panel = new DebuggerPanel();
        add(panel);
    }
}

class DebuggerPanel extends JPanel{
    public DebuggerPanel(){
        ActionListener listener = new ButtonListener();
        JButton yellowButton = new JButton("YELLOW");
        add(yellowButton);
        yellowButton.addActionListener(listener);

        JButton greenButton = new JButton("GREEN");
        add(greenButton);
        greenButton.addActionListener(listener);

        JButton blueButton = new JButton("BLUE");
        add(blueButton);
        blueButton.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String arg = e.getActionCommand();
            if(arg.equals("YELLOW")) setBackground(Color.YELLOW);
            else if(arg.equals("GREEN")) setBackground(Color.GREEN);
            else if(arg.equals("BLUE")) setBackground(Color.BLUE);
        }
    }
}