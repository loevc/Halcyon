package org.loevc.halcyon.creational.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RoadLogistics extends Logistics {


    public Truck createTransport(){
        log.info("create road logistic");
        return new Truck();
    }
}
