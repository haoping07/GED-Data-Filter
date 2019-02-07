import java.util.ArrayList;

public class Family {

	public String familyID;
	public String INDI_husband;
	public String INDI_wife;
	public ArrayList<String> INDI_child;
	public String marrDate;
	public String divoDate;

    public Family(String ID){
        familyID = ID;
        INDI_husband = "";
        INDI_wife = "";
        INDI_child = new ArrayList<>();
        marrDate = "";
        divoDate = "";
    }

    public static void main(String[] args){

    }

}
