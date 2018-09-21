package Volume_I.Chapter9.Info;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class PasswordChooser extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser(){
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.add(new JLabel("Username"));
        panel.add(username=new JTextField(""));
        panel.add(new JLabel("Password"));
        panel.add(password=new JPasswordField(""));
        add(panel,BorderLayout.CENTER);

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ok = true;
                dialog.setVisible(false);
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel,BorderLayout.SOUTH);
    }

    public void setUser(User user){
        username.setText(user.getUsername());
        password.setText(user.getPassword());
    }

    public User getUser(){
        return new User(username.getText(),new String(password.getPassword()));
    }

    public boolean showDialog(Component parent , String title){
        ok = false;
        Frame owner = null;
        if(parent instanceof Frame) owner = (Frame)parent;
        else owner = (Frame)SwingUtilities.getAncestorOfClass(Frame.class,parent);
        //在组件层次结构中搜索上面的 comp 的便捷方法，返回它找到的类 c 的第一个对象。如果无法找到类 c，可以返回 null。

        if(dialog==null || dialog.getOwner() != owner){
            dialog = new JDialog(owner , true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}
