package com.zhbit.findwork.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ��ɫbean��
 * @author ����˸
 *
 */
public class Role {
	private int id;
	private String name;
	private int delete_flag;//ɾ����ʶ��0��������1����ɾ��
	private String comment;
	private Date create_at;
	private Date update_at;
	private List<Business> businesses;//���ú���ҵ��һ�Զ��ϵ
	private List<User> users;//���ú��û���һ�Զ��ϵ  ������
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	public Date getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	public List<Business> getBusinesses() {
		return businesses;
	}
	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", delete_flag=" + delete_flag + ", comment=" + comment
				+ ", create_at=" + create_at + ", update_at=" + update_at + "]";
	}
	
	
}
