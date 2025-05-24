package org.loevc.cloud.halcyon.admin.example.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class TransactionSample {

    @Autowired
    private TransactionTemplate transactionTemplate;


    public void testTransaction(){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    // business code
                } catch (Exception e) {
                    // rollback
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }



    @Autowired
    private PlatformTransactionManager transactionManager;

    public void testTransaction2(){
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            // business code
            transactionManager.commit(transactionStatus);
        } catch (Exception e){
            transactionManager.rollback(transactionStatus);
        }
    }



    @Transactional(propagation = Propagation.REQUIRED)
    public void testAnnotation(){
        // do something
    }

}
