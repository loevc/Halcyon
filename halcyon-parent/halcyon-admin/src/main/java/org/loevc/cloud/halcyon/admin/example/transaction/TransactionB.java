package org.loevc.cloud.halcyon.admin.example.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionB {

    @Transactional(propagation = Propagation.REQUIRED)
    public void methodB(){
        // do  sth
    }
}
