package test_file;


import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fam.Family;
import indi.individual;
import sprint3.US22;


class test_us22 {
	public static ArrayList<individual> indis;
	public static ArrayList<Family> fams;
	public static ArrayList<Boolean> result;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		indis = new ArrayList<>(); 
		individual i1=new individual("xs"),
				i2=new individual("sss"),
				i3=new individual("sss");
		indis.add(i1);
		indis.add(i2);
		indis.add(i3);
		
		fams= new ArrayList<Family>();
		Family f1=new Family("f1"),
				f2=new Family("f2"),
				f3=new Family("f2");
		fams.add(f1);
		fams.add(f2);
		fams.add(f3);
		
		result = new ArrayList<Boolean>();
		//Some sorting work is done in the method to make the work quicker
		result.add(true);
		result.add(false);
		result.add(true);
		result.add(true);
		result.add(true);
		result.add(false);
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
	void test() {
		Assertions.assertEquals(result, US22.UniqueId(indis, fams));
	}

}
