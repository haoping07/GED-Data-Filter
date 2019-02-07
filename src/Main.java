import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Testing("MyFamily.ged");
        Testing("proj02test.ged");
        System.out.print("Shih-Hao");
    }

    public static void Testing(String pathname)throws IOException{
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = " ";
        File writename = new File(pathname+"-out.ged");
        writename.createNewFile();
        BufferedWriter outs = new BufferedWriter(new FileWriter(writename));
        while (line != null) {
            line = br.readLine();
            if(line==null) break;
            String in="--> "+line;
            outs.write(in+"\r\n");

            String[] temp=line.split(" ");
            String valid,Tag;
            if(isValidTag(temp)) valid="Y";
            else valid="N";
            StringBuffer out=new StringBuffer();
            if(temp[temp.length-1].equals("INDI")||temp[temp.length-1].equals("FAM"))
                Tag=temp[temp.length-1];
            else Tag=temp[1];
            out.append("<-- "+temp[0]+"|"+Tag+"|"+valid+"|");
            for(String s:temp){
                if(!s.equals(Tag)&&!s.equals(temp[0]))
                    out.append(s+" ");
            }
            outs.write(out+"\r\n");
        }
        outs.flush();
        outs.close();
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
