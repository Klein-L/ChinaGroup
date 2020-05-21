package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.AdvertiseDao;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.service.AdvertiseService;

public class AdvertiseServiceImpl implements AdvertiseService {
	private AdvertiseDao advertiseDao;

	@Override
	public boolean addAdvertese(Advertise advertise) {
		advertiseDao.addAdvertise(advertise);
		return true;
	}

	@Override
	public boolean updateAdvertese(Advertise advertise) {
		advertiseDao.updateAdvertise(advertise);
		return true;
	}

	@Override
	public Advertise getAdvertiseByID(int id) {
		return advertiseDao.getAdvertiseByID(id);
	}

	@Override
	public boolean deleteAdvertiseByID(int id) {
		advertiseDao.deleteAdvertiseByID(id);
		return true;
	}

	public AdvertiseDao getAdvertiseDao() {
		return advertiseDao;
	}

	public void setAdvertiseDao(AdvertiseDao advertiseDao) {
		this.advertiseDao = advertiseDao;
	}

	@Override
	public List<Advertise> getAdvertiseByExample(Advertise advertise) {
		return advertiseDao.getAdvertiseByExample(advertise);
	}

	@Override
	public List<Advertise> getUnFinAdvertise() {
		
		return advertiseDao.getUnFinAdvertise();
	}

	@Override
	public List<Advertise> getAdvertiseByPageWithCheck(int firstResult,
			int maxResults, int check) {
		
		return advertiseDao.getAdvertiseByPageWithCheck(firstResult,maxResults,check);
	}

	@Override
	public List<Advertise> getAdvertiseByBid(int bid,int check) {
	
		return advertiseDao.getAdvertiseByBid(bid,check);
	}

	@Override
	public int getUnFinAdvertiseCount() {
		
		return advertiseDao.getUnFinAdvertise().size();
	}

	@Override
	public int getAdvertiseCountByBid(int bid,int check) {
		
		return advertiseDao.getAdvertiseByBid(bid,check).size();
	}
	
}
