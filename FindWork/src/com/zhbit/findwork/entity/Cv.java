package com.zhbit.findwork.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * �û�����Bean��
 * @author ����ƽ
 *
 */
public class Cv {
	private int id;                     //����
	private String name;                //����
	private String telephone;           //��ϵ��ʽ
	private String self;                //��������
	private String education_background;//ѧ��
	private String politics_status;     //������ò
	private String skill;               //����
	private String experience;          //��������
	private String live_province;       //��סʡ��
	private String want_joy_type;       //������������
	private String live_city;           //��ס����
	private String want_province;       //��ȥ��ʡ��
	private String want_city;           //��ȥ�ĳ���
	private int want_low_wages;         //������͹���
	private int want_large_wages;       //������߹���
	private String want_post;           //��ְ����
	private int delete_flag = 0;        //ɾ����ʶ   0������  1����ɾ��
	private String comment;		        //��ע
	private Date create_at;		        //����ʱ��
	private Date update_at;		        //����ʱ��
	private User user;                  //���û������������һ��һ����
	private Set<Advertise> advertises = new HashSet<Advertise>();//����Ƹ��Ϣ��Զ��ϵ
	
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEducation_background() {
		return education_background;
	}
	public void setEducation_background(String education_background) {
		this.education_background = education_background;
	}
	
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getPolitics_status() {
		return politics_status;
	}
	public void setPolitics_status(String politics_status) {
		this.politics_status = politics_status;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getLive_province() {
		return live_province;
	}
	public void setLive_province(String live_province) {
		this.live_province = live_province;
	}
	public String getWant_joy_type() {
		return want_joy_type;
	}
	public void setWant_joy_type(String want_joy_type) {
		this.want_joy_type = want_joy_type;
	}
	public String getLive_city() {
		return live_city;
	}
	public void setLive_city(String live_city) {
		this.live_city = live_city;
	}
	public String getWant_province() {
		return want_province;
	}
	public void setWant_province(String want_province) {
		this.want_province = want_province;
	}
	public String getWant_city() {
		return want_city;
	}
	public void setWant_city(String want_city) {
		this.want_city = want_city;
	}
	public int getWant_low_wages() {
		return want_low_wages;
	}
	public void setWant_low_wages(int want_low_wages) {
		this.want_low_wages = want_low_wages;
	}
	public int getWant_large_wages() {
		return want_large_wages;
	}
	public void setWant_large_wages(int want_large_wages) {
		this.want_large_wages = want_large_wages;
	}
	public String getWant_post() {
		return want_post;
	}
	public void setWant_post(String want_post) {
		this.want_post = want_post;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<Advertise> getAdvertises() {
		return advertises;
	}
	public void setAdvertises(Set<Advertise> advertises) {
		this.advertises = advertises;
	}
	@Override
	public String toString(){
		return "Cv [id=" + id + ", name=" + name + ", telephone=" + telephone + ",education_background=" + education_background + ", self_appraisal=" +self + ", politics_status=" + politics_status + ", skill="
		+ skill +", experience=" +experience +", live_province=" + live_province +", want_joy_type=" + want_joy_type +", live_city=" + live_city +", want_province=" + want_province +", want_city=" +want_city +", want_low_wages="
		+ want_low_wages +", want_large_wages=" + want_large_wages +", want_post=" + want_post +", delete_flag="
		+ delete_flag +", comment=" + comment + ", create_at=" + create_at + ", update_at=" + update_at + "]";
	}

}
