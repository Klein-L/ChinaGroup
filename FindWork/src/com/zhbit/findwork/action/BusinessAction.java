package com.zhbit.findwork.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.BusinessService;

public class BusinessAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Business business;
	private List<Business> businesses;
	private BusinessService businessService;
	private String message;				//���ڷ�����Ϣ��ҳ�棬��ʾ�û�
	private String errorMessage;		//��ʾ�쳣��Ϣ
	private File license;				//Ӫҵִ���ļ�
	private String licenseFileName;		//�ļ�����
	private String licenseContentType;	//�ļ�����
	private String searchName;			//�û�������ҵ����ģ����ѯʱ�����ֵ
	private int currentPage;			//��ǰҳ�棨��ҳ��
	private int firstResult;			//������¼����ҳ��
	private int lastPage;				//���һҳҳ��
	private int pageSize = Integer.parseInt(ServletActionContext.getServletContext().getInitParameter("maxResults"));
	
	//private int maxResults = 5;
	
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public String getLicenseFileName() {
		return licenseFileName;
	}

	public void setLicenseFileName(String licenseFileName) {
		this.licenseFileName = licenseFileName;
	}

	public File getLicense() {
		return license;
	}
	public void setLicense(File license) {
		this.license = license;
	}
	public String getLicenseContentType() {
		return licenseContentType;
	}

	public void setLicenseContentType(String licenseContentType) {
		this.licenseContentType = licenseContentType;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
	public List<Business> getBusinesses() {
		return businesses;
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
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getSearchName() {
		return searchName;
	}
	
	
	
	//ע����ҵ����֤
	public void validateRegister() {
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
			} else {
				if (business.getPassword().length() < 8 || business.getPassword().length() > 16) {
					addFieldError("business.password", "���볤�ȱ�����6��18λ֮��");
				}
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
			if (license == null) {
				addFieldError("license", "�����ϴ�Ӫҵִ�գ�����ã�");
			}
			
		}
	
	/**
	 * ע�ᣬ������ҵ
	 * @return
	 */
	public String register() {
//		System.out.println(licenseFileName);
//		System.out.println(licenseContentType);
//		System.out.println(ServletActionContext.getServletContext().getRealPath("/upload/"+1+".jpg"));
//		System.out.println(temp[0]);
//		System.out.println(temp[temp.length-1]);
		String[] temp = licenseFileName.split("\\.");
		business.setLicense_path("/upload/businessLicense/"+business.getName()+"."+temp[temp.length-1]);
		int result = businessService.addBusiness(business);
		if (result == 0) {
			//���ݿ������иü�¼
			errorMessage = "���ݿ������иü�¼";
			return "regBusiness";
		} else if (result == 1){
			//����ɹ� Ӧ����ת����¼ҳ��ģ�
			//TODO Ŀǰ��¼ҳ����δ�Ž���������������ҵ����
			File destFile = new File(ServletActionContext.getServletContext().getRealPath(business.getLicense_path()));
			try {
				FileUtils.copyFile(license, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			message = "ע��ɹ�";
			return "businessCenter";
		} else if (result == 2) {
			errorMessage = "��¼�����ȷ�����벻һ��";
			return "regBusiness";
		}
		return SUCCESS;
	}

	/**
	 * ��ʾ��ҵ����
	 * @return
	 */
	public String showBusinessCenter() {
		business = businessService.getBusinessByID(business.getId());
		return "businessCenter";
	}
	
	/**
	 * ��ʾ�޸�ҳ��
	 * @return
	 */
	public String showUpdatePage() {
		business = businessService.getBusinessByID(business.getId());
		return "showUpdatePage";
	}
	
	//�޸���ҵ��Ϣ����֤
		public void validateUpdate() {
				if (business.getName() == null || "".equals(business.getName())) {
					addFieldError("business.name", "��ҵ���Ʋ���Ϊ��");
				}
				if (business.getCity() == null || "".equals(business.getCity())) {
					addFieldError("business.city", "���ڳ��в���Ϊ��");
				}
				if (business.getTelephone() == null || "".equals(business.getTelephone())) {
					addFieldError("business.telephone", "��ϵ�绰����Ϊ��");
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
	 * �޸���ҵ��Ϣ
	 * @return
	 */
	public String update() {
		int result = businessService.updateBusiness(business);
		if (result == 0) {
			//�޸ĳɹ�
			message = "�޸ĳɹ�";
			return "businessCenter";
		} else if (result == 1) {
			//���ֱ�ռ��
			errorMessage = "�޸�ʧ��,�����ֱ�����һ��ע��";
			Business businessTemp = businessService.getBusinessByID(business.getId());
			business.setRole(businessTemp.getRole());
			business.setCreate_at(businessTemp.getCreate_at());
			business.setLicense_path(businessTemp.getLicense_path());
			business.setCheck_flag(businessTemp.getCheck_flag());
			return "showUpdatePage";
		}
		return NONE;
	}
	
	/**
	 * ������ҵ����������ҵ
	 * @return
	 */
	public String searchByName() {
		int count = businessService.getCountByNameSearch(searchName);
		this.getPagingParameter(count);
		ActionContext.getContext().put("count", count);
		ActionContext.getContext().put("searchName", searchName);
		businesses = businessService.getBusinessesByNameSearch(firstResult, pageSize, searchName);
		return "showSearchResultByName";
	}
	//���ݵ�ǰҳ���ҳ���С�������ҳ��Ҫ������
	private void getPagingParameter(int count) {
		this.firstResult = (this.currentPage-1)*this.pageSize;
		this.lastPage = (int) Math.ceil(count/(this.pageSize*1.0));
		return ;
	}
	
	public String showBusinessInfo() {
		business = businessService.getBusinessByID(business.getId());
		return "showBusinessInfo";
	}
}
