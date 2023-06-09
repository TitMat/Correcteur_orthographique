import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.*;
public class PrefixeTree {
    private HashMap<Character, PrefixeTree> fils = new HashMap<>();
    private boolean terminal = false;


    PrefixeTree(String filename) throws FileNotFoundException {
        File file= new File(filename);
        Scanner fichier = new Scanner(file);
        while (fichier.hasNextLine()){
            String mot=fichier.nextLine();
            add(mot);
        }


    }
    PrefixeTree(){

    }

    public void add(String mot){
        if (mot.length()==0){
            this.terminal=true;
        }

        else if(fils.containsKey(mot.charAt(0))) {
            fils.get(mot.charAt(0)).add(mot.substring(1));
        }

                else {
                    fils.put(mot.charAt(0), new PrefixeTree());
                    fils.get(mot.charAt(0)).add(mot.substring(1));
                }
            }




    public boolean contain(String mot){
        if ( mot.length()==0){
            return terminal;
        }
        Character Char = mot.charAt(0);
        if(!fils.containsKey(Char)){
            return terminal;
        }
        return fils.get(Char).contain(mot.substring(1));

        }

//        public HashSet<String> getMotsFromTrigrame(String trigram){
//
//        }
//
//        public HashSet<String> GetAllmots(){
//
//        }





    public static String déconcatenation(String mot){
        if (mot.length()==0){
            return "";
        }
        char dernier = mot.charAt(0);
        String result= new String();
        for(int a =1; a<mot.length(); a++){
            result=result+""+mot.charAt(a);
        }
        return result;

    }


}
