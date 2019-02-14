// GJ write
package datecheck;

public class US05 {
	public boolean marrige_before_divorce(String marrigeDate, String deathDate){
		String[] md=marrigeDate.split(" ");
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
		US05 us = new US05();
		boolean res = us.marrige_before_divorce("19 JAN 1998","20 MAR 1996");
		if(res) {
			System.out.println("true");
		}
		else {
			System.out.println("wrong");
		}
	}

}
