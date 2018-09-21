package Volume_I.Chapter9.Info;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.io.File;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class FileIconView extends FileView{
    private FileFilter filter;
    private Icon icon;

    public FileIconView(FileFilter filter , Icon icon){
        this.filter = filter;
        this.icon = icon;
    }

    public Icon getIcon(File file){
        if(!file.isDirectory()&&filter.accept(file))
            return icon;
        else return null;
    }
}
