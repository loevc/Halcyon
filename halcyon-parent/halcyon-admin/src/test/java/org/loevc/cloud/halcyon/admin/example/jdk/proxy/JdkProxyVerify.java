package org.loevc.cloud.halcyon.admin.example.jdk.proxy;

public class JdkProxyVerify {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.sendSms();
    }
}
