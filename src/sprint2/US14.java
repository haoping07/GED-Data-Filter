//Author: Hao-Ping Lin
package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fam.Family;
import indi.individual;

//Debug Code:
//#0: No sibling greater than 5 at the same time (Pass)
//#1(For DEV): Something Wrong
//#2(Error): Multiple births > 5 

public class US14 {
	public int[] Multiple_Births_Smaller_5(ArrayList<individual> allPeople, ArrayList<Family> allFamilies)
	{
		int[] DEBUG = new int[allFamilies.size()];
		
		for (int i = 0; i < allFamilies.size(); i++)
		{
			int childrenSize = allFamilies.get(i).children.size();
			
			if (childrenSize > 5)
			{
				List<String> childenBirthDateList = new ArrayList<String>();
				
				for (int j = 0; j < childrenSize; j++)
				{
					String IndiID = allFamilies.get(i).children.get(j);
					childenBirthDateList.add(gBirthDateByIndiID(IndiID, allPeople));
				}
				
				boolean checkResult = CalSameBirthDateGreater5(childenBirthDateList);
				if (!checkResult)
				{
					DEBUG[i] = 0;	//Msg #0: "No sibling greater than 5 at the same time (Pass)"
					//System.out.println(allFamilies.get(i).familyID + " Looking Good! No sibling greater than 5 at the same time!");
					continue;
				}
				else
				{
					DEBUG[i] = 2;	//Msg #2(Error): "Multiple births > 5"
					System.out.println("Error(US14)[#2]: Family " + allFamilies.get(i).familyID + " sibling is greater than 5 at the same time!");
					continue;
				}
			}
			else
			{
				DEBUG[i] = 0;	//Msg #0: "No sibling greater than 5 at the same time (Pass)"
				//System.out.println(allFamilies.get(i).familyID + " Looking Good! No sibling greater than 5 at the same time!");
				continue;
			}
		}
		return DEBUG;
	}
	
	public String gBirthDateByIndiID(String indiID, ArrayList<individual> allPeople)
	{
		String birthDate = "";
		
		for (int i = 0; i < allPeople.size(); i++)
		{
			if (allPeople.get(i).id.equals(indiID))
			{				
				if (!allPeople.get(i).Birthday.isEmpty())
				{
					birthDate = allPeople.get(i).Birthday;
				}
				else
				{
					//Birth date is empty
					//System.out.println(indiID + " birth date is empty");
				}
			}
		}
		return birthDate;
	}
	
	public boolean CalSameBirthDateGreater5(List<String> childenBirthDateList)
	{
		HashMap<String, Integer> birthDateMap = new HashMap<String, Integer>();
		for (int i = 0; i < childenBirthDateList.size(); i++)
		{
			if (birthDateMap.get(childenBirthDateList.get(i)) != null)
			{
				birthDateMap.put(childenBirthDateList.get(i), birthDateMap.get(childenBirthDateList.get(i)) + 1);
				if (birthDateMap.get(childenBirthDateList.get(i)) > 5)
				{
					return true;
				}
			}
			else
			{
				birthDateMap.put(childenBirthDateList.get(i), 1);
			}
		}
		return false;
	}
}