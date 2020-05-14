package com.zhbit.findwork.dao.impl;

import java.util.Date;

import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.RoleDao;
import com.zhbit.findwork.entity.Role;

/**
 * RoleDaoʵ����
 * @author SX
 *
 */
public class RoleDaoImpl implements RoleDao{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * ��ӽ�ɫ
	 */
	@Override
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}
	
}
