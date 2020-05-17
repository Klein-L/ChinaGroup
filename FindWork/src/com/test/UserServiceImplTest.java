package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.dao.RoleDao;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.UserService;

public class UserServiceImplTest {
	private static ApplicationContext context;
	private static UserService userService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService) context.getBean("userServiceImpl");
	}
	
	@Test
	public void testAddUser() {
		User user = new User();
		//user.setName("������"); ���û����ڣ����ʧ�ܣ�����false
		user.setName("С��");//��ӳɹ�
		user.setPassword("123456");
		user.setAddress("�㶫XXXXXX");
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		Role role = roleDao.getRoleByID(1);
		user.setRole(role);
		boolean fla =userService.addUser(user);
		System.out.println(fla);
	}

	@Test
	public void testUpdateUser() {
		User user= new User();
		user.setName("С��3");
		user.setPassword("123");
		boolean fla =userService.updateUser(user);
		System.out.println(fla);
	}

	@Test
	public void testGetUserByID() {
		User user=	userService.getUserByID(1);
	   System.out.println(user);
	}
	@Test
	public void testGetUserByName() {
		User user=	userService.getUserByName("С��3");
	   System.out.println(user);
	}

	@Test
	public void testGetAllUser() {
		List<User> users=userService.getAllUsers();
		System.out.println(users);
	}

	@Test
	public void testDeleteUserByID() {
		boolean fla= userService.deleteUserByID(4);
		System.out.println(fla);
	}

	@Test
	public void testGetUserByPage() {
		List<User> users=userService.getUserByPage(0, 3);
		System.out.println(users);
	}

	@Test
	public void testGetCount() {
		int t= userService.getCount();
		System.out.println(t);
	}

	@Test
	public void testGetUserDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserDao() {
		fail("Not yet implemented");
	}

}
