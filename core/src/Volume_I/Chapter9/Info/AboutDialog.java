package Volume_I.Chapter9.Info;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner){
        super(owner,"About Dialog",true);
        add(new JLabel("<html><h1><i>Core Java</i></h1><hr>By Carl Horstmann and Gary Cornell</html>"),BorderLayout.CENTER);
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        pack();
    }
}
