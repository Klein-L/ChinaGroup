package com.zhbit.findwork.service.impl;



import java.util.List;

import com.zhbit.findwork.dao.RoleDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.RoleService;


public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}


	/**
	 * 0:���ݿ������иü�¼
	 * 1:����ɹ�
	 */
	@Override
	public int addRole(Role role) {
		boolean exist = roleDao.isExist(role.getName());
		if (exist ==  true) {
			return 0;
		} else  {
			roleDao.addRole(role);
			return 1;
		}
	}


	@Override
	public int updateRole(Role role) {
		List<Role> rolesInDB = (List<Role>) roleDao.getRolesByName(role.getName());
		if (rolesInDB.size() == 0) {
			//˵�����ݿ����������û���ã�Ҳ֤���޸��˽�ɫ�� ִ���޸�
			roleDao.updateRole(role);
			return 0;
		} else {
			if (role.getId() == rolesInDB.get(0).getId()) {
				//˵��Ҫ�޸���Ϣ����ҵû���޸����֣��޸��˱���ֶ� ִ���޸�
				roleDao.updateRole(role);
				return 0;
			} else {
				return 1;
			}
		}
	}


	@Override
	public Role getRoleByID(int id) {
		Role role = roleDao.getRoleByID(id);
		return role;
	}


	@Override
	public List<Role> getRolesByName(String name) {
		List<Role> roles = roleDao.getRolesByName(name);
		return roles;
	}


	@Override
	public void deleteRoleByID(int id) {
		Role role = roleDao.getRoleByID(id);
		role.setDelete_flag(1);
		roleDao.updateRole(role);
	}


	@Override
	public List<Role> getRoleByPage(int firstResult, int maxResults) {
		List<Role> roles = roleDao.getRolesByPage(firstResult, maxResults);
		return roles;
	}
	
	@Override
	public List<Role> getAllRoles() {
		List<Role> roles = roleDao.getAllRoles();
		return roles;
	}


	@Override
	public int getCount() {
		int count = roleDao.getCount();
		return count;
	}

}
