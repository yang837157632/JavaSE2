package Volume_I.Chapter11;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

/**
 * Created by Star Yang on 2017/2/10.
 */
public class D_Logger {
    public static void main(String[] args){
        if(System.getProperty("java.util.logging.config.class")==null&&System.getProperty("java.util.logging.config.file")==null){
            try{
                Logger.getLogger("Volume_I.Chapter11").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/D_Logger.log",0,LOG_ROTATION_COUNT);
                Logger.getLogger("Volume_I.Chapter11").addHandler(handler);
            }catch(IOException e){
                Logger.getLogger("Volume_I.Chapter11").log(Level.SEVERE,"Can't create log file handler" ,e);
            }
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Handler handler = new WindowHandler();
                handler.setLevel(Level.ALL);
                Logger.getLogger("Volume_I.Chapter11").addHandler(handler);

                JFrame frame = new MyFrame();
                frame.setTitle("Logging");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Logger.getLogger("Volume_I.Chapter11").fine("Showing frame");
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private static Logger logger = Logger.getLogger("Volume_I.Chapter11");

    public MyFrame(){
        logger.entering("MyFrame","<init>");
        setSize(DEFAULT_WIDTH , DEFAULT_HEIGHT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });

        label = new JLabel();
        add(label);
        logger.exiting("MyFrame","<init>");
    }

    private class FileOpenListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.entering("MyFrame.FileOpenListener","actionPerformed",e);

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("F:\\Pictures\\gif"));

            chooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif")||f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });
            int r = chooser.showOpenDialog(MyFrame.this);
            if(r==JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE,"Reading file {0}",name);
                label.setIcon(new ImageIcon(name));
            }else{
                logger.fine("File open dialog canceled");
                logger.exiting("MyFrame.FileOpenListener","actionPerformed");
            }
        }
    }
}

class WindowHandler extends StreamHandler{
    private JFrame frame;

    public WindowHandler(){
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200,200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);

        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {}

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                output.append(new String(b,off,len));
            }
        });
    }

    public void publish(LogRecord record){
        if(!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}
