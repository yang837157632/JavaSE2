package Volume_II.Chapter1;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Star Yang on 2017/4/26.
 */
public class H_Match {
    public static void main(String[] args){
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Please input : ");
            String urlString = in.nextLine();
            InputStreamReader isr = new InputStreamReader(new URL(urlString).openStream());
            StringBuilder sb = new StringBuilder();
            int ch;
            while((ch=isr.read())!=-1)
                sb.append((char)ch);
            System.out.println(sb);

            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(sb);

            while(matcher.find()){
                int start = matcher.start();
                int end = matcher.end();
                String match = sb.substring(start,end);
                System.out.println(match+"*****");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
