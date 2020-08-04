package org.lxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FooProxy implements InvocationHandler {

    private Object obj;

    private FooProxy(Object obj) {
        this.obj = obj;
    }

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new FooProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}
