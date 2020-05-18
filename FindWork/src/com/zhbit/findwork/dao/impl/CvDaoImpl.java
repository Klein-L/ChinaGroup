package com.zhbit.findwork.dao.impl;
import java.util.Date;
/**
 * 
 * @author ����ƽ
 * @description����dao��ʵ����
 *@date 2020��5��16��
 */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.CvDao;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.entity.User;

public class CvDaoImpl implements CvDao {
	//ע��hibernate��session���̣������ļ���application.xml��
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean isExistbyName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Cv where name = :cvName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("cvName", name);
		List<Cv> cvs = query.list();
		if (cvs == null || cvs.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isExistbyId(String id) {
		// TODO Auto-generated method stub
		String hql = "from Cv where id = :cvid";
		Cv cv = (Cv)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("cvid", id)
				.uniqueResult();
		if (cv== null) {
			return false;
		}
		return true;
	}
	@Override
	public void addCv(Cv cv) {
		cv.setCreate_at(new Date());
		cv.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(cv);

	}

	@Override
	public void updateCv(Cv cv) {
		cv.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().merge(cv);

	}

	@Override
	public void deleteCvByID(int id) {
		Cv cv = (Cv)sessionFactory.getCurrentSession().get(Cv.class, id);
		cv.setDelete_flag(1);//��ɾ����ʶ��Ϊ1����ʶ�ü�¼��ɾ��
		cv.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(cv);

	}

	@Override
	public Cv getCvByID(int id) {
		Cv cv = (Cv)sessionFactory.getCurrentSession().get(Cv.class, id);
		return cv;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cv getCvByName(String name) {
		String hql = "from Cv where name=? and delete_flag = 0 ";
		Cv cv = (Cv)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, name)
				.uniqueResult();
		return cv;
	}

}
