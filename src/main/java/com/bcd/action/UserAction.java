package com.bcd.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bcd.entity.User;
import com.bcd.service.UserService;
import com.bcd.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserService userService;
	
	private Map<String, Object> map = new HashMap<String, Object>();;
	private User user = new User();
	private List<User>list;
	private HttpServletRequest request;
	
	public UserAction(){
		request = ServletActionContext.getRequest();
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String findAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("findAll开始");
		System.out.println("name:"+request.getParameter("name"));
		User user = new User();
		user.setName(request.getParameter("name"));
		System.out.println("user:"+user);
		PageBean<User> pageBean = new PageBean<User>();
		System.out.println("request:"+request.getParameter("page")+"values:"+request.getParameter("rows"));
		pageBean.setPageNo(Integer.parseInt(request.getParameter("page")));
		pageBean.setPageSize(Integer.parseInt(request.getParameter("rows")));
		System.out.println("pagebean:"+pageBean);
		pageBean = userService.findAll(user,pageBean);
		map.clear();
		map.put("total", pageBean.getRows());
		map.put("rows", pageBean.getLists());
		return "flag";
	}

	public String add(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = simpleDateFormat.format(new Date());
		user.setCreatetime(string);
		int flag = userService.add(user);
		map.clear();
		if(flag > 0 ){
			map.put("flag",true);
		}else {
			map.put("flag", false);
		}
		return "flag";
	}
	
	public String delete(){
		User user = new User();
		map.clear();
		if(request.getParameter("id")==null){
			map.put("flag", false);
			return "flag";
		}
		user.setId(Integer.parseInt(request.getParameter("id")));
		int flag = userService.delete(user);
		if(flag > 0 ){
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		return "flag";
	}
	
	public String update(){
		System.out.println("update:"+user);
		int flag = userService.update(user);
		map.clear();
		if(flag > 0 ){
			map.put("flag", true);
		}else {
			map.put("flag", false);
		}
		return "flag";
	}
	
	public String findOne(){
		System.out.println("findOne:"+user);
		List<User> list = userService.getUser(user.getName());
		return "list";
	}
	
}
