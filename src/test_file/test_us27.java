package test_file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import indi.individual;


class test_us27 {
	public static individual i1;
	public static individual i2;
	public static individual i3;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		i1 = new individual("i1");
		i1.update("BIRT", "1 MAR 2500");
		i2 = new individual("i2");
		i2.update("BIRT", "1 MAR 2019");
		i3 = new individual("i3");
		i3.update("BIRT", "1 MAR 1995");
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
		//2019 - 2500 = -481
		int age = i1.age;
		Assertions.assertEquals(-481, age);
	}
	
	@Test
	void test2() {
		//2019 - 2019 = 0;
		int age = i2.age;
		Assertions.assertEquals(0, age);
	}
	
	@Test
	void test3() {
		//2019 - 1995 = 24
		int age = i3.age;
		Assertions.assertEquals(24, age);
	}

}
