//Hao-Ping Lin (LH)
package datecheck;

public class US06 {
	public boolean divorce_before_death(String divorce_date,String death_date) {
        String[] divorce = divorce_date.split(" ");
        String[] death = death_date.split(" ");
        //front base, later input
        if (checkdate_US01.checkyear(death[2], divorce[2])) {
        	if (checkdate_US01.checkmonth(death[1], divorce[1])) {
        		if (checkdate_US01.checkday(death[0], divorce[0])) {
        			return true;
        		}
        	}
        }
       return false;
    }
	
	public static void main(String[] args) {
		US06 test = new US06();
		boolean testFlag = test.divorce_before_death("1 JAN 1991","1 JAN 2000");
		System.out.println(testFlag);
	}
}
