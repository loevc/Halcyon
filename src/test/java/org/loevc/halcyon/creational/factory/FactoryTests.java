package org.loevc.halcyon.creational.factory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class FactoryTests {

    @Test
    void testFactory(){
        log.info(log.getName());
        log.warn("test road method >>>>>>>");
        Logistics logistics = new RoadLogistics();
        logistics.planDelivery();

        log.warn("test ship method >>>>>>>");
        new ShipLogistics().planDelivery();

        log.warn("test error method >>>>>>>");
        new Logistics().planDelivery();
    }
}
