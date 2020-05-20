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

	/**
	 * 0:�޸ĳɹ�
	 * 1:�Ѵ���
	 */
	@Override
	public int updateRole(Role role) {
		List<Role> rolesInDB = (List<Role>) roleDao.getRolesByNameInAll(role.getName());
		Role roleInDB = roleDao.getRoleByID(role.getId());
		if (rolesInDB.size() == 0) {
			//˵�����ݿ����������û���ã�Ҳ֤���޸��˽�ɫ�� ִ���޸�
			this.setRoleForUpdate(roleInDB, role);
			roleDao.updateRole(roleInDB);
			return 0;
		} else {
			if (role.getId() == rolesInDB.get(0).getId()) {
				//˵��Ҫ�޸���Ϣ�Ľ�ɫû���޸����֣��޸��˱���ֶ� ִ���޸�
				this.setRoleForUpdate(roleInDB, role);
				roleDao.updateRole(roleInDB);
				return 0;
			} else {
				return 1;
			}
		}
	}

	private void setRoleForUpdate(Role r1, Role r2) {
		r1.setName(r2.getName());
		r1.setComment(r2.getComment());
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
