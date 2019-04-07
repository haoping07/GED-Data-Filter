package test_file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fam.Family;
import indi.individual;
import sprint3.US18;
import java.util.ArrayList;

class test_us18 {

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
	void testNoMarriageToSiblingTrue() {
		US18 us18 = new US18();
		//individual
		individual husband = new individual("I1");
		ArrayList<String> husChildList = new ArrayList<>();
		husChildList.add("F1");
		husChildList.add("F2");
		husband.children = husChildList;
		
		individual wife = new individual("I2");
		ArrayList<String> wifChildList = new ArrayList<>();
		wifChildList.add("F3");
		wife.children = wifChildList;
		
		ArrayList<individual> allPeople = new ArrayList<>();
		allPeople.add(husband);
		allPeople.add(wife);
		
		//family
		Family fam1 = new Family("F1");
		ArrayList<String> fam1Children = new ArrayList<>();
		fam1Children.add("I1");
		fam1Children.add("I11");
		fam1Children.add("I12");
		fam1.children = fam1Children;
		
		Family fam2 = new Family("F2");
		ArrayList<String> fam2Children = new ArrayList<>();
		fam2Children.add("I1");
		fam2Children.add("I13");
		fam2Children.add("I14");
		fam2.children = fam2Children;
		
		Family fam3 = new Family("F3");
		ArrayList<String> fam3Children = new ArrayList<>();
		fam3Children.add("I2");
		fam3Children.add("I21");
		fam3.children = fam3Children;
		
		Family fam4 = new Family("F4");
		fam4.husband = "I1";
		fam4.wife = "I2";
		
		ArrayList<Family> allFamilies = new ArrayList<>();
		allFamilies.add(fam1);
		allFamilies.add(fam2);
		allFamilies.add(fam3);
		allFamilies.add(fam4);
		
		//test
		us18.initFamMap(allFamilies);
		us18.findOwnSibling(allPeople, allFamilies);
		assertTrue(us18.noMarriageToSibling(fam4));
		
	}
	
	@Test
	void testNoMarriageToSiblingFalse() {
		US18 us18 = new US18();
		//individual
		individual husband = new individual("I1");
		ArrayList<String> husChildList = new ArrayList<>();
		husChildList.add("F1");
		husChildList.add("F2");
		husband.children = husChildList;
		
		individual wife = new individual("I2");
		ArrayList<String> wifChildList = new ArrayList<>();
		wifChildList.add("F2");
		wife.children = wifChildList;
		
		ArrayList<individual> allPeople = new ArrayList<>();
		allPeople.add(husband);
		allPeople.add(wife);
		
		//family
		Family fam1 = new Family("F1");
		ArrayList<String> fam1Children = new ArrayList<>();
		fam1Children.add("I1");
		fam1Children.add("I11");
		fam1Children.add("I12");
		fam1.children = fam1Children;
		
		Family fam2 = new Family("F2");
		ArrayList<String> fam2Children = new ArrayList<>();
		fam2Children.add("I1");
		fam2Children.add("I13");
		fam2Children.add("I14");
		fam2Children.add("I2");
		fam2.children = fam2Children;
		
		Family fam3 = new Family("F3");
		fam3.husband = "I1";
		fam3.wife = "I2";
		
		ArrayList<Family> allFamilies = new ArrayList<>();
		allFamilies.add(fam1);
		allFamilies.add(fam2);
		allFamilies.add(fam3);
		
		//test
		us18.initFamMap(allFamilies);
		us18.findOwnSibling(allPeople, allFamilies);
		assertFalse(us18.noMarriageToSibling(fam3));
		
	}

}
