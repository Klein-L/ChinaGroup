package com.zhbit.findwork.service.impl;

import java.util.Date;
import java.util.List;

import com.zhbit.findwork.dao.AdvertiseDao;
import com.zhbit.findwork.dao.BlackListDao;
import com.zhbit.findwork.dao.BusinessDao;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.BlackList;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.BlackListService;
/**
 * ���������ܽӿ�ʵ����
 * @author ������
 * @description TODO
 * @date 2020��6��12��
 */
public class BlackListServiceImpl implements BlackListService{

	private BlackListDao blackListDao;
	private BusinessDao businessDao;
	private AdvertiseDao advertiseDao;
	
	public AdvertiseDao getAdvertiseDao() {
		return advertiseDao;
	}

	public void setAdvertiseDao(AdvertiseDao advertiseDao) {
		this.advertiseDao = advertiseDao;
	}

	public BusinessDao getBusinessDao() {
		return businessDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public BlackListDao getBlackListDao() {
		return blackListDao;
	}

	public void setBlackListDao(BlackListDao blackListDao) {
		this.blackListDao = blackListDao;
	}

	@Override
	public boolean addBusinessToBlackList(User user, Business business,String comment) {
		// TODO Auto-generated method stub
		if(blackListDao.isBusinessExited(user.getId(), business.getId())){
			return false;//����ʧ��		
		}
		else{
			BlackList bl = new BlackList();
			bl.setUser(user);
			bl.setBusiness(business);
			bl.setUpdate_at(new Date());
			bl.setCreate_at(new Date());
			bl.setComment(comment);
			blackListDao.add(bl);
			return true;//����ɹ�
		}
		
	}

	@Override
	public boolean addAdvertiseToBlackList(User user, Advertise advertise,String comment) {
		// TODO Auto-generated method stub
		if(blackListDao.isAdvertiseExited(user.getId(), advertise.getId())){
			return false;//����ʧ��		
		}
		else{
			BlackList bl = new BlackList();
			bl.setUser(user);
			bl.setAdvertise(advertise);
			bl.setUpdate_at(new Date());
			bl.setCreate_at(new Date());
			bl.setComment(comment);
			blackListDao.add(bl);
			return true;//����ɹ�
		}
	}

	@Override
	public List<Business> getAllBusinesses() {
		// TODO Auto-generated method stub
		return blackListDao.getAllBusinesses();
	}

	@Override
	public List<Advertise> getAllAdvertises() {
		// TODO Auto-generated method stub
		return blackListDao.getAllAdvertises();
	}

	@Override
	public void complainsBusinessOfSuccess(int businessId) {
		// TODO Auto-generated method stub
		businessDao.deleteBusinessByID(businessId);
		blackListDao.complainsBusinessOfSuccess(businessId);
	}

	@Override
	public void complainsBusinessOfFaile(int businessId) {
		// TODO Auto-generated method stub
		blackListDao.complainsBusinessOfFaile(businessId);
	}

	@Override
	public void complainsAdvertiseOfSuccess(int advertiseId) {
		// TODO Auto-generated method stub
		advertiseDao.deleteAdvertiseByID(advertiseId);
		blackListDao.complainsAdvertiseOfSuccess(advertiseId);
	}

	@Override
	public void complainsAdvertiseOfFaile(int advertiseId) {
		// TODO Auto-generated method stub
		blackListDao.complainsAdvertiseOfFaile(advertiseId);
	}

}
