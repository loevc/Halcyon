package org.loevc.Halcyon.factory;

public class BaiduFactory implements UrlFactory {
    @Override
    public String generate() {
        return "www.baidu.com";
    }
}
