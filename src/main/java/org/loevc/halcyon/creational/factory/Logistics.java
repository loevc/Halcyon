package org.loevc.halcyon.creational.factory;


import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchProviderException;
@Slf4j
public class Logistics {

    public void planDelivery(){
        log.info("super create transport");
        Transport t = createTransport();
        log.info("super deliver");
        t.deliver();
    }


    public Transport createTransport(){
        // this way of writing is not capture the exception
        throw new RuntimeException("not support this call");
    }
}
