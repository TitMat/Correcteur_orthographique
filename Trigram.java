import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Trigram {
    Dictionary Table;
    //Solution pas opti
    public Trigram(Dictionary Table) throws FileNotFoundException {
        this.Table=Table;

    }

    public Trigram(){

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

    public HashSet<String> Mots_candidatsPasopt(String mot){
        HashSet<String> trigrames_mot= Trigramisation(mot);
        HashSet<String> resultat= new HashSet<>();
        for(String trigrame : trigrames_mot){
            if(resultat.size()>=100){
                break;
            }
            HashSet<String> inter = Table.getTable().get(trigrame);
            if(!(inter==null)){
            resultat.addAll(inter);
            }

        }
        return resultat;
    }

}
