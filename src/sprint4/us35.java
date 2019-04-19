package sprint4;

import java.util.ArrayList;
import java.time.LocalDate;
import indi.individual;

public class us35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.now();
		String now = localDate.toString();
		String[] nowarr = now.split("-");
		System.out.println(now);
		System.out.println(stoi(nowarr[0]));
		System.out.println(nowarr[1]);
		System.out.println(nowarr[2]);
		ArrayList<individual> p = new ArrayList<>();
		individual i = new individual("i1");
		i.update("BIRT", "18 MAR 2019");
		System.out.println(i.Birthday);
		p.add(i);
		list_recent_birth(p);
	}
	
	public static void list_recent_birth(ArrayList<individual> people) {
		LocalDate localDate = LocalDate.now();
		String now = localDate.toString();
		String[] nowarr = now.split("-");
		int mon = stoi(nowarr[1]);
		int yer = stoi(nowarr[0]);
		int day = stoi(nowarr[2])-30;
		if(day <= 0) {
			mon -= 1;
			day += 30;
		}
		for(int x = 0 ; x < people.size() ; x++) {
			String curdob = people.get(x).Birthday;
			String[] arrdob = curdob.split(" ");
			if(arrdob.length <2) continue;
			if(stoi(arrdob[2]) == yer) {
				int curm = mapmonth(arrdob[1]);
				int curd = stoi(arrdob[0]);
				if(curm == mon+1) {
					System.out.println("Info(US35): id " + people.get(x).id + " is born recently.");
					continue;
				} 
				else if(curm == mon) {
					if(curd >= day) {
						System.out.println("Info(US35): id " + people.get(x).id + " is born recently.");
						continue;
					}
				}
			}
		}
	}
	
	public static int stoi(String input) {
		int out = 0;
		for(int x = 0 ; x < input.length() ; x++) {
			out = (out*10)+((int)input.charAt(x)-48);
		}
		return out;
	}
	
	public static int mapmonth(String month) {
		String[] months = {"" , "JAN" , "FEB" , "MAR" , "APR" , "MAR" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
		for(int x = 1 ; x <= 12 ; x++) {
			if(months[x].equals(month)) return x;
		}
		return 0;
	}
}
