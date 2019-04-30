package com.xyy.gys.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyy.gys.pojo.ImoocJSONResult;
import com.xyy.gys.pojo.SysUser;
import com.xyy.gys.service.SysUserService;

@RestController
@RequestMapping("/mybatis")
public class MybatisCRUDController {

	@Autowired
	private SysUserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public ImoocJSONResult saveSysUser() {
		//工具类生成id
		String id = sid.nextShort();
		
		SysUser sysUser = new SysUser();
		sysUser.setId(id);
		sysUser.setUsername("faker"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		sysUser.setNickname("faker"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		sysUser.setPassword("123456");
		sysUser.setIsDelete(0);
		sysUser.setRegistTime(new Date());
		
		userService.saveSysUser(sysUser);
		
		return ImoocJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/exitUser")
	public ImoocJSONResult exitSysUser(String id) {

		SysUser sysUser = new SysUser();
		sysUser.setId(id);
		sysUser.setUsername(id+new Date());
		sysUser.setNickname(id+new Date());
		sysUser.setPassword(id);
		sysUser.setIsDelete(1);
		userService.exitSysUser(sysUser);
		
		return ImoocJSONResult.ok("修改成功");
	}
	
	@RequestMapping("/delUser")
	public ImoocJSONResult delSysUser(String id) {

		userService.delSysUser(id);
		
		return ImoocJSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUser")
	public ImoocJSONResult querySysUserById(String id) {
		SysUser sysUser = userService.querySysUserById(id);
		return ImoocJSONResult.ok(sysUser);
	}
	
	/**
	 * 分页查询
	 * @param sysUser
	 * @return
	 */
	@RequestMapping("/pageUser")
	public ImoocJSONResult PageUser(SysUser sysUser,Integer pageNum,Integer pageSize) {
		
		if(pageNum == null || pageNum == 0) {
			pageNum = 1;
		}
		
		if(pageSize == null || pageSize == 0) {
			pageSize = 10;
		}
		
		List<SysUser> userList = userService.querySysUserPageList(sysUser, pageNum, pageSize);
		return ImoocJSONResult.ok(userList);
	}
	
	@RequestMapping("/custom")
	public ImoocJSONResult queryCustomSysUser(String id) {
		List<SysUser> list = userService.queryCustomList(id);
		return ImoocJSONResult.ok(list);
	}
	
	
}
