//Hao-Ping Lin 10437296 (LH)
package datecheck;

import java.util.ArrayList;
import java.util.HashMap;
import fam.Family;
import indi.individual;

public class US06 {
	public void Divorce_Before_Death(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		for (int i = 0; i < allPeople.size(); i++) {
			//If that person have spouse
			if (!allPeople.get(i).spouse.isEmpty()) {
				ArrayList<String> divorceDateList = Get_Divorce_Date(allPeople.get(i).spouse, allFamilies);
				if (divorceDateList == null) System.out.println("Debug messages(US06)[GOOD]: " + "No divorce date detected! ::" + allPeople.get(i).id); // very wired!!! GJ
				else {
					//Get the person's death date in allPeople (if not dead)
					String death_date = allPeople.get(i).Deathday;
					if (death_date.isEmpty()) System.out.println("Debug messages(US06)[GOOD]: " + "The person is alive! ::" + allPeople.get(i).id);
					else {
						boolean check = true;
						for (int j = 0; j < divorceDateList.size(); j++) {
							check = DateCheck(divorceDateList.get(j), death_date); // check will be overwritten by some elements. This is wrong! GJ
						}
						//If divorce date before death date, legal!
						if (check) System.out.println("Debug messages(US06)[GOOD]: " + "Divorce date before Death date! ::" + allPeople.get(i).id);
						//If divorce date after death date, illegal!
						else {
							 System.out.println("Debug messages(US06)[**ILLEGAL**]: " + "Divorce date after Death date! ::" +
							 allPeople.get(i).id);
						}
					}
				}
			} 
			else System.out.println("Debug messages(US06)[GOOD]: " + "The person is single! ::" + allPeople.get(i).id);
		}
	}

	public ArrayList<String> Get_Divorce_Date(ArrayList<String> famIDList, ArrayList<Family> allFamilies) {
		ArrayList<String> divorceDateList = new ArrayList<String>();
		if (famIDList.isEmpty()) return null;
		for (int i = 0; i < famIDList.size(); i++) {
			for (int j = 0; j < allFamilies.size(); j++) {
				if (famIDList.get(i) == allFamilies.get(j).familyID) {
					if (!allFamilies.get(j).divoDate.isEmpty()) {
						divorceDateList.add(allFamilies.get(j).divoDate);
					} 
					else return null;	// looks wired!!! need to check(GJ)				
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
		monthmap.put("JAN", 1);	monthmap.put("FEB", 2);	monthmap.put("MAR", 3);	monthmap.put("APR", 4);	monthmap.put("MAY", 5);	monthmap.put("JUN", 6);
		monthmap.put("JUL", 7);	monthmap.put("AUG", 8);	monthmap.put("SEP", 9);	monthmap.put("OCT", 10);	monthmap.put("NOV", 11); monthmap.put("DEC", 12);
		if (Integer.valueOf(divorce[2]) > Integer.valueOf(death[2])) return false;
		if (Integer.valueOf(divorce[2]) < Integer.valueOf(death[2])) return true;
		if (Integer.valueOf(divorce[2]) == Integer.valueOf(death[2])) {
			if (monthmap.get(divorce[1]) > monthmap.get(death[1])) return false;
			if (monthmap.get(divorce[1]) < monthmap.get(death[1])) return true;
			if (monthmap.get(divorce[1]) == monthmap.get(death[1])) {
				if (Integer.valueOf(divorce[0]) > Integer.valueOf(death[0])) return false;
				if (Integer.valueOf(divorce[0]) < Integer.valueOf(death[0])) return true;
				if (Integer.valueOf(divorce[0]) == Integer.valueOf(death[0])) return true;
			}
		}
		return true;
	}
}