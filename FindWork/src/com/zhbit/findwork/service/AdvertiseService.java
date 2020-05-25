package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Cv;


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
	
	
	/**
	 * ��ȡ������ҵְλδ�����Ϣ
	 * @param advertise
	 */
	public List<Advertise> getUnFinAdvertise();
	
	/**
	 * ��ȡ������ҵְλδ�����Ϣ����
	 * @param advertise
	 */
	public int getUnFinAdvertiseCount();
	
	/**
	 * ��ҳ��ѯδ��˵�ְλ��Ϣ���������״̬��
	 * 0:δ��� 1�������
	 * @param firstResult
	 * @param maxResults
	 * @param check ���״̬
	 * @return
	 */
	public List<Advertise> getAdvertiseByPageWithCheck(int firstResult, int maxResults, int check);
	
	/**
	 * ������ҵid�����״̬��ȡְλ��Ϣ
	 * 0:δ��� 1�������
	 * @param advertise
	 */
	public List<Advertise> getAdvertiseByBid(int bid,int check);
	
	
	/**
	 * ������ҵid�����״̬��ȡְλ��Ϣ����
	 * 0:δ��� 1�������
	 * @param advertise
	 */
	public int getAdvertiseCountByBid(int bid,int check);
	
	
	/**
	 * ������ҵid��ȡְλ��Ϣ����
	 * 
	 * @param advertise
	 */
	public int getAdvertiseCountByBid(int bid);
	
	/**
	 * ������ҵid��ȡְλ��Ϣ
	 * 
	 * @param advertise
	 */
	public List<Advertise> getAdvertiseByBid(int bid,int firstResult, int maxResults);
	
	
	//���ݸ�λ������Ƹ��Ϣ�б���ҳ��
	public List<Advertise> getAdvertisesByPostSearch(String postName, int firstResult, int maxResults);
	
	//���ݸ�λ������Ƹ��Ϣ��������
	public int getCountByPostSearch(String postName);
	
	//��ҵ�鿴���ռ���
	public List<Cv> getCVOfAdvertise(int aID, int firstResult, int maxResults);
	
	//��ҵ�鿴���ռ���������
	public int getCVCountOfAdvertise(int aID);
}
