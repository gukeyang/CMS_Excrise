package com.ujcmsitems;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author xing'chen
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.ujcmsitems.core.mapper")
@EnableCaching
public class UjcmsItemsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UjcmsItemsApplication.class, args);
        log.info("项目启动成功...");
    }
}
