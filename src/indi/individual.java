package indi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
	}
	
	public individual(String id) {
		this.id = id;
		name = "";
		sex = "";
		Birthday = "";
		Deathday = "";
		children = new ArrayList<>();;
		spouse = new ArrayList<>();;
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
	
	private void calage(){
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
		
	}
	private int stoi(String input) {
		int out = 0;
		for(int x = 0 ; x < input.length() ; x++) {
			out = (out*10)+((int)input.charAt(x)-48);
		}
		return out;
	}

	protected boolean checkdate(String date1 , String date2) {
		return true;
	}
	
	private void updatedeath(String date) {
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
