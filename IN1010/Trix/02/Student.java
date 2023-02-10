class Student {

    private String navn;
    private int score;
    private int antall_quizer;


    public Student(String navn, int score, int antall_quizer){

        this.navn = navn;
        this.score = score;
        this.antall_quizer = antall_quizer;
    }

    public Student(String navn){

        this.navn = navn;
        this.score = 0;
        this.antall_quizer = 0;
    }

    public String hentNavn(){

        return navn;
    }

    public void leggTilQuizScore(int nye_poeng) {

        score += nye_poeng;
        antall_quizer++;
    }
    public int hentTotalScore(){

        return score;
    }

    public int hentGjennomsnittligScore(){

        return (score/antall_quizer);
    }

    


    public static void main(String[] args){

        Student student_1 = new Student("Joakim");
        Student student_2 = new Student("Marius");
        Student student_3 = new Student("Markus");

        student_1.leggTilQuizScore(0);
        student_1.leggTilQuizScore(2);

        student_2.leggTilQuizScore(0);
        student_2.leggTilQuizScore(0);
        
        student_3.leggTilQuizScore(10);
        student_3.leggTilQuizScore(10);

        System.out.println();
        System.out.println(student_1.hentNavn() + " har scoren " + student_1.hentTotalScore() + ", som betyr at de har en gjennomsnitts score paa: " + student_1.hentGjennomsnittligScore() + ".");
        System.out.println(student_2.hentNavn() + " har scoren " + student_2.hentTotalScore() + ", som betyr at de har en gjennomsnitts score paa: " + student_2.hentGjennomsnittligScore() + ".");
        System.out.println(student_3.hentNavn() + " har scoren " + student_3.hentTotalScore() + ", som betyr at de har en gjennomsnitts score paa: " + student_3.hentGjennomsnittligScore() + ".");
        System.out.println();
    }
}