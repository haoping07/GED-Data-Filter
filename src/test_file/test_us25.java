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
import sprint3.US25;


class test_us25 {
	public static ArrayList<individual> People;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		People = new ArrayList<>(); 
		individual i1 = new individual("I1");
		i1.update("NAME" , "Howard /Lo/");
		individual i2 = new individual("I2");
		i1.update("NAME" , "Howard /Lin/");
		individual i3 = new individual("I3");
		i1.update("NAME" , "HaoPing /Lo/");
		People.add(i1);
		People.add(i2);
		People.add(i3);
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
		//Should fail: "Howard" is not unique in same family
		Assertions.assertFalse(US25.check_unique(People));
	}

}
