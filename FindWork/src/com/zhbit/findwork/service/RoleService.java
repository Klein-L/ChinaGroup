package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Role;

public interface RoleService {
	
	/**
	 * ������ɫ
	 * @param role
	 */
	public int addRole(Role role);
	
	/**
	 * �޸Ľ�ɫ��Ϣ
	 * @param role
	 */
	public int updateRole(Role role);
	
	/**
	 * ����ID��ѯ��ɫ��Ϣ
	 * @param id
	 * @return
	 */
	public Role getRoleByID(int id);
	
	/**
	 * ���ݽ�ɫ���ֲ�ѯ��ɫ��Ϣ����ѯ�ã�
	 * @param name
	 * @return
	 */
	public List<Role> getRolesByName(String name);
	
	/**
	 * ����IDɾ����ɫ
	 * @param id
	 */
	public void deleteRoleByID(int id);
	
	/**
	 * ���ݷ�ҳ����ĳһҳ�Ľ�ɫ��Ϣ�б�
	 * @param firstResult Ҫ��ѯ�ĵ�һ����¼
	 * @param maxResults  ҳ���С
	 * @return
	 */
	public List<Role> getRoleByPage(int firstResult, int maxResults);
	
	/**
	 * ��ȡ������������
	 * @return
	 */
	public int getCount();
}
