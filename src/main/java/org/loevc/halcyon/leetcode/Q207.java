package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q207 {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, GraphNode> map = new HashMap<>();
            GraphNode root = new GraphNode(-1);
            for (int[] pre : prerequisites) {
                int a = pre[0];
                int b = pre[1];
                if (a == b)
                    return false;
                GraphNode GraphNodeA = map.computeIfAbsent(a, GraphNode::new);
                GraphNode GraphNodeB = map.computeIfAbsent(b, GraphNode::new);
                if (!root.list.contains(GraphNodeA))
                    root.list.add(GraphNodeA);
                if (!root.list.contains(GraphNodeB))
                    root.list.add(GraphNodeB);
                GraphNodeA.list.add(GraphNodeB);
                root.list.remove(GraphNodeB);
            }
            int[] state = new int[numCourses];
            for (GraphNode node : root.list) {
                if (judgeCircle(node, state))
                    return false;
            }
            return true;
        }

        private boolean judgeCircle(GraphNode root, int[] state) {
            if (state[root.val] == 1)
                return true;
            if (state[root.val] == 2)
                return false;
            state[root.val] = 1;
            for (GraphNode node : root.list) {
                if (judgeCircle(node, state)) {
                    return true;
                }
            }
            state[root.val] = 2;
            return false;
        }

        class GraphNode {
            Integer val;
            List<GraphNode> list = new ArrayList<>();

            public GraphNode() {
            }

            public GraphNode(int val) {
                this.val = val;
            }
        }
    }

     public static void main(String[] args) {
     }
}
