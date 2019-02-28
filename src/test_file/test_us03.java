package test_file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datecheck.US03;

class test_us03 {

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
	void testBirth_before_deathStringString() {
		assertTrue(US03.birth_before_death("28 JAN 2019","28 JAN 2019"));
		assertTrue(US03.birth_before_death("17 JAN 2019","28 JAN 2019"));
		assertTrue(US03.birth_before_death("28 JAN 2019","28 FEB 2019"));
		assertTrue(US03.birth_before_death("28 JAN 2018","28 JAN 2019"));
		assertTrue(US03.birth_before_death("28 JAN 2019","18 JAN 2019"));
		assertFalse(US03.birth_before_death("28 FEB 2019","28 JAN 2019"));
		assertFalse(US03.birth_before_death("28 JAN 2019","28 JAN 2018"));
		assertTrue(US03.birth_before_death("28 APR 2018","28 JAN 2019"));
		assertTrue(US03.birth_before_death("28 JAN 2019","28 FEB 2019"));
	}

}
