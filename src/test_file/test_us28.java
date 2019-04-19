package test_file;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fam.Family;
import indi.individual;
import sprint4.US28;


class test_us28 {
	public static ArrayList<individual> indis;
	public static Family fam;
	public static ArrayList<String> result;
	static HashMap<String,Integer> index;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		indis = new ArrayList<>(); 
		individual i1=new individual("xs");
		i1.update("SEX", "M");
		i1.update("BIRT", "1 JAN 2001");
		individual i2=new individual("sss");
		i2.update("SEX", "F");
		i2.update("BIRT", "3 JAN 1998");
		individual i3=new individual("ssx");
		i3.update("SEX", "F");
		i3.update("BIRT", "5 APR 1999");
		indis.add(i1);
		indis.add(i2);
		indis.add(i3);
		
		fam=new Family("f1");
		
		fam.update("CHIL", i1.id);
		fam.update("CHIL", i2.id);
		fam.update("CHIL", i3.id);
		
		result = new ArrayList<String>();
		result.add("sss");
		result.add("ssx");
		result.add("xs");
		index = new HashMap<String,Integer>();
		for(int i=0;i<indis.size();i++) {
			index.put(indis.get(i).id,i);
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
	void test() {
		Assertions.assertEquals(result,US28.order(indis, fam, index));
	}

}
