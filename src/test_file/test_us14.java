//Author: Hao-Ping Lin
package test_file;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import other_dependencies.ObjectSet;
import other_dependencies.testingMain;
import sprint2.US14;

public class test_us14 {
	@TestFactory
	public Collection<DynamicTest> TestCase() throws IOException 
	{
		Collection<DynamicTest> dynamicTests = new ArrayList<>();
		
		//Read the custom GED file
		ObjectSet testGED = testingMain.startHere("US10_GED.ged");
		
		//Initialize US10
		US14 test = new US14();
		
		//Get the Debug code of US14
		int[] outputArr = new int[testGED.allPeopleR.size()];
		outputArr = test.Multiple_Births_Smaller_5(testGED.allPeopleR, testGED.allFamiliesR);
		
		//** The correct answer **//
		int[] ANSWER = new int[] {2,0,0,0,0};
		
		//Run US14 on data
		for (int i = 0; i < outputArr.length; i++) 
		{
			//Initialize the two args here to prevent final type error message
			int arg1 = outputArr[i], arg2 = ANSWER[i];
			
			//Create an test execution
			Executable exec = () -> assertEquals(arg1, arg2);
			
			//Create test display name
			String testName = "Family Checked: " + "@F" + (i + 1);
			
			//Create dynamic test
			DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);
			
			//Add the dynamic test to collection
			dynamicTests.add(dTest);
		}
		return dynamicTests;
	}
}
