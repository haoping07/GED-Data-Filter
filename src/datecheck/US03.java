//Author: Song Xu
package datecheck;

public class US03 {
	public static void main(String[] args) {
		System.out.println(birth_before_death("28 JAN 2019","28 JAN 2019"));
		System.out.println(birth_before_death("17 JAN 2019","28 JAN 2019"));
		System.out.println(birth_before_death("28 JAN 2019","28 FEB 2019"));
		System.out.println(birth_before_death("28 JAN 2018","28 JAN 2019"));
		System.out.println(birth_before_death("28 JAN 2019","18 JAN 2019"));
		System.out.println(birth_before_death("28 FEB 2019","28 JAN 2019"));
		System.out.println(birth_before_death("28 JAN 2019","28 JAN 2018"));
		
	}
    public static boolean birth_before_death(String birth_date,String death_date){
        String[] brith=birth_date.split(" ");
        String[] death=death_date.split(" ");
        
        if(checkdate_US01.checkyear(death[2], brith[2])) {
            if(checkdate_US01.checkmonth(death[1], brith[1])) {
                if(checkdate_US01.checkday(death[0], brith[0])) {
                    return true;
                }
            }
        }
        return false;
    }
}

