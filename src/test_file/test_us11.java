package test_file;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Mainprogram.Main;
import fam.Family;
import indi.individual;
import sprint2.US11;
import sprint2.US15;
class test_us11 {

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
	void testNoBigamy() throws Exception{
		Main.main(new String[] {});
		ArrayList<Family> allFamilies = Main.allFamilies;
		ArrayList<individual> allPeople = Main.allPeople;
		ArrayList<Boolean> outputs=US11.NoBigamy(allPeople,allFamilies);
		boolean[] expect= {true,true,true,true,true,true,true,true,true,true,true,true,true,true,false};
		for(int i=0;i<expect.length;i++) {
			if(expect[i]) {
				assertTrue(outputs.get(i));
			}
			else {
				assertFalse(outputs.get(i));
			}
		}
	}

}
