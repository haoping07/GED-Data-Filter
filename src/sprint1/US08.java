//Hao-Ping Lin 10437296 (LH)
//User Stroy 08 - Birth before marriage of parents
package sprint1;

import java.util.ArrayList;
import fam.Family;
import indi.individual;

public class US08 
{
	public ArrayList<Boolean> Birth_Before_Marriage_Of_Parents(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) 
	{
		ArrayList<Boolean> resultCheck = new ArrayList<Boolean>();
		
		for (int i = 0; i < allPeople.size(); i++) 
		{
			if (!allPeople.get(i).children.isEmpty()) 
			{
				ArrayList<String> parent_Married_Date_List = Get_Marry_Date(allPeople.get(i).children, allFamilies);
				if (parent_Married_Date_List.isEmpty())
				{
					System.out.println("WARNING(US08): Person::" + allPeople.get(i).id +
							"'s parent was Married but don't have Married Date? (Lack of GED data?)");
					resultCheck.add(true);
				}
				else 
				{
					String birth_date = allPeople.get(i).Birthday;
					if (birth_date.isEmpty())
					{
						System.out.println("WARNING(US08): Person::" + allPeople.get(i).id +
								" don't have Birth Date? (Lack of GED data?)");
						resultCheck.add(true);
					}

					else 
					{
						// Run function DateCheck(date1, date2) in US06 with birth date and parent's
						// marry date
						boolean check = true;
						for (int j = 0; j < parent_Married_Date_List.size(); j++) 
						{
							check = US06.DateCheck(parent_Married_Date_List.get(j), birth_date);
							// If birth date after parent's marry date, legal!
							if (check)
							{
							//	System.out.println("Debug messages(US08)[GOOD]: "
							//			+ "Birth date after parent's marry date! ::" + allPeople.get(i).id);
								resultCheck.add(true);
							}
							// If birth date after parent's marry date, illegal!
							else 
							{
								System.out.println("ERROR(US08): Person::" + allPeople.get(i).id +
										" Birth date " + "( " + birth_date + ")" + " before parent's Married Date " + 
										"( " + parent_Married_Date_List.get(j) + ")" + "!");
								resultCheck.add(false);
							}
						}
					}
				}
			} 
			else
			{
				System.out.println("WARNING(US08): Person::" + allPeople.get(i).id +
						" don't have parent? (Lack of GED data?)");
				resultCheck.add(true);
			}

		}
		return resultCheck;
	}

	public ArrayList<String> Get_Marry_Date(ArrayList<String> famIDList, ArrayList<Family> allFamilies) 
	{
		ArrayList<String> marryDateList = new ArrayList<String>();
		if (famIDList.isEmpty())
			return null;
		for (int i = 0; i < famIDList.size(); i++) 
		{
			for (int j = 0; j < allFamilies.size(); j++) 
			{
				if (famIDList.get(i) == allFamilies.get(j).familyID) 
				{
					if (!allFamilies.get(j).marrDate.isEmpty()) 
					{
						marryDateList.add(allFamilies.get(j).marrDate);
					}
				}
			}
		}
		return marryDateList;
	}
}