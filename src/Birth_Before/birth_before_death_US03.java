//Author: Song Xu
package Birth_Before;

import datecheck.checkdate_US01;

public class birth_before_death_US03 {
    public boolean birth_before_death(String birth_date,String death_date){
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

