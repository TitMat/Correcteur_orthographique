import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SpellChecker {

    private ArrayList<String> words = new ArrayList<String>();
    private Dictionary dictionary=null;
    /**
     * On essaie d'ouvrir le fichier pathToFile contenant les mots à corriger
     * Si erreur, on utilise seulement word
     *
     * @param pathToFile
     * @param word
     */
    public SpellChecker(String pathToFile, String word, Dictionary dictionary) throws FileNotFoundException {
        try{
            this.dictionary=dictionary;
            File file= new File(pathToFile);
            Scanner fichier = new Scanner(file);
            this.dictionary=dictionary;
            while (fichier.hasNextLine()) {
                String mot=fichier.nextLine();
                words.add(mot);
            }
        } catch(FileNotFoundException e){
            words.add(word);
        }
    }

    /**
     * Regarde si word est dans le dictionnaire
     * sinon il affiche une liste de mot les plus proches
     *
     * @param word
     */
    public void spell(String word) throws FileNotFoundException {
        if (dictionary.getTree().contain(word)){
            System.out.println("mot dans le dictionaire mais peut être vouliez vous ecrire : ");
        }
        System.out.println("vouliez vous écrire : ");
        Trigram trigram_class= new Trigram(dictionary);
        HashSet<String> candidats=trigram_class.Mots_candidatsPasopt(word);
        Levenshtein calculatrice= new Levenshtein();
        HashMap<String,Integer> dico= new HashMap<>();
        ArrayList<String> resultat= new ArrayList<>();
        int distances_max= 10000;
        for(String mot : candidats){
            int distance= Levenshtein.distance2(word, mot);
            dico.put(mot, distance);
            if (distance< distances_max){ //boucle à 100 éléments
                if(resultat.size()>=5){
                    int max =0;
                    int avant_dernier=0;
                    String worse_candidate=null;
                    for(String candidat: resultat){ // boucle constante à 5 éléments
                        if((dico.get(candidat)<max)) {
                            continue;
                        }
                        avant_dernier = max;
                        max = dico.get(candidat);
                        worse_candidate = candidat;
                    }
                    distances_max=avant_dernier;
                    resultat.remove(worse_candidate);
                    resultat.add(mot);
                }
                else{
                    resultat.add(mot);
                }
            }

        }
        for(String candidat: resultat){
            System.out.println(candidat);
        }

    }
    //
    public void spell_opt(String word) {

        /**
         * Retourne la liste de tous les mot dont
         * il faut faire la correction
         *
         * @return
         */
    }
    public ArrayList<String> getWords() {
        return words;
    }

}
