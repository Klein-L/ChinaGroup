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
	 * �������ֺ������ѯ��ҵ����¼��
	 * @param name
	 * @param password
	 * @return
	 */
	public List<Business> getBusinessByNameAndPassword(String name, String password);
	
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
	 * ������ҵ���ֲ�ѯ��ҵ��Ϣ��ȫ���ѯ�������Ƿ�ɾ����
	 * ��Ϊ�޸�ʱ�������⣺��ҵ�����޸��Լ�����ҵ��Ϊ��ɾ������ҵ�����ⲻ������
	 * Ӧ�õ����ǰ����ݿ������ɾ����������ֲſ��ã������Ӵ˷���
	 * @param name
	 * @return
	 */
	public List<Business> getBusinessesByNameInAll(String name);
	
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
	 * ��ȡĳһҳ����ҵ��Ϣ���������״̬��
	 * 0:����� 1��ͨ�� -1��δͨ��  
	 * @param firstResult
	 * @param maxResults
	 * @param check_flag ���״̬
	 * @return
	 */
	public List<Business> getBusinessesByPageWithCheck(int firstResult, int maxResults, int check_flag);
	
	
	/**
	 * ��ȡ�����������������״̬��
	 * @param flag
	 * @return
	 */
	public int getCountByCheckFlag(int flag);
	
	/**
	 * ��ȡ������������
	 * @return
	 */
	public int getCount();
	
	/**
	 * ������ҵ����������ҵ��ģ����ѯ��
	 * @param firstResult
	 * @param maxResults
	 * @param nameҪ��ѯ����ҵ��
	 * @return
	 */
	public List<Business> getBusinessesByNameSearch(int firstResult, int maxResults, String name);
	
	/**
	 * ��ȡģ����ѯ����������
	 * @param name
	 * @return
	 */
	public int getCountByNameSearch(String name);
	
}



















