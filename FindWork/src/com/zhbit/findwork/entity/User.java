package com.zhbit.findwork.entity;

import java.util.Date;
import java.util.List;

/**
 * ��ְ�û�Bean��
 * 
 * @author ������
 *
 */
public class User {
	private int id;				//
	private String name;		//
	private String password;    //��¼����
	private String address;		//�û����ڵ�ַ
	private String imagepath;	//�û�ͷ��
	private String telephone;		//����Ϊ�ַ���
	private String email;		//
	private Date birthday;		//����
	private int delete_flag = 0;//ɾ����ʶ   0������  1����ɾ��
	private String comment;		//
	private Date create_at;		//����ʱ��
	private Date update_at;		//����ʱ��
	private Role role;			//���ɫ����һ��ϵ
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User [id=" + id + ", name=" + name + ", telephone=" + telephone + ", email="
		+ email + ", address=" + address + ", delete_flag="
		+ delete_flag +",imagepath="+imagepath+",birthday="+birthday+ ", comment=" + comment + ", create_at=" + create_at + ", update_at=" + update_at + "]";
}
}
