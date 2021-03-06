// GJ write
package sprint1;

import java.util.ArrayList;
//import java.util.HashMap;

import fam.Family;
import indi.individual;

public class US05 {
	
	public void Marriage_Before_Death(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		for(int i = 0; i<allFamilies.size(); i++) {
			String husID = allFamilies.get(i).husband;
			String wifeID = allFamilies.get(i).wife;
			String famID = allFamilies.get(i).familyID;
			String marrDate = allFamilies.get(i).marrDate;
			individual hus = searchByID(allPeople,husID);
			individual wife = searchByID(allPeople,wifeID);
			if(hus==null) {
				System.out.println("WARNING: FAMILY: US05: "
					    + famID + " Married: " + marrDate
					    + " No husband");
			}
			else {
				try {
					if(!dateCheck(marrDate,hus.Deathday)) {
						System.out.println("ERROR: FAMILY: US05: "
							    +famID + " Married: " + marrDate
							    +" after husband's ( " + husID 
							    +" ) death on " + hus.Deathday);
					}
				}
				catch(IllegalArgumentException ex) {
					System.out.println("WARNING: FAMILY: US05: "
						    + famID + " " +ex.getMessage());
				}
			}
			if(wife==null) {
				System.out.println("WARNING: FAMILY: US05: "
					    + famID + " Married: " + marrDate
					    + " No wife");
			}
			else {
				try {
					if(!dateCheck(marrDate,wife.Deathday)) {
						System.out.println("ERROR: FAMILY: US05: "
							    +famID + " Married: " + marrDate
							    +" after wife's ( " + wifeID 
							    +" ) death on " + wife.Deathday);
					}
				}
				catch(IllegalArgumentException ex) {
					System.out.println("WARNING: FAMILY: US05: "
						    + famID + " " +ex.getMessage());
				}
			}
			
		}
	}
	
	private individual searchByID(ArrayList<individual> allPeople, String ID) {
		for(int x = 0 ; x < allPeople.size() ; x++) {
    		if(ID.equals(allPeople.get(x).id)) {    		
    			return allPeople.get(x);
    		}
    	}
    	
    	return null;
	}
	
	// The following is all for DateCheck function
		// if marriageDate > deathDate, return false
	public static boolean dateCheck(String marriageDate, String deathDate){
		if (marriageDate.isEmpty()) {
			throw new IllegalArgumentException("Marriage Date Is EMPTY!");
		}
		
		if (deathDate.isEmpty()) {
			return true;
		} //  no death return true
		
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
//        System.out.println(dateCheck("29 JAN 2020","28 MAY 2018"));
////        System.out.println(marriage_before_death("17 JAN 2019","28 JAN 2019"));
////        System.out.println(marriage_before_death("28 JAN 2019","28 FEB 2019"));
////        System.out.println(marriage_before_death("28 JAN 2018","28 JAN 2019"));
////        System.out.println(marriage_before_death("28 JAN 2019","18 JAN 2019"));
////        System.out.println(marriage_before_death("28 FEB 2019","28 JAN 2019"));
////        System.out.println(marriage_before_death("28 JAN 2019","28 JAN 2018"));
//    }

}
