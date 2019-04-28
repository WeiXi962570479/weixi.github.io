package com.xyy.gys.service;

import java.util.List;

import com.xyy.gys.pojo.SysUser;

public interface SysUserService {

	public void saveSysUser(SysUser sysUser);

	public void exitSysUser(SysUser sysUser);

	public void delSysUser(String userId);

	public SysUser querySysUserById(String userId);

	public List<SysUser> querySysUserList(SysUser sysUser);
	
	public List<SysUser> querySysUserPageList(SysUser sysUser,Integer pageNum,Integer pageSize);

}
