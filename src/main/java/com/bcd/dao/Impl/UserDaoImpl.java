package com.bcd.dao.Impl;



import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bcd.entity.User;
import com.bcd.util.PageBean;

import com.bcd.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<User> getUser(String name) {
		// TODO Auto-generated method stub
		String hql = "from User where name = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(1, name);
		List<User> list = query.list();
		System.out.println("list:"+list.isEmpty());
		for(User string:list){
			System.out.println("list:"+string);
		}
		return list;
	}
	
	
	@Override
	public PageBean<User> findAll(User user,PageBean<User>pageBean) {
		// TODO Auto-generated method stub
		String hql;
		if(user.getName() == null){
			hql = "from User";
		}else{
			hql = "from User where name='"+user.getName()+"'";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int totalCount = query.list().size();
		System.out.println("totalcount:"+totalCount);
		pageBean.setRows(totalCount);
		//设置起始行
		query.setFirstResult((pageBean.getPageNo()-1)*pageBean.getPageSize());
		//设置每页条数
		query.setMaxResults(pageBean.getPageSize());
		List<User> list = query.list();
		pageBean.setLists(list);
		System.out.println("list:"+list.isEmpty());
		for(User string:list){
			System.out.println("list:"+string);
		}
		return pageBean;
	}
	
	
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			Serializable resultSerializable = sessionFactory.getCurrentSession().save(user);
			System.out.println("add方法resulet:"+resultSerializable);
			flag = flag+1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("add方法error:"+e.getMessage());
		}
		return flag;
	}
	
	
	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			sessionFactory.getCurrentSession().delete(user);
			flag = flag+1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}
	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			sessionFactory.getCurrentSession().update(user);
			flag = flag+1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("update方法："+e.getMessage());
		}
		return flag;
	}

	
}
