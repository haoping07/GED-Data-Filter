package test_file;

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

import indi.individual;
import sprint1.US01;
import Mainprogram.*;

public class test_us01{
	public static ArrayList<individual> people = null;
	public static FileWriter writer = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		output_format in = Main.main_output();
		people = in.People;
		System.out.println("Test start!");
		final String dir = System.getProperty("user.dir");
		writer = new FileWriter(dir + "\\us01_output.txt", true);     
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
	        		Assertions.assertTrue(US01.checkdate_us01(people.get(n).Birthday));	
	        	}catch(AssertionError e) {
	        		fail(n);
	        	}
	        	
	        }));
	}
	
	public void fail(int x) {
		System.out.println(people.get(x).id + " fails user story 01\n");
		try {
				writer.write(people.get(x).id + " fails user story 01\n");
		} catch (IOException e1) {
				e1.printStackTrace();
		}
	}

}
