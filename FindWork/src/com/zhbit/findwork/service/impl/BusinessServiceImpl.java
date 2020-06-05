package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.BusinessDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.BusinessService;
import com.zhbit.findwork.service.RoleService;


/**
 * ��ҵҵ��ӿ�ʵ����
 * @author SX
 * @description TODO
 * @date 2020��5��16��
 */
public class BusinessServiceImpl implements BusinessService {
	
	private BusinessDao businessDao;
	private RoleService roleService;
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	/**
	 * ���øýӿ�ʱ�����ֺ����봫��
	 * Ȼ���жϷ��ص�business�����Ƿ�Ϊ�ռ���
	 */
	@Override
	public Business login(String name, String password) {
		List<Business> businesses = businessDao.getBusinessByNameAndPassword(name, password);
		Business business = businesses.size() == 0 ? null : businesses.get(0);
		return business;
	}
	
	/**
	 * 0:���ݿ������иü�¼
	 * 1:����ɹ�
	 * 2:��ҵ�����ȷ�����벻һ��
	 */
	@Override
	public int addBusiness(Business business) {
		//�ж��û��������������ȷ�������Ƿ�һ��
		if (!(business.getPassword().equals(business.getConfirmPassword()))) {
			return 2;
		}
		//List<Role> roles = roleService.getRolesByName("��ҵ");
		Role role = roleService.getRoleByID(2);
		business.setRole(role);
		//����֮ǰ���ж����ݿ����Ƿ����иü�¼
		boolean exist = businessDao.isExist(business.getName());
		if (exist == true) {
			//������ݿ������иü�¼�򲻲�������
			return 0;
		} else {
			//������ݿ��в��������������
			businessDao.addBusiness(business);
			return 1;
		}
	}

	/**
	 * 0:�����޸ĳɹ�
	 * 1:�����ѱ�ռ��
	 */
	@Override
	public int updateBusiness(Business business) {
		List<Business> businessesInDB = (List<Business>) businessDao.getBusinessesByNameInAll(business.getName());
		Business businessInDB = businessDao.getBusinessByID(business.getId());
		
		if (businessesInDB.size() == 0) {
			//˵�����ݿ����������û���ã�Ҳ֤����ҵ�޸����Լ������� ִ���޸�
			this.setBusinessForUpdate(businessInDB, business);
			businessDao.updateBusiness(businessInDB);
			return 0;
		} else {
			if (business.getId() == businessesInDB.get(0).getId()) {
				//˵��Ҫ�޸���Ϣ����ҵû���޸����֣��޸��˱���ֶ� ִ���޸�
				this.setBusinessForUpdate(businessInDB, business);
				businessDao.updateBusiness(businessInDB);
				return 0;
			} else {
				return 1;
			}
		}
	}
	//�޸���ҵ�ĸ�������
	private void setBusinessForUpdate(Business b1, Business b2) {
		b1.setName(b2.getName());
		b1.setProvince(b2.getProvince());
		b1.setCity(b2.getCity());
		b1.setTelephone(b2.getTelephone());
		b1.setEmail(b2.getEmail());
		b1.setLicense_path(b2.getLicense_path() == null ? b1.getLicense_path() : b2.getLicense_path());
		b1.setAddress(b2.getAddress());
		b1.setDescription(b2.getDescription());
		b1.setUrl(b2.getUrl());
	}

	@Override
	public Business getBusinessByID(int id) {
		Business business = businessDao.getBusinessByID(id);
		return business;
	}

	@Override
	public List<Business> getBusinessesByName(String name) {
		List<Business> businesses = businessDao.getBusinessesByName(name);
		return businesses;
	}

	@Override
	public void deleteBusinessByID(int id) {
		businessDao.deleteBusinessByID(id);

	}

	@Override
	public List<Business> getBusinessesByPage(int firstResult, int maxResults) {
		List<Business> businesses = businessDao.getBusinessesByPage(firstResult, maxResults);
		return businesses;
	}
	
	@Override
	public List<Business> getBusinessesByPageWithCheck(int firstResult, int maxResults, int check_flag) {
		List<Business> businesses = businessDao.getBusinessesByPageWithCheck(firstResult, maxResults, check_flag);
		return businesses;
	}
	
	@Override
	public void updateBusinessCheckFlag(Business business) {
		Business businessInDB = businessDao.getBusinessByID(business.getId());
		businessInDB.setCheck_flag(business.getCheck_flag());
		businessInDB.setComment(business.getComment());
		businessDao.updateBusiness(businessInDB);
		return ;
	}

	@Override
	public int getCountByCheckFlag(int flag) {
		int count = businessDao.getCountByCheckFlag(flag);
		return count;
	}
	@Override
	public int getCount() {
		int count = businessDao.getCount();
		return count;
	}
	
	@Override
	public List<Business> getBusinessesByNameSearch(int firstResult, int maxResults, String name) {
		List<Business> businesses = businessDao.getBusinessesByNameSearch(firstResult, maxResults, name);
		return businesses;
	}
	
	@Override
	public int getCountByNameSearch(String name) {
		int count = businessDao.getCountByNameSearch(name);
		return count;
	}

}
