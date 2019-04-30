package com.xyy.gys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyy.gys.pojo.ImoocJSONResult;
import com.xyy.gys.pojo.SysUser;
import com.xyy.gys.pojo.User;
import com.xyy.gys.utils.JsonUtil;
import com.xyy.gys.utils.RedisOperator;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private StringRedisTemplate strRedis;
	
	@Autowired
	private RedisOperator redis;
	
	@RequestMapping("/test")
	public ImoocJSONResult test() {
		
		strRedis.opsForValue().set("imooc", "2019/4/28");
		String string = strRedis.opsForValue().get("imooc");
		
		SysUser sysUser = new SysUser();
		sysUser.setId("10086");
		sysUser.setUsername("imooc");
		sysUser.setNickname("imooc");
		sysUser.setPassword("2019/4/28");
		sysUser.setIsDelete(0);
		sysUser.setRegistTime(new Date());
		
		strRedis.opsForValue().set("json:sysUser",JsonUtil.objectToJson(sysUser));
		String jsonUser = strRedis.opsForValue().get("json:sysUser");
		SysUser user = JsonUtil.jsonToPojo(jsonUser, SysUser.class);
		
		return ImoocJSONResult.ok(user);
	}
	
	@RequestMapping("/jsonList")
	public ImoocJSONResult jsonList() {
		
		User user = new User();
		user.setAge(29);
		user.setName("zhangsan");
		user.setPassword("123456");
		user.setBirthday(new Date());
		user.setDesc("qwe");
		
		User user1 = new User();
		user1.setAge(15);
		user1.setName("lisi");
		user1.setPassword("111111");
		user1.setBirthday(new Date());
		user.setDesc("asd");
		
		User user2 = new User();
		user2.setAge(33);
		user2.setName("wangwu");
		user2.setPassword("777777");
		user2.setBirthday(new Date());
		user.setDesc("zxc");
		
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user1);
		list.add(user2);
		
		redis.set("json:list", JsonUtil.objectToJson(list),2000);
		String string = redis.get("json:list");
		List<User> jsonToList = JsonUtil.jsonToList(string, User.class);
		
		return ImoocJSONResult.ok(jsonToList);
	}
	
	
	
	
}
