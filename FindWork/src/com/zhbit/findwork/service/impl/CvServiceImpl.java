package com.zhbit.findwork.service.impl;
import java.util.List;

/**
 * ����ҵ��ӿ�ʵ����
 * @author ����ƽ
 *@description
 *@date 2020��5��16��
 */
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
		cvDao.addCv(cv);
		return true;
	
	}

	@Override
	public boolean updateCv(Cv cv) {
		Cv cv2 = cvDao.getCvByID(cv.getId());
		if (cv.getId() == cv2.getId()) {
			this.setCvForUpdate(cv2,cv);
			cvDao.updateCv(cv2);
			return true;
		}else {
			return false;
		}
		
	}
	//�޸ļ�����Ϣ�ĸ�������
	private void setCvForUpdate(Cv c1,Cv c2){
		c1.setName(c2.getName());
		c1.setTelephone(c2.getTelephone());
		c1.setLive_city(c2.getLive_city());
		c1.setLive_province(c2.getLive_province());
		c1.setPolitics_status(c2.getPolitics_status());
		c1.setEducation_background(c2.getEducation_background());
		c1.setWant_low_wages(c2.getWant_low_wages());
		c1.setWant_large_wages(c2.getWant_large_wages());
		c1.setWant_joy_type(c2.getWant_joy_type());
		c1.setWant_city(c2.getWant_city());
		c1.setWant_province(c2.getWant_province());
		c1.setWant_post(c2.getWant_post());
		c1.setExperience(c2.getExperience());
		c1.setSkill(c2.getSkill());
		c1.setSelf(c2.getSelf());
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
	
	@Override
	public List<Cv> getAllCv(){
		return cvDao.getAllCvList();
	}

	@Override
	public List<Cv> getCvListByUserId(int userid) {
		// TODO Auto-generated method stub
		return cvDao.getCvListByUserId(userid);
	}

}
