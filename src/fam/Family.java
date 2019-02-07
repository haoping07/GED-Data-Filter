package fam;
import java.util.ArrayList;

public class Family {

	public String familyID;
	public String husband;
	public String wife;
	public ArrayList<String> children;
	public String marrDate;
	public String divoDate;
	public boolean isDivored;

    public Family(String ID){
        familyID = ID;
        husband = "";
        wife = "";
        children = new ArrayList<>();
        marrDate = "";
        divoDate = "";
        isDivored = false;
    }

    public void update(int level, String tag, String content){
        switch(tag.toUpperCase()){
            case "HUSB":
                this.husband = content;
                break;

            case "WIFE":
                this.wife = content;
                break;

            case "CHIL":
                this.children.add(content);
                break;

            case "MARR":
                this.marrDate = content;
                break;

            case "DIV":
                this.divoDate = content;
                this.isDivored = true;
                break;

                default;
        }
    }

    //private boolean checkDate()


    public static void main(String[] args){

    }

}
