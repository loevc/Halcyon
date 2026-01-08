package org.loevc.cloud.halcyon.admin;

public class Demo {

    public static void main(String[] args) {
        Student alice  = new Student();
        Student bob    = new Student();
        Student candy  = new Student();

        bob.age = "20";
        bob.name = "qq";


        System.out.println(bob.age);
        bob.study("read");

        alice.study("dance");

    }
}
