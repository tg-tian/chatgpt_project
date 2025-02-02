package cn.bugstack.chatgpt.data;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 启动类
 * @create 2023-07-16 07:43
 */
@SpringBootApplication
@Configurable
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportResource(locations = {"classpath:spring-config.xml"})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}
