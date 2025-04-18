package org.loevc.halcyon.creational.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ship implements Transport {
    @Override
    public void deliver() {
        log.info("ship deliver");
    }
}
