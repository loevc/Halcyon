package org.loevc.cloud.halcyon.admin.example.bytecode;

import org.openjdk.jol.info.ClassLayout;

public class ViewBytecode {

    public static void main(String[] args) {
        Object obj = new Object();
        Integer integer = new Integer(1);
        Person person = new Person();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println(ClassLayout.parseInstance(integer).toPrintable());
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
    }

    static class Person{
        private String name;
        private int age;
    }
}
