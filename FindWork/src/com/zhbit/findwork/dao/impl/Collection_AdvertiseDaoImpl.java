package com.zhbit.findwork.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import com.zhbit.findwork.dao.Collection_AdvertiseDao;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Collection_Advertise;


public class Collection_AdvertiseDaoImpl implements Collection_AdvertiseDao{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Collection_Advertise c_a) {
		// TODO Auto-generated method stub
		c_a.setCreate_at(new Date());
		c_a.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(c_a);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExist(Collection_Advertise c_a) {
		// TODO Auto-generated method stub
		String hql="from Collection_Advertise as cb where Uid =? and Aid = ? and delete_flag = 0 ";
		List<Collection_Advertise> cb=(List<Collection_Advertise>)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0,c_a.getUser().getId() )
				.setParameter(1, c_a.getAdvertise().getId())
				.list();
		if(cb.size()==0)
		  return false;
		else
			return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertise> getAdvertisesByUserId(int userid) {
		// TODO Auto-generated method stub
		//�ӱ��и����û�id���ҳ��ղصĶ���,ɾ����־Ϊ0
				String hql="from Collection_Advertise as cb where Uid =? and delete_flag = 0 ";
				List<Collection_Advertise> c_as=(List<Collection_Advertise>)sessionFactory.getCurrentSession()
						.createQuery(hql)
						.setParameter(0, userid)
						.list();
				//����һ����ҵ����
				List<Advertise> advertises= new ArrayList<Advertise>();
				for(int i=0;i<c_as.size();i++){
					//ͨ���ղصĶ�����ҳ���ҵ��Ȼ�����������
					advertises.add(c_as.get(i).getAdvertise());
				}
				return advertises;
	}

	@Override
	public void delete(int userid, int advertiseid) {
		// TODO Auto-generated method stub
		String hql="from Collection_Advertise as cb where Uid =? and Aid = ? and delete_flag = 0";
		Collection_Advertise c_a=(Collection_Advertise)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, userid)
				.setParameter(1, advertiseid)
				.uniqueResult();
		c_a.setDelete_flag(1);//����ɾ����־Ϊ1��ɾ��
		sessionFactory.getCurrentSession().merge(c_a);//����
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertise> getAdvertiseByPage(int userid, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		String hql="from Collection_Advertise as cb where Uid =? and delete_flag = 0 order by id";
		List<Collection_Advertise> c_as=(List<Collection_Advertise>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter(0, userid)
				.setFirstResult(firstResult)
				.setMaxResults(maxResults)
				.list();
		//����һ����ҵ����
		List<Advertise> advertises= new ArrayList<Advertise>();
		for(int i=0;i<c_as.size();i++){
			//ͨ���ղصĶ�����ҳ���ҵ��Ȼ�����������
			advertises.add(c_as.get(i).getAdvertise());
		}
		return advertises;
	}

}
