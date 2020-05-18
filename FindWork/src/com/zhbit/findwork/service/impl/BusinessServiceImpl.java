package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.BusinessDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.BusinessService;


/**
 * ��ҵҵ��ӿ�ʵ����
 * @author SX
 * @description TODO
 * @date 2020��5��16��
 */
public class BusinessServiceImpl implements BusinessService {
	
	private BusinessDao businessDao;
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
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
		List<Business> businessesInDB = (List<Business>) businessDao.getBusinessesByName(business.getName());
		if (businessesInDB.size() == 0) {
			//˵�����ݿ����������û���ã�Ҳ֤����ҵ�޸����Լ������� ִ���޸�
			businessDao.updateBusiness(business);
			return 0;
		} else {
			if (business.getId() == businessesInDB.get(0).getId()) {
				//˵��Ҫ�޸���Ϣ����ҵû���޸����֣��޸��˱���ֶ� ִ���޸�
				businessDao.updateBusiness(business);
				return 0;
			} else {
				return 1;
			}
		}
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
	public int getCount() {
		int count = businessDao.getCount();
		return count;
	}

}
