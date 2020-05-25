package com.zhbit.findwork.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Collection_Advertise;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.Page;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.UserService;

/**
 * �û��ղ���
 * 
 * @author ������
 *
 */
public class Collection_AdvertiseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private UserService userService;
	private List<Advertise> advertises; // �����洢��ѯ����Ƹ
	private Page page; // ҳ�ٿ���
	private Advertise advertise;
	private AdvertiseService advertiseService;
	private String message;				//���ڷ�����Ϣ��ҳ�棬��ʾ�û�
	private String errorMessage;		//��ʾ�쳣��Ϣ
	private Advertise as;
	public Advertise getAs() {
		return as;
	}
	public void setAs(Advertise as) {
		this.as = as;
	}
	public String addadvertise(){
		//user=userService.getUserByID(1);//��ȡ��ǰ��¼���û�
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		advertise=advertiseService.getAdvertiseByID(advertise.getId());
		as=advertise;
		int isUser=0;
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("isUser", isUser);
		Collection_Advertise ca = new Collection_Advertise();
		ca.setUser(user);
		ca.setAdvertise(advertise);
		boolean t =userService.addCollection_Advertise(ca);
		if(t){
			message="�ղسɹ�";
			return "addAdvertise";
		}else{
			errorMessage="���Ѿ��ղع�,�������ղ���";
			return "addAdvertise";
		}
		
	}
	//ɾ���ղص���Ƹ��Ϣ
	public String deleteAdvertise(){
		System.out.println("ɾ���ղ���Ƹ");
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		boolean t=userService.deleteCollection_Advertise(user.getId(), advertise.getId());
		System.out.println(t);
		int p=page.getCurrent();
		System.out.println(p);
		page.setCurrent(p);//���浱ǰ���ʵ�ҳ��
		System.out.println(page.getCurrent());
		System.out.println("dffffffffffffff");
		return "deleteAdvertise";
	}
	//��ҳ��ѯ�ղص���Ƹ
	public String showAdvertise() {
		if (page == null) {// ���Ϊ�գ��򴴽�һ��ҳ������
			page = new Page();
			page.setCurrent(1); // ���õ�ǰҳ��Ϊ1
		}	
		//��ȡ��ǰ�û�
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
	//	user=userService.getUserByID(1);
		int total = userService.getAdvertisesByUserId(user.getId()).size();
		checkPage(total);// ����ҳ��
		int start = (page.getCurrent() - 1) * page.getMaxSize();// ���õ�ǰҳ�濪ʼ
		advertises = userService.getAdvertisesByPage(user.getId(), start, page.getMaxSize());
		return "showPage";
	}

	
	//���ҳ��
	public void checkPage(int total) {
		page.setMaxSize(4);// ���õ�ǰҳ����������
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
	public List<Advertise> getAdvertises() {
		return advertises;
	}
	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Advertise getAdvertise() {
		return advertise;
	}
	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}
	public AdvertiseService getAdvertiseService() {
		return advertiseService;
	}
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
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
