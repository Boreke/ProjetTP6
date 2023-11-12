import javax.net.ssl.SNIHostName;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;



public class Main {

    static int SIZE=Integer.MAX_VALUE / 10000;
    static int[] tableau=new int[SIZE];
    public static void main(String[] args) {
        /*initialiserTableau();
        int[] tableauSelection = new int[SIZE];

        System.arraycopy(tableau, 0, tableauSelection, 0, SIZE);

        Instant start = Instant.now();

        tableauSelection=triInsertion(tableauSelection);
        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();
        System.out.println(Arrays.toString(tableauSelection));
        System.out.println("le tri a pris "+duration+"ms\n ");*/
        System.out.println(recur(5));
    }
    public static void initialiserTableau() {
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        Random random = new Random();
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt(SIZE);
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
    }
    private static int[] triSelection(int[] liste){
        int temp;
        for (int i = 0; i < liste.length ; i++) {
            for (int j = i+1; j < liste.length; j++) {
                if(liste[i]>liste[j]){
                    temp=liste[j];
                    liste[j]=liste[i];
                    liste[i]=temp;
                }
            }
        }
        return liste;
    }
    private static int[] triInsertion(int[] liste){
        for (int i = 1; i < tableau.length; i++)
        {
            int elementATrier = tableau[i];
            int j = i;
            while (j > 0 && tableau[j - 1] > elementATrier)
            {
                tableau[j] = tableau[j - 1];
                j--;
            }
            tableau[j] = elementATrier;
        }
        return tableau;
    }

    private static double recur(int n){

        if (n==1){
            return 1;
        }else{
            return 1.0 / n + recur(n - 1);
        }

    }

}