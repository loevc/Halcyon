package org.loevc.cloud.halcyon.admin.example.jvm;

public class ObserveObject {
    public static void main(String[] args) {
        // -XX:+TraceClassLoading -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
        Object obj = new Object();
    }
}
