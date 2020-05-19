package com.zhbit.findwork.entity;

import java.util.Date;

/**
 * ְλBean��
 * 
 * @author ����
 *
 */
public class Advertise {
	private int id;// ְλid
	private String title;// ��Ƹ����
	private String post;// ��Ƹ��λ
	private String educationBackground;// ѧ��
	private int lowWages;// ��͹���
	private int largeWages;// ��߹���
	private String ask;// ��λҪ��
	private String wantJoyType;// ��Ƹ����:0ȫְ1ʵϰ2��ְ
	private Date deadline;// ��ֹ����
	private int deleteFlag;// ɾ����ʶ
	private String comment;// ��ע
	private Date createAt; // ����ʱ��
	private Date updateaAt; // �޸�ʱ��
	private int check;// �Ƿ����
	private Business business;// ����ҵ����һ��ϵ
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getEducationBackground() {
		return educationBackground;
	}
	public void setEducationBackground(String educationBackground) {
		this.educationBackground = educationBackground;
	}
	public int getLowWages() {
		return lowWages;
	}
	public void setLowWages(int lowWages) {
		this.lowWages = lowWages;
	}
	
	public int getLargeWages() {
		return largeWages;
	}
	public void setLargeWages(int largeWages) {
		this.largeWages = largeWages;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public String getWantJoyType() {
		return wantJoyType;
	}
	public void setWantJoyType(String wantJoyType) {
		this.wantJoyType = wantJoyType;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateaAt() {
		return updateaAt;
	}
	public void setUpdateaAt(Date updateaAt) {
		this.updateaAt = updateaAt;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	@Override
	public String toString() {
		return "Advertise [id=" + id + ", title=" + title + ", post=" + post
				+ ", educationBackground=" + educationBackground
				+ ", lowWages=" + lowWages + ", largeWages=" + largeWages
				+ ", ask=" + ask + ", wantJoyType=" + wantJoyType
				+ ", deadline=" + deadline + ", deleteFlag=" + deleteFlag
				+ ", comment=" + comment + ", createAt=" + createAt
				+ ", updateaAt=" + updateaAt + ", check=" + check
				+ ", business=" + business + "]";
	}
	
}
