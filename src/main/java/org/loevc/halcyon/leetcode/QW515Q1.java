package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class QW515Q1 {

    class Solution {
        public int nearestDrone(int[][] drones, int[] target) {
            int minDist = 101;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(minDist, -1);

            for (int i = 0; i < drones.length; ++i) {
                int temp = 101;
                int dist = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);
                if (dist <= drones[i][2]) {
                    temp = dist;
                    minDist = Math.min(minDist, temp);
                    if (map.get(minDist) == null)
                        map.put(minDist, i);
                }

            }
            return map.get(minDist);
        }
    }

     public static void main(String[] args) {
     }
}
