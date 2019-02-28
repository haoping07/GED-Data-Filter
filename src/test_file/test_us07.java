package test_file;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import indi.individual;

class test_us07 {
	public static individual person = null;
	public static FileWriter writer = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Test start!");
		final String dir = System.getProperty("user.dir");
		writer = new FileWriter(dir + "\\us07_output.txt", true);     
	}
	
	public static void setperson(individual from_other_file) {
		person = from_other_file;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		writer.close();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws IOException {
		System.out.println("in test" + person.id);
		try {
			Assertions.assertTrue(person.Checkage());
			//Assertions.assertTrue(false);
		}catch(AssertionError e) {
			fail();
		}
	}
	
	public void fail() {
		System.out.println(" fails user story 07\n");
		try {
				writer.write(" fails user story 07\n");
		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
	}

}
