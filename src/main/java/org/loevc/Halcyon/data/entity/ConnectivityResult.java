package org.loevc.Halcyon.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConnectivityResult {
    private boolean reachable;
    private int statusCode;
    private long responseTime;
    private String errorMessage;
}
