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
	
	
	/**
	 * ��ȡ������ҵְλδ�����Ϣ
	 * @param advertise
	 */
	public List<Advertise> getUnFinAdvertise();
	
	/**
	 * ������˱�־��ȡ��Ƹ��Ϣ�б�
	 * @param firstResult
	 * @param maxResults
	 * @param check
	 * @return
	 */
	public List<Advertise> getAdvertiseByPageWithCheck(int firstResult,
			int maxResults, int check);
	
	/**
	 * ������ҵid��ȡ��Ƹ��Ϣ
	 * @param bid
	 * @param check
	 * @return
	 */
	public List<Advertise> getAdvertiseByBid(int bid,int check);
	
	/**
	 * ������ҵid��ȡ����ҵ������Ƹ��Ϣ����
	 * @param bid
	 * @return
	 */
	public int getAdvertiseCountByBid1(int bid);
	//������ҵid����˱�ʶ��ȡ����ҵ������Ƹ��Ϣ����
	public int getAdvertiseCountByBid(int bid, int check);
	
	//����δ��������Ƹ��Ϣ����
	public int getUnFinAdvertiseCount();
	
	//������ҵid��ȡ��Ƹ��Ϣ��ҳ�б�
	public List<Advertise> getAdvertiseByBid(int bid,int firstResult,int maxResults);
	
	
	//���ݸ�λ������Ƹ��Ϣ�б���ҳ��
	public List<Advertise> getAdvertisesByPostSearch(String postName, int firstResult, int maxResults);
	
	//���ݸ�λ������Ƹ��Ϣ����������
	public int getCountByPostSearch(String postName);
	
	//���ݳ�������
	
	//���ݹ�������
}
