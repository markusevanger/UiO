import java.util.HashMap;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




class SubsekvensRegister{

    // HashMap<String, Subsekvens> SubsekvensRegister;
    private ArrayList<HashMap<String, Subsekvens>> subsekvensRegister; // **** Kan være static?


    public SubsekvensRegister(){
        subsekvensRegister = new ArrayList<HashMap<String, Subsekvens>>();
    }

    public ArrayList<HashMap<String, Subsekvens>> hentRegister(){
        return subsekvensRegister;
    }

    public void leggTil(HashMap<String, Subsekvens> dict){
        subsekvensRegister.add(dict); // referanse til dict i overordnet ArrayList: subsekvensRegister.
    }

    public HashMap<String, Subsekvens> hentSubsekvens(String riktigSubsekvens){

        // itererer gjennom alle hashmaps til riktig subsekvens er "funnet". Returnerer hele hashmappet.
        for (HashMap<String, Subsekvens> dict : subsekvensRegister){
            for (String nokkel : dict.keySet()){
                if (nokkel == riktigSubsekvens){ // matcher gitt nokkel med hashmaps nokkel.
                    return dict;
                }
            }
        }
        return null; // om aldri blir funnet.
    }

    public int hentStoerelse(){
        return subsekvensRegister.size();
    }



    // Oppgave 3: LesFraFil()
    // går linje for linje og oppretter Subsekvens objekter bestående av tre bokstaver hver.
    //          -> I linje iterer for hver bokstav og henter ettefulgende bokstaver +1 og +2.
    //             "ABCDEFG" = "ABC", "BCD", "CDE" ... osv
    
    // legger til i hashmap som returneres av metoden.

    public static HashMap<String, Subsekvens> lesFraFil(String filnavn){

        File fil;
        Scanner sc = null;

        try{
            fil = new File(filnavn);
            sc = new Scanner(fil);
        }
        catch(FileNotFoundException e){
            System.out.println("Fant ikke filen!");
            System.out.println(e);
            e.printStackTrace();
        }

        HashMap<String, Subsekvens> dict = new HashMap<String, Subsekvens>(); // opprett ny hashmap.
        
        while (sc.hasNextLine()){
            String linje = sc.nextLine();
            
            if (!linje.equals("amino_acid")){
                for (int i = 0; i < linje.length()-2; i++){
                    String substring = linje.substring(i, i+3); // tusen takk marius for hjelp <3
                    Subsekvens ss = new Subsekvens(substring, 1);
                        dict.put(substring, ss);
                }
            }
        }
        sc.close();
        return dict;       
    }


    // oppgave 4 Slaa sammen hash. Fletter sammen dict2 inn i dict1. 
    public static HashMap<String, Subsekvens> slaaSammen(HashMap<String, Subsekvens> dict1, HashMap<String, Subsekvens> dict2){

        for (String key2 : dict2.keySet()){
            if (dict1.containsKey(key2)){
                dict1.get(key2).oekAntallForekomster(dict2.get(key2).hentAntallForekomster());
            }
            else{
                dict1.put(key2, dict2.get(key2));
            }
        }
        return dict1;

    }
}