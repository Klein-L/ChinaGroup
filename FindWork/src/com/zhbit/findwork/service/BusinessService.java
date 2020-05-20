package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Business;

/**
 * ��ҵҵ��ӿ�
 * @author SX
 * @description TODO
 * @date 2020��5��16��
 */
public interface BusinessService {
	
	
	/**
	 * ��¼
	 * @param name
	 * @param password
	 * @return
	 */
	public Business login(String name, String password);
	
	/**
	 * ������ҵ
	 * @param business
	 */
	public int addBusiness(Business business);
	
	/**
	 * �޸���ҵ��Ϣ
	 * @param business
	 */
	public int updateBusiness(Business business);
	
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
	 * ��ȡĳһҳ����ҵ��Ϣ���������״̬��
	 * 0:����� 1��ͨ�� -1��δͨ��  
	 * @param firstResult
	 * @param maxResults
	 * @param check_flag ���״̬
	 * @return
	 */
	public List<Business> getBusinessesByPageWithCheck(int firstResult, int maxResults, int check_flag);
	
	/**
	 * �޸���ҵ�����״̬
	 * @param business ������˹�����ҵ����(ע��check_flag��ֵ��0:����� 1��ͨ�� -1��δͨ��  )
	 * @return
	 */
	public void updateBusinessCheckFlag(Business business);
	
	/**
	 * �������״̬��ȡ��������
	 * @param flag ���״̬��ʶ��0:����� 1��ͨ�� -1��δͨ����
	 * @return
	 */
	public int getCountByCheckFlag(int flag);
	
	/**
	 * ��ȡ������������
	 * @return
	 */
	public int getCount();
}
