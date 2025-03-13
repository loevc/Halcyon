package org.loevc.Halcyon.factory;

public class SmartFactory implements UrlFactory{

    private static String smartUrl;

    @Override
    public String generate() {
        String  urlDecode = "www.{}.com";
        return String.format(urlDecode, smartUrl);
    }

    public SmartFactory(String smartUrl){
        this.smartUrl = smartUrl;
    }

}
