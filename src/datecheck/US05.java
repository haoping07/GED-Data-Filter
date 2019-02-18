// GJ write
package datecheck;

public class US05 {
	public US05() {
		System.out.println("create!");
	}
	
	public static boolean marriage_before_death(String marriageDate, String deathDate){
		String[] md=marriageDate.split(" ");
        String[] dd=deathDate.split(" ");
        
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
		System.out.println(marriage_before_death("28 JAN 2019","28 JAN 2019"));
		System.out.println(marriage_before_death("17 JAN 2019","28 JAN 2019"));
		System.out.println(marriage_before_death("28 JAN 2019","28 FEB 2019"));
		System.out.println(marriage_before_death("28 JAN 2018","28 JAN 2019"));
		System.out.println(marriage_before_death("28 JAN 2019","18 JAN 2019"));
		System.out.println(marriage_before_death("28 FEB 2019","28 JAN 2019"));
		System.out.println(marriage_before_death("28 JAN 2019","28 JAN 2018"));
	}

}
