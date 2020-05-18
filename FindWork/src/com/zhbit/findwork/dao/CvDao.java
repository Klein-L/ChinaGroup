package com.zhbit.findwork.dao;
/**
 * @author ����ƽ
 */
import java.util.List;

import com.zhbit.findwork.entity.Cv;

public interface CvDao {

	/**
	 * �����û����ֲ�ѯ�û��Ƿ����
	 * @return
	 */
	public boolean isExistbyName(String name);
	/**
	 * �����û�id��ѯ�û��Ƿ����
	 * @return
	 */
	public boolean isExistbyId(String id);
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
}
