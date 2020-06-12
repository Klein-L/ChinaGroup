package com.zhbit.findwork.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ResolverUtil.NameEndsWith;
import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.PostVo;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.service.PostService;
import com.zhbit.findwork.service.Post_typeService;


public class PostAction extends ActionSupport{
	
	private PostService postService;
	private Post_typeService post_typeService;

	private Post post;
	private PostVo postVo;
	private List<Post> posts;
	private List<Post_type> postTypes;
	private String ptype;
	private String message;//��ʾ��Ϣ
	private String errorMessage;//������ʾ��Ϣ
	private int currentPage;       //��ǰ���ڵڼ�ҳ
	private int lines;             //������
	private int totalPages;        //
	private List<String> plist;
	private static int page_line = 6;
	private int firstResult;

	/**
	 * ��Ӹ�λ����֤
	 */
	public void validateAdd() {
		if (post.getPname() == null || "".equals(post.getPname())) {
			addFieldError("post.name", "��λ���Ʋ���Ϊ��");
		} else {
			if (post.getPname().length()>20) {
				this.addFieldError("post.name", "��λ���Ƴ��Ȳ��ܳ���20");
			}
		}
	}
	
	//������λ
	public String add(){
		Post_type post_type = new Post_type();
		post_type.setPTid(Integer.parseInt(ptype));
		post.setPtype(post_type);
		int result = postService.addPost(post);
		if (result == 0) {
			//���ݿ������иý�ɫ
			errorMessage = "���ݿ������иø�λ";
			return "showAdd";
		} else if (result == 1) {
			//����ɹ�
			message = "��λ�����ɹ�";
			posts = postService.getAllPost();
			return "showAllPosts";
		}
		return "showAllRoles";
	}
	
	//��ת������λҳ��
	public String toAddPost(){
		postTypes = post_typeService.getAllPost_type();
		return "toAddPost";
	}
	
	//��ת�޸ĸ�λ�б�ҳ��
	public String toUpdatePost(){
		lines = postService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		System.out.println("size:"+lines);
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		posts = postService.getPostsByPageWithCheck(firstResult, page_line, 0);
		return "toUpdatePost";
	}
	
	//��ת�޸ĸ�λҳ��
	public String showUpdatePost(){
		post = postService.getPostByID(post.getPid());
		postVo = new PostVo(post.getPname(), post.getComment(), post.getPid());
		postTypes = post_typeService.getAllPost_type();
		return "showUpdatePost";
	}
	
	/**
	 * �޸ĸ�λ����֤
	 */
	public void validateUpdate() {
		if (postVo.getPname() == null || "".equals(postVo.getPname())) {
			addFieldError("post.name", "��λ���Ʋ���Ϊ��");
		} else {
			if (postVo.getPname().length()>20) {
				this.addFieldError("post.name", "��λ���Ƴ��Ȳ��ܳ���20");
			}
		}
	}
	
	//�޸ĸ�λ
	public String update(){
		System.out.println("post:"+post.getPid()+"---"+postVo.getPname()+"--"+postVo.getComment());
		post.setPname(postVo.getPname());
		post.setComment(postVo.getComment());
		postService.updatePost(post);
		
		lines = postService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		System.out.println("size:"+lines);
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		posts = postService.getPostsByPageWithCheck(firstResult, page_line, 0);
		
		return "toUpdatePost";
	}
	
	//ɾ����λ
	public String deletePost(){
		System.out.println(post.getPid());
		
		postService.deletePost(post.getPid());
		
		lines = postService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		System.out.println("size:"+lines);
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		posts = postService.getPostsByPageWithCheck(firstResult, page_line, 0);
		
		return "deletePost";
	}
	
	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public PostVo getPostVo() {
		return postVo;
	}

	public void setPostVo(PostVo postVo) {
		this.postVo = postVo;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<Post_type> getPostTypes() {
		return postTypes;
	}

	public void setPostTypes(List<Post_type> postTypes) {
		this.postTypes = postTypes;
	}

	public Post_typeService getPost_typeService() {
		return post_typeService;
	}

	public void setPost_typeService(Post_typeService post_typeService) {
		this.post_typeService = post_typeService;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<String> getPlist() {
		return plist;
	}

	public void setPlist(List<String> plist) {
		this.plist = plist;
	}

	public static int getPage_line() {
		return page_line;
	}

	public static void setPage_line(int page_line) {
		PostAction.page_line = page_line;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

}
