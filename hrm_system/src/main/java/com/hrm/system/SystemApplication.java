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
//这里设置(scanBasePackages = "com.hrm")是为了能读取在hrm_common项目中
// 设置异常处理器，将包扫描扩大到整个com.hrm
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
