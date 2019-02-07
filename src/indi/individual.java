package indi;

public class individual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public individual(String id) {
		this.id = id;
		name = "";
		sex = "";
		Birthday = "";
		Deathday = "";
		children = new String[1];
		spouse = new String[1];
		isdead = false;
	}
	
	public void update(String tag , String content) {
		switch(tag.toUpperCase()) {
		    case "NAME":
		    	this.name = content;
			break;
			
		    case "SEX":
		    	this.sex = content;
			break;
			
		    case "BIRT":
		    	if(checkdate(content , this.Deathday)) {
		    		this.Birthday = content;
		    	}
			break;
			
		    case "DEAT":
		    	if(checkdate(this.Birthday , content)) {
		    		updatedeath(content);
		    	}
			break;
			
		    case "CHIL":
		    	addchild(content);
			break;
			
		    case "SPOU":
		    	addmerrage(content);
			break;
			
			default:
		}
	}
	
	private void addmerrage(String family_id) {
		String[] temp = new String[this.spouse.length+1];
		for(int x = 0 ; x < this.spouse.length ; x++) {
			temp[x] = this.spouse[x];
		}
		
		temp[temp.length-1] = family_id;
		this.spouse = temp;
	}

	protected boolean checkdate(String date1 , String date2) {
		return true;
	}
	
	private void updatedeath(String date) {
		this.isdead = true;
		this.Deathday = date;
	}
	
	private void addchild(String child_id) {
		String[] temp = new String[this.children.length+1];
		for(int x = 0 ; x < this.children.length ; x++) {
			temp[x] = this.children[x];
		}
		
		temp[temp.length-1] = child_id;
		this.children = temp;
	}
	
	public String id;
	public String name;
	public String sex;
	public String Birthday;
	public String Deathday;
	public String[] children;
	public String[] spouse;
	public boolean isdead;
}
