package com.zhbit.findwork.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.service.AdvertiseService;
/**
 * ������action��������ҵ����Ƹ��Ϣ��
 * 
 * @author SX
 * @description TODO
 * @date 2020��5��25��
 */
public class SearchAction extends ActionSupport{
	
	private String postName;
	private AdvertiseService advertiseService;
	private int currentPage = 1;			//��ǰҳ�棨��ҳ��Ĭ�ϵ�ǰҳ����ҳ
	private int firstResult;			//������¼����ҳ��
	private int lastPage;				//���һҳҳ��
	private int pageSize = Integer.parseInt(ServletActionContext.getServletContext().getInitParameter("maxResults"));
	private List<Advertise> advertises;	//������������Ƹ��Ϣ�б�
	private int count;					//�����������
	
	
	
	public List<Advertise> getAdvertises() {
		return advertises;
	}
	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	/**
	 * ���ݸ�λģ��������Ƹ��Ϣ
	 * @return
	 */
	public String getAdvertisesByPostSearch() {
		count = advertiseService.getCountByPostSearch(postName);
		this.getPagingParameter(count);
		advertises = advertiseService.getAdvertisesByPostSearch(postName, firstResult, pageSize);
		return "showAdvertisesByPostSearch";
	}
	//���ݵ�ǰҳ���ҳ���С�������ҳ��Ҫ������
	private void getPagingParameter(int count) {
		this.firstResult = (this.currentPage-1)*this.pageSize;
		this.lastPage = (int) Math.ceil(count/(this.pageSize*1.0));
		return ;
	}
}
