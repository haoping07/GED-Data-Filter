//Author: Song Xu
package birth_before;

public class birth_before_death_US03 {
    public boolean birth_before_death(String birth_date,String death_date){
        String[] brith=birth_date.split(" ");
        String[] death=death_date.split(" ");

        if(checkdate_US01.checkyear(birth[0] , death[2])) {
            if(checkdate_US01.checkmonth(brith[1] , death[1])) {
                if(checkdate_US01.checkday(brith[2] , death[2])) {
                    return true;
                }
            }
        }
            return false;
    }
}

