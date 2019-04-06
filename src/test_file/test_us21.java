package test_file;

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
import sprint3.US21;


class test_us21 {
	public static ArrayList<individual> indis;
	public static ArrayList<Family> fams;
	public static ArrayList<Boolean> result;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		indis = new ArrayList<>(); 
		individual i1=new individual("xs");
		i1.update("SEX", "M");
		individual i2=new individual("sss");
		i2.update("SEX", "F");
		indis.add(i1);
		indis.add(i2);
		
		fams= new ArrayList<Family>();
		Family f1=new Family("f1"),f2=new Family("f2");
		f1.update("HUSB", i1.id);
		f1.update("WIFE", i2.id);
		f2.update("HUSB", i2.id);
		f2.update("WIFE", i1.id);
		fams.add(f1);
		fams.add(f2);
		
		result = new ArrayList<Boolean>();
		result.add(true);
		result.add(true);
		result.add(false);
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
		Assertions.assertEquals(result, US21.CorrectGender(indis,fams));
	}

}
