package Volume_I.Chapter3;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Star Yang on 2017/1/8.
 */
public class C_FileInputOutput {
    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        System.out.println("System directory: "+dir);

        Path path = Paths.get(dir+"\\out\\production\\core\\txt\\1.txt");
        Scanner file1 = new Scanner(path);
        System.out.println("path : "+file1.nextLine());

        String pathName = path.toString();
        Scanner file2 = new Scanner(pathName);
        System.out.println("string: " + file2.nextLine());

        PrintWriter out = new PrintWriter(pathName);
        out.println("xyz");
        out.println("ABCDEFG");
        out.println("1234567");
        out.close();
    }
}
