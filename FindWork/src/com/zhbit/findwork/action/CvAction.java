package com.zhbit.findwork.action;
import java.io.File;
/**
 * 简历信息action类
 * @author 段世平
 * @date 2020年5月18日
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.service.CvService;

public class CvAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Cv cv;
	private CvService cvService;
	private String message;				//用于返回信息给页面，提示用户
	private String errorMessage;		//显示异常信息
	ActionContext context = ActionContext.getContext();
	private List<Cv> list = new ArrayList<Cv>();
	
	public Cv getCv() {
		return cv;
	}
	public void setCv(Cv cv) {
		this.cv = cv;
	}
	public CvService getCvService() {
		return cvService;
	}
	public void setCvService(CvService cvService) {
		this.cvService = cvService;
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
	
	public List<Cv> getList() {
		return list;
	}
	public void setList(List<Cv> list) {
		this.list = list;
	}
	//添加信息验证
	public void validateAdd(){
		//判断电话号码格式是否正确的正则表达式
		String tel = "((^(13|15|18|17|19)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
		String na = "(^[0-9]*$)";
		if (cv.getName()==null||cv.getName().equals(na)||cv.getName().equals("")) {
			this.addFieldError("name", "用户名格式不正确（不能有数字出现）");
			System.out.println("0");
		}
		if (!cv.getTelephone().matches(tel)) {
			this.addFieldError("telephone", "手机号码格式不正确");
		}
		if (cv.getWant_low_wages()==0 || cv.getWant_large_wages()==0) {
			this.addFieldError("want_low_wages", "工资填写不正确");
			this.addFieldError("want_large_wages", "工资填写不正确");
		}else if (cv.getWant_low_wages()>cv.getWant_large_wages()||cv.getWant_low_wages()<1000 ||cv.getWant_large_wages()>99999) {
			this.addFieldError("want_low_wages", "工资填写不正确");
			this.addFieldError("want_large_wages", "工资填写不正确");
		}
		if (cv.getPolitics_status()==null ||cv.getPolitics_status().equals("")) {
			this.addFieldError("politics_status", "政治面貌不能为空");
		}
		if (cv.getEducation_background()==null||cv.getEducation_background().equals("")) {
			this.addFieldError("education_background", "学历不能为空");
		}
		if (cv.getWant_post()==null || cv.getWant_post().equals("")) {
			this.addFieldError("want_post", "求职意向不能为空");
		}
		if (cv.getLive_city()==null||cv.getLive_city().equals("")) {
			this.addFieldError("live_city", "居住城市不能为空");
		}
		if (cv.getLive_province()==null || cv.getLive_province().equals("")) {
			this.addFieldError("live_province", "居住省份不能为空");
		}
		if (cv.getWant_joy_type()==null || cv.getWant_joy_type().equals("")) {
			this.addFieldError("want_joy_type", "工作类型不能为空");
		}
		if (cv.getWant_city()==null || cv.getWant_city().equals("")) {
			this.addFieldError("want_city", "想去的城市不能为空");
		}
		if (cv.getWant_province()==null || cv.getWant_province().equals("")) {
			this.addFieldError("want_province", "想去的省份不能为空");
		}
	}
	/**
	 * 新增简历信息
	 */
	public String add(){
		cv = cvService.getCvByID(1);
		boolean result = cvService.addCv(cv);
		if (result ) {
			message="添加成功";
			return "add";
		}else {
			errorMessage="添加不成功";
			return "input";
		}
		
	}
	//修改信息验证
		public void validateUpdate(){
			//判断电话号码格式是否正确的正则表达式
			String tel = "((^(13|15|18|17|19)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
			String na = "(^[0-9]*$)";
			if (cv.getName()==null||cv.getName().equals(na)||cv.getName().equals("")) {
				this.addFieldError("name", "用户名格式不正确（不能有数字出现）");
				System.out.println("0");
			}
			if (!cv.getTelephone().matches(tel)) {
				this.addFieldError("telephone", "手机号码格式不正确");
			}
			if (cv.getWant_low_wages()==0 || cv.getWant_large_wages()==0) {
				this.addFieldError("want_low_wages", "工资填写不正确");
				this.addFieldError("want_large_wages", "工资填写不正确");
			}else if (cv.getWant_low_wages()>cv.getWant_large_wages()||cv.getWant_low_wages()<1000 ||cv.getWant_large_wages()>99999) {
				this.addFieldError("want_low_wages", "工资填写不正确");
				this.addFieldError("want_large_wages", "工资填写不正确");
			}
			if (cv.getPolitics_status()==null ||cv.getPolitics_status().equals("")) {
				this.addFieldError("politics_status", "政治面貌不能为空");
			}
			if (cv.getEducation_background()==null||cv.getEducation_background().equals("")) {
				this.addFieldError("education_background", "学历不能为空");
			}
			if (cv.getWant_post()==null || cv.getWant_post().equals("")) {
				this.addFieldError("want_post", "求职意向不能为空");
			}
			if (cv.getLive_city()==null||cv.getLive_city().equals("")) {
				this.addFieldError("live_city", "居住城市不能为空");
			}
			if (cv.getLive_province()==null || cv.getLive_province().equals("")) {
				this.addFieldError("live_province", "居住省份不能为空");
			}
			if (cv.getWant_joy_type()==null || cv.getWant_joy_type().equals("")) {
				this.addFieldError("want_joy_type", "工作类型不能为空");
			}
			if (cv.getWant_city()==null || cv.getWant_city().equals("")) {
				this.addFieldError("want_city", "想去的城市不能为空");
			}
			if (cv.getWant_province()==null || cv.getWant_province().equals("")) {
				this.addFieldError("want_province", "想去的省份不能为空");
			}
		}
	/**
	 * 修改简历信息
	 */
	public String update(){
		boolean result =  cvService.updateCv(cv);
		if (result) {
			//修改成功
			message = "修改成功";
			return "update";
		}else {
			return "error";
		}
		
	}
	/**
	 * 删除简历信息
	 */
	public String delete(){
		int id = cv.getId();
		cvService.deleteCvByID(id);	
		return "delete";
		
	}
	
	public String show(){
		cv = cvService.getCvByID(1);
		if (cv==null) {
			return "error";
		}else {
			return "show";
		}
	}
	
	public String showDetail(){
		int id = cv.getId();
		cv = cvService.getCvByID(id);
		return "showDetail";
	}

	
}
