package com.zhbit.findwork.service.impl;

import com.zhbit.findwork.dao.CvDao;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.service.CvService;

public class CvServiceImpl implements CvService {
	
	private CvDao cvDao;
	

	public CvDao getCvDao() {
		return cvDao;
	}

	public void setCvDao(CvDao cvDao) {
		this.cvDao = cvDao;
	}

	@Override
	public boolean addCv(Cv cv) {
		if (cvDao.isExistbyName(cv.getName())) {
			return false;
		}else {
			cvDao.addCv(cv);
			return true;
		}
	
	
	}

	@Override
	public boolean update(Cv cv) {
		//����û����������ݿ�
		if (cvDao.isExistbyName(cv.getName())) {
			//�жϴ��û����Ƿ�Ϊԭ�����û���
			if (cv.getId()!=cvDao.getCvByName(cv.getName()).getId()) {
				//�������ԭ�����û����������ʧ��
				return false;
			}
			//����û�����ԭ�����û��������³ɹ�
			cvDao.updateCv(cv);
			return true;
		}else {
			cvDao.updateCv(cv);
			return true;
		}
	}

	@Override
	public Cv getCvByID(int id) {
		// TODO Auto-generated method stub
		return cvDao.getCvByID(id);
	}

	@Override
	public boolean deleteCvByID(int id) {
		// �жϴ�id�Ƿ����û�������û����ɾ��ʧ��
		if (cvDao.getCvByID(id)!=null) {
			cvDao.deleteCvByID(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Cv getCvByName(String name) {
		// TODO Auto-generated method stub
		return cvDao.getCvByName(name);
	}

}
