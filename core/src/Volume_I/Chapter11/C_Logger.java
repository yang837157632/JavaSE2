package Volume_I.Chapter11;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by Star Yang on 2017/2/10.
 */
public class C_Logger {
    @Test
    public void test1(){
        Logger log = Logger.getLogger("xml");
        log.setLevel(Level.INFO);
        Logger log1 = Logger.getLogger("xml");
        System.out.println(log==log1);
        Logger log2 = Logger.getLogger("XML");
        log2.setLevel(Level.WARNING);
        log.info("aaa");
        log2.info("bbb");
        log.fine("fine");
//        Level SEVERE WARNING INFO CONFIG FINE FINER FINEST
    }

    @Test
    public void test2() throws IOException {
        Logger log = Logger.getLogger("xml");
        log.setLevel(Level.WARNING);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        log.addHandler(consoleHandler);
        log.info("aaa");
        log.warning("bbb");

        Logger log2 = Logger.getLogger("class");
        FileHandler fileHandler = new FileHandler("E:\\admin\\123.log");
        fileHandler.setLevel(Level.FINE);
        log2.addHandler(fileHandler);
        log2.info("FileHandle");
        log2.fine("fine");
    }

    @Test
    public void test3() throws IOException {
        Logger logger = Logger.getLogger("JAVA");
        FileHandler fileHandler = new FileHandler("E:\\admin\\123%g.log");
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new MyLoggerHandler());
        logger.addHandler(fileHandler);
        logger.info("Hello World");
        logger.fine("Youth");

    }

    class MyLoggerHandler extends Formatter{
        @Override
        public String format(LogRecord record) {
            return record.getLoggerName()+" -- "+record.getLevel()+" : "+record.getMessage()+"\n";
        }
    }
}
