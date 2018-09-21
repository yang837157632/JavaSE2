package Volume_I.Chapter9.Info;

import javax.swing.*;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class ButtonPanel extends JPanel {
    private ButtonGroup group;
    public ButtonPanel(String title , String... options){
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder() , title));
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));
        group = new ButtonGroup();

        for(String option : options){
            JRadioButton button = new JRadioButton(option);
            button.setActionCommand(option);
            add(button);
            group.add(button);
            button.setSelected(option==options[0]);
        }
    }

    public String getSelection(){
        return group.getSelection().getActionCommand();
    }
}
