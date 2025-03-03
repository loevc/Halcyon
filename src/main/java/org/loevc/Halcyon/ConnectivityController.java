package org.loevc.Halcyon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/connectivity")
public class ConnectivityController {

    @GetMapping("/baidu")
    public String baiduConnectivity(){
        return "baidu";
    }

    @GetMapping("/google")
    public String googleConnectivity(){
        return "google";
    }

    @GetMapping("/taobao")
    public String taobaoConnectivity(){
        return "taobao";
    }

    @GetMapping("/cloudflare")
    public String cloudflareConnectivity(){
        return "cloudflare";
    }


}
