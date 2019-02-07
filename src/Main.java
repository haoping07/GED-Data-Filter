import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import indi.individual;
import fam.Family;

public class Main {
	
	public static ArrayList<individual> allPeople = new ArrayList<individual>();
	public static ArrayList<Family> allFamilies = new ArrayList<Family>();
	
    public static void main(String[] args) throws IOException {
        Testing("MyFamily.ged");
        //Testing("proj02test.ged");
        //LS: test script of individual
        /*for(int i = 0; i < allPeople.size(); i++) {   
            System.out.print(allPeople.get(i).age +" | ");
            System.out.print(allPeople.get(i).Birthday+" | "); //missing
            System.out.print(allPeople.get(i).Deathday+" | "); //missing
            System.out.print(allPeople.get(i).id+" | ");
            System.out.print(allPeople.get(i).isdead+" | ");
            System.out.print(allPeople.get(i).name+" | ");
            System.out.print(allPeople.get(i).sex);
            System.out.println(" ");
        }  */
        
        //LS: test script of family
        for(int i = 0; i < allFamilies.size(); i++) {
        	System.out.print(allFamilies.get(i).divoDate +" | "); //missing
        	System.out.print(allFamilies.get(i).familyID +" | ");
        	System.out.print(allFamilies.get(i).husband +" | "); //missing
        	System.out.print(allFamilies.get(i).isDivored +" | ");
        	System.out.print(allFamilies.get(i).marrDate +" | ");
        	System.out.print(allFamilies.get(i).wife +" | "); //missing
        	System.out.print(allFamilies.get(i).children +" | "); //missing
        	System.out.println(" "); 
        }
    }
    
    public static void Testing(String pathname)throws IOException{
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = " ";
        //add something to save tags
        individual person = null;
        Family family = null;
        String[] tags=new String[3];
        while (line != null) {
            line = br.readLine();
            if(line==null) break;

            String[] temp=line.split(" ");
            String valid,Tag;
            if(isValidTag(temp)) valid="Y";
            else valid="N";
            StringBuffer out=new StringBuffer();
            if(temp[temp.length-1].equals("INDI")||temp[temp.length-1].equals("FAM"))
                Tag=temp[temp.length-1];
            else Tag=temp[1];

            // LS: add to object
            tags[Integer.parseInt(temp[0])]=Tag;//add tag
            switch (temp[0]){
                case "0":
                    tags[0]=Tag;
                case "1":
                    tags[1]=Tag;
                case "2":
                    tags[2]=Tag;
                    default:
            }
            StringBuffer content=new StringBuffer();
            for(String s:temp){
                if(!s.equals(Tag)&&!s.equals(temp[0]))
                    content.append(s+" ");
            }
            switch (temp[0]){
                case "0":
                    if(Tag.equals("INDI")){
                        if(person!=null) allPeople.add(person);
                        person=new individual(content.toString());
                    }

                    else if(Tag.equals("FAM"))
                        if(family!=null) allFamilies.add(family);
                        family=new Family(content.toString());
                    break;
                case "1":
                    if(tags[0].equals("INDI")) {
                        if(!Tag.equals("BIRT")&&!Tag.equals("DEAT"))
                            person.update(Tag,content.toString());
                    }

                    else if(tags[0].equals("FAM")){
                        if(!Tag.equals("MARR")&&!Tag.equals("DIV"))
                            person.update(Tag,content.toString());
                    }
                    break;
                case "2":
                    if(tags[0].equals("INDI")){
                        if (tags[1].equals("BIRT") || tags[1].equals("DEAT")) {
                            family.update(tags[1],content.toString());
                        }
                    }

                    else if(tags[0].equals("FAM")){
                        if (tags[1].equals("MARR") || tags[1].equals("DIV")) {
                            family.update(tags[1],content.toString());
                        }
                    }

                    break;
                    default:
                        break;
            }
        }
        allPeople.add(person);
        allFamilies.add(family);
    }

    public static boolean isValidTag(String[] words){
        return  isValidNormal(words[0],words[1])||isValidSpecial(words[0],words[words.length-1]);
    }

    public static boolean isValidNormal(String Level,String Tag){
        String[] legalTags;
        switch (Level){
            case "0":
                String[] temp0={"HEAD","TRLR","NOTE"};
                legalTags=temp0;
                break;
            case "1":
                String[] temp1={"NAME","SEX","BIRT","DEAT","FAMC","FAMS","MARR","HUSB","WIFE","CHIL","DIV"};
                legalTags=temp1;
                break;
            case "2":
                String[] temp2={"DATE"};
                legalTags=temp2;
                break;
                default: return false;
        }
        for(String s: legalTags){
            if(s.equals(Tag)) return true;
        }
        return false;
    }

    public static boolean isValidSpecial(String Level,String Tag){
        if(!Level.equals("0")) return false;
        if(Tag.equals("INDI")||Tag.equals("FAM")) return true;
        return false;
    }
}
