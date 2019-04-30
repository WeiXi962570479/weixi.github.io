package com.xyy.gys.mapper;

import java.util.List;

import com.xyy.gys.pojo.SysUser;

public interface SysUserCustomMapper {
	
	public List<SysUser> queryCustom(String userId);
	
}