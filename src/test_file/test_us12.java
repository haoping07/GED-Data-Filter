package test_file;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fam.Family;
import indi.individual;
import sprint2.US12;

class test_us12 {

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
	void testCheckParentsAgeTrue() throws Exception{
		US12 us12 = new US12();
		// individual information
		individual husband = new individual("husID");
		husband.age = 70;
		individual wife = new individual("wifeID");
		wife.age = 60;
		
		individual c1 = new individual("c1ID");
		c1.age = 36;
		individual c2 =new individual("c2ID");
		c2.age = 29;
		individual c3 =new individual("c3ID");
		c3.age = 9;
		ArrayList<individual> allPeople = new ArrayList<>();
		allPeople.add(husband);
		allPeople.add(wife);
		allPeople.add(c1);
		allPeople.add(c2);
		allPeople.add(c3);
		// family information
		Family fam = new Family("famID");
		fam.husband = "husID";
		fam.wife = "wifeID";
		fam.children.add("c1ID");
		fam.children.add("c2ID");
		fam.children.add("c3ID");
		
		ArrayList<int[]> expected = new ArrayList<>();
		int[] correct = new int[2];
		expected.add(correct);
		expected.add(correct);
		expected.add(correct); // [0,0][0,0][0,0]
		
		ArrayList<int[]> actual = us12.checkParentsAge(fam, allPeople);
		
		assertArrayEquals(expected.toArray(),actual.toArray());
		
	}
	
	@Test
	void testCheckParentsAgeFalse() throws Exception{
		US12 us12 = new US12();
		// individual information
		individual husband = new individual("husID");
		husband.age = 100;
		individual wife = new individual("wifeID");
		wife.age = 60;
		
		individual c1 = new individual("c1ID");
		c1.age = 36;
		individual c2 =new individual("c2ID");
		c2.age = 9;
		ArrayList<individual> allPeople = new ArrayList<>();
		allPeople.add(husband);
		allPeople.add(wife);
		allPeople.add(c1);
		allPeople.add(c2);
		// family information
		Family fam = new Family("famID");
		fam.husband = "husID";
		fam.wife = "wifeID";
		fam.children.add("c1ID");
		fam.children.add("c2ID");
		
		ArrayList<int[]> expected = new ArrayList<>();
		int[] correct = new int[2];
		int[] wrong  = new int[2];
		wrong[0] = 1;
		expected.add(correct);
		expected.add(wrong); // second child husband is wrong
		
		ArrayList<int[]> actual = us12.checkParentsAge(fam, allPeople);
		
		assertArrayEquals(expected.toArray(),actual.toArray());
		
	}


}
