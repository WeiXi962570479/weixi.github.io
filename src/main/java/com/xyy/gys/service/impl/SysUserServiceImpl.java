package com.xyy.gys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.xyy.gys.mapper.SysUserMapper;
import com.xyy.gys.pojo.SysUser;
import com.xyy.gys.service.SysUserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper userMapper;
	
	@Override
	public void saveSysUser(SysUser sysUser) {
		userMapper.insert(sysUser);
	}

	@Override
	public void exitSysUser(SysUser sysUser) {
		userMapper.updateByPrimaryKeySelective(sysUser);	
	}

	@Override
	public void delSysUser(String userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public SysUser querySysUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<SysUser> querySysUserList(SysUser sysUser) {
		return userMapper.select(sysUser);
	}

	@Override
	public List<SysUser> querySysUserPageList(SysUser sysUser, Integer pageNum, Integer pageSize) {
		//开始分页
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(SysUser.class);
		Criteria criteria = example.createCriteria();
		//username模糊查询
		if(!StringUtils.isEmptyOrWhitespace(sysUser.getUsername())) {
			criteria.andLike("username","%"+sysUser.getUsername()+"%" );
		}
		//nickname模糊查询
		if(!StringUtils.isEmptyOrWhitespace(sysUser.getNickname())) {
			criteria.andLike("nickname","%"+sysUser.getNickname()+"%" );
		}
		//isDelete
		if(sysUser.getIsDelete()!=null && !StringUtils.isEmptyOrWhitespace(sysUser.getIsDelete().toString())) {
			criteria.andEqualTo("isDelete", sysUser.getIsDelete());
		}
		//排序
		example.orderBy("registTime").desc();
		List<SysUser> list = userMapper.selectByExample(example);
		
		return list;
	}

}
