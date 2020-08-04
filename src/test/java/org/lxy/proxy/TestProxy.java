package org.lxy.proxy;

public class TestProxy {

    public static void main(String[] args) {
        Foo foo = (Foo) FooProxy.newInstance(new Foo() {
            @Override
            public String foo(String name) {
                return "hello: " + name;
            }
        });
        System.out.println(foo.foo("Eric"));
    }



}
