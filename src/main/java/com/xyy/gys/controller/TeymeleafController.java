package com.xyy.gys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyy.gys.pojo.ImoocJSONResult;
import com.xyy.gys.pojo.Resource;
import com.xyy.gys.pojo.User;

@Controller
@RequestMapping("/th")
public class TeymeleafController {

	@Autowired
	private Resource sourceth;
	
	@RequestMapping("/index")
	public String index(ModelMap map) {
		map.addAttribute("sourceth", sourceth);
		return "teymeleaf/index";
	}

	@RequestMapping("/center")
	public String center(ModelMap map) {
		map.addAttribute("myNameis","teymeleaf");
		return "teymeleaf/center/center";
	}
	
	@RequestMapping("/test")
	public String test(ModelMap map) {
		User user = new User();
		user.setName("manager");
		user.setAge(10);
		user.setBirthday(new Date());
		user.setDesc("<font color='green'><b>hello girl!</b></font>");
		map.addAttribute("user",user);
		
		User user1 = new User();
		user1.setName("jack");
		user1.setAge(18);
		user1.setBirthday(new Date());

		User user2 = new User();
		user2.setName("rose");
		user2.setAge(20);
		user2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user1);
		userList.add(user2);
		map.addAttribute("userList", userList);
		
		return "teymeleaf/test";
	}
	
	@RequestMapping("/postfrom")
	public String postfrom(User user) {
		System.out.println(user.getName());
		System.out.println(user.getAge());
		return "redirect:/th/test";
	}
	
	/**
	 * web的异常
	 * @return
	 */
	@RequestMapping("/weberror")
	public String weberror() {
		int a = 1/0;
		return "teymeleaf/error";
	}

	
	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		return "teymeleaf/ajaxerror";
	}
	
	/**
	 * ajax的异常
	 * @return
	 */
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public ImoocJSONResult getAjaxerror() {
		int a = 1/0;
		return ImoocJSONResult.ok();
	}
	
}
