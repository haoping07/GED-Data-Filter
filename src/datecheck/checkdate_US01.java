//Lo Shih Hao
package datecheck;

import java.time.LocalDate;

public class checkdate_US01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Date today");
		String[] nowarr = LocalDate.now().toString().split("-");
		nowarr[1] = mapmonth(nowarr[1]);
		System.out.println(nowarr[2] + " " + nowarr[1] + " " + nowarr[0]);
		System.out.println(checkdate_US01.checkdate_us01(nowarr[2] + " " + nowarr[1] + " " + nowarr[0]));
		System.out.println("Yesterday");
		System.out.println(checkdate_US01.checkdate_us01("23 FEB 2019"));
		System.out.println("Last month");
		System.out.println(checkdate_US01.checkdate_us01("17 JAN 2019"));
		System.out.println("Next month");
		System.out.println(checkdate_US01.checkdate_us01("17 MAR 2019"));
		System.out.println("Next Year");
		System.out.println(checkdate_US01.checkdate_us01("17 FEB 2020"));
	}
	private static String mapmonth(String string) {
		String[] month = {" " , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
		int a = checkdate_US01.stoi(string);
		return month[a];
	}
	
	public checkdate_US01() {
		System.out.println("create!");
	}
	
	public static boolean checkdate_us01(String date){
	//public boolean checkdate_us01(String date){
		String[] indate = date.split(" ");
		LocalDate localDate = LocalDate.now();
		String now = localDate.toString();
		String[] nowdate = now.split("-");
		
		//System.out.println("y:"+checkyear(nowdate[0] , indate[2]));
		//System.out.println("m:"+checkmonth(nowdate[1] , indate[1]));
		//System.out.println("d:"+checkday(nowdate[2] , indate[0]));
			
		if(!checkyear(nowdate[0] , indate[2])) {
			return false;
		} else if (checkyeareq(nowdate[0] , indate[2])) {
			if(!checkmonth2(nowdate[1] , indate[1])) {
				return false;
			} else if (checkmontheq(nowdate[1] , indate[1])) {
				if(!checkday(nowdate[2] , indate[0])) {
					return false;
				} else {
					return true;
				}
			} else {
				return true;
			}
		} else {
			return true;
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
	
	public static boolean checkmonth2(String nowmonth , String inmonth){
		String[] month = {" " , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
		int in = inarridx(month , inmonth);
		//System.out.println("in"+in);
		//System.out.println("now:"+nowmonth);
		if(in == -1) return false;
		if(in > stoi(nowmonth)) return false;
		else return true;
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

}
