package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Advertisement;

/**
 * ���ҵ��ӿ�
 * @author ������
 * @description TODO
 * @date 2020��6��13��
 */
public interface AdvertisementService {
/**
 * ���һ�����
 * */
	public boolean addAD(Advertisement ad);
	/**
	 * ɾ��һ�����
	 * */
	public boolean deleteAD(int adId);
	/**
	 * �޸Ĺ��
	 * */
	public boolean changeAD(Advertisement ad);
	/**
	 * ͨ�����id��ȡ�ù��
	 * */
	public Advertisement getAdvertisementById(int adId);
	/**
	*  ��ȡ���еĹ��
	**/
	public List<Advertisement> getAllAdvertisements();
}
