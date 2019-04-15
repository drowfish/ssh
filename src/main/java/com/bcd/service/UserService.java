package com.bcd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcd.dao.UserDao;
import com.bcd.entity.User;
import com.bcd.util.PageBean;

@Service
@Transactional(readOnly=false)
public class UserService {
	@Resource
	private UserDao userDao;
	
	
	public PageBean<User> findAll(User user,PageBean<User> pageBean){
		return userDao.findAll(user,pageBean);
	}
	public int add(User user){
		return userDao.add(user);
	}
	
	public int delete(User user){
		return userDao.delete(user);
	}
	
	public int update(User user){
		return userDao.update(user);
	}
	
}
