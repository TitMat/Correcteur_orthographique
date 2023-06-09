import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Testeur {
    private static HashMap<String,ArrayList<String>> Table;

    public Testeur(String filename) throws FileNotFoundException {
        File file= new File(filename);
        Scanner fichier = new Scanner(file);
        HashMap<String, ArrayList<String>> Table = new HashMap<>();
        while (fichier.hasNextLine()) {
            String mot=fichier.nextLine();
            ArrayList<String> Trigrame =this.Trigramisation(mot);
            for(String trigrame:Trigrame){
                if(!Table.containsKey(trigrame)){
                    Table.put(trigrame,new ArrayList<String>());
                }
                ArrayList<String> inter= Table.get(trigrame);
                inter.add(mot);
                Table.replace(trigrame,inter);
            }


        }
        this.Table=Table;


    }


    public ArrayList<String> Trigramisation(String mot){
        String mot_inter = "<"+mot+">";
        ArrayList<String> List =new ArrayList<>();
        for(int a =0; a<=(mot_inter.length()-3); a++){
            char sequence1 = mot_inter.charAt(a);
            char sequence2 = mot_inter.charAt(a+1);
            char sequence3 = mot_inter.charAt(a+2);
            String inter=""+ sequence1+sequence2+sequence3;
            List.add(inter);
        }

        return List;
    }

    public static HashMap<String, ArrayList<String>> getTable() {
        return Table;
    }
}
