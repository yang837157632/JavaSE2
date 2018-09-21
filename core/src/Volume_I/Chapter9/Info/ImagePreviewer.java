package Volume_I.Chapter9.Info;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class ImagePreviewer extends JLabel {
    public ImagePreviewer(JFileChooser chooser){
        setPreferredSize(new Dimension(100 , 100));
        setBorder(BorderFactory.createEtchedBorder());
        chooser.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if(evt.getPropertyName()==JFileChooser.SELECTED_FILE_CHANGED_PROPERTY){
                    File file = (File)evt.getNewValue();
                    if(file==null){
                        setIcon(null);
                        return;
                    }
                    ImageIcon icon = new ImageIcon(file.getPath());
                    if(icon.getIconWidth()>getWidth())
                        icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth() , -1 , Image.SCALE_DEFAULT));
                    setIcon(icon);
                }
            }
        });
    }
}
