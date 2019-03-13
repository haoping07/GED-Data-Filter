package test_file;

import static org.junit.jupiter.api.Assertions.*;

import indi.individual;
import sprint2.US09;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class test_us09 {
	static individual father1 = new individual("f1");
	static individual father2 = new individual("f2");
	static individual c1 = new individual("c1");
	static individual c2 = new individual("c2");
	static individual c3 = new individual("c3");
	static individual c4 = new individual("c4");
	static individual c5 = new individual("c5");
	static individual c6 = new individual("c6");
	static individual c7 = new individual("c7");
	static individual c8 = new individual("c8");
	static individual mother = new individual("m");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//father1: dead after MAR
		father1.update("DEAT", "3 MAY 2019");
		//father2: dead before MAR
		father2.update("DEAT", "3 FEB 2019");
		
		//c1: birth after 9 month of death of father1
		c1.update("BIRT", "3 APR 2020");
		//c2: birth within 0 ~ 9 month of death of father1, but in next year
		c2.update("BIRT", "3 JAN 2020");
		//c3: birth within 0 ~ 9 month of death of father1, but in same year
		c3.update("BIRT", "3 OCT 2019");
		//c4: birth before father1 dead
		c4.update("BIRT" , "3 MAR 2019");
		//c5: birth after 9 month of death of father2, but in next year
		c5.update("BIRT", "3 JAN 2020");
		//c6: birth after 9 month of death of father2, but in same year
		c6.update("BIRT", "3 DEC 2019");
		//c7: birth within 0 ~ 9 month of death of father2
		c7.update("BIRT", "3 JUL 2019");
		//c8: birth before father2 dead
		c8.update("BIRT" , "3 JAN 2019");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		Assertions.assertFalse(US09.checkfather(c1.Birthday,father1.Deathday));
	}
	@Test
	void test2() {
		Assertions.assertTrue(US09.checkfather(c2.Birthday,father1.Deathday));
	}
	@Test
	void test3() {
		Assertions.assertTrue(US09.checkfather(c3.Birthday,father1.Deathday));
	}
	@Test
	void test4() {
		Assertions.assertTrue(US09.checkfather(c4.Birthday,father1.Deathday));
	}
	@Test
	void test5() {
		Assertions.assertFalse(US09.checkfather(c5.Birthday,father2.Deathday));
	}
	@Test
	void test6() {
		Assertions.assertFalse(US09.checkfather(c6.Birthday,father2.Deathday));
	}
	@Test
	void test7() {
		Assertions.assertTrue(US09.checkfather(c7.Birthday,father2.Deathday));
	}
	@Test
	void test8() {
		Assertions.assertTrue(US09.checkfather(c8.Birthday,father2.Deathday));
	}

}
