package test_file;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fam.Family;
import indi.individual;
import sprint3.US17;

class test_us17 {

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
	void testNoMarriageToChildTrue() {
		US17 us17 = new US17();
		// family information
		Family fam = new Family("famID");
		fam.husband = "husID";
		fam.wife = "wifID";
		fam.children.add("c1ID");
		fam.children.add("c2ID");
		fam.children.add("c3ID");
		ArrayList<Family> allFamilies = new ArrayList<>();
		allFamilies.add(fam);
		us17.findOwnChild(allFamilies);
		assertTrue(us17.noMarriageToChild(fam));
	}
	
	@Test
	void testNoMarriageToChildFalse() {
		US17 us17 = new US17();
		// family1 information
		Family fam1 = new Family("famID1");
		fam1.husband = "husID1";
		fam1.wife = "wifID1";
		fam1.children.add("c1ID1");
		fam1.children.add("c2ID1");
		fam1.children.add("c3ID1");
		// family1 information
		Family fam2 = new Family("famID2");
		fam2.husband = "c1ID1";
		fam2.wife = "wifID1";
		fam2.children.add("c1ID2");
		fam2.children.add("c2ID2");
		fam2.children.add("c3ID2");
		ArrayList<Family> allFamilies = new ArrayList<>();
		allFamilies.add(fam1);
		allFamilies.add(fam2);
		us17.findOwnChild(allFamilies);
		assertTrue(us17.noMarriageToChild(fam1));
		assertFalse(us17.noMarriageToChild(fam2));
	}
	
	

}
