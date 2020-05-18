package com.zhbit.findwork.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.BusinessService;

public class BusinessAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Business business;
	private BusinessService businessService;
	private String message;				//���ڷ�����Ϣ��ҳ�棬��ʾ�û�
	private String errorMessage;		//��ʾ�쳣��Ϣ
	
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public Business getBusiness() {
		return business;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	//ע����ҵ����֤
	public void validateadd() {
			if (business.getName() == null || "".equals(business.getName())) {
				addFieldError("business.name", "��ҵ���Ʋ���Ϊ��");
			}
			if (business.getCity() == null || "".equals(business.getCity())) {
				addFieldError("business.city", "���ڳ��в���Ϊ��");
			}
			if (business.getTelephone() == null || "".equals(business.getTelephone())) {
				addFieldError("business.telephone", "��ϵ�绰����Ϊ��");
			}
			if (business.getPassword() == null || "".equals(business.getPassword())) {
				addFieldError("business.password", "��¼���벻��Ϊ��");
			}
			if (business.getConfirmPassword() == null || "".equals(business.getConfirmPassword())) {
				addFieldError("business.confirmPassword", "ȷ�����벻��Ϊ��");
			}
			if (business.getAddress() == null || "".equals(business.getAddress())) {
				addFieldError("business.address", "��ҵ��ַ����Ϊ��");
			}
			if (business.getDescription() == null || "".equals(business.getDescription())) {
				addFieldError("business.description", "��ҵ��������Ϊ��");
			}
			if (business.getUrl() == null || "".equals(business.getUrl())) {
				addFieldError("business.url", "��ҵ�������Ӳ���Ϊ��");
			}if (business.getEmail() == null || "".equals(business.getEmail())) {
				addFieldError("business.email", "��ҵ���䲻��Ϊ��");
			}
			
		}
	
	/**
	 * ע�ᣬ������ҵ
	 * @return
	 */
	public String add() {
		int result = businessService.addBusiness(business);
		if (result == 0) {
			//���ݿ������иü�¼
			message = "���ݿ������иü�¼";
			return "regBusiness";
		} else if (result == 1){
			//����ɹ� Ӧ����ת����¼ҳ��ģ�
			//TODO Ŀǰ��¼ҳ����δ�Ž���������������ҵ����
			message = "ע��ɹ�";
			return "businessCenter";
		} else if (result == 2) {
			errorMessage = "��¼�����ȷ�����벻һ��";
			return "regBusiness";
		}
		return SUCCESS;
	}

}
