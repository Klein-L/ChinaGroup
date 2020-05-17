package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.UserDao;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.UserService;
/**
 * �û�ҵ��ӿ�ʵ����
 * @author ������
 * @description TODO
 * @date 2020��5��17��
 */
public class UserServiceImpl implements UserService{
	//ע��UserDao
	private UserDao userDao;
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		//����û������ڣ������ʧ��
		if(userDao.isExistbyName(user.getName()))
			return false;
		else{
			userDao.addUser(user);
			return true;
		}
		
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		//����û����������ݿ�
		if(userDao.isExistbyName(user.getName())){
			//�жϴ��û����Ƿ�ԭ�����û���
			if(user.getId()!=userDao.getUserByName(user.getName()).getId()){
				//�������ԭ���û���������ʧ��
				return false;
			}
			//����û�����ԭ�����û��������³ɹ�
			userDao.updateUser(user);
			return true;
		}
		else{
			//�û����������ݣ����³ɹ�
			userDao.updateUser(user);
			return true;	
		}
	}

	@Override
	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		//ʹ�����������Ҫ�ж��û��Ƿ�Ϊ�գ���Ϊ�п��ܷ���null
		return userDao.getUserByID(id);
	
	}
	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		//�п��ܷ��ؿ�������Ҫ�ж��������Ƿ�Ϊ0
		return userDao.getAllUsers();
	}
	
	@Override
	public boolean deleteUserByID(int id) {
		// TODO Auto-generated method stub
		//�жϴ�id�Ƿ����û�������ɾ��ʧ��
		if(userDao.getUserByID(id)!=null){
			userDao.deleteUserByID(id);
			return true;
		}
		else
			return false;
			
	}

	@Override
	public List<User> getUserByPage(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return userDao.getUserByPage(firstResult, maxResults);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return userDao.getCount();
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
