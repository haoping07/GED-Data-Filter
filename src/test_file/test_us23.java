//Author: Hao-Ping Lin
package test_file;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import sprint3.US23;
import testing_Lin.ObjectSet;
import testing_Lin.testingMain;

public class test_us23
{
	@TestFactory
	public Collection<DynamicTest> TestCase() throws IOException
	{
		Collection<DynamicTest> dynamicTests = new ArrayList<>();

		// Initialize US23
		US23 unit_test_23 = new US23();

		// Read custom GED file
		ObjectSet customGED = testingMain.startHere("US10_GED.ged");

		// Get the Debug code of US23
		int[] DEBUG = new int[customGED.allPeopleR.size()];
		DEBUG = unit_test_23.Unique_name_and_birth_date(customGED.allPeopleR);

		// ================== Correct Answer Table ================== //
		int[] ANSWER = new int[]
		{ 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };

		// Run US23 JUnit test
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
