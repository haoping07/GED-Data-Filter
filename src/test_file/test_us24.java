package test_file;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import sprint3.US24;
import testing_Lin.ObjectSet;
import testing_Lin.testingMain;

public class test_us24
{
	@TestFactory
	public Collection<DynamicTest> TestCase() throws IOException
	{
		Collection<DynamicTest> dynamicTests = new ArrayList<>();

		// Initialize US24
		US24 unit_test_24 = new US24();

		// Read custom GED file
		ObjectSet customGED = testingMain.startHere("US10_GED.ged");

		// Get the Debug code of US24
		int[] DEBUG = new int[customGED.allFamiliesR.size()];
		DEBUG = unit_test_24.Unique_families_by_spouses(customGED.allFamiliesR);

		// ================== Correct Answer Table ================== //
		int[] ANSWER = new int[]
		{ 0, 0, 0, 1, 0 };

		// Run US24 JUnit test
		for (int i = 0; i < DEBUG.length; i++)
		{
			// Initialize the two args here to prevent final type error message
			int arg1 = DEBUG[i], arg2 = ANSWER[i];

			// Create an test execution
			Executable exec = () -> assertEquals(arg1, arg2);

			// Create test display name
			String test_title_name = "Checked: " + "@I" + (i + 1);

			// Create dynamic test
			DynamicTest test_result = DynamicTest.dynamicTest(test_title_name, exec);

			// Add the dynamic test to collection
			dynamicTests.add(test_result);
		}
		return dynamicTests;
	}
}
