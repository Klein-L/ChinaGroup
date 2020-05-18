package com.zhbit.findwork.service;

import com.zhbit.findwork.entity.Cv;

/**
 * ����ҵ��ӿ�
 * @author tongr
 *@description
 *@date 2020��5��16��
 */
public interface CvService {
	/**
	 * ����������Ϣ
	 * @param cv
	 */
	public boolean addCv(Cv cv);
	/**
	 * �޸ļ�����Ϣ
	 * @param cv
	 */
	public boolean update(Cv cv);
	/**
	 * ����ID��ѯ������Ϣ
	 * @param cv
	 */
	public Cv getCvByID(int id);
	/**
	 * ����IDɾ��������Ϣ
	 * @param cv
	 */
	public boolean deleteCvByID(int id);
	/**
	 * �����û����ֲ�ѯ������Ϣ
	 * @param name
	 * @return 
	 */
	public Cv getCvByName(String name);
	

}
