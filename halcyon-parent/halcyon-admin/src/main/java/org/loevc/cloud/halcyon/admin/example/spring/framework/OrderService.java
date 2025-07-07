package org.loevc.cloud.halcyon.admin.example.spring.framework;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderService implements InitializingBean {

    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public OrderService (UserService userService123) {
    public OrderService (UserService userService) {
//    public OrderService (UserService xxxx) {  // 依赖查找，如果先 byName ， 那么使用 xxx 名字会有问题， 所以先 byType  再 byName
        System.out.println(userService);
        System.out.println(1);
        this.userService = userService;
    }

/*    @Autowired
    public OrderService (UserService userService, UserService userService2) {
        System.out.println(userService);
        System.out.println(2);
        this.userService = userService;
    }*/



    public void print(){
        System.out.println(userService);
    }

    /**
     * 初始化
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(userService);
        System.out.println("afterPropertiesSet");
    }


    @Transactional
    public void execSql(){
        jdbcTemplate.execute("insert into t1 values ('2','bob', 10)");
        throw new NullPointerException();
    }
}
