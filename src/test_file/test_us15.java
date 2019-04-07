package test_file;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Mainprogram.Main;
import fam.Family;
import indi.individual;
import sprint2.US15;

class test_us15 {
	public static Family f1,f2;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		individual i1=new individual("xs"),
				i2=new individual("sss");
		
		f1=new Family("f1");
		f2=new Family("f2");
		
		for(int i=0;i<20;i++) {
			f1.update("CHIL", i1.id);
		}
		
		for(int i=0;i<10;i++) {
			f1.update("CHIL", i2.id);
		}
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
		assertTrue(US15.sibilings(f2));
		assertFalse(US15.sibilings(f1));
		/*
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
		*/
	}

}
