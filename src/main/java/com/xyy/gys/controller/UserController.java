package com.xyy.gys.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyy.gys.pojo.ImoocJSONResult;
import com.xyy.gys.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/string")
	public String hello() {
		return "Hello World!";
	}

	@RequestMapping("/json")
	public ImoocJSONResult getUserJSON() {
		User user = new User();
		user.setName("tomcat");
		user.setPassword("777777");
		user.setAge(30);
		user.setBirthday(new Date());
		user.setDesc("SOF");

		return ImoocJSONResult.ok(user);
	}

}
