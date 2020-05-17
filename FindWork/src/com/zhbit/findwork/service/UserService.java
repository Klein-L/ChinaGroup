package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.User;

/**
 * �û�ҵ��ӿ�
 * @author ������
 * @description TODO
 * @date 2020��5��17��
 */
public interface UserService {
	/**
	 * �����û�
	 * @param user
	 */
	public boolean addUser(User user);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	public boolean updateUser(User user);
	/**
	 * ����ID��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	public User getUserByID(int id);
	/**
	 * ��ѯ���е��û�����ѯ�ã�
	 * @param 
	 * @return
	 */
	public List<User> getAllUsers();
	/**
	 * �����û�����ѯ�û�����ѯ�ã�
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	
	/**
	 * ����IDɾ���û�
	 * @param id
	 */
	public boolean deleteUserByID(int id);
	
	/**
	 * ���ݷ�ҳ����ĳһҳ���û���Ϣ�б�
	 * @param firstResult Ҫ��ѯ�ĵ�һ����¼
	 * @param maxResults  ҳ���С
	 * @return
	 */
	public List<User> getUserByPage(int firstResult, int maxResults);
	
	/**
	 * ��ȡ������������
	 * @return
	 */
	public int getCount();
}
