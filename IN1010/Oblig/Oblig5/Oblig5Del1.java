import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Oblig5Del1{

    private static SubsekvensRegister sR;

    public static void main(String[] dataMappe){



        sR = new SubsekvensRegister();
        ArrayList<String> alleLitenArr = lesMetafil("TestDataLitenLike/metadata.csv"); // TODO***************** La bruker velge mappe for data.
        ArrayList<String> alleStoreArr = lesMetafil("TestDataLike/metadata.csv");

        HashMap<String, Subsekvens> AlleLitenHash = lesFlereFilerOgSlaaSammen(alleLitenArr, "TestDataLitenLike/");
        HashMap<String, Subsekvens> AlleStoreHash = lesFlereFilerOgSlaaSammen(alleStoreArr, "TestDataLike/");

        System.out.println("Ferdig lest.");

        System.out.println(hentStorsteSubsekvens(AlleLitenHash));
        System.out.println(hentStorsteSubsekvens(AlleStoreHash));
    }
    

    // les metafil og returner som itererbar ArrayList.
    public static ArrayList<String> lesMetafil(String filepath){

        File fil = null;
        Scanner sc = null;
        ArrayList<String> filListe = new ArrayList<String>();

        try {
            fil = new File(filepath);
            sc = new Scanner(fil);
        }
        catch(FileNotFoundException e){
            System.out.println("Fant ikke filen: " + filepath);
        }

        while (sc.hasNextLine()){
            String linje = sc.nextLine();
            filListe.add(linje);
        }
        return filListe;
    }

    public static HashMap<String, Subsekvens> lesFlereFilerOgSlaaSammen(ArrayList<String> filListe, String dataMappe){

        HashMap<String, Subsekvens> bigDict = new HashMap<String, Subsekvens>();
        HashMap<String, Subsekvens> smallDict = new HashMap<String, Subsekvens>();

    

        for (String filnavn : filListe){
            System.out.print(filnavn + ": ");
            smallDict = sR.lesFraFil(dataMappe + filnavn);
            bigDict = sR.slaaSammen(smallDict, bigDict);
        }
        System.out.println("Slo sammen " + filListe.size() + " filer til en HashMap med " + bigDict.size() + " unike entries.");
        System.out.println();
        return bigDict;
    }

    public static Subsekvens hentStorsteSubsekvens(HashMap<String, Subsekvens> dict){

        Subsekvens storste = null;
        int flestForekomster = 0;

        

        for (String nokkel : dict.keySet()){
            
            Subsekvens ss = dict.get(nokkel);

            if (ss.hentAntallForekomster() > flestForekomster){
                flestForekomster = ss.hentAntallForekomster();
                storste = ss;
            }

            //System.out.println(ss);
        }
        System.out.println();
        return storste;
    }
}