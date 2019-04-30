package com.xyy.gys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mapper,使用tk.mybatis包下的
@MapperScan(basePackages="com.xyy.gys.mapper")
//扫描所需的包，包括工具包
@ComponentScan(basePackages= {"com.xyy.gys","org.n3r.idworker"})
//开启定时任务,与@Component连用
@EnableScheduling
//开启异步任务,与@Component和@Async连用
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
