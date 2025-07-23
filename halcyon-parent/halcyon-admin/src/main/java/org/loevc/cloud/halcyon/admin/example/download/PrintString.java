package org.loevc.cloud.halcyon.admin.example.download;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintString {

    @GetMapping("print")
    public String print(){
        return "hello";
    }
}
