package Volume_I.Chapter3;

import java.io.Console;

/**
 * Created by Star Yang on 2017/1/8.
 */
public class A_Console {
    public static void main(String[] args) {
        Console console = System.console();
        if(console==null){
            System.out.print("System console is unavailable");
            return;
        }
        String username = console.readLine("User name: ");
        char[] password = console.readPassword("Password: ");
        System.out.println(username + "*****" + password);
    }
}
