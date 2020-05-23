package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.Collection_AdvertiseDao;
import com.zhbit.findwork.dao.Collection_BusinessDao;
import com.zhbit.findwork.dao.UserDao;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Advertise;
import com.zhbit.findwork.entity.Collection_Business;
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
	private Collection_BusinessDao collection_BusinessDao;
	private Collection_AdvertiseDao collection_AdvertiseDao;
	
	/**
	 * �ж��û����Ƿ����
	 * @retrun ����û������ڣ�����true ���򣬷���flase
	 * */	
	@Override
	public boolean isExistName(String name) {
		// TODO Auto-generated method stub
		User user=userDao.getUserByName(name);
		if(user!=null)
			return true;
		else
			return false;
	}
	
	
	@Override
	public boolean addCollection_Business(Collection_Business c_b) {
		// TODO Auto-generated method stub
		if(!collection_BusinessDao.isExist(c_b)){
			collection_BusinessDao.add(c_b);
			return true;
		}
		else
			return false;
		
	}
	@Override
	public List<Business> getBusinessesByUserId(int userid) {
		// TODO Auto-generated method stub
		return collection_BusinessDao.getBusinessesByUserId(userid);
	}
	@Override
	public boolean deleteCollection_Business(int userid, int businessid) {
		// TODO Auto-generated method stub	
		System.out.println("�����ࣺɾ��");
			collection_BusinessDao.delete(userid, businessid);
			return true;
		
	}
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
	public Collection_BusinessDao getCollection_BusinessDao() {
		return collection_BusinessDao;
	}

	public void setCollection_BusinessDao(Collection_BusinessDao collection_BusinessDao) {
		this.collection_BusinessDao = collection_BusinessDao;
	}


	@Override
	public User getUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return 	userDao.getUserByNameAndPassword(name, password);
		
	}

	@Override
	public List<Business> getBusinessesByPage(int userid, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return collection_BusinessDao.getBusinessesByPage(userid, firstResult, maxResults);
	}
	public Collection_AdvertiseDao getCollection_AdvertiseDao() {
		return collection_AdvertiseDao;
	}


	public void setCollection_AdvertiseDao(Collection_AdvertiseDao collection_AdvertiseDao) {
		this.collection_AdvertiseDao = collection_AdvertiseDao;
	}


	@Override
	public boolean addCollection_Advertise(Collection_Advertise c_a) {
		// TODO Auto-generated method stub
		if(!collection_AdvertiseDao.isExist(c_a)){
			collection_AdvertiseDao.add(c_a);
			return true;
		}
		else
			return false;
	}


	@Override
	public boolean deleteCollection_Advertise(int userid, int advertiseid) {
		// TODO Auto-generated method stub		
			collection_AdvertiseDao.delete(userid, advertiseid);
			return true;		
	}


	@Override
	public List<Advertise> getAdvertisesByUserId(int userid) {
		// TODO Auto-generated method stub
		return collection_AdvertiseDao.getAdvertisesByUserId(userid);
	}


	@Override
	public List<Advertise> getAdvertisesByPage(int userid, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return collection_AdvertiseDao.getAdvertiseByPage(userid, firstResult, maxResults);
	}


}
