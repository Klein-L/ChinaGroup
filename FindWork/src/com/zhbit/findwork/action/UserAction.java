package com.zhbit.findwork.action;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.entity.UserBirthday;
import com.zhbit.findwork.service.Post_typeService;
import com.zhbit.findwork.service.RoleService;
import com.zhbit.findwork.service.UserService;

public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;
	private Post_typeService post_typeService;

	private String message;				//���ڷ�����Ϣ��ҳ�棬��ʾ�û�
	private String errorMessage;		//��ʾ�쳣��Ϣ
	private String spassword;           //�ڶ������������
	private UserBirthday ubirthday;     //ע��������� �� ����Ϣ
	private List<Post_type> pts;        //��λ���ͼ���λ
	
	/**
	 * �������� ��ʾ�ҵ���Ϣ
	 * @return
	 */
	public String show(){
		//�ӵ�¼�����л�ȡ�û���������ʱ�����ݿ��ж�ȡһ���û�
		user=userService.getUserByID(1);
/*		Rid=user.getRole().getId();
		System.out.println(Rid+"dfaaaaaaaaaaaaaaaaaaaaaaaaaaaa");*/
		if(user==null)
			return ERROR;
		else{
			return "show";
		}
	}
	//�ҵ���Ϣ ��֤
	public void validateSave(){
		//�жϵ绰�����ʽ�Ƿ���ȷ��������ʽ
		String tel = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";		
		//�ж�������ȷ��������ʽ
		String em = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";				
		System.out.println(user.getBirthday());
		if(user.getName()==null||user.getName().equals("")){
			this.addFieldError("userName", "�û�������Ϊ��");
		}
		if(!user.getEmail().matches(em)){
			this.addFieldError("userEmail", "�����ʽ����ȷ");
		}
		if(!user.getTelephone().matches(tel)){
			this.addFieldError("userTelephone", "�ֻ������ʽ����ȷ");
		}
		if(user.getBirthday()==null||user.getBirthday().equals("")){
			this.addFieldError("userBirthday", "ʱ���ʽ����ȷ������2020-02-02");
		}
		if(user.getAddress()==null||user.getAddress().equals("")){
			this.addFieldError("userAddress", "��ַ����Ϊ��");
		}
		
	}
	/**
	 *�������� �����ҵ���Ϣ
	 * @return
	 */
	public String save(){	
		/*Role role = roleService.getRoleByID(Rid);//��������Ķ���
		System.out.println(role);
		user.setRole(role);*/
		boolean flag= userService.updateUser(user);		
		if(flag){
			message="����ɹ�";
			return "save";
		}	
		else{
			errorMessage="�û����Ѿ�����";
			return "input";
		} 
			
	}
	
	/**
	 *�û�ע����Ϣ��֤
	 * @return
	 */
	public void validateRegister(){
		
		String em = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		
		//�ж��û����Ƿ�Ϊ��
		if(user.getName()==null||user.getName().equals("")){
			this.addFieldError("userName", "�û�������Ϊ��");
			System.out.println("0");
		}else{
			//�ж��û����Ƿ�ʹ��
			if(userService.getUserByName(user.getName()) != null){
				this.addFieldError("userName", "���û����ѱ�ʹ��");
				System.out.println("1");
			}
		}
		
		//�ж������ַ��ʽ�Ƿ���ȷ
		if(!user.getEmail().matches(em)){
			this.addFieldError("userEmail", "�����ʽ����ȷ");
		}
		
		//�ж����������Ƿ���ͬ
		if(user.getPassword() == null || user.getPassword().equals("")){
			this.addFieldError("userPassword", "����Ϊ��");
			System.out.println("2");
		}else if(user.getPassword().length() <8 && user.getPassword().length() >18){
			this.addFieldError("userPassword", "���볤��Ӧ��8-16λ���ֺ���ĸ���");
			System.out.println("3");
		}
		if(spassword == null || spassword.equals("")){
			this.addFieldError("sPassword", "ȷ������Ϊ��");
			System.out.println("4");
		}else if(!spassword.equals(user.getPassword())){
			this.addFieldError("userPassword", "������ȷ�����벻һ��");
			this.addFieldError("sPassword", "������ȷ�����벻һ��");
			System.out.println("5");
		}
		System.out.println("6");
	}
	
	/**
	 *�û�ע��
	 * @return
	 */
	public String register(){
		
		if(ubirthday.getByear().length() == 1){
			ubirthday.setByear(new String("0").concat(ubirthday.getByear()));
		}
		if(ubirthday.getBmonth().length() == 1){
			ubirthday.setBmonth(new String("0").concat(ubirthday.getBmonth()));
		}
		if(ubirthday.getBday().length() == 1){
			ubirthday.setBday(new String("0").concat(ubirthday.getBday()));
		}
		try {
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(ubirthday.toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userService.addUser(user);
		return "register";
		
	}
	
	/**
	 *�û���¼��Ϣ��֤
	 * @return
	 */
	public void validateLogin(){
		
		//�ж��û����Ƿ�Ϊ��
		if(user.getName()==null||user.getName().equals("")){
			this.addFieldError("userName", "�û�������Ϊ��");
			System.out.println("0");
		}else if(user.getPassword()==null || user.getPassword().equals("")){
			this.addFieldError("userPassword", "���벻��Ϊ��");
		}else if(userService.getUserByNameAndPassword(user.getName(), user.getPassword()) == null){
			this.addFieldError("userName", "�û������������");
			this.addFieldError("userPassword", "�û������������");
		}
	}
		
	public String login(){
		
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_USER", user);
		pts = post_typeService.getAllPost_type();
		return "login";
		
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
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public UserBirthday getUbirthday() {
		return ubirthday;
	}
	public void setUbirthday(UserBirthday ubirthday) {
		this.ubirthday = ubirthday;
	}
	public Post_typeService getPost_typeService() {
		return post_typeService;
	}
	public void setPost_typeService(Post_typeService post_typeService) {
		this.post_typeService = post_typeService;
	}
	public List<Post_type> getPts() {
		return pts;
	}
	public void setPts(List<Post_type> pts) {
		this.pts = pts;
	}
	
	
}
