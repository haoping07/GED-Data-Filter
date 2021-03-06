package test_file;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import Mainprogram.Main;
import Mainprogram.output_format;
import indi.individual;
import sprint1.US01;

class test_us07 {
	public static ArrayList<individual> people = null;
	public static FileWriter writer = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Test start!");
		output_format in = Main.main_output();
		people = in.People;
		final String dir = System.getProperty("user.dir");
		writer = new FileWriter(dir + "\\us07_output.txt", true);     
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

	@TestFactory
	Stream<DynamicTest> dynamicTestsFromIntStream() {
	    return IntStream.iterate(0, n -> n + 1).limit(people.size())
	      .mapToObj(n -> DynamicTest.dynamicTest("test" + n,
	        () ->{
	        	try {
	        		Assertions.assertTrue(people.get(n).Checkage());	
	        	}catch(AssertionError e) {
	        		fail(n);
	        	}
	        	
	        }));
	}
	
	public void fail(int x) {
		System.out.println(people.get(x).id + " fails user story 07\n");
		try {
				writer.write(people.get(x).id + " fails user story 07\n");
		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
	}

}
