package org.loevc.cloud.halcyon.admin.example.transaction;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionC {



    public void methodC1(){
        // do sth
        methodC2();
//        ((TransactionC) AopContext.currentProxy()).methodC2();
    }


    @Transactional
    public void methodC2() {

    }
}
