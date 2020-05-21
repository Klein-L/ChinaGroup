package com.zhbit.findwork.dao;
/**
 * @author ����ƽ
 */
import java.util.List;

import com.zhbit.findwork.entity.Cv;

public interface CvDao {

	/*
	 * ��������
	 * @param cv
	 */
	public void addCv(Cv cv );
	/*
	 * �޸ļ�����Ϣ
	 * @param cv
	 */
	public void updateCv(Cv cv);
	/*
	 * ����IDɾ��������Ϣ
	 * @param cv
	 */
	public void deleteCvByID(int id);
	/*
	 *����ID��ѯ������Ϣ
	 *
	 * @param id
	 */
	public Cv getCvByID(int id);
	/**
	 * �����û����ֲ�ѯ������Ϣ
	 * @param name
	 * @return 
	 */
	public Cv getCvByName(String name);
	/**
	 * ��ȡ����������Ϣ
	 * @return
	 */
	public List<Cv> getAllCvList();
}
