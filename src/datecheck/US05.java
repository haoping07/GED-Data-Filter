// GJ write
package datecheck;

import java.util.ArrayList;
import java.util.HashMap;

import fam.Family;
import indi.individual;

public class US05 {
	public US05() {
		System.out.println("create!");
	}
	
	public void Marriage_Before_Death(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		for (int i = 0; i < allPeople.size(); i++) {
			//If that person have spouse
			if (!allPeople.get(i).spouse.isEmpty()) {
				HashMap<String,String> mf_map = Get_Marriage_FamilyID(allPeople.get(i).spouse,allFamilies);
				String deathDate = allPeople.get(i).Deathday;
				for(HashMap.Entry<String,String> entry : mf_map.entrySet()) {
					if(!DateCheck(entry.getKey(),deathDate)) {
						System.out.println("Debug messages(US05)[**ILLEGAL**]: "
						+ "Marriage date NOT before death date " + " INDI ID:: " +allPeople.get(i).id +" FAM ID:: "
						+ entry.getValue());
					}
					else {
						System.out.println("Debug messages(US05)[GOOD]: "
						+ "Marriage date before death date " + " INDI ID:: " +allPeople.get(i).id +" FAM ID:: "
						+ entry.getValue());
					}
				}
			} 
			else {
				System.out.println("Debug messages(US05)[GOOD]: " + "The person is single! ::" + allPeople.get(i).id);
			} 
		}
	}
	
	public HashMap<String,String> Get_Marriage_FamilyID(ArrayList<String> famIDList, ArrayList<Family> allFamilies) {
		HashMap<String,String> mf_map = new HashMap<> ();
		for (int i = 0; i < famIDList.size(); i++) {
			for (int j = 0; j < allFamilies.size(); j++) {
				if (famIDList.get(i) == allFamilies.get(j).familyID) {
					mf_map.put(allFamilies.get(j).marrDate,allFamilies.get(j).familyID);
					//if marrDate repeat, then only the last one will be stored in the hashmap!!! maybe error!!!!
				}
			}
		}
		return mf_map; // key is the marriage date, value is the familyID
	}
	
	// The following is all for DateCheck function
		// if marriageDate > deathDate, return false
	public static boolean DateCheck(String marriageDate, String deathDate){
		if (deathDate.isEmpty() || marriageDate.isEmpty()) // no marriage or no death return true
			return true;
		
		String[] md=marriageDate.split(" ");
        String[] dd=deathDate.split(" ");

        switch(checkyear(md[2],dd[2])){
            case 2:
                return false;

            case 1:
                return true;

            case 0:
                switch(checkmonth(md[1],dd[1])){
                    case 2:
                        return false;

                    case 1:
                        return true;

                    case 0:
                        switch(checkday(md[0],dd[0])){
                            case 2:
                                return false;

                            case 1:
                                return true;

                            case 0:
                                return true;
                        }
                }
        }
        return false; // default
	}
	
	public static int checkday(String preDay , String aftDay){
        if(stoi(preDay) > stoi(aftDay)) return 2; // false
        if(stoi(preDay) < stoi(aftDay)) return 1; //true
        else return 0; // equal
    }

    public static int checkmonth(String preMonth , String aftMonth ){
        String[] month = {" " , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
        int pre = inarridx(month , preMonth);
        int aft = inarridx(month , aftMonth);
        if(pre == -1 || aft == -1) return 2; // false
        else {
            if(pre>aft) return 2; // false
            if(pre<aft) return 1; //true
            else return 0; // equal
        }
    }

    public static int checkyear(String preYear , String aftYear){ //
        if(stoi(preYear) > stoi(aftYear)) return 2; // false
        if(stoi(preYear) < stoi(aftYear)) return 1; //true
        else return 0; // equal
    }

    public static int stoi(String input) {
        // should check the ASCII number ranging from ("0" to "9");
        int out = 0;
        for(int x = 0 ; x < input.length() ; x++) {
            out = (out*10)+((int)input.charAt(x)-48);
        }
        return out;
    }

    public static int inarridx(String[] arr , String value) {
        for(int x = 0 ; x < arr.length ; x++) {
            if(arr[x].equals(value)) return x;
        }
        return -1;
    }

//    public static void main(String[] args) {
//        System.out.println(marriage_before_death("29 JAN 2018","28 MAY 2018"));
//        System.out.println(marriage_before_death("17 JAN 2019","28 JAN 2019"));
//        System.out.println(marriage_before_death("28 JAN 2019","28 FEB 2019"));
//        System.out.println(marriage_before_death("28 JAN 2018","28 JAN 2019"));
//        System.out.println(marriage_before_death("28 JAN 2019","18 JAN 2019"));
//        System.out.println(marriage_before_death("28 FEB 2019","28 JAN 2019"));
//        System.out.println(marriage_before_death("28 JAN 2019","28 JAN 2018"));
//    }

}
