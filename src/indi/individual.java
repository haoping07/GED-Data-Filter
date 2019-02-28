package indi;
import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import datecheck.checkdate_US01;

public class individual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		//LS: Test script of function calage()
		/*individual i = new individual("1000");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String now = localDate.toString();
		String[] nowyear = now.split("-");
		System.out.println(nowyear[0]);		
		i.update("BIRT", "1 SEP 1995");	
		String[] qq = i.Birthday.split(" ");
		System.out.println(qq[2]);
		System.out.println(i.age);
		i.update("DEAT", "2 SEP 2020");
		System.out.println(i.age);*/
		
		//LS: Test method of US01
		//System.out.println(checkdate1("13 FEB 2019"));
		//LS: Test method of us07
		individual test = new individual("@US00@");
		test.update("BIRT", "15 MAY 1995");
		System.out.println("age of test:" + test.age);
		individual test2 = new individual("@US01@");
		test2.update("BIRT", "15 MAY 1000");
		System.out.println("age of test2: " + test2.age);
	}
	
	public individual(String id) {
		this.id = id;
		name = "";
		sex = "";
		Birthday = "";
		Deathday = "";
		children = new ArrayList<>();
		spouse = new ArrayList<>();
		isdead = false;
		age = 0;
	}
	
	public void update(String tag , String content) {
		switch(tag.toUpperCase()) {
		    case "NAME":
		    	this.name = content;
			break;
			
		    case "SEX":
		    	if(this.sex != "") {
		    		break;
		    	}
		    	this.sex = content;
			break;
			
		    case "BIRT":
		    	if(this.Birthday != "") {
		    		break;
		    	}
		    	if(!checkdate1(content)) {
		    		System.out.println("Birthday can not after current date");
		    	}
		    	if(checkdate(content , this.Deathday)) {
		    		this.Birthday = content;
		    	}
		    	this.calage();
			break;
			
		    case "DEAT":
		    	if(checkdate(this.Birthday , content)) {
		    		updatedeath(content);
		    	}
		    	this.calage();
			break;
			
		    case "CHIL":
		    	this.children.add(content);
			break;
			
		    case "SPOU":
		    	this.spouse.add(content);
			break;
			
			default:
		}
		
	}
	
	public void calage(){
		if(Birthday == "") {
			age = 0;
			return;
		}
		String[] bdate = this.Birthday.split(" ");
		LocalDate localDate = LocalDate.now();
		String now = localDate.toString();
		String[] nowyear = now.split("-");
		if(this.isdead) {
			String[] ddate = this.Deathday.split(" ");
			this.age = stoi(ddate[2]) - stoi(bdate[bdate.length-1]);
		}
		else {
			this.age = stoi(nowyear[0]) - stoi(bdate[bdate.length-1]);
		}
		if(!Checkage()) {
			System.out.println("Age is larger then 150!");
		}
	}
	
	public boolean Checkage() {
		if(this.age > 150) return false;
		else return true;
	}
	
	public int stoi(String input) {
		int out = 0;
		for(int x = 0 ; x < input.length() ; x++) {
			out = (out*10)+((int)input.charAt(x)-48);
		}
		return out;
	}

	public boolean checkdate(String date1 , String date2) {
		return true;
	}
	
	public static boolean checkdate1(String date) {
		if(checkdate_US01.checkdate_us01(date)) {
			return true;
		}
		else return false;
	}
	
	public void updatedeath(String date) {
		this.isdead = true;
		this.Deathday = date;
	}
	
	public String id;
	public String name;
	public String sex;
	public String Birthday;
	public String Deathday;
	public int age;
	public ArrayList<String> children;
	public ArrayList<String> spouse;
	public boolean isdead;
}
