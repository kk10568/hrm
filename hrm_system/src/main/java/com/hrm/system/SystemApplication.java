package com.hrm.system;

import com.hrm.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-14 17:49
 **/
@SpringBootApplication(scanBasePackages = "com.hrm")
@EnableTransactionManagement(proxyTargetClass = true)
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}
