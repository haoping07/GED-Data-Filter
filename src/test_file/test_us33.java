package test_file;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import other_dependencies.ObjectSet;
import other_dependencies.testingMain;
import sprint4.US33;

public class test_us33 {
	@TestFactory
	public Collection<DynamicTest> TestCase() throws IOException {
		Collection<DynamicTest> dynamicTests = new ArrayList<>();

		// Initialize US33
		US33 unit_test_33 = new US33();

		// Read custom GED file
		ObjectSet customGED = testingMain.startHere("US33_GED.ged");

		// Get the Debug code of US33
		List<String> DEBUG = new ArrayList<>();

		DEBUG = unit_test_33.List_orphans(customGED.allPeopleR, customGED.allFamiliesR);

		// ================== Correct Answer Table ================== //
		List<String> ANSWER = new ArrayList<>();
		ANSWER.add("@I1@ ");
		ANSWER.add("@I4@ ");
		ANSWER.add("@I5@ ");

		// Run US33 JUnit test
		for (int i = 0; i < DEBUG.size(); i++) {
			// Initialize the two args here to prevent final type error message
			Boolean ANSCode = ANSWER.contains(DEBUG.get(i));

			// Create an test execution
			Executable exec = () -> assertTrue(ANSCode);

			// Create test display name
			String test_title_name = "Orphan checked: " + DEBUG.get(i);

			// Create dynamic test
			DynamicTest test_result = DynamicTest.dynamicTest(test_title_name, exec);

			// Add the dynamic test to collection
			dynamicTests.add(test_result);
		}
		return dynamicTests;
	}
}