package com.zhbit.findwork.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.BlackListService;
import com.zhbit.findwork.service.BusinessService;

/**
 * ������ҵ����Ƹ��ϢͶ�ߵ�action
 * @author SX
 * @date 2020��6��11��
 */
public class ComplainAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userid;		//����Ͷ����id
	private int businessid; //���ձ�Ͷ����ҵid
	private int advertiseid;//���ձ�Ͷ����Ƹ��Ϣid
	private String complainReason;//Ͷ��������Ϣ
	private String message;	//��Ϣ����
	
	private BusinessService businessService;	//ע����ҵ��ҵ���߼������
	private BlackListService blackListService; //ע�������ҵ���߼�����
	private AdvertiseService advertiseService;	//ע����Ƹ��Ϣҵ���߼�����
	
	

	
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}
	public int getAdvertiseid() {
		return advertiseid;
	}
	public void setAdvertiseid(int advertiseid) {
		this.advertiseid = advertiseid;
	}
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setBlackListService(BlackListService blackListService) {
		this.blackListService = blackListService;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public String getComplainReason() {
		return complainReason;
	}
	public void setComplainReason(String complainReason) {
		this.complainReason = complainReason;
	}

	/**
	 * ������ҵͶ��
	 * @return
	 */
	public String dealBusinessComplain() {
		//System.out.println("����ٱ�����");
		User user = new User();
		user.setId(userid);
		Business business = new Business();
		business.setId(businessid);
		
		boolean result = blackListService.addBusinessToBlackList(user, business, complainReason);
		//true:�ٱ��ɹ�   false:�Ѿ��ٱ���
		Business businessForShow = businessService.getBusinessByID(businessid);
		ActionContext.getContext().put("business", businessForShow);
		if (result) {
			message = "�ٱ��ɹ����ȴ�����Ա����";
			return "showBusiness";
		} else {
			message = "�벻Ҫ�ظ��ٱ���";
			return "showBusiness";
		}
		
	}
	
	/**
	 * ������Ƹ��ϢͶ��
	 * @return
	 */
	public String dealAdvertiseComplain() {
		User user = new User();
		user.setId(userid);
		Advertise advertise = new Advertise();
		advertise.setId(advertiseid);
		
		boolean result = blackListService.addAdvertiseToBlackList(user, advertise, complainReason);
		//true:�ٱ��ɹ�   false:�Ѿ��ٱ���
		Advertise as = advertiseService.getAdvertiseByID(advertiseid);
		ActionContext.getContext().put("as", as);
		Integer s = (Integer) ActionContext.getContext().getSession().get("LOGINED_ROLE");
		Integer isUser = 9;
		if (s == 2) isUser = 1;
		if (s == 1) isUser = 0;
		ServletActionContext.getRequest().setAttribute("isUser", isUser);
		if (result) {
			message = "�ٱ��ɹ����ȴ�����Ա����";
			return "showAdvertise";
		} else {
			message = "�벻Ҫ�ظ��ٱ���";
			return "showAdvertise";
		}
	}
}
