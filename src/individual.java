
public class individual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		individual i = new individual("asas");
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
