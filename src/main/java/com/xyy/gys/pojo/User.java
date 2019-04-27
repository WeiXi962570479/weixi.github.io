package com.xyy.gys.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class User {

	private String name;
	
	@JsonIgnore     //忽略，不显示给前端
	private String password;	
	
	private Integer age;
	
	@JsonFormat(pattern="yyy-MM-dd hh:mm:ss a",locale="zh",timezone="GMT+8")
	private Date birthday;	
	
	@JsonInclude(Include.NON_NULL) //数据为空，则不显示给前端
	private String desc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}	
	
}
