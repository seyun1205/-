package com.elephant;

import com.elephant.controller.WebSocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * projectName: consulte
 *
 * @author: chenguoquan
 * @since: 2022/11/7 0:43
 * description:启动类
 */
@SpringBootApplication
@MapperScan("com.elephant.mapper")
public class ConsultApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConsultApplication.class, args);
        WebSocketServer.setApplicationContext(configurableApplicationContext);
    }
}