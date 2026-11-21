package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class QDW196Q1 {

    class Solution {
        public String[] assignUmbrella(int[] rain) {
            int length = rain.length;
            String[] res = new String[length];
            int idx = 0;
            Map<String, Integer> map = new HashMap<>();
            String alice = "Alice";
            String bob = "Bob";
            map.put(alice, 0);
            map.put(bob, 0);
            for (int i = 0; i < length - 1; ++i) {
                if (rain[i] == 1) {
                    if (rain[i + 1] == 1) {
                        if (map.get(alice) <= map.get(bob)) {
                            res[idx++] = alice;
                            map.put(alice, map.get(alice) + 1);
                        } else {
                            res[idx++] = bob;
                            map.put(bob, map.get(bob) + 1);
                        }
                    } else {
                        res[idx++] = bob;
                        map.put(bob, map.get(bob) + 1);
                    }
                } else {
                    res[idx++] = "None";
                }
            }

            if (rain[length - 1] == 1)
                res[idx] = bob;
            else {
                res[idx] = "None";
            }
            return res;

        }
    }

     public static void main(String[] args) {
     }
}
