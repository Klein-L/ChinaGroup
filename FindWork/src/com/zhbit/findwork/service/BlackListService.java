package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.BlackList;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.User;
/**
 * ����������ҵ��ӿ�
 * @author ������
 * @description TODO
 * @date 2020��6��12��
 */
public interface BlackListService {
	/**
	 * �û�����ҵ�����������
	 * δ�ٱ���������ɹ�������ֵ true ��֮ false
	 * 
	 * conmment�����Ǿٱ���д������
	 * */	
	public boolean addBusinessToBlackList(User user,Business business,String comment);		
	/**
	 * �û�����Ƹ��Ϣ�����������
	 * δ�ٱ���������ɹ�������ֵ true ��֮ false
	 * conmment�����Ǿٱ���д������
	 * 
	 * */	
	public boolean addAdvertiseToBlackList(User user,Advertise advertise,String comment);
	/**
	 * ��ȡ���б��ٱ���,�����߻�û��˵���ҵ
	 * 
	 * */	
	public List<Business> getAllBusinesses();
	/**
	 * ��ȡ���б��ٱ���,�����߻�û��˵���Ƹ��Ϣ
	 * 
	 * */	
	public List<Advertise> getAllAdvertises();
	/**
	 * ���Ͷ����ҵ�ɹ�
	 * */
	public void complainsBusinessOfSuccess(int businessId);
	/**
	 * ���Ͷ����ҵʧ��
	 * */
	public void complainsBusinessOfFaile(int businessId);
	/**
	 * ���Ͷ����Ƹ��Ϣ�ɹ�
	 * */
	public void complainsAdvertiseOfSuccess(int advertiseId);
	/**
	 * ���Ͷ����Ƹ��Ϣʧ��
	 * */
	public void complainsAdvertiseOfFaile(int advertiseId);
	/**
	 * ��ѯδ�����Ͷ������
	 * */
	public int getCountByStatus(int status);
	/**
	 * ��ҳ��ѯδ�����Ͷ��
	 * */
	public List<BlackList> getBlackListsByPageWithStatus(int firstResult, int maxResults, int status);
	/**
	 * ����id��ѯ
	 * */
	public BlackList getBlackListById(int id);
	/**
	 * ���º�����
	 * */
	public void updateBlackListStatus(BlackList blackList);
}
