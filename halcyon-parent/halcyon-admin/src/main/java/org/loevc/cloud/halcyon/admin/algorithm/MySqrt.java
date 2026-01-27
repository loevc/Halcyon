package org.loevc.cloud.halcyon.admin.algorithm;

public class MySqrt {

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.sqrt(24));
        System.out.println((int)mySqrt.sqrt(12));
    }

    private double sqrt(int c) {
        double x = c;
        double x1 ;
        while (true) {
            x1 = x - f(x, c)/g(x);
            if (Math.abs(x1 - x) < 0.001){
                break;
            }
            x = x1;
        }
        return x1;
    }

    private double f(double x, double c) {
        return x * x - c;
    }

    private double g(double x) {
        return 2 * x;
    }
}
