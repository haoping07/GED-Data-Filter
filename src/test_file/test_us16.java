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
import sprint2.US16;

class test_us16 {

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
	void testCheckMaleNameTrue() throws Exception{
		US16 us16 = new US16();
		// individual information
		individual husband = new individual("husID");
		husband.name = "Jiacheng /Guo/";
		
		individual c1 = new individual("c1ID");
		c1.name = "Niuniu /Guo/";
		c1.sex = "F ";
		individual c2 =new individual("c2ID");
		c2.name = "Goudan /Guo/";
		c2.sex = "M ";
		individual c3 =new individual("c3ID");
		c3.name = "Gang /Guo/";
		c3.sex = "M ";
		ArrayList<individual> allPeople = new ArrayList<>();
		allPeople.add(husband);
		allPeople.add(c1);
		allPeople.add(c2);
		allPeople.add(c3);
		// family information
		Family fam = new Family("famID");
		fam.husband = "husID";
		fam.children.add("c1ID");
		fam.children.add("c2ID");
		fam.children.add("c3ID");
		
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(0);
		expected.add(0);
		expected.add(0);
		
		ArrayList<Integer> actual = us16.checkMaleName(fam, allPeople);
		
		assertArrayEquals(expected.toArray(),actual.toArray());
		
	}
	
	@Test
	void testCheckMaleNameFalse() throws Exception{
		US16 us16 = new US16();
		// individual information
		individual husband = new individual("husID");
		husband.name = "Jiacheng /Guo/";
		
		individual c1 = new individual("c1ID");
		c1.name = "Niuniu /Guo/";
		c1.sex = "F ";
		individual c2 =new individual("c2ID");
		c2.name = "Goudan /Guo/";
		c2.sex = "M ";
		individual c3 =new individual("c3ID");
		c3.name = "Gang /Li/";
		c3.sex = "M ";
		ArrayList<individual> allPeople = new ArrayList<>();
		allPeople.add(husband);
		allPeople.add(c1);
		allPeople.add(c2);
		allPeople.add(c3);
		// family information
		Family fam = new Family("famID");
		fam.husband = "husID";
		fam.children.add("c1ID");
		fam.children.add("c2ID");
		fam.children.add("c3ID");
		
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(0);
		expected.add(0);
		expected.add(1);
		
		ArrayList<Integer> actual = us16.checkMaleName(fam, allPeople);
		
		assertArrayEquals(expected.toArray(),actual.toArray());
		
	}
	
	@Test
	void test_checkMaleName_ex() {
        US16 us16 = new US16();
     // individual information
     	individual husband = new individual("husID");
     	husband.name = "Jiacheng /Guo/";
    		
   		individual c1 = new individual("c1ID");
   		c1.name = "Niuniu /Guo/";
   		c1.sex = "F ";
     	individual c2 =new individual("c2ID");
   		c2.name = "Goudan /Guo/";
   		c2.sex = "M ";
   		individual c3 =new individual("c3ID");
     	c3.name = "Gang /Li/";
   		c3.sex = "M ";
   		ArrayList<individual> allPeople = new ArrayList<>();
   		allPeople.add(husband);
     	allPeople.add(c1);
   		allPeople.add(c2);
   		allPeople.add(c3);
   		// family information
     	Family fam = new Family("famID");
   		fam.husband = "";
   		fam.children.add("c1ID");
   		fam.children.add("c2ID");
     	fam.children.add("c3ID");
        
        assertThrows(IllegalArgumentException.class,
        		() ->{us16.checkMaleName(fam, allPeople);});
    }

}
