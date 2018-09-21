package Volume_I.Chapter9;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Star Yang on 2017/1/29.
 */
public class G_JSlider {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame7 frame = new MyFrame7();
                frame.setTitle("Slider");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame7 extends JFrame{
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public MyFrame7(){
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());
        listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                textField.setText(""+source.getValue());
            }
        };

        JSlider slider = new JSlider();
        addSlider(slider,"Plain");

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Ticks");

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);;
        addSlider(slider,"Snap to ticks");

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider,"No track");

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider,"Inverted");

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Labels");

        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        Dictionary<Integer ,Component> labelTable = new Hashtable<Integer, Component>();
        labelTable.put(0,new JLabel("A"));
        labelTable.put(20,new JLabel("B"));
        labelTable.put(40,new JLabel("C"));
        labelTable.put(60,new JLabel("D"));
        labelTable.put(80,new JLabel("E"));
        labelTable.put(100,new JLabel("F"));
        slider.setLabelTable(labelTable);
        addSlider(slider,"Custom labels");

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        labelTable = new Hashtable<Integer, Component>();
        labelTable.put(0,new JLabel(new ImageIcon("out/production/core/img/3.gif")));
        labelTable.put(20,new JLabel(new ImageIcon("out/production/core/img/4.gif")));
        labelTable.put(40,new JLabel(new ImageIcon("out/production/core/img/5.gif")));
        labelTable.put(60,new JLabel(new ImageIcon("out/production/core/img/5.gif")));
        labelTable.put(80,new JLabel(new ImageIcon("out/production/core/img/4.gif")));
        labelTable.put(100,new JLabel(new ImageIcon("out/production/core/img/3.gif")));
        slider.setLabelTable(labelTable);
        addSlider(slider,"Icon labels");

        textField = new JTextField();
        add(sliderPanel);
        add(textField,BorderLayout.SOUTH);
        pack();
    }

    public void addSlider(JSlider slider,String description){
        slider.addChangeListener(listener);
        JPanel panel = new JPanel();
        panel.add(slider);
        panel.add(new JLabel(description));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel,gbc);
    }
}
