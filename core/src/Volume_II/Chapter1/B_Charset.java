package Volume_II.Chapter1;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by Star Yang on 2017/4/14.
 */
public class B_Charset {
    @Test
    public void test1(){
        Charset cset = Charset.forName("ISO-8859-1");
        Set<String> aliases = cset.aliases();
        for (String  alias : aliases)
            System.out.println(alias);
    }

    @Test
    public void test2(){
        Map<String , Charset> charsets = Charset.availableCharsets();
        for (String name: charsets.keySet())
            System.out.println(name);
    }

    @Test
    public void test3(){
        Charset cset = Charset.forName("ISO-8859-1");;
        String str = "Freedom";
        ByteBuffer buffer = cset.encode(str);
        byte[] bytes = buffer.array();
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test4(){
        Charset cset = Charset.forName("ISO-8859-1");
        byte[] bytes = new byte[]{70, 114, 101, 101, 100, 111, 109};
        ByteBuffer bbuf = ByteBuffer.wrap(bytes , 0 ,5);
        CharBuffer cbuf = cset.decode(bbuf);
        System.out.println(cbuf);
    }
}
