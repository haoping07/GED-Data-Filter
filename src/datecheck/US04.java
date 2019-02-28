// GJ write
package datecheck;

import java.util.ArrayList;
import java.util.HashMap;

import fam.Family;
import indi.individual;

//import datecheck.checkdate_US01;

public class US04 {
	public US04() {
        System.out.println("create!");
    }
	
	public void Marriage_Before_Divorce(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		for (int i = 0; i < allPeople.size(); i++) {
			//If that person have spouse
			if (!allPeople.get(i).spouse.isEmpty()) {
				HashMap<String,String> md_map = Get_Marriage_Divorce(allPeople.get(i).spouse,allFamilies);
				for(HashMap.Entry<String,String> entry : md_map.entrySet()) {
					if(!DateCheck(entry.getKey(),entry.getValue())) {
						System.out.println("Debug messages(US04)[**ILLEGAL**] " 
					+ "marriage date NOT before divorce date :: "+allPeople.get(i).id);
					}
					else {
						System.out.println("Debug messages(US04)[GOOD] " 
								+ "marriage date before divorce date :: "+allPeople.get(i).id);
					}
				}
			} 
			else System.out.println("Debug messages(US04)[GOOD]: " + "The person is single! ::" + allPeople.get(i).id);
		}
	}
	
	public HashMap<String,String> Get_Marriage_Divorce(ArrayList<String> famIDList, ArrayList<Family> allFamilies) {
		HashMap<String,String> md_map = new HashMap<> ();
		for (int i = 0; i < famIDList.size(); i++) {
			for (int j = 0; j < allFamilies.size(); j++) {
				if (famIDList.get(i) == allFamilies.get(j).familyID) {
					md_map.put(allFamilies.get(j).marrDate,allFamilies.get(j).divoDate);
					//if marrDate repeat, then only the last one will be stored in the hashmap!!! maybe error!!!!
				}
			}
		}
		return md_map; // key is the marriage date, value is the divorce date
	}
	
	
	
// The following is all for DateCheck function
	// if marriageDate > divorceDate, return false
    public static boolean DateCheck(String marriageDate, String divorceDate){
    	if(divorceDate.isEmpty()) { // if no divorceDate, return true(dont need to check marriage date)
    		return true;
    	}
    	else if(marriageDate.isEmpty()) { // if it has divorceDate but no marriage date, return false
    		return false;
    	}
    	
        String[] md=marriageDate.split(" ");
        String[] dd=divorceDate.split(" ");

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
        String[] month = {" " , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" ,
        		"JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
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

    public static void main(String[] args) {
        System.out.println(DateCheck("29 JAN 2018","28 MAY 2018"));
//        System.out.println(marriage_before_divorce("17 JAN 2019","28 JAN 2019"));
//        System.out.println(marriage_before_divorce("28 JAN 2019","28 FEB 2019"));
//        System.out.println(marriage_before_divorce("28 JAN 2018","28 JAN 2019"));
//        System.out.println(marriage_before_divorce("28 JAN 2019","18 JAN 2019"));
//        System.out.println(marriage_before_divorce("28 FEB 2019","28 JAN 2019"));
//        System.out.println(marriage_before_divorce("28 JAN 2019","28 JAN 2018"));


    }

}
