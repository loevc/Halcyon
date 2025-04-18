package org.loevc.halcyon.creational.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShipLogistics extends Logistics {

    public Ship createTransport(){
        log.info("create ship logistic");
        return new Ship();
    }
}
