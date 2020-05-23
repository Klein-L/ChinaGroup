package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Collection_Advertise;
/**
 * 
 * @author ������
 *
 */
public interface Collection_AdvertiseDao {
	/**
	 * ���һ���ղص���Ƹ
	 * ����һ����Ƹ�ղض���Ȼ�󱣴�
	 * @param c_b
	 * @return
	 */
	public void add(Collection_Advertise c_a);
	/**
	 * 
	 * �жϸ��û��Ƿ��Ѿ��ղظ���Ƹ
	 * @param c_b
	 * @return
	 */
	public boolean isExist(Collection_Advertise c_a);
	/**
	 * ��ѯ�û��ղص�������Ƹ
	 * userid
	 * @return
	 */
	public List<Advertise> getAdvertisesByUserId(int userid);
	/**
	 * ɾ���û��ղص���Ƹ
	 * @param userid businessid
	 * @return
	 */
	public void delete(int userid,int advertiseid);
	/**
	 * ���ݷ�ҳ����ĳһҳ���û��ղص���Ƹ�б�
	 *  @param userid  ��ǰ�û�
	 * @param firstResult Ҫ��ѯ�ĵ�һ����¼
	 * @param maxResults  ҳ���С
	 * @return
	 */
	public List<Advertise> getAdvertiseByPage(int userid,int firstResult, int maxResults);
}
