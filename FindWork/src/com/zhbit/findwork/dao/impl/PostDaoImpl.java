package com.zhbit.findwork.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.zhbit.findwork.dao.PostDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;

public class PostDaoImpl implements PostDao {

	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#addPost(com.zhbit.findwork.entity.Post)
	 */
	@Override
	public void addPost(Post p){
		p.setCreate_at(new Date());
		p.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().save(p);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#deletePost(int)
	 */
	@Override
	public void deletePost(int id) {
		Post p = (Post) sessionFactory.getCurrentSession().get(Post.class, id);
		p.setDelete_flag(1);//��ɾ����ʶ��Ϊ1����ʶ�ü�¼��ɾ��
		p.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().update(p);
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#updatePost(com.zhbit.findwork.entity.Post)
	 */
	@Override
	public void updatePost(Post p) {
		p.setUpdate_at(new Date());
		sessionFactory.getCurrentSession().merge(p);
	}
	
	@Override
	public boolean isExist(String postName) {
		String hql="from Role where name = :postName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("postName", postName);
		List<Post> ps = query.list();
		if (ps == null || ps.size() == 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<Post> getPostByName(String name) {
		String hql = "from Post where Pname = :Name and delete_flag = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("Name", name);
		List<Post> ps = query.list();
		return ps;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#getPostByID(int)
	 */
	@Override
	public Post getPostByID(int id) {
		Post p = (Post) sessionFactory.getCurrentSession().get(Post.class, id);
		if (p != null) {
			if (p.getDelete_flag() == 1) {
				//˵���ü�¼�ѱ�ɾ��
				return null;
			}
		}
		return p;
	}
	
	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.zhbit.findwork.dao.impl.PostDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Post> getAllPost() {
		String hql = "from Post where delete_flag = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Post> ps = query.list();
		return ps;
	}

	@Override
	public int getCountByCheckFlag(int checkFlag) {
		String hql = "select count(Pid) from Post where delete_flag = 0 ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long)query.uniqueResult(); //��õ�����ֻ��ΪLong�ͣ���Ҫ�Լ���ת��Ϊint
		String temp = String.valueOf(sum);  //ǿ��ת���ᱨ��Cannot cast from Long to int
		int count = Integer.parseInt(temp);    //����תString����תint
		return count;
	}

	@Override
	public List<Post> getPostsByPageWithCheck(int firstResult, int maxResults, int check_flag) {
		String hql = "from Post where delete_flag = 0 order by Pid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(firstResult)
			.setMaxResults(maxResults);
		List<Post> posts = query.list();
		return posts;
	}
	
}
