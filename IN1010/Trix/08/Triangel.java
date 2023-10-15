class Triangel{

    public static void main(String[] args) {
        

        triangel(0, 10);
    }

    // skriver ut lengden 1 gang, så kommer tilbake igjen når senere kall i stacken er ferdig og skriver seg selv ut igjen. 
    // takk trix løsningsforslag <3
    static void triangel(int m, int n){

        String str = "";
        for (int i = 0; i < m; i++){
            str += "*";
        }
        
        System.out.println(str);
        
       if (m == n){
        System.out.println(str);
        return;
       }

       if (m < n){
        triangel(m+1, n);
        System.out.println(str);
       }

    }
}