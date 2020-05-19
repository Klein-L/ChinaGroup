package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.BusinessService;
import com.zhbit.findwork.service.RoleService;

public class BusinessServiceImplTest {

	private static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
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
	public void testLogin() {
		BusinessService businessService = (BusinessService) context.getBean("businessServiceImpl");
		Business business = businessService.login("�ٶ�", "liadanhong");
		if (business == null) {
			System.out.println("���޴���");
		} else {
			System.out.println("��¼�ɹ�");
		}
	}
	
	@Test
	public void testAddBusiness() {
		Business business = new Business();
		business.setName("�ٶ�");
		business.setCity("����");
		BusinessService businessService = (BusinessService) context.getBean("businessServiceImpl");
		businessService.addBusiness(business);
	}

	//TODO ����NonUnique
	//�²⣺�������ε�����businessService�ķ�����Ӧ���ǿ������������񣬻���
	//���������merge���� �������session����
	//��¼�����������merge����
	@Test
	public void testUpdateBusiness() {
		BusinessService businessService = (BusinessService) context.getBean("businessServiceImpl");
		Business business = businessService.getBusinessByID(4);
		//business.setPassword("liyanhong");
		business.setName("��Ѷ");
		int result = businessService.updateBusiness(business);
		System.out.println(result);
	}

	@Test
	public void testGetBusinessByID() {
		BusinessService businessService = (BusinessService) context.getBean("businessServiceImpl");
		Business business = businessService.getBusinessByID(3);
		System.out.println(business);
	}

	@Test
	public void testGetBusinessesByName() {
		BusinessService businessService = (BusinessService) context.getBean("businessServiceImpl");
		List<Business> businesses = (List<Business>) businessService.getBusinessesByName("�ٶ�");
		System.out.println(businesses);
	}

	@Test
	public void testDeleteBusinessByID() {
		BusinessService businessService = (BusinessService) context.getBean("businessServiceImpl");
		businessService.deleteBusinessByID(4);
	}

	@Test
	public void testGetBusinessesByPage() {
		BusinessService businessService = (BusinessService) context.getBean("businessServiceImpl");
		List<Business> businesses = (List<Business>) businessService.getBusinessesByPage(0, 3);
		System.out.println(businesses);
	}

	@Test
	public void testGetCount() {
		BusinessService businessService = (BusinessService) context.getBean("businessServiceImpl");
		int count = businessService.getCount();
		System.out.println(count);
	}

}
