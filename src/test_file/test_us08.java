package test_file;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import other_dependencies.ObjectSet;
import other_dependencies.testingMain;
import sprint1.*;

class test_us08 {

	@TestFactory
	public Collection<DynamicTest> TestCase1() throws IOException 
	{
		Collection<DynamicTest> dynamicTests = new ArrayList<>();
		ObjectSet testGED = testingMain.startHere("US23_GED.ged");
		US08 test = new US08();
		ArrayList<Boolean> outputList = test.Birth_Before_Marriage_Of_Parents(testGED.allPeopleR, testGED.allFamiliesR);

		//** The Answer List **//
		ArrayList<Boolean> answerList = new ArrayList<>();
		answerList.add(false);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);	//Birth before marriage of parents (Illegal)
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);

		//Traverse all data to check if divorce before death
		for (int i = 0; i < outputList.size(); i++) 
		{
			int s = i;
			//Create an test execution
			Executable exec = () -> assertEquals(outputList.get(s), answerList.get(s));
			//Create test display name
			String testName = "Person Checked: " + "@I" + (i + 1);
			//Create dynamic test
			DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);
			//Add the dynamic test to collection
			dynamicTests.add(dTest);
		}
		return dynamicTests;
	}
}
