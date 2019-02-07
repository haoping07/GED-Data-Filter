public class Family {

    public:
    String familyID;
    String INDI_husband;
    String INDI_wife;
    ArrayList<String> INDI_child;
    String marrDate;
    String divoDate;

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
