package org.loevc.Halcyon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;

@SpringBootTest
class HalcyonApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testSort(){
        int[][] items = new int[10][5];
        int[] querys = new int[10];

        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(querys);
    }

}
