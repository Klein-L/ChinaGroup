package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.service.CvService;

public class CvServiceImplTest {
	private static ApplicationContext context;
	private static CvService cvService;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		cvService = (CvService)context.getBean("cvServiceImpl");
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
	public void testGetCvDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCvDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCv() {
		Cv cv = new Cv();
		cv.setName("����ƽ");
		cv.setTelephone("13116865902");
		cv.setEducation_background("����");
		cv.setSelf("good");
		cv.setPolitics_status("��Ա");
		cv.setSkill("����");
		cv.setExperience("��");
		cv.setLive_province("�㶫");
		cv.setWant_joy_type("java");
		cv.setLive_city("�麣");
		cv.setWant_province("����");
		cv.setWant_city("����");
		cv.setWant_low_wages(2500);
		cv.setWant_large_wages(15000);
		cv.setWant_post("java");
		//cv.setSelf_appraisal("goodluck51");
//		UserService userService = (UserService)context.getBean("userServiceImpl");
//		User user = userService.getUserByID(1);
//		cv.setUser(user);
		cvService.addCv(cv);
	}

	@Test
	public void testUpdate() {
		Cv cv = new Cv();
		cv.setId(1);
		cv.setName("����ƽ");
		cvService.updateCv(cv);
	}

	@Test
	public void testGetCvByID() {
		Cv cv = cvService.getCvByID(1);
	}

	@Test
	public void testDeleteCvByID() {
		cvService.deleteCvByID(1);
	}

	@Test
	public void testGetCvByName() {
		Cv cv = cvService.getCvByName("����ƽ");
		System.out.println(cv);
	}

}
