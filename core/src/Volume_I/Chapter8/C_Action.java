package Volume_I.Chapter8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Star Yang on 2017/1/29.
 */
public class C_Action {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame3 frame = new MyFrame3();
                frame.setTitle("Action");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame3 extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    public MyFrame3(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();
        add(buttonPanel);

        Action redAction = new colorAction("RED" , new ImageIcon("out/production/core/img/5.gif") , Color.RED);
        Action greenAction = new colorAction("GREEN" , new ImageIcon("out/production/core/img/5.gif") , Color.GREEN);
        Action blueAction = new colorAction("BLUE" , new ImageIcon("out/production/core/img/5.gif") , Color.BLUE);

        buttonPanel.add(new JButton(redAction));
        buttonPanel.add(new JButton(greenAction));
        buttonPanel.add(new JButton(blueAction));

        InputMap inputMap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");
        inputMap.put(KeyStroke.getKeyStroke("ctrl G"),"panel.green");
        inputMap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");

        ActionMap actionMap = buttonPanel.getActionMap();
        actionMap.put("panel.red" , redAction);
        actionMap.put("panel.green" , greenAction);
        actionMap.put("panel.blue" , blueAction);
    }

    public class colorAction extends AbstractAction {
        public colorAction(String name, Icon icon, Color color){
            putValue(Action.NAME , name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION , "Set panel color to "+ name.toLowerCase());
            putValue("color" ,color);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Color color = (Color)getValue("color");
            buttonPanel.setBackground(color);
        }
    }
}
