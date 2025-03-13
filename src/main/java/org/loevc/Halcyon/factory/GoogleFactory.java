package org.loevc.Halcyon.factory;

public class GoogleFactory implements UrlFactory {
    @Override
    public String generate() {
        return "www.google.com";
    }
}
