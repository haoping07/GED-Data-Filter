//Hao-Ping Lin 10437296 (LH)
package datecheck;

import java.util.ArrayList;
import fam.Family;
import indi.individual;

public class US08 {
	public US08() {
		
	}
	public void Birth_Before_Marriage_Of_Parents(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		for (int i = 0; i < allPeople.size(); i++) {
			if (!allPeople.get(i).children.isEmpty()) {
				ArrayList<String> parent_Married_Date_List = Get_Marry_Date(allPeople.get(i).children, allFamilies);
				if (parent_Married_Date_List.isEmpty()) System.out.println("Debug messages(US08)[WARNING]: " + "No parent marry date found!(Lack of GED data?) ::" + allPeople.get(i).id);
				else {
					String birth_date = allPeople.get(i).Birthday;
					if (birth_date.isEmpty()) System.out.println("Debug messages(US08)[WARNING]: " + "Birth date not found!(Lack of GED data?) ::" + allPeople.get(i).id);
					else {
						//Run function DateCheck(date1, date2) in US06 with birth date and parent's marry date
						boolean check = true;
						for (int j = 0; j < parent_Married_Date_List.size(); j++) {
							check = US06.DateCheck(parent_Married_Date_List.get(j), birth_date);
							//If birth date after parent's marry date, legal!
							if (check) System.out.println("Debug messages(US08)[GOOD]: " + "Birth date after parent's marry date! ::" + allPeople.get(i).id);
							//If birth date after parent's marry date, illegal!
							else {
								 System.out.println("Debug messages(US08)[**ILLEGAL**]: " + "Birth date after parent's marry date! ::" +
								 allPeople.get(i).id);
							}
						}
					}
				}
			}
			else System.out.println("Debug messages(US08)[WARNING]: " + "The person don't have parent! (Lack of GED data?) ::" + allPeople.get(i).id);
		}
	}

	public ArrayList<String> Get_Marry_Date(ArrayList<String> famIDList, ArrayList<Family> allFamilies) {
		ArrayList<String> marryDateList = new ArrayList<String>();
		if (famIDList.isEmpty()) return null;
		for (int i = 0; i < famIDList.size(); i++) {
			for (int j = 0; j < allFamilies.size(); j++) {
				if (famIDList.get(i) == allFamilies.get(j).familyID) {
					if (!allFamilies.get(j).marrDate.isEmpty()) {
						marryDateList.add(allFamilies.get(j).marrDate);
					} 
				}
			}
		}
		return marryDateList;
	}
}