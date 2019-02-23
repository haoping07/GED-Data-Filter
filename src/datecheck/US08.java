//Hao-Ping Lin 10437296 (LH)
package datecheck;

import java.util.ArrayList;
import Mainprogram.Main;

public class US08 {
	public void Birth_Before_Marriage_Of_Parents() {
		// --
		// What I am doing in this function is:
		// Loop the allPeople elements
		// If (the person have birth date) {
		// Run function Get_Divorce_Date() and get divorce date (If divorced)
		// Run function divorce_before_death() with divorce date and death date
		// }
		// --

		// Loop the allPeople elements
		for (int i = 0; i < Main.allPeople.size(); i++) {
			// If that person have parent
			if (!Main.allPeople.get(i).children.isEmpty()) {
				//Run function Get_Marry_Date() to get marry date (If married)
				ArrayList<String> parent_Married_Date_List = Get_Marry_Date(Main.allPeople.get(i).children);

				//If marry date is null, it means no marry date found in allFamilies
				if (parent_Married_Date_List == null) {
					//Have parent but they don't have marry date, Lack of GED data? [No problem with marry date before birth date]
					System.out.println("Debug messages(US08)[WARNING]: " + "No parent marry date found!(Lack of GED data?) ::" + Main.allPeople.get(i).id);
				}
				//Marry date found in allFamilies
				else {
					// Get the person's birth date in allPeople
					String birth_date = Main.allPeople.get(i).Birthday;
					if (birth_date.isEmpty()) {
						// The person exist, but don't have birth date, Lack of GED data? [No problem with marry date before birth date
						System.out.println("Debug messages(US08)[WARNING]: " + "Birth date not found!(Lack of GED data?) ::" + Main.allPeople.get(i).id);
					} else {
						//Run function DateCheck(date1, date2) in US06 with birth date and parent's marry date
						boolean check = true;
						for (int j = 0; j < parent_Married_Date_List.size(); j++) {
							// System.out.println(divorceDateList);
							check = US06.DateCheck(parent_Married_Date_List.get(j), birth_date);
						}
						//If birth date after parent's marry date, legal!
						if (check) {
							System.out.println("Debug messages(US08)[GOOD]: " + "Birth date after parent's marry date! ::" + Main.allPeople.get(i).id);
						}
						//If birth date after parent's marry date, illegal!
						else {
							 System.out.println("Debug messages(US08)[**ILLEGAL**]: " + "Birth date after parent's marry date! ::" +
							 Main.allPeople.get(i).id);
						}
					}
				}
			}
			else {
				//The person don't have parent, Lack of GED data? [No problem with birth date after parent's marry date]
				System.out.println("Debug messages(US08)[WARNING]: " + "The person don't have parent! (Lack of GED data?) ::" + Main.allPeople.get(i).id);
			}
		}
	}

	public ArrayList<String> Get_Marry_Date(ArrayList<String> famIDList) {
		// --
		// What I am doing in this function is:
		// Search the given family ID in myFamilies
		// Get & return marry date (if married)
		// --

		// Some person maybe have multiple parents(remarried), use ArrayList to collect each
		// marriage marry date (if applicable)
		ArrayList<String> marryDateList = new ArrayList<String>();
		if (famIDList.isEmpty()) {
			//Family not existed
			return null;
		}
		// Loop the famIDList elements
		for (int i = 0; i < famIDList.size(); i++) {
			// Loop the allFamilies elements
			for (int j = 0; j < Main.allFamilies.size(); j++) {
				// If given famID existed in allFamilies
				if (famIDList.get(i) == Main.allFamilies.get(j).familyID) {
					// Get & return the marry date (if married)
					if (!Main.allFamilies.get(j).marrDate.isEmpty()) {
						marryDateList.add(Main.allFamilies.get(j).marrDate);
					} else {
						//No marry date found, GED file data error?
						return null;
					}
				}
			}
		}
		return marryDateList;
	}
}