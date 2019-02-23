//Hao-Ping Lin 10437296 (LH)
package datecheck;

import java.util.ArrayList;
import java.util.HashMap;
import Mainprogram.Main;

public class US06 {
	public void Divorce_Before_Death() {
		// --
		// What I am doing in this function is:
		// Loop the allPeople elements
		// If (the person have spouse) {
		// Run function Get_Divorce_Date() and get divorce date (If divorced)
		// Run function DateCheck() with divorce date and death date
		// }
		// --

		//Loop the allPeople elements
		for (int i = 0; i < Main.allPeople.size(); i++) {
			//If that person have spouse
			if (!Main.allPeople.get(i).spouse.isEmpty()) {
				//Run function Get_Divorce_Date() to get divorce date (If divorced)
				ArrayList<String> divorceDateList = Get_Divorce_Date(Main.allPeople.get(i).spouse);

				//If divorce_date is null, it means no divorce date found in allFamilies
				if (divorceDateList == null) {
					// The spouse love each other, [No problem with divorce date after death date]
					System.out.println("Debug messages(US06)[GOOD]: " + "No divorce date detected! ::" + Main.allPeople.get(i).id);
				}
				//divorce_date found in allFamilies
				else {
					//Get the person's death date in allPeople (if not dead)
					String death_date = Main.allPeople.get(i).Deathday;
					if (death_date.isEmpty()) {
						//The person is alive, [No problem with divorce date after death date]
						System.out.println("Debug messages(US06)[GOOD]: " + "The person is alive! ::" + Main.allPeople.get(i).id);
					} else {
						//Run function divorce_before_death(date1, date2) with death date and divorce date
						boolean check = true;
						for (int j = 0; j < divorceDateList.size(); j++) {
							//System.out.println(divorceDateList);
							check = DateCheck(divorceDateList.get(j), death_date);
						}
						//If divorce date before death date, legal!
						if (check) {
							System.out.println("Debug messages(US06)[GOOD]: " + "Divorce date before Death date! ::" + Main.allPeople.get(i).id);
						}
						//If divorce date after death date, illegal!
						else {
							 System.out.println("Debug messages(US06)[**ILLEGAL**]: " + "Divorce date after Death date! ::" +
							 Main.allPeople.get(i).id);
						}
					}
				}
			} else {
				//The person didn't get married, [No problem with divorce date after death date]
				System.out.println("Debug messages(US06)[GOOD]: " + "The person is single! ::" + Main.allPeople.get(i).id);
			}
		}
	}

	public ArrayList<String> Get_Divorce_Date(ArrayList<String> famIDList) {
		// --
		// What I am doing in this function is:
		// Search the given family ID in myFamilies
		// Get & return divorce date data (if divorce)
		// --

		// Some person maybe have multiple marriages, use ArrayList to collect each
		//..marriage divorce date (if applicable)
		ArrayList<String> divorceDateList = new ArrayList<String>();
		if (famIDList.isEmpty()) {
			//No spouse
			return null;
		}
		// Loop the famIDList elements
		for (int i = 0; i < famIDList.size(); i++) {
			// Loop the allFamilies elements
			for (int j = 0; j < Main.allFamilies.size(); j++) {
				// If given famID existed in allFamilies
				if (famIDList.get(i) == Main.allFamilies.get(j).familyID) {
					// Get & return the divorce date data (if divorce)
					if (!Main.allFamilies.get(j).divoDate.isEmpty()) {
						divorceDateList.add(Main.allFamilies.get(j).divoDate);
					} else {
						// This spouse love each other, no divorce date found
						return null;
					}
				}
			}
		}
		return divorceDateList;
	}
	
	//If Date1 > Date2, return false
	public static boolean DateCheck(String divorce_date, String death_date) {
		String[] divorce = divorce_date.split(" ");
		String[] death = death_date.split(" ");
		HashMap<String, Integer> monthmap = new HashMap<String, Integer>();
		monthmap.put("JAN", 1);
		monthmap.put("FEB", 2);
		monthmap.put("MAR", 3);
		monthmap.put("APR", 4);
		monthmap.put("MAY", 5);
		monthmap.put("JUN", 6);
		monthmap.put("JUL", 7);
		monthmap.put("AUG", 8);
		monthmap.put("SEP", 9);
		monthmap.put("OCT", 10);
		monthmap.put("NOV", 11);
		monthmap.put("DEC", 12);

		if (Integer.valueOf(divorce[2]) > Integer.valueOf(death[2])) {
			return false;
		}
		if (Integer.valueOf(divorce[2]) < Integer.valueOf(death[2])) {
			return true;
		}
		if (Integer.valueOf(divorce[2]) == Integer.valueOf(death[2])) {
			if (monthmap.get(divorce[1]) > monthmap.get(death[1])) {
				return false;
			}
			if (monthmap.get(divorce[1]) < monthmap.get(death[1])) {
				return true;
			}
			if (monthmap.get(divorce[1]) == monthmap.get(death[1])) {
				if (Integer.valueOf(divorce[0]) > Integer.valueOf(death[0])) {
					return false;
				}
				if (Integer.valueOf(divorce[0]) < Integer.valueOf(death[0])) {
					return true;
				}
				if (Integer.valueOf(divorce[0]) == Integer.valueOf(death[0])) {
					return true;
				}
			}
		}
		return true;
	}
}