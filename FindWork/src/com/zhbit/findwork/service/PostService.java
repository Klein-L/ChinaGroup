package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.dao.PostDao;
import com.zhbit.findwork.entity.Post;

public interface PostService {

	int addPost(Post p);

	int updatePost(Post p);

	void deletePost(int id);

	Post getPostByID(int id);

	List<Post> getPostByName(String name);

	PostDao getPostDao();

	void setPostDao(PostDao postDao);
	
	//获取所有岗位
		List<Post> getAllPost();

	int getCountByCheckFlag(int checkFlag);
	
	List<Post> getPostsByPageWithCheck(int firstResult, int maxResults, int check_flag);
}