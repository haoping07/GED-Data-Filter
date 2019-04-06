package test_file;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Mainprogram.Main;
import fam.Family;
import indi.individual;
import sprint2.US15;

class test_us15 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ArrayList<individual> allPeople = new ArrayList<individual>();
		ArrayList<Family> allFamilies = new ArrayList<Family>();
		Main.main(new String[] {});
		allPeople=Main.allPeople;
		allFamilies=Main.allFamilies;
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
	void testSibilingsFamily() throws IOException {
		ArrayList<Family> allFamilies = new ArrayList<Family>();
		Main.main(new String[] {});
		allFamilies=Main.allFamilies;
		boolean[] expect= {true,true,true,true,true,true,true,true,true,true,false,true,true,true,true,true,true,true,true,true,true,false};
		for(int i=0;i<allFamilies.size();i++) {
			if(expect[i]) {
				assertTrue(US15.sibilings(allFamilies.get(i)));
			}
			else {
				assertFalse(US15.sibilings(allFamilies.get(i)));
			}
		}
	}

}
