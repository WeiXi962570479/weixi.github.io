package com.xyy.gys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mapper
@MapperScan(basePackages="com.xyy.gys.mapper")
//扫描所需的包，包括工具包
@ComponentScan(basePackages= {"com.xyy.gys","org.n3r.idworker"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
