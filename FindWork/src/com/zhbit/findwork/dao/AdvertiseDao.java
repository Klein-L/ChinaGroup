package com.zhbit.findwork.dao;
/**
 * @author ����
 */

import java.util.List;

import com.zhbit.findwork.entity.Advertise;

public interface AdvertiseDao {

	/*
	 * ����ְλ
	 * @param advertise
	 */
	public void addAdvertise(Advertise advertise);
	/*
	 * �޸�ְλ��Ϣ
	 * @param advertise
	 */
	public void updateAdvertise(Advertise advertise);
	/*
	 * ����IDɾ��ְλ��Ϣ
	 * @param advertise
	 */
	public void deleteAdvertiseByID(int id);
	/*
	 *����ID��ѯְλ��Ϣ
	 *
	 * @param advertise
	 */
	public Advertise getAdvertiseByID(int id);
	
	
	/*
	 *������ѯְλ��Ϣ
	 *
	 * @param advertise
	 */
	public List<Advertise> getAdvertiseByExample(Advertise advertise);
}
