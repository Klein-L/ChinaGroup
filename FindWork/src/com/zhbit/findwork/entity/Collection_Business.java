package com.zhbit.findwork.entity;

import java.util.Date;
import java.util.List;

/**
 * �ղ����ģ���ҵ����
 * 
 * @author ������
 *
 */
public class Collection_Business {
	private int id;
	private User user; //�û����һ
	private Business business; //����ҵ���һ
	private int delete_flag = 0;//ɾ����ʶ   0������  1����ɾ��
	private String comment;		//
	private Date create_at;		//����ʱ��
	private Date update_at;		//����ʱ��
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
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
	
	
}
