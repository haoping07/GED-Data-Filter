package test_file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datecheck.US02;

class test_us02 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	void testBirth_before_marriage() {
		assertTrue(US02.birth_before_marriage("28 JAN 2019","28 JAN 2019"));
		assertTrue(US02.birth_before_marriage("17 JAN 2019","28 JAN 2019"));
		assertTrue(US02.birth_before_marriage("28 JAN 2019","28 FEB 2019"));
		assertTrue(US02.birth_before_marriage("28 JAN 2018","28 JAN 2019"));
		assertTrue(US02.birth_before_marriage("28 JAN 2019","18 JAN 2019"));
		assertFalse(US02.birth_before_marriage("28 FEB 2019","28 JAN 2019"));
		assertFalse(US02.birth_before_marriage("28 JAN 2019","28 JAN 2018"));
		assertTrue(US02.birth_before_marriage("28 APR 2018","28 JAN 2019"));
		assertTrue(US02.birth_before_marriage("28 JAN 2019","28 FEB 2019"));
		//fail("Not yet implemented");
	}

}
