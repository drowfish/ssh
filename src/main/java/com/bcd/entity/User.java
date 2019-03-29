package com.bcd.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class User {
	
	private Integer id;
	private String name;
	private String grade;
	private String num;
	private String createtime;
	
//	public User(){
//		Date date = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		this.createtime = simpleDateFormat.format(date);
//	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE")   
    @SequenceGenerator(name="SEQ_STORE", sequenceName="SEQ_TB_USER",allocationSize = 1)
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getCreatetime() {
		return createtime;
	}
	
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", grade=" + grade
				+ ", num=" + num + ",createtime="+createtime+"]";
	}
	
	
}
