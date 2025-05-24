package org.loevc.cloud.halcyon.admin.example.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionA {

    @Autowired
    TransactionB transactionB;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = -1, readOnly = false, rollbackFor = Exception.class)
    public void methodA(){
        // do sth
        transactionB.methodB();
    }
}
