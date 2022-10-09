package com.ujcmsitems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xing'chen
 */
@SpringBootApplication
@MapperScan("com.ujcmsitems.core.mapper")
public class UjcmsItemsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UjcmsItemsApplication.class, args);
    }
}
