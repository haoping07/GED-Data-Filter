package sprint3;

import java.time.LocalDate;
import java.util.ArrayList;

import indi.individual;

public class US27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void age_calculate(ArrayList<individual> people){
		int cur = 0;
		for(int x = 0 ; x < people.size() ; x++) {
			cur = age(people.get(x));
			if(cur == -1) System.out.println("Warning(US27) [**ILLEGAL**]: No birthday found for id: " + people.get(x).id);
			else System.out.println("Info(US27): age for " + people.get(x).id +" is " + cur);
		}
	}
	
	public static int age(individual person){
		if(person.Birthday == "") {
			return -1;
		}
		String[] bdate = person.Birthday.split(" ");
		LocalDate localDate = LocalDate.now();
		String now = localDate.toString();
		String[] nowyear = now.split("-");
		if(person.isdead) {
			String[] ddate = person.Deathday.split(" ");
			person.age = stoi(ddate[2]) - stoi(bdate[bdate.length-1]);
		}
		else {
			person.age = stoi(nowyear[0]) - stoi(bdate[bdate.length-1]);
		}
		return person.age;
	}
	
	public static int stoi(String input) {
		int out = 0;
		for(int x = 0 ; x < input.length() ; x++) {
			out = (out*10)+((int)input.charAt(x)-48);
		}
		return out;
	}

}