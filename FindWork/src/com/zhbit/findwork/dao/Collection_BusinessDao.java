package com.zhbit.findwork.dao;

import java.util.List;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Business;
/**
 * 
 * @author ������
 *
 */
public interface Collection_BusinessDao {
	/**
	 * ���һ���ղص���ҵ
	 * ����һ����ҵ�ղض���Ȼ�󱣴�
	 * @param c_b
	 * @return
	 */
	public void add(Collection_Business c_b);
	/**
	 * 
	 * �жϸ��û��Ƿ��Ѿ��ղظ���ҵ
	 * @param c_b
	 * @return
	 */
	public boolean isExist(Collection_Business c_b);
	/**
	 * ��ѯ�û��ղص�������ҵ
	 * userid
	 * @return
	 */
	public List<Business> getBusinessesByUserId(int userid);
	/**
	 * ɾ���û��ղص���ҵ
	 * @param userid businessid
	 * @return
	 */
	public void delete(int userid,int businessid);
	/**
	 * ���ݷ�ҳ����ĳһҳ���û��ղص���ҵ�б�
	 *  @param userid  ��ǰ�û�
	 * @param firstResult Ҫ��ѯ�ĵ�һ����¼
	 * @param maxResults  ҳ���С
	 * @return
	 */
	public List<Business> getBusinessesByPage(int userid,int firstResult, int maxResults);
}
