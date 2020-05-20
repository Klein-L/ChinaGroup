package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;


/**
 * ְλҵ��ӿ�
 *@author ����
 *@description
 *@date 2020��5��19��
 */
public interface AdvertiseService {
	/**
	 * ����ְλ��Ϣ
	 * @param advertise
	 */
	public boolean addAdvertese(Advertise advertise);
	/**
	 * �޸�ְλ��Ϣ
	 * @param advertise
	 */
	public boolean updateAdvertese(Advertise advertise);
	/**
	 * ����ID��ѯְλ��Ϣ
	 * @param advertise
	 */
	public Advertise getAdvertiseByID(int id);
	
	/**
	 * ����IDɾ��ְλ��Ϣ
	 * @param advertise
	 */
	public boolean deleteAdvertiseByID(int id);
	
	
	/**
	 * ������ѯְλ��Ϣ
	 * @param advertise
	 */
	public List<Advertise> getAdvertiseByExample(Advertise advertise);
}
