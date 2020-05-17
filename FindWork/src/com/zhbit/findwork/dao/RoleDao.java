package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Role;

/**
 * RoleDao�ӿ�
 * @author ����˸
 *
 */
public interface RoleDao {
	
	public void addRole(Role role);
	
	/**
	 * ���ݽ�ɫ���жϸý�ɫ�Ƿ����
	 * @param roleName
	 * @return
	 */
	public boolean isExist(String roleName);
	
	/**
	 * �޸Ľ�ɫ
	 * @param role
	 */
	public void updateRole(Role role);
	
	/**
	 * ɾ����ɫ
	 * @param role
	 */
	public void deleteRole(int id);
	
	/**
	 * ����ID��ȡRole
	 * @param id
	 * @return
	 */
	public Role getRoleByID(int id);
	
	/**
	 * ���ݽ�ɫ����ȡrole
	 * @param name
	 * @return
	 */
	public List<Role> getRolesByName(String name);
	/**
	 * ��ȡ��ҳ��Ҫ�Ľ�ɫ�б�
	 * @param firstResult Ҫ��ѯ�ĵ�һ����¼
	 * @param maxResults  ҳ���С
	 * @return
	 */
	public List<Role> getRolesByPage(int firstResult, int maxResults);
	
	/**
	 * ��ȡ���е���������
	 * @return
	 */
	public int getCount();
	
	

}
