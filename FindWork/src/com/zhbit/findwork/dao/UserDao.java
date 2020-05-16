package com.zhbit.findwork.dao;

import java.util.List;
import com.zhbit.findwork.entity.User;

public interface UserDao {
	/**
	 * �����û����ֲ�ѯ�û��Ƿ����
	 * @return
	 */
	public boolean isExist(String name);
	/**
	 * �����û�
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * ����ID��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	public User getUserByID(int id);
	/**
	 * �����û����ֲ�ѯ�û���Ϣ����ѯ�ã�
	 * @param name
	 * @return
	 */
	public List<User> getUserListByName(String name);
	
	/**
	 * ����IDɾ���û�
	 * @param id
	 */
	public void deleteUserByID(int id);
	
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
