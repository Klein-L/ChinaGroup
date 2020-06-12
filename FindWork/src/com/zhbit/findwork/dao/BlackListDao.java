package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.BlackList;
import com.zhbit.findwork.entity.Business;


/**
 * ����������
 * @author ������
 *
 */
public interface BlackListDao {
	/**
	 * ���һ������������
	 * */
	public void add(BlackList blacklist);
	/**
	 * �жϸ��û��ٱ�����ҵ�����Ƿ��Ѿ�����
	 * */	
	public boolean isBusinessExited(int userId,int businessId);
	/**
	 * �жϸ��û��ٱ�����Ƹ��Ϣ�����Ƿ��Ѿ�����
	 * */	
	public boolean isAdvertiseExited(int userId,int advertiseId);
	/**
	 * ��ȡ�������е�����δ��˵���ҵ����
	 * */	
	public List<Business> getAllBusinesses();
	/**
	 * ��ȡ�������е�����δ��˵���Ƹ��Ϣ����
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
	public void complainsAdvertiseOfSuccess(int AdvertiseId);
	/**
	 * ���Ͷ����Ƹ��Ϣʧ��
	 * */
	public void complainsAdvertiseOfFaile(int AdvertiseId);
}
