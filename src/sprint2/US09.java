package sprint2;

import java.util.ArrayList;

import fam.Family;
import indi.individual;

public class US09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void Birth_before_death_of_parents(ArrayList<individual> people , ArrayList<Family> families) {
		individual person = null;
		individual father = null;
		individual mother = null;
		int fid = 0;
		int mid = 0;
		
		for(int x = 0 ; x < people.size() ; x++) {
			person = people.get(x);
			fid = get_family_by_id(families , person.id);
			father = people.get(fid);
		}
	}


	public static boolean checkday(String nowday , String inday){
		if(stoi(inday) > stoi(nowday)) return false;
		else return true;
	}
	public static boolean checkdayeq(String nowday , String inday){
		if(stoi(inday) == stoi(nowday)) return true;
		else return false;
	}
	public static boolean checkmontheq(String nowmonth , String inmonth){
		String[] month = {" " , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
		int in = inarridx(month , inmonth);
		//System.out.println("in"+in);
		//System.out.println("now:"+nowmonth);
		if(in == -1) return false;
		if(in == stoi(nowmonth)) return true;
		else return false;
	}
	
	public static boolean checkmonth(String premonth , String aftmonth){
		String[] month = {" " , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
		int pre = inarridx(month , premonth);
		int aft = inarridx(month , aftmonth);
		//System.out.println("pre"+pre);
		//System.out.println("aft:"+aft);
		if(pre == -1 || aft == -1) return false;
		else {
			if(aft > pre) return false;
			else return true;
		}
	}
	
	public static boolean checkyear(String nowyear , String inyear){
		if(stoi(inyear) > stoi(nowyear)) return false;
		else return true;
	}
	
	public static boolean checkyeareq(String nowyear , String inyear){
		if(stoi(inyear) == stoi(nowyear)) return true;
		else return false;
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
	
	public int get_family_by_id(ArrayList<Family> families , String target) {
		for(int x = 0 ; x < families.size() ; x++) {
			if(families.get(x).familyID.equals(target)) {
				return x;
			}
		}
		return -1;
	}
}
