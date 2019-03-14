package test_file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sprint2.US13;

class test_us13 {
	public static int a = 0;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		a = 0;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		a++;
		System.out.println("before"+a);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//within 2 days
		Assertions.assertTrue(US13.check_space("1 JAN 2000", "2 JAN 2000"));
	}
	@Test
	void test2() {
		//within same month but larger then two days
		Assertions.assertFalse(US13.check_space("1 JAN 2000", "22 JAN 2000"));
	}
	@Test
	void test3() {
		//within 8 months
		Assertions.assertFalse(US13.check_space("1 JAN 2000", "4 MAR 2000"));
	}
	@Test
	void test4() {
		//over 1 year
		Assertions.assertTrue(US13.check_space("1 JAN 2000", "1 JAN 2001"));
	}
	

}
