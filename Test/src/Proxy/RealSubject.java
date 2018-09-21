package Proxy;

public class RealSubject implements Subjects
{
    public void doSomething()
    {
        System.out.println( "call doSomething()" );
    }
}