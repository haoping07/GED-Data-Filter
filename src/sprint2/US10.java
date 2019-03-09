package sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fam.Family;
import indi.individual;

//Debug Code:
//#0: Marriage after 14 (Pass)
//#1(For DEV):  Something Wrong
//#2(Warning): Birth date is empty (lack of GED data?)
//#3: The person is single (Pass)
//#4(Error): Marriage before 14
//#5(Warning): The person's family don't have marriage date (lack of GED data?)

public class US10 
{
	public int[] Marriage_After_14(ArrayList<individual> allPeople, ArrayList<Family> allFamilies)
	{
		int[] DEBUG = new int[allPeople.size()];
		for (int i = 0; i < allPeople.size(); i++)
		{
			if (allPeople.get(i).Birthday.isEmpty())
			{
				DEBUG[i] = 2;	//Msg #2: "Birth date is empty!"
				System.out.println("Warning(US10)[#2]: Person " + allPeople.get(i).id + "'s birth date is empty! (Lack of GED data?)");
				continue;
			}
			if (allPeople.get(i).spouse.isEmpty())
			{
				DEBUG[i] = 3;	//Msg #3: "The person is single!"
				continue;
			}
			
			String BDPlus14 = BirthDatePlus14(allPeople.get(i).Birthday);
			
			int spouseSize = allPeople.get(i).spouse.size();
			
			List<String> gMarriedDate = new ArrayList<String>();
			
			for (int p = 0; p < spouseSize; p++)
			{
				String FamID = allPeople.get(i).spouse.get(p);
				gMarriedDate.add(GetMarriedDateByFamID(FamID, allFamilies));
			}
			
			for (int k = 0; k < spouseSize; k++)
			{
				if (!gMarriedDate.get(k).isEmpty())
				{
					DEBUG[i] = CheckDate(BDPlus14, gMarriedDate.get(k));
					if (DEBUG[i] == 4)	//Msg #4 (Error): "Marriage before 14!"
					{
						System.out.println("Error(US10)[#4]: One or more family " + allPeople.get(i).id + 
								" built was before 14! (ex. " + allPeople.get(i).spouse.get(k) + "..)");
						break;
					}
				}
				else
				{
					DEBUG[i] = 5;
					System.out.println("Warning(US10)[#5]: Person " + allPeople.get(i).id + "'s family " + allPeople.get(i).spouse.get(k) + "don't have married date! (Lack of GED data?)");
				}

			}
		}
		return DEBUG;
	}

	public String BirthDatePlus14(String birthday)
	{
		String[] BDSplitStr = birthday.split(" ");
		
		BDSplitStr[2] = Integer.toString(Integer.parseInt(BDSplitStr[2]) + 14);
		
		return BDSplitStr[0] + " " + BDSplitStr[1] + " " + BDSplitStr[2];
	}
	
	public String GetMarriedDateByFamID(String FamID, ArrayList<Family> allFamilies)
	{
		String marriedDate = "";
		for (int i = 0; i < allFamilies.size(); i++)
		{
			if (allFamilies.get(i).familyID.equals(FamID))
			{
				if (!allFamilies.get(i).marrDate.isEmpty())
				{
					marriedDate = allFamilies.get(i).marrDate;
				}
				else
				{
					//Married date is empty
					//System.out.println(FamID + " Married date is empty");
				}
			}
		}
		return marriedDate;
	}
		
	public int CheckDate(String date1, String date2)
	{
		String[] date1SplitStr = date1.split(" ");
		String[] date2SplitStr = date2.split(" ");
		
		HashMap<String, Integer> monthmap = new HashMap<String, Integer>();
		
		monthmap.put("JAN", 1);	monthmap.put("FEB", 2);	monthmap.put("MAR", 3);	monthmap.put("APR", 4);
		monthmap.put("MAY", 5);	monthmap.put("JUN", 6);	monthmap.put("JUL", 7);	monthmap.put("AUG", 8);
		monthmap.put("SEP", 9);	monthmap.put("OCT", 10); monthmap.put("NOV", 11); monthmap.put("DEC", 12);
		
		if (Integer.parseInt(date1SplitStr[2]) > Integer.parseInt(date2SplitStr[2]))
			return 4;	//Msg #4 (Error): "Marriage before 14!"
		if (Integer.parseInt(date1SplitStr[2]) < Integer.parseInt(date2SplitStr[2]))
			return 0;	//Msg #0: "Marriage after 14!"
		if (Integer.parseInt(date1SplitStr[2]) == Integer.parseInt(date2SplitStr[2])) 
		{
			if (monthmap.get(date1SplitStr[1]) > monthmap.get(date2SplitStr[1]))
				return 4;	//Msg #4 (Error): "Marriage before 14!"
			if (monthmap.get(date1SplitStr[1]) < monthmap.get(date2SplitStr[1]))
				return 0;	//Msg #0: "Marriage after 14!"
			if (monthmap.get(date1SplitStr[1]) == monthmap.get(date2SplitStr[1])) 
			{
				if (Integer.parseInt(date1SplitStr[0]) > Integer.parseInt(date2SplitStr[0]))
					return 4;	//Msg #4 (Error): "Marriage before 14!"
				if (Integer.parseInt(date1SplitStr[0]) < Integer.parseInt(date2SplitStr[0]))
					return 0;	//Msg #0: "Marriage after 14!"
				if (Integer.parseInt(date1SplitStr[0]) == Integer.parseInt(date2SplitStr[0]))
					return 0;	//Msg #0: "Marriage after 14! Actually, same day as being 14."
			}
		}
		return 1;	//Msg #1: For dev: Something wrong!
	}
}