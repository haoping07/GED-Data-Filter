// GJ write
package datecheck;

import datecheck.checkdate_US01;

public class US04 {
	public US04() {
		System.out.println("create!");
	}
	
	public static boolean marriage_before_divorce(String marriageDate, String devorceDate){
		String[] md=marriageDate.split(" ");
        String[] dd=devorceDate.split(" ");
        
        if(checkdate_US01.checkyear(dd[2] , md[2])) {
            if(checkdate_US01.checkmonth(dd[1] , md[1])) {
                if(checkdate_US01.checkday(dd[0] , md[0])) {
                    return true;
                }
            }
        }
            return false;
	}
	
	public static void main(String[] args) {
		System.out.println(marriage_before_divorce("28 JAN 2019","28 JAN 2019"));
		System.out.println(marriage_before_divorce("17 JAN 2019","28 JAN 2019"));
		System.out.println(marriage_before_divorce("28 JAN 2019","28 FEB 2019"));
		System.out.println(marriage_before_divorce("28 JAN 2018","28 JAN 2019"));
		System.out.println(marriage_before_divorce("28 JAN 2019","18 JAN 2019"));
		System.out.println(marriage_before_divorce("28 FEB 2019","28 JAN 2019"));
		System.out.println(marriage_before_divorce("28 JAN 2019","28 JAN 2018"));
		
	}

}
