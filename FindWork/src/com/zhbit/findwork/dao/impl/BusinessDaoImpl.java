package com.zhbit.findwork.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.BusinessDao;
import com.zhbit.findwork.entity.Business;

/**
 * 
 * @author SX
 * @description ��ҵdao��ʵ����
 * @date 2020��5��14��
 */
public class BusinessDaoImpl implements BusinessDao {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean isExist(String name) {
		String hql = "from Business where name = :businessName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("businessName", name);
		List<Business> businesses = query.list();
		if (businesses == null || businesses.size() == 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<Business> getBusinessByNameAndPassword(String name, String password) {
		String hql = "from Business where name = :name and password = :password and delete_flag = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", name).setParameter("password", password);
		List<Business> businesses = query.list();
		return businesses;
	}

	@Override
	public void addBusiness(Business business) {
		business.setCreate_at(new Date());
		business.setUpdate_at(new Date());
		business.setCheck_flag(0);
		sessionFactory.getCurrentSession().save(business);
	}

	@Override
	public void updateBusiness(Business business) {
		business.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().merge(business);
	}

	@Override
	public Business getBusinessByID(int id) {
		Business business = (Business)sessionFactory.getCurrentSession().get(Business.class, id);
		if (business != null) {
			if (business.getDelete_flag() == 1) {
				return null;
			}
		}
		return business;
	}

	@Override
	public List<Business> getBusinessesByName(String name) {
		String hql = "from Business where name = :businessName and delete_flag = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("businessName", name);
		List<Business> businesses = query.list();
		return businesses;
	}

	@Override
	public void deleteBusinessByID(int id) {
		//Business business = new Business();
		//business.setId(id);
		Business business = (Business) sessionFactory.getCurrentSession().get(Business.class, id);
		business.setDelete_flag(1); //��ɾ����ʶ��Ϊ1����ʶ�ü�¼��ɾ��
		business.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(business);
	}

	@Override
	public List<Business> getBusinessesByPage(int firstResult, int maxResults) {
		String hql = "from Business where delete_flag = 0 order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(firstResult)
			.setMaxResults(maxResults);
		List<Business> businesses = query.list();
		return businesses.size() == 0 ? null : businesses;
	}

	@Override
	public int getCount() {
		String hql = "select count(id) from Business where delete_flag = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long)query.uniqueResult(); //��õ�����ֻ��ΪLong�ͣ���Ҫ�Լ���ת��Ϊint
		String temp = String.valueOf(sum);  //ǿ��ת���ᱨ��Cannot cast from Long to int
		int count = Integer.parseInt(temp);    //����תString����תint
		return count;
	}

	

}
