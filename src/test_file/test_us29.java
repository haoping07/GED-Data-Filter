package test_file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import indi.individual;
import sprint4.us29;

class test_us29 {
	public static individual p1;
	public static individual p2;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		p1 = new individual("p1");
		p1.update("DEAT", "19 APR 2019");
		p2 = new individual("p2");
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
		Assertions.assertTrue(us29.check_death(p1));
	}

	@Test
	void test2() {
		Assertions.assertFalse(us29.check_death(p2));
	}
}
