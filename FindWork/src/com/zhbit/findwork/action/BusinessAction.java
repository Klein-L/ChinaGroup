package com.zhbit.findwork.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.BusinessService;

public class BusinessAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Business business;
	private List<Business> businesses;
	private BusinessService businessService;
	private AdvertiseService advertiseService;
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
	private List<Advertise> advertises;	//��ҵ���µ�������Ƹ��Ϣ
	private String businessProvince;	//������ҵ����ʡ�ݵ�ֵ
	//private int maxResults = 5;
	
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	public String getBusinessProvince() {
		return businessProvince;
	}
	public void setBusinessProvince(String businessProvince) {
		this.businessProvince = businessProvince;
	}
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}
	
	public List<Advertise> getAdvertises() {
		return advertises;
	}


	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
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
			} else {
				if (!business.getTelephone().matches("(13|14|15|18|17)[0-9]{9}")) {
					this.addFieldError("business.telephone", "��������ȷ���ֻ�����");
				}
			}
			if (business.getPassword() == null || "".equals(business.getPassword())) {
				addFieldError("business.password", "��¼���벻��Ϊ��");
			} else {
				if (business.getPassword().length() < 6 || business.getPassword().length() > 16) {
					addFieldError("business.password", "���볤�ȱ�����6��18λ֮��");
				}
			}
			if (business.getConfirmPassword() == null || "".equals(business.getConfirmPassword())) {
				addFieldError("business.confirmPassword", "ȷ�����벻��Ϊ��");
			}
			if (business.getAddress() == null || "".equals(business.getAddress())) {
				addFieldError("business.address", "��ҵ��ַ����Ϊ��");
			} else {
				if (business.getAddress().length()>255) {
					this.addFieldError("business.address", "��ҵ��ַ���Ȳ��ܳ���255");
				}
			}
			if (business.getDescription() == null || "".equals(business.getDescription())) {
				addFieldError("business.description", "��ҵ��������Ϊ��");
			} else {
				if (business.getDescription().length() > 255) {
					this.addFieldError("business.description", "��ҵ�������Ȳ��ܳ���255");
				}
			}
			if (business.getUrl() == null || "".equals(business.getUrl())) {
				addFieldError("business.url", "��ҵ�������Ӳ���Ϊ��");
			}if (business.getEmail() == null || "".equals(business.getEmail())) {
				addFieldError("business.email", "��ҵ���䲻��Ϊ��");
			} else {
				if (!business.getEmail().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
					this.addFieldError("business.email", "��������ȷ�������ַ");
				}
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
			return "businessLogin";
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
		//List<Advertise> temp = business.getAdvertises();
		int count = advertiseService.getAdvertiseCountByBid(business.getId(), 0) + advertiseService.getAdvertiseCountByBid(business.getId(), 1);
		this.getPagingParameter(count);
		if (currentPage < 1) currentPage = 1;
		if (currentPage > this.lastPage){
			currentPage = lastPage;
			this.firstResult = (this.currentPage-1)*this.pageSize;
		}
		//advertises = temp.subList((currentPage-1)*pageSize + 1, pageSize > temp.size() ? temp.size() : pageSize);
		advertises = advertiseService.getAdvertiseByBid(business.getId(), firstResult, pageSize);
		ActionContext.getContext().put("count", count);
		
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
				} else {
					if (!business.getTelephone().matches("(13|14|15|18|17)[0-9]{9}")) {
						this.addFieldError("business.telephone", "��������ȷ���ֻ�����");
					}
				}
				if (business.getAddress() == null || "".equals(business.getAddress())) {
					addFieldError("business.address", "��ҵ��ַ����Ϊ��");
				} else {
					if (business.getAddress().length()>255) {
						this.addFieldError("business.address", "��ҵ��ַ���Ȳ��ܳ���255");
					}
				}
				if (business.getDescription() == null || "".equals(business.getDescription())) {
					addFieldError("business.description", "��ҵ��������Ϊ��");
				} else {
					if (business.getDescription().length() > 255) {
						this.addFieldError("business.description", "��ҵ�������Ȳ��ܳ���255");
					}
				}
				if (business.getUrl() == null || "".equals(business.getUrl())) {
					addFieldError("business.url", "��ҵ�������Ӳ���Ϊ��");
				}if (business.getEmail() == null || "".equals(business.getEmail())) {
					addFieldError("business.email", "��ҵ���䲻��Ϊ��");
				} else {
					if (!business.getEmail().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
						this.addFieldError("business.email", "��������ȷ�������ַ");
					}
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
			Business business = businessService.getBusinessByID(this.business.getId());
			//advertises = business.getAdvertises().subList(1, pageSize > business.getAdvertises().size() ? business.getAdvertises().size() : pageSize);
			advertises = advertiseService.getAdvertiseByBid(business.getId(), firstResult, pageSize);
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
