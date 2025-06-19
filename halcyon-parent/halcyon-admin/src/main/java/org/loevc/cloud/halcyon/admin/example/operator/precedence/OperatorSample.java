package org.loevc.cloud.halcyon.admin.example.operator.precedence;

public class OperatorSample {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int temp = (1 << 0) + (1 << 4) + (1 << 8) + (1 << 14) + (1 << 20);
        // temp 1065233
        System.out.println(temp);

        temp = 1 << 0 + 1 << 4 + 1 << 8 + 1 << 14 + 1 << 20;
        System.err.println(temp);

    }

}
