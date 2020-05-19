package com.zhbit.findwork.action;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.RoleService;
import com.zhbit.findwork.service.UserService;

public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;


	private String message;				//���ڷ�����Ϣ��ҳ�棬��ʾ�û�
	private String errorMessage;		//��ʾ�쳣��Ϣ

	
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
}
