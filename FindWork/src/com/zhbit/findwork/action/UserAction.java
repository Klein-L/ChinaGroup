package com.zhbit.findwork.action;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.entity.UserBirthday;
import com.zhbit.findwork.service.CvService;
import com.zhbit.findwork.service.Post_typeService;
import com.zhbit.findwork.service.RoleService;
import com.zhbit.findwork.service.UserService;
/**
 * �û�action��
 * 
 * @author ������
 *
 */
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
	
	private File Header; //ͷ��
	private String HeaderFileName;//�ļ���
	private String HeaderContentType;//�ļ�����

	private String repwd;//�޸�����
	private String repwd2;//ע������
	private String deleteMessage;//ע����ʾ
	
	private String newpwd;
	private String confirmpwd;
	//����
	private CvService cvService;
	private List<Cv> cvs;
	
	private RoleService roleService;
	
	

	/**
	 * �������� ע���û�
	 * @return
	 */
	public String delete(){
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		if(repwd2==null){
			deleteMessage="���ٴ�ȷ��ע����ȷ������������";
			repwd2="";
			return "showSecurity";//����ע��ҳ��
		}
		if(repwd2.equals("")){
			deleteMessage="���벻��Ϊ��";
			return "showSecurity";
		}
		if(userService.getUserByNameAndPassword(user.getName(), repwd2)==null){
			deleteMessage="�������";
			return "showSecurity";
		}
		else{
			userService.deleteUserByID(user.getId());
			return "delete";
		}
		
	}
	
	//��ʾ�û��ļ���
	public String showCvList(){
		//���赱ǰ�û��ǵ�¼�û�
		/*User user =userService.getUserByID(1);*/
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		cvs=cvService.getCvListByUserId(user.getId());
		return "showCvList";
	}
	//�˳�
	public String logout(){
		  
		  ActionContext ac = ActionContext.getContext();
		  ac.getSession().put("LOGINED_USER",null);
		
		  ac.getSession().put("LOGINED_ROLE", null);
		  return "logout";
		  
		 }

	/**
	 * �������� ��ʾ�ҵ���Ϣ
	 * @return
	 */
	public String showMyInformation(){
		//��ȡ��ǰ�û�
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		if(user==null)
			return ERROR;
		else{
			return "showMyInformation";
		}
	}

	//�ҵ���Ϣ ��֤
		public void validateSaveMyInformation(){
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
		public String saveMyInformation(){	
			Role role= user.getRole();
			user.setRole(role);
			boolean flag= userService.updateUser(user);	
			
			if(flag){
				user=userService.getUserByID(user.getId());
				ActionContext ac = ActionContext.getContext();
				  ac.getSession().put("LOGINED_USER", user);
				message="����ɹ�";
				return "saveMyInformation";
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
		Role role= roleService.getRoleByID(1);//��ְ��
		user.setRole(role);
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

	/**
	 * ��¼
	 * @return
	 */	
	public String login(){
		
		User u = userService.getUserByNameAndPassword(user.getName(), user.getPassword());
		
		ActionContext ac = ActionContext.getContext();
		  ac.getSession().put("LOGINED_USER", u);
		  ac.getSession().put("LOGINED_ROLE", 1);
		System.out.println(ActionContext.getContext()
		.getSession().get("LOGINED_USER"));
		pts = post_typeService.getAllPost_type();
		return "login";
		
	}
	
	//��֤�ϴ����ļ��Ƿ�Ϊ��
		public void validateSaveHeader(){
			System.out.println("jhhhhhhhhhhhhhhhhhhhhhhh");
			if(HeaderFileName==null||HeaderFileName.equals("")){
				this.addFieldError("userHeader", "��ѡ���µ�ͷ��");
			}
		}
		/**
		 *�������� �޸��ҵ�ͷ��
		 * @return
		 */
		public String saveHeader(){
			//����Ψһ��ʶ��·��
			//�������·��
			String imagePath="/upload/Header/"+
			UUID.randomUUID().toString()+
					HeaderFileName.substring(HeaderFileName.lastIndexOf("."));		
			//���þ���·��
			String path=ServletActionContext.
					getServletContext().getRealPath(imagePath);
			
			System.out.println(path);
			//�����µ��ļ�
			File file=new File(path);
			try {
				FileUtils.copyFile(Header, file);
				//��ȡ��ǰ�û�
				user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
				user.setImagepath(path);//�û������ϴ������·��
				userService.updateUser(user);
				//���浱ǰͷ�����·����ҳ���ȡ
				message="ͷ�񱣴�ɹ�";
				ActionContext.getContext().getSession().put("imagePath", ".."+imagePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return "saveHeader";

		}

		/**
		 * �������� ��ʾ�ҵ�ͷ��
		 * @return
		 */
		//չʾ�ҵ�ͷ��
		public String showHeader(){
			//��ȡ��ǰ�û��洢��ͼƬ·��
			user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
			ActionContext.getContext().getSession().put("imagePath", ".."+user.getImagepath());
			System.out.println("չʾ��ǰ�û���ͷ��");
			return "showHeader";
		}
	    public void validateSaveSecurity(){
			if(repwd.equals("")||repwd==null)
				this.addFieldError("repwd", "ԭ���벻��Ϊ��");
			if(newpwd.equals("")||newpwd==null)
				this.addFieldError("newpwd", "�����벻��Ϊ��");
			if(confirmpwd.equals("")||confirmpwd==null)
				this.addFieldError("confirmpwd", "�ڶ���ȷ�����벻��Ϊ��");
			if(!confirmpwd.equals(newpwd))
				this.addFieldError("confirmpwd", "���벻һ�£�����������");
			if(newpwd.matches("[0-9]{1,}"))
				this.addFieldError("newpwd", "���벻���Ǵ�����");
			if(newpwd.length()<=6)
				this.addFieldError("newpwd", "���벻������6λ");
		}

		/**
		 * �������� �޸�����
		 * @return
		 */
		//�޸�����
		public String saveSecurity(){
			//��������ǵ�ǰ��¼�û�
			User olduser=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
			User user = userService.getUserByNameAndPassword(olduser.getName(), repwd);
			//�����ͨ���������ѯ����ǰ�û���˵������������ȷ
			if(user!=null){
				user.setPassword(newpwd);//���ĵ�ǰ����
				userService.updateUser(user);//�־û�
				message="�����޸ĳɹ�";
				return "showSecurity";
			}
			else{//�����������
				errorMessage="ԭ���������������������";
				return "showSecurity";
			}		
		}
		
		/**
		 * �������� ��ȡͷ��
		 * @return
		 */
		public String readHeader(){
			System.out.println("��ȡͷ��");
			return "readHeader";
		}
		/**
		 * �������� ��ȡͷ��������
		 * @return
		 */
		public InputStream getInputStream() throws Exception{
			System.out.println("��������ȡͷ��");
			//��ȡ��ǰ�û�
			user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
			System.out.println(user);
			System.out.println(user.getId());
			String path=user.getImagepath();
			System.out.println(path);
			try{
				//����û���ͷ�񣬷����û�ͷ��
				InputStream inputStream = new FileInputStream(path);
				return inputStream;
			}catch(Exception e){
				//�û����֮ǰû��ͷ�񣬷���Ĭ��ͷ��
				InputStream inputStream = new FileInputStream("D:\\a.jpg");
				return inputStream;
			}
			
			
		}
    

		public CvService getCvService() {
			return cvService;
		}

		public void setCvService(CvService cvService) {
			this.cvService = cvService;
		}

		public List<Cv> getCvs() {
			return cvs;
		}

		public void setCvs(List<Cv> cvs) {
			this.cvs = cvs;
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
	
	public File getHeader() {
		return Header;
	}
	public void setHeader(File header) {
		Header = header;
	}
	public String getHeaderFileName() {
		return HeaderFileName;
	}
	public void setHeaderFileName(String headerFileName) {
		HeaderFileName = headerFileName;
	}
	public String getHeaderContentType() {
		return HeaderContentType;
	}
	public void setHeaderContentType(String headerContentType) {
		HeaderContentType = headerContentType;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public String getRepwd2() {
		return repwd2;
	}
	public String getDeleteMessage() {
		return deleteMessage;
	}

	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}

	public void setRepwd2(String repwd2) {
		this.repwd2 = repwd2;
	}
}
