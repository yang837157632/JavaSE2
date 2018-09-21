package Proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

public class Test {
    public static void main( String args[] )
    {
        RealSubject real = new RealSubject();
        Subjects proxySubject = (Subjects) Proxy.newProxyInstance(Subjects.class.getClassLoader(),
                new Class[]{Subjects.class},
                new MyProxyHandler(real));

        proxySubject.doSomething();

        //write proxySubject class binary data to file
        createProxyClassFile();
    }

    public static void createProxyClassFile()
    {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Subjects.class});
        try
        {
            FileOutputStream out = new FileOutputStream( "Test/src/Proxy/"+name + ".class" );
            out.write( data );
            out.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
