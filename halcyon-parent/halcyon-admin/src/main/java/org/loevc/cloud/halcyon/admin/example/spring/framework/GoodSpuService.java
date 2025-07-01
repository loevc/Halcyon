package org.loevc.cloud.halcyon.admin.example.spring.framework;

import org.springframework.stereotype.Component;

//@Component
public class GoodSpuService {

    private GoodSkuService skuService;

    public GoodSkuService getSkuService() {
        return skuService;
    }

    public void setSkuService(GoodSkuService skuService) {
        this.skuService = skuService;
    }

    public void print(){
        System.out.println(skuService);
    }

}
