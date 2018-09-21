package Volume_I.Chapter9;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/29.
 */
public class E_Border {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame5 frame = new MyFrame5();
                frame.setTitle("Border");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame5 extends JFrame{
    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup group;

    public MyFrame5(){
        demoPanel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Lowered bevel",BorderFactory.createLoweredBevelBorder());
        addRadioButton("Raised bevel",BorderFactory.createRaisedBevelBorder());
        addRadioButton("Etched",BorderFactory.createEtchedBorder());
        addRadioButton("Line",BorderFactory.createLineBorder(Color.RED));
        addRadioButton("Matte",BorderFactory.createMatteBorder(10,10,10,10,Color.GREEN));
        addRadioButton("Empty",BorderFactory.createEmptyBorder());

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched,"Border types");
        buttonPanel.setBorder(titled);

        setLayout(new GridLayout(2,1));
        add(demoPanel);
        add(buttonPanel);
        setSize(600,200);
        setLocationByPlatform(true);
    }

    public void addRadioButton(String name,final Border border){
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                demoPanel.setBorder(border);
            }
        });
        group.add(button);
        buttonPanel.add(button);
    }
}