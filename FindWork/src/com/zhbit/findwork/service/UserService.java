package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.User;

/**
 * �û�ҵ��ӿ�
 * @author ������
 * @description TODO
 * @date 2020��5��17��
 */
public interface UserService {
	/**ע��ʹ�ýӿ�
	 * �ж��û����Ƿ��Ѿ�����
	 * @param name
	 */
	public boolean isExistName(String name);
	/**��¼ʹ�ýӿ�
	 *�����û����������ѯ�û�
	 * @param name
	 */
	public User getUserByNameAndPassword(String name,String password);
	 /**ע��ʹ�ýӿ�
	 * �����û�
	 * @param user
	 */
	public boolean addUser(User user);
	/**
	 * ������ҵ�ղ�
	 * @param c_b
	 */
	public boolean addCollection_Business(Collection_Business c_b);
	/**
	 * ɾ���ղص���ҵ
	 * @param userid businessid
	 */
	public boolean deleteCollection_Business(int userid,int businessid);
	/**
	 * �鿴�ղص���ҵ
	 * @param userid
	 */
	public List<Business> getBusinessesByUserId(int userid);
	/**
	 * ���ݷ�ҳ����ĳһҳ���û��ղص���ҵ�б�
	 *  @param userid  ��ǰ�û�
	 * @param firstResult Ҫ��ѯ�ĵ�һ����¼
	 * @param maxResults  ҳ���С
	 * @return
	 */
	public List<Business> getBusinessesByPage(int userid,int firstResult, int maxResults);
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
