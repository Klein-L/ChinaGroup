package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.Page;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.BusinessService;
import com.zhbit.findwork.service.UserService;

/**
 * �û��ղ���
 * 
 * @author ������
 *
 */
public class Collection_BusinessAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;
	private List<Business> Businesses; // �����洢��ѯ����ҵ
	private Page page; // ҳ�ٿ���
	private Business business;
	private BusinessService businessService;
	private String message;				//���ڷ�����Ϣ��ҳ�棬��ʾ�û�
	private String errorMessage;		//��ʾ�쳣��Ϣ
	
	public String deleteBusiness(){
		//����Ŀǰ��¼�û���id��1
		System.out.println("ɾ���ղ���ҵ");
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		boolean t=userService.deleteCollection_Business(user.getId(),business.getId());
		System.out.println(t);
		int p=page.getCurrent();
		System.out.println(p);
		page.setCurrent(p);//���浱ǰ���ʵ�ҳ��
		System.out.println(page.getCurrent());
		System.out.println("dffffffffffffff");
		return "deleteBusiness";
	}
	//����ղ���ҵ
	public String addBusiness(){
		//user=userService.getUserByID(1);//��ȡ��ǰ��¼���û�
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		business=businessService.getBusinessByID(business.getId());
		Collection_Business c_b = new Collection_Business();
		c_b.setUser(user);
		c_b.setBusiness(business);
		System.out.println(user);
		System.out.println(business);
		System.out.println(c_b);
		boolean t =userService.addCollection_Business(c_b);
		if(t){
			message="�ղسɹ�";
			return "addBusiness";
		}else{
			errorMessage="���Ѿ��ղع�,�������ղ���";
			return "addBusiness";
		}
		
	}
	public void checkPage(int total) {
		page.setMaxSize(3);// ���õ�ǰҳ����������
		int pageCount = total / page.getMaxSize();// �ܵ�ҳ��=�ܵ�����/���ҳ�������������
		if (total % page.getMaxSize() != 0)
			pageCount++;// �������������
		page.setTotal(pageCount);// �����ܵ�ҳ��
		if (page.getCurrent() > pageCount - 1)// �����ǰҳ��>��ҳ��-1
			page.setHasnex(false);// û����һҳ					
		else
			page.setHasnex(true);// ������һҳ
		if (page.getCurrent() < 2)// ͬ��û����һҳ
			page.setHaspre(false);
		else
			page.setHaspre(true);
	}

	public String showBusiness() {
		if (page == null) {// ���Ϊ�գ��򴴽�һ��ҳ������
			page = new Page();
			page.setCurrent(1); // ���õ�ǰҳ��Ϊ1
		}
		// ��ȡ�û��ղص���ҵ������
		//��ȡ��ǰ�û�
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
	//	user=userService.getUserByID(1);
		int total = userService.getBusinessesByUserId(user.getId()).size();
		checkPage(total);// ����ҳ��
		int start = (page.getCurrent() - 1) * page.getMaxSize();// ���õ�ǰҳ�濪ʼ
		Businesses = userService.getBusinessesByPage(user.getId(), start, page.getMaxSize());
		return "showPage";
	}

	public List<Business> getBusinesses() {
		return Businesses;
	}

	public void setBusinesses(List<Business> businesses) {
		Businesses = businesses;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public BusinessService getBusinessService() {
		return businessService;
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
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
