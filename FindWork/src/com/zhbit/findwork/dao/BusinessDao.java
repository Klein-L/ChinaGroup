package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Business;

/**
 * 
 * @author SX
 *
 */
public interface BusinessDao {
	
	/**
	 * ������ҵ���ֲ�ѯ��ҵ�Ƿ����
	 * @return
	 */
	public boolean isExist(String name);
	
	/**
	 * ������ҵ
	 * @param business
	 */
	public void addBusiness(Business business);
	
	/**
	 * �޸���ҵ��Ϣ
	 * @param business
	 */
	public void updateBusiness(Business business);
	
	/**
	 * ����ID��ѯ��ҵ��Ϣ
	 * @param id
	 * @return
	 */
	public Business getBusinessByID(int id);
	
	/**
	 * ������ҵ���ֲ�ѯ��ҵ��Ϣ����ѯ�ã�
	 * @param name
	 * @return
	 */
	public List<Business> getBusinessesByName(String name);
	
	/**
	 * ����IDɾ����ҵ
	 * @param id
	 */
	public void deleteBusinessByID(int id);
	
	/**
	 * ���ݷ�ҳ����ĳһҳ����ҵ��Ϣ�б�
	 * @param firstResult Ҫ��ѯ�ĵ�һ����¼
	 * @param maxResults  ҳ���С
	 * @return
	 */
	public List<Business> getBusinessesByPage(int firstResult, int maxResults);
	
	/**
	 * ��ȡ������������
	 * @return
	 */
	public int getCount();
	
}



















