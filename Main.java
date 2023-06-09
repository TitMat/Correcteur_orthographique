import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Testeur test= new Testeur("dico.txt");
        //System.out.println(Testeur.getTable());
        long time = System.nanoTime();
        PrefixeTree Tree=new PrefixeTree("dico.txt");
        Dictionary dico= new Dictionary("dico.txt",Tree);
        File faute = new File("fautes.txt");
        SpellChecker Speller=new SpellChecker("fautes.txt","mots",dico);
        Scanner scan=new Scanner(faute);
        System.out.println("temps 1 " +(System.nanoTime()-time));
        time=System.nanoTime();
        while (scan.hasNextLine()){
            String mot =scan.nextLine();
            System.out.println(mot);
            Speller.spell(mot);
        }

        System.out.println((System.nanoTime()-time));

//        Options.parseCommandLine(args);
//
//        Timer timer_dico = new Timer("Dictionnaire");
//        Dictionary.java dico = new Dictionary.java(Options.pathToFile);
//        timer_dico.print_time_past();
//
//        Timer timer_speller = new Timer("Spelchecker");
//
//        SpellChecker spellchecker = new SpellChecker(Options.pathToFile, Options.word, dico);
//        for (String word : spellchecker.getWords()) {
//            spellchecker.spell(word);
//        }
//        timer_speller.print_time_past();
//    }
//
//    private static class Timer {
//        long startTime = 0;
//        String name = "";
//
//        public Timer(String name) {
//            startTime = System.currentTimeMillis();
//            this.name = name;
//        }
//
//        public long time_past() {
//            return System.currentTimeMillis() - startTime;
//        }
//
//        public void print_time_past() {
//            String message = String.format("Timer %s : %f sec. past", name, ((double) time_past()) / 1000);
//            System.out.println(message);
//        }

    }
}
