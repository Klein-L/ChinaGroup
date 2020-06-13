package com.zhbit.findwork.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.AdvertisementDao;
import com.zhbit.findwork.entity.Advertisement;
/**
 * 
 * @author ������
 * @description ���Dao��ʵ����
 * @date 2020��6��13��
 */
public class AdvertisementDaoImpl implements AdvertisementDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Advertisement ad) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(ad);
	}

	@Override
	public Advertisement getAdvertisementById(int adId) {
		// TODO Auto-generated method stub
		String hql="from Advertisement where Aid =? and delete_flag = 0 ";
		Advertisement ad=(Advertisement)sessionFactory.getCurrentSession().createQuery(hql)
			.setParameter(0, adId)
			.uniqueResult();
		return ad;
	}

	@Override
	public void change(Advertisement ad) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(ad);
	}

	@Override
	public void delete(int adId) {
		// TODO Auto-generated method stub
		Advertisement ad=getAdvertisementById(adId);
		ad.setDelete_flag(1);
		sessionFactory.getCurrentSession().merge(ad);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getAllAdvertisements() {
		// TODO Auto-generated method stub
		String hql="from Advertisement where delete_flag = 0 ";
		List<Advertisement> ads=(List<Advertisement>)sessionFactory.getCurrentSession().createQuery(hql).list();
		return ads;
	}

}
