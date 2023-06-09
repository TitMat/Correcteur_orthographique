import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.io.*;
public class Dictionary {

    private HashMap<String,HashSet<String>> Table; // utilisé uniquement dans le cas pas opti
    private PrefixeTree Tree;

    public Dictionary(String filename, PrefixeTree Tree) throws FileNotFoundException {
        File file= new File(filename);
        Scanner fichier = new Scanner(file);
        HashMap<String, HashSet<String>> Table = new HashMap<>();
        while (fichier.hasNextLine()) {
            String mot=fichier.nextLine();
            HashSet<String> Trigrame =this.Trigramisation(mot);
            for(String trigrame:Trigrame){
                if(!Table.containsKey(trigrame)){
                    Table.put(trigrame,new HashSet<String>());
                }
                HashSet<String> inter= Table.get(trigrame);
                inter.add(mot);
                Table.replace(trigrame,inter);
            }
        }
        this.Table=Table;
        this.Tree=Tree;
    }

    public Dictionary(PrefixeTree Tree) throws FileNotFoundException {
        this.Tree=Tree;
    }

    public PrefixeTree getTree(){
        return Tree;
    }


    //retourne la liste des trigrammes d'un mot
    public HashSet<String> Trigramisation(String mot){
        String mot_inter = "<"+mot+">";
        HashSet<String> List =new HashSet<>();
        for(int a =0; a<mot_inter.length()-2; a++){
            char sequence1 = mot_inter.charAt(a);
            char sequence2 = mot_inter.charAt(a+1);
            char sequence3 = mot_inter.charAt(a+2);
            String inter=""+ sequence1+sequence2+sequence3;
            List.add(inter);
        }

        return List;
    }

    public HashMap<String,HashSet<String>> getTable(){
        return Table;
    }
}