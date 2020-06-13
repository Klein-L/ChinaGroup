package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Advertisement;

/**
 * ���Dao�ӿ�
 * @author ������
 *
 */
public interface AdvertisementDao {
 /**
  * ���һ�����
  **/
	public void add(Advertisement ad);
/**
*  ͨ��id��ȡ���
 **/
	public Advertisement getAdvertisementById(int adId);
/**
*  �޸Ĺ��
**/
	public void change(Advertisement ad);
	/**
	*  ɾ�����
	**/
	public void delete(int adId);
	/**
	*  ��ȡ���еĹ��
	**/
	public List<Advertisement> getAllAdvertisements();
	
}
