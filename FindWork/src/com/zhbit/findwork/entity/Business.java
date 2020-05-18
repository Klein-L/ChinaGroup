package com.zhbit.findwork.entity;

import java.util.Date;

/**
 * ��ҵBean��
 * 
 * @author ����˸
 *
 */
public class Business {
	private int id;				//
	private String name;		//
	private String city;		//��ҵ���ڳ���
	private String telephone;		//
	private String email;		//
	private String address;		//
	private String description;	//��ҵ���
	private String url;			//��˾���鳬����
	private String password;    //��¼����
	private String confirmPassword; //ȷ�����룬�����ݿ�û�й�ϵ
	private int delete_flag = 0;//ɾ����ʶ   0������  1����ɾ��
	private String comment;		//
	private Date create_at;		//
	private Date update_at;		//
	private Role role;			//���ɫ��������һ��ϵ
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
		return "Business [id=" + id + ", name=" + name + ", city=" + city + ", telephone=" + telephone + ", email="
				+ email + ", address=" + address + ", description=" + description + ", url=" + url + ", delete_flag="
				+ delete_flag + ", comment=" + comment + ", create_at=" + create_at + ", update_at=" + update_at + "]";
	}
	
	
	
}
