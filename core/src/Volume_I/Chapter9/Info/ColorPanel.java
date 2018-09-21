package Volume_I.Chapter9.Info;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class ColorPanel extends JPanel {
    public ColorPanel(){
        JButton modalButton = new JButton("Modal");
        modalButton.addActionListener(new ModalListener());
        add(modalButton);

        JButton modelessButton = new JButton("Modeless");
        modelessButton.addActionListener(new ModelessListener());
        add(modelessButton);

        JButton immediateButton = new JButton("Immediate");
        immediateButton.addActionListener(new ImmediateListener());
        add(immediateButton);
    }

    private class ModalListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Color defaultColor = getBackground();
            Color selected = JColorChooser.showDialog(ColorPanel.this,"Set Background",defaultColor);
            if(selected!=null) setBackground(selected);
        }
    }

    private class ModelessListener implements ActionListener{
        private JDialog dialog;
        private JColorChooser chooser;
        public ModelessListener(){
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog(ColorPanel.this, "Background Color", false, chooser, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBackground(chooser.getColor());
                }
            },null);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }

    private class ImmediateListener implements ActionListener{
        private JDialog dialog;
        private JColorChooser chooser;
        public ImmediateListener(){
            chooser = new JColorChooser();
            chooser.getSelectionModel().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    setBackground(chooser.getColor());
                }
            });
            dialog = new JDialog((Frame)null,false);
            dialog.add(chooser);
            dialog.pack();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }
}
