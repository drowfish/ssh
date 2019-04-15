package com.bcd.dao;

import java.util.List;

import com.bcd.entity.User;
import com.bcd.util.PageBean;


public interface UserDao {
	
	//查询用户也可根据姓名查询
	public PageBean<User> findAll(User user,PageBean<User> pageBean);
	//增加用户
	public int add(User user);
	//删除用户
	public int delete(User user);
	//更新用户
	public int update(User user);
	
}
