package com.ujcmsitems;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author xing'chen
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.ujcmsitems.core.mapper")
@EnableCaching
@EnableTransactionManagement
public class UjcmsItemsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UjcmsItemsApplication.class, args);
        log.info("项目启动成功...");
    }
}


// jpg加载器工厂 class JpgReaderFactory implements ReaderFactory {     @Override     public Reader getReader() {         return new JpgReader();     } } // png加载器工厂 class PngReaderFactory implements ReaderFactory {     @Override     public Reader getReader() {         return new PngReader();     } } // gif加载器工厂 class GifReaderFactory implements ReaderFactory {     @Override     public Reader getReader() {         return new GifReader();     } }
