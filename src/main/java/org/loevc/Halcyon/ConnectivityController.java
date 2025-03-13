package org.loevc.Halcyon;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.loevc.Halcyon.data.dto.UrlConnectivityDTO;
import org.loevc.Halcyon.data.entity.ConnectivityResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController("/connectivity")
public class ConnectivityController {

    private final ConnectivityService connectivityService;

    @GetMapping("/{website}")
    public String basicConnectivity(@PathVariable String website, @RequestHeader String protocol, @RequestHeader String visitMethod,
                                    @RequestHeader String clientType){
        boolean bool = connectivityService.checkConnectivity("https://www." + website + ".com");
        if (!bool) return null;
        return website;
    }


    @PostMapping("/dynamic")
    public String dynamicConnectivity(@RequestBody UrlConnectivityDTO urlConnectivityDTO,
                                      @RequestHeader String protocol,
                                      @RequestHeader String visitMethod,
                                      @RequestHeader String clientType){
        ConnectivityResult connectivityResult = connectivityService.checkConnectivity(urlConnectivityDTO, protocol, visitMethod, clientType);
        return  JSONUtil.toJsonStr(connectivityResult);
    }


}
