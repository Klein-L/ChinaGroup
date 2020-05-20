package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.RoleService;

public class RoleAction extends ActionSupport {
	
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	private Role role;
	private List<Role> roles;
	private String message;//��ʾ��Ϣ
	private String errorMessage;//������ʾ��Ϣ
	
	public void setRole(Role role) {
		this.role = role;
	}
	public Role getRole() {
		return role;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * ��ӽ�ɫ����֤
	 */
	public void validateAdd() {
		if (role.getName() == null || "".equals(role.getName())) {
			addFieldError("role.name", "��ɫ������Ϊ��");
		}
	}
	/**'
	 * ���role
	 * @return
	 */
	public String add() {
		int result = roleService.addRole(role);
		if (result == 0) {
			//���ݿ������иý�ɫ
			errorMessage = "���ݿ������иý�ɫ";
			return "showAdd";
		} else if (result == 1) {
			//����ɹ�
			message = "��ɫ�����ɹ�";
			roles = roleService.getAllRoles();
			return "showAllRoles";
		}
		return "showAllRoles";
//		System.out.println("add...");
//		return NONE;
	}
	
	public String showUpdatePage() {
		role = roleService.getRoleByID(role.getId());
		return "showUpdatePage";
	}

	/**
	 * �޸Ľ�ɫ����֤
	 */
	public void validateUpdate() {
		if (role.getName() == null || "".equals(role.getName())) {
			addFieldError("role.name", "��ɫ������Ϊ��");
		}
	}
	/**
	 * �޸Ľ�ɫ
	 * @return
	 */
	public String update() {
		int result = roleService.updateRole(role);
		System.out.println(111);
		if (result == 0) {
			//�޸ĳɹ�
			message = "�޸ĳɹ�";
			roles = roleService.getAllRoles();
			return "showAllRoles";
		} else if (result == 1) {
			//�Ѵ���
			errorMessage = "�ý�ɫ�Ѵ���";
			return "showUpdatePage";
		}
		return "showUpdatePage";
	}
	
	/**
	 * ��ȡ���н�ɫ
	 * @return
	 */
	public String getAllRoles() {
		roles = roleService.getAllRoles();
		return "showAllRoles";
	}
	
	/**
	 * ɾ����ɫ
	 * @return
	 */
	public String delete() {
		roleService.deleteRoleByID(role.getId());
		message = "��ɫɾ���ɹ�";
		roles = roleService.getAllRoles();
		return "showAllRoles";
	}
	
}
