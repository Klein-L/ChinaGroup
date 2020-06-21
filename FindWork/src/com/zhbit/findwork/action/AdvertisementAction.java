package com.zhbit.findwork.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertisement;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.AdvertisementService;
import com.zhbit.findwork.service.BusinessService;
/**
 * ���action��
 * 
 * @author ������
 *
 */
public class AdvertisementAction extends ActionSupport  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  List<Advertisement> ads;
	private Advertisement ad;
	private AdvertisementService  advertisementService;
	private String businessName;
	private String target;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	private BusinessService businessService;
	private List<Integer>  adids=new ArrayList<Integer>();
	


	private File Header; //ͷ��
	private String HeaderFileName;//�ļ���
	private String HeaderContentType;//�ļ�����
	
	private String message;				//���ڷ�����Ϣ��ҳ�棬��ʾ�û�
	private String errorMessage;		//��ʾ�쳣��Ϣ
	public String readHeader(){
		ad=advertisementService.getAdvertisementByPosition(ad.getPosition());
		return "readHeader";
	}
	public InputStream getInputStream() throws Exception{
		
		try{
			InputStream inputStream = new FileInputStream(ad.getPicture());
			return inputStream;
		}catch(Exception e){
			//
			InputStream inputStream = new FileInputStream("D:\\ad.jpg");
			return inputStream;
		}
		
		
	}
	
	//��֤�޸Ĺ���
		public void validateChange(){
			if(ad.getTopic()==null||ad.getTopic().equals("")){
				  this.addFieldError("topic", "�����ⲻ��Ϊ��");
			   }
			   if(ad.getTopic().length()>20){
					  this.addFieldError("topic", "�����ⳤ�Ȳ��ܳ���20");
			   }
			   if(ad.getCost()==null||ad.getCost().equals("")){
				   this.addFieldError("cost", "���ò���Ϊ��");
			   }
			   if(!ad.getCost().matches("^[0-9]*$")){
				   this.addFieldError("cost", "���ð����Ƿ��ַ���������������");
			   }
			   if(ad.getUrl()==null||ad.getUrl().equals("")){
				   this.addFieldError("url", "������Ӳ���Ϊ��");
			   }			 
			   if(businessName==null||businessName.equals("")){
				   this.addFieldError("business", "��ҵ���ֲ���Ϊ��");		   
			   }
			   if(businessService.getBusinessesByName(businessName).size()==0){
				   this.addFieldError("business", "��ҵ���ֲ�����");		   
			   }
			   if(ad.getPosition()==0){
				   this.addFieldError("id", "���λ����Ϊ��");	
			   }			 
			   getallADs();			   
		       adids.add(advertisementService.getAdvertisementById(ad.getId()).getPosition());
		}
	public String change(){					
		Business business =businessService.getBusinessesByName(businessName).get(0);
		Advertisement temp=advertisementService.getAdvertisementById(ad.getId());
		ad.setPicture(temp.getPicture());
		ad.setCreate_at(temp.getCreate_at());
		ad.setComment(temp.getComment());
		ad.setBusiness(business);	
		advertisementService.changeAD(ad);
		return "add";
	}
	
	//չʾ�޸�ҳ��
	public String showChange(){
		
		getallADs();		
		ad=advertisementService.getAdvertisementById(ad.getId());
		businessName=ad.getBusiness().getName();
		adids.add(ad.getPosition());
		target="change";
		return "showChange";
	}
	
	//��֤��ӹ���
	public void validateAdd(){
	   if(ad.getTopic()==null||ad.getTopic().equals("")){
		  this.addFieldError("topic", "�����ⲻ��Ϊ��");
	   }
	   if(ad.getTopic().length()>20){
			  this.addFieldError("topic", "�����ⳤ�Ȳ��ܳ���20");
	   }
	   if(ad.getCost()==null||ad.getCost().equals("")){
		   this.addFieldError("cost", "���ò���Ϊ��");
	   }
	   if(!ad.getCost().matches("^[0-9]*$")){
		   this.addFieldError("cost", "���ð����Ƿ��ַ���������������");
	   }
	   if(ad.getUrl()==null||ad.getUrl().equals("")){
		   this.addFieldError("url", "������Ӳ���Ϊ��");
	   }
	   if(HeaderFileName==null||HeaderFileName.equals("")){
		 this.addFieldError("picture", "��ѡ���µĹ������ͼƬ");
		}
	   if(Header==null||!Header.exists()){
			 this.addFieldError("picture", "����ʽ����ȷ");
		}	 
	   if(businessName==null||businessName.equals("")){
		   this.addFieldError("business", "��ҵ���ֲ���Ϊ��");		   
	   }
	   if(businessService.getBusinessesByName(businessName).size()==0){
		   this.addFieldError("business", "��ҵ���ֲ�����");		   
	   }
	   if(ad.getPosition()==0){
		   this.addFieldError("id", "���λ����Ϊ��");	
	   }
	 
	   getallADs();
	}
	public String add(){	
		Business business =businessService.getBusinessesByName(businessName).get(0);
		ad.setBusiness(business);
		setADPicture();//����ͼƬ
		advertisementService.addAD(ad);	
		return "add";
	}
	
	public void setADPicture(){
		String imagePath="/upload/Advertisement/"+
				UUID.randomUUID().toString()+
						HeaderFileName.substring(HeaderFileName.lastIndexOf("."));		
				//���þ���·��
				String path=ServletActionContext.
						getServletContext().getRealPath(imagePath);
				//�����µ��ļ�
				File file=new File(path);
				try {
					FileUtils.copyFile(Header, file);
					//��ȡ��ǰ�û�
					ad.setPicture(path);
					//���浱ǰͷ�����·����ҳ���ȡ
					message="ͷ�񱣴�ɹ�";				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
	}
	
	public String showAddAD(){	
		target="add";
		getallADs();
		return "showAddAD";
	}
	
	//�������õĹ��λ
	public void getallADs(){
		ads = advertisementService.getAllAdvertisements();
		for(int i=0;i<5;i++){
			adids.add(i+1);
		}	
		for(int j=0;j<ads.size();j++){
			for(int i=0;i<adids.size();i++){			
				if(ads.get(j).getPosition()==adids.get(i)){
					adids.remove(i);					
				}
			}
		}
	}
	
	public String deleteById(){
		advertisementService.deleteAD(ad.getId());
		return "deleteById";
	}
	
	//��ȡ���еĹ��
	public String getAllAdvertisements(){
		ads = advertisementService.getAllAdvertisements();
		return "getAllAdvertisements";		
	}
	
	
	public AdvertisementService getAdvertisementService() {
		return advertisementService;
	}
	public void setAdvertisementService(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}
	public BusinessService getBusinessService() {
		return businessService;
	}
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
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
	public List<Advertisement> getAds() {
		return ads;
	}
	public void setAds(List<Advertisement> ads) {
		this.ads = ads;
	}
	public Advertisement getAd() {
		return ad;
	}
	public void setAd(Advertisement ad) {
		this.ad = ad;
	}
	public List<Integer> getAdids() {
		return adids;
	}

	public void setAdids(List<Integer> adids) {
		this.adids = adids;
	}
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
}
