package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.zhbit.findwork.dao.UserDao;
import com.zhbit.findwork.entity.User;

/**
 * 
 * @author ������
 * @description �û�dao��ʵ����
 * @date 2020��5��16��
 */
public class UserDaoImpl implements UserDao {
	
	//ע��hibernate��session���̣������ļ���application.xml��
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean isExistbyName(String name) {
		// TODO Auto-generated method stub
		String hql = "from User where name = :userName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userName", name);
		List<User> users = query.list();
		if (users == null || users.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isExistbyId(String id) {
		// TODO Auto-generated method stub
		String hql = "from User where id = :userid";
		User user = (User)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userid", id)
				.uniqueResult();
		if (user== null) {
			return false;
		}
		return true;
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		user.setCreate_at(new Date());
		user.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		user.setUpdate_at(new Date());
		System.out.println("dao============================");
		sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		User user=(User)sessionFactory.getCurrentSession().get(User.class, id);
		if(user!=null)
			if(user.getDelete_flag()==1)//ɾ����־Ϊ1����ɾ�������ܱ���ѯ
				return null;
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		//0û�б�ɾ��
		String hql="from User u where name=? and delete_flag = 0 ";
		User user=(User)sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, name)
				.uniqueResult();
		return user;
	}
	

	@Override
	public void deleteUserByID(int id) {
		// TODO Auto-generated method stub
		//����ɾ����־ 1 �� ��ʾɾ��
		User user=(User)sessionFactory.getCurrentSession().get(User.class, id);
		user.setDelete_flag(1);
		user.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(user);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByPage(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		String hql="from User where delete_flag = 0 order by id";
		List<User> list=(List<User>)sessionFactory.getCurrentSession().createQuery(hql)
						.setFirstResult(firstResult)
						.setMaxResults(maxResults)
						.list();
		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from User where delete_flag = 0";
		long count=(Long)sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
		return (int)count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		String hql="from User u where delete_flag = 0";//ɾ����־
		List<User> users=(List<User>)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.list();
		return users;
	}

	@Override
	public User getUserByNameAndPassword(String name,String password) {
		// TODO Auto-generated method stub
		String hql = "from User where name = :userName and password=:password";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userName", name);
		query.setParameter("password", password);
		return (User)query.uniqueResult();
	}






}
