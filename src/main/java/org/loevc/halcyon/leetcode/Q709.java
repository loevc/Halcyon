package org.loevc.halcyon.leetcode;

public class Q709 {

    /**
     * 问题： 能不能通过位运算来实现呢？
     * 我记得 大小写字母是有特殊值的，
     * 想想哈，其实 大写 + 32 = 小写，也就是 2^5, 那么就是 10_0000
     * 不对哈，题目中是可打印字符，可打印字符不仅仅包含 大小写字母，还有数字和符号，所以不能直接使用位运算来实现
     */
    class Solution {
        public String toLowerCase(String s) {
            StringBuilder sb = new StringBuilder();
            byte[] bytes = s.getBytes();
            for (byte b : bytes) {
                if (b >= 'A' && b <= 'Z')
                    b |= 32;
                sb.append((char) b);
            }
            return sb.toString();
        }
    }
}
