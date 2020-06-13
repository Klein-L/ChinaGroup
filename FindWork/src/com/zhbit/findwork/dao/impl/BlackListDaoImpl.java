package com.zhbit.findwork.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.zhbit.findwork.dao.BlackListDao;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.BlackList;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Advertise;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.Post;
/**
 * 
 * @author ������
 * @description ����������Dao��ʵ����
 * @date 2020��6��12��
 */

public class BlackListDaoImpl implements BlackListDao{
	
	private SessionFactory sessionFactory;
		
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(BlackList blacklist) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(blacklist);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isBusinessExited(int userId, int businessId) {
		// TODO Auto-generated method stub
		String hql="from BlackList as bl where Uid =? and BusinessID = ? and delete_flag = 0 and status=0 ";
		List<BlackList> bls=(List<BlackList>)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0,userId)
				.setParameter(1,businessId)
				.list();
		if(bls.size()==0)
		  return false;
		else
			return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isAdvertiseExited(int userId, int advertiseId) {
		// TODO Auto-generated method stub
		String hql="from BlackList as bl where Uid =? and AdvertiseID = ? and delete_flag = 0  and status=0 ";
		List<BlackList> bls=(List<BlackList>)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0,userId)
				.setParameter(1,advertiseId)
				.list();
		if(bls.size()==0)
		  return false;
		else
			return true;	
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Business> getAllBusinesses() {
		// TODO Auto-generated method stub
			String hql="from BlackList where delete_flag = 0 and status=0 and BusinessID is not null GROUP BY BusinessID";
				List<BlackList> bls=(List<BlackList>)sessionFactory.getCurrentSession()
						.createQuery(hql)						
						.list();
				//����һ����ҵ����
				List<Business> businesses= new ArrayList<Business>();
				for(int i=0;i<bls.size();i++){
					//ͨ���ղصĶ�����ҳ���ҵ��Ȼ�����������
					businesses.add(bls.get(i).getBusiness());
				}
				return businesses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertise> getAllAdvertises() {
		// TODO Auto-generated method stub
		//��
		String hql="from BlackList where delete_flag = 0 and status=0 and AdvertiseID is not null GROUP BY AdvertiseID ";
		List<BlackList> bls=(List<BlackList>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.list();		
		List<Advertise> advertises= new ArrayList<Advertise>();
		for(int i=0;i<bls.size();i++){			
			advertises.add(bls.get(i).getAdvertise());
		}
		return advertises;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void complainsBusinessOfSuccess(int businessId) {
		// TODO Auto-generated method stub
		String hql="from BlackList where delete_flag = 0 and BusinessID=?";
		List<BlackList> bls=(List<BlackList>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter(0,businessId)
				.list();
		for(int i=0;i<bls.size();i++){
			bls.get(i).setStatus(1);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void complainsBusinessOfFaile(int businessId) {
		// TODO Auto-generated method stub
		String hql="from BlackList where delete_flag = 0 and BusinessID=?";
		List<BlackList> bls=(List<BlackList>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter(0,businessId)
				.list();
		for(int i=0;i<bls.size();i++){
			bls.get(i).setStatus(-1);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void complainsAdvertiseOfSuccess(int AdvertiseId) {
		// TODO Auto-generated method stub
		String hql="from BlackList where delete_flag = 0 and AdvertiseID=?";
		List<BlackList> bls=(List<BlackList>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter(0,AdvertiseId)
				.list();
		for(int i=0;i<bls.size();i++){
			bls.get(i).setStatus(1);
		}
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void complainsAdvertiseOfFaile(int AdvertiseId) {
		// TODO Auto-generated method stub
		String hql="from BlackList where delete_flag = 0 and AdvertiseID=?";
		List<BlackList> bls=(List<BlackList>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter(0,AdvertiseId)
				.list();
		for(int i=0;i<bls.size();i++){
			bls.get(i).setStatus(-1);
		}
	}

	@Override
	public int getCountByStatus(int status) {
		String hql = "select count(id) from BlackList where delete_flag = 0 and status = :status";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("status", status);
		Long sum = (Long)query.uniqueResult(); //��õ�����ֻ��ΪLong�ͣ���Ҫ�Լ���ת��Ϊint
		String temp = String.valueOf(sum);  //ǿ��ת���ᱨ��Cannot cast from Long to int
		int count = Integer.parseInt(temp);    //����תString����תint
		return count;
	}

	@Override
	public List<BlackList> getBlackListByPageWithStatus(int firstResult, int maxResults, int status) {
		String hql = "from BlackList where delete_flag = 0 and status= :status order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(firstResult)
			.setMaxResults(maxResults)
			.setParameter("status", status);
		List<BlackList> blackList = query.list();
		return blackList;
	}

	@Override
	public BlackList getBlackListById(int id) {
		BlackList blackList = (BlackList) sessionFactory.getCurrentSession().get(BlackList.class, id);
		if (blackList != null) {
			if (blackList.getDelete_flag() == 1) {
				//˵���ü�¼�ѱ�ɾ��
				return null;
			}
		}
		return blackList;
	}

	@Override
	public void updateBlackList(BlackList blackList) {
		// TODO Auto-generated method stub
		blackList.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().merge(blackList);
	}



}
