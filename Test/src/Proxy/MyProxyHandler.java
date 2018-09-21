package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyHandler implements InvocationHandler
{
    private Object proxied;

    public MyProxyHandler(Object proxied)
    {
        this.proxied = proxied;
    }

    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable
    {
        //在转调具体目标对象之前，可以执行一些功能处理
        System.out.println("start..."+System.currentTimeMillis());
        //转调具体目标对象的方法
        System.out.println("end..."+System.currentTimeMillis());
        return method.invoke( proxied, args);

        //在转调具体目标对象之后，可以执行一些功能处理
    }
}