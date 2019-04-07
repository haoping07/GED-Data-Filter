package testing_Lin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import sprint1.*;

class US06_testing {

	@TestFactory
	public Collection<DynamicTest> TestCase1() throws IOException 
	{
		Collection<DynamicTest> dynamicTests = new ArrayList<>();
		ObjectSet testGED = testingMain.startHere("MyFamily.ged");
		US06 test = new US06();
		ArrayList<Boolean> outputList = test.Divorce_Before_Death(testGED.allPeopleR, testGED.allFamiliesR);

		//** The Answer List **//
		ArrayList<Boolean> answerList = new ArrayList<>();
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(true);
		answerList.add(false);	//Divorce before death (Illegal)
		answerList.add(true);
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
