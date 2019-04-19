package test_file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import indi.individual;
import sprint4.US30;

class test_us30 {

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
	void testfindLivingMarriage() {
		US30 us30 = new US30();
		ArrayList<individual> allPeople = new ArrayList<>();
		individual i1 = new individual("I1");
		i1.spouse.add("F1");
		
		individual i2 = new individual("I2");
		
		individual i3 = new individual("I3");
		i3.isdead = true;
		i3.spouse.add("F2");
		
		allPeople.add(i1);
		allPeople.add(i2);
		allPeople.add(i3);
		ArrayList<String> actual = us30.findLivingMarriage(allPeople);
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("I1");
		
		assertArrayEquals(expected.toArray(),actual.toArray());
	}

}
