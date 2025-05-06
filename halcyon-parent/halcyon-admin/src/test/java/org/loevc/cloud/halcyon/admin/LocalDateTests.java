package org.loevc.cloud.halcyon.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class LocalDateTests {

    @Test
    void testLocalDate(){
        LocalDate localDate = LocalDate.of(2025, 5, 6);
        LocalDate previousDate = localDate.minusDays(285);
        System.out.println(previousDate);
    }
}
