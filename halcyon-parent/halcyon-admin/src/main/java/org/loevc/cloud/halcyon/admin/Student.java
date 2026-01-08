package org.loevc.cloud.halcyon.admin;


public class Student extends Person {

    private String clazz;

    public void study(String behavior){
        System.out.println(behavior);
    }

    public Integer run(){
        return 5;
    }
}
