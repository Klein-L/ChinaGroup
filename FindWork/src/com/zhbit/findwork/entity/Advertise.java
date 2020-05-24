package com.zhbit.findwork.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ְλBean��
 * 
 * @author ����
 *
 */
public class Advertise {
	private int id;// ְλid
	private int bid;//��ҵid
	private String title;// ��Ƹ����
	private String postName;// ��Ƹ��λ
	private String businessName;//��ҵ����
	private String educationBackground;// ѧ��
	private int lowWages;// ��͹���
	private int largeWages;// ��߹���
	private String ask;// ��λҪ��
	private String wantJoyType;// ��Ƹ����:0ȫְ1ʵϰ2��ְ
	private Date deadline;// ��ֹ����
	private int deleteFlag;// ɾ����ʶ
	private String comment;// ��ע
	private Date createAt; // ����ʱ��
	private Date updateAt; // �޸�ʱ��
	private int check;// �Ƿ���� 0�� 1��
	private String city;//����
	private Business business;// ����ҵ����һ��ϵ
	private Post post;			//���λ���һ��ϵ
	private Set<Cv> cvs = new HashSet<Cv>();//�������Զ�;
	
	
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
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
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
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
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
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
	public Set<Cv> getCvs() {
		return cvs;
	}
	public void setCvs(Set<Cv> cvs) {
		this.cvs = cvs;
	}
}
