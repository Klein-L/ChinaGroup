package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.PostService;
import com.zhbit.findwork.service.Post_typeService;
import com.zhbit.findwork.service.RoleService;

public class Post_typeServiceImplTest {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddPost_type() {
		Post_typeService Post_typeService = (Post_typeService) context.getBean("post_typeService");
		PostService postService = (PostService) context.getBean("postService");
		
		
		Post_type pt1 = new Post_type();
		pt1.setPTname("����");
		
		
		Post p1 = new Post();
		p1.setPname("Ͷ���ܼ�");
		p1.setPtype(pt1);
	
		Post p2 = new Post();
		p2.setPname("Ͷ�ʾ���");
		p2.setPtype(pt1);
		
		Post p3 = new Post();
		p3.setPname("��Ͷ");
		p3.setPtype(pt1);
		
		Post p4 = new Post();
		p4.setPname("֤ȯ");
		p4.setPtype(pt1);
		
		pt1.getPosts().add(p1);
		pt1.getPosts().add(p2);
		pt1.getPosts().add(p3);
		pt1.getPosts().add(p4);
		Post_typeService.addPost_type(pt1);
		
		Post_type pt2 = new Post_type();
		pt2.setPTname("����");
		
		Post p5 = new Post();
		p5.setPname("Java");
		p5.setPtype(pt2);
		
		Post p6 = new Post();
		p6.setPname("PHP");
		p6.setPtype(pt2);
		
		Post p7 = new Post();
		p7.setPname("Webǰ��");
		p7.setPtype(pt2);
		
		Post p8 = new Post();
		p8.setPname("�����ھ�");
		p8.setPtype(pt2);
		
		Post p9 = new Post();
		p9.setPname("C++");
		p9.setPtype(pt2);
		
		Post p10 = new Post();
		p10.setPname("Python");
		p10.setPtype(pt2);
		
		pt2.getPosts().add(p5);
		pt2.getPosts().add(p6);
		pt2.getPosts().add(p7);
		pt2.getPosts().add(p8);
		pt2.getPosts().add(p9);
		pt2.getPosts().add(p10);
		Post_typeService.addPost_type(pt2);
	
		
		Post_type pt3 = new Post_type();
		pt3.setPTname("���");
		
		Post p11 = new Post();
		p11.setPname("UI���ʦ");
		p11.setPtype(pt3);
		
		Post p12 = new Post();
		p12.setPname("ƽ�����ʦ");
		p12.setPtype(pt3);
		
		Post p13 = new Post();
		p13.setPname("�������ʦ");
		p13.setPtype(pt3);
		
		Post p14 = new Post();
		p14.setPname("����ܼ�");
		p14.setPtype(pt3);
		
		pt3.getPosts().add(p11);
		pt3.getPosts().add(p12);
		pt3.getPosts().add(p13);
		pt3.getPosts().add(p14);
		Post_typeService.addPost_type(pt3);
		
		
		Post_type pt4 = new Post_type();
		pt4.setPTname("�г�");
		
		Post p15 = new Post();
		p15.setPname("�г�Ӫ��");
		p15.setPtype(pt4);
		
		Post p16 = new Post();
		p16.setPname("Ʒ�ƹ���");
		p16.setPtype(pt4);
		
		Post p17 = new Post();
		p17.setPname("�г��ܼ�");
		p17.setPtype(pt4);
		
		Post p18 = new Post();
		p18.setPname("�߻�����");
		p18.setPtype(pt4);
		
		Post p19 = new Post();
		p19.setPname("��߻�");
		p19.setPtype(pt4);
		
		Post p20 = new Post();
		p20.setPname("SEO");
		p20.setPtype(pt4);
		
		Post p21 = new Post();
		p21.setPname("SEM");
		p21.setPtype(pt4);
		
		pt4.getPosts().add(p15);
		pt4.getPosts().add(p16);
		pt4.getPosts().add(p17);
		pt4.getPosts().add(p18);
		pt4.getPosts().add(p19);
		pt4.getPosts().add(p20);
		pt4.getPosts().add(p21);
		Post_typeService.addPost_type(pt4);
		
		postService.addPost(p1);
		postService.addPost(p2);
		postService.addPost(p3);
		postService.addPost(p4);
		postService.addPost(p5);
		postService.addPost(p6);
		postService.addPost(p7);
		postService.addPost(p8);
		postService.addPost(p9);
		postService.addPost(p10);
		postService.addPost(p11);
		postService.addPost(p12);
		postService.addPost(p13);
		postService.addPost(p14);
		postService.addPost(p15);
		postService.addPost(p16);
		postService.addPost(p17);
		postService.addPost(p18);
		postService.addPost(p19);
		postService.addPost(p20);
		postService.addPost(p21);
		
		
	}

	@Test
	public void testUpdatePost_type() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePost_type() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPost_typeByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPost_typeByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPost_typeDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPost_typeDao() {
		fail("Not yet implemented");
	}

}
