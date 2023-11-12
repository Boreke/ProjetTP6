import javax.net.ssl.SNIHostName;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;



public class Main {

    static int SIZE=Integer.MAX_VALUE / 1000;
    static int[] tab=new int[SIZE];
    public static void main(String[] args) {
        initialiserTableau();
        int[] tableauSelection = new int[SIZE];

        System.arraycopy(tab, 0, tableauSelection, 0, SIZE);

        Instant start = Instant.now();

        triJava(tableauSelection);
        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();
        System.out.println(Arrays.toString(tableauSelection));
        System.out.println("le tri a pris "+duration+"ms\n ");

    }
    public static void initialiserTableau() {
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        Random random = new Random();
        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(SIZE);
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
    }
    private static void triSelection(int[] liste){
        //compléxité:O(n^2)
        //temps avec AMD Ryzen 7 5800X3D 4.20Ghz 8 coeurs et une taille divisée par 10000:50862ms
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

    }
    private static void triInsertion(int[] tableau){
        //compléxité:pire=O(n^2)
        //           meilleur=O(n)
        //temps avec AMD Ryzen 7 5800X3D 4.20Ghz 8 coeurset une taille divisée par 10000: 2755ms
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

    }

    private static void triBulles(int[] tableau){
        //compléxité:O(n^2)
        //temps avec AMD Ryzen 7 5800X3D 4.20Ghz 8 coeurs et une taille divisée par 10000: 51294ms
        int tabLength=tableau.length;
        int buf;
        for (int i = 0; i < tabLength-1; i++) {
            for (int j = 0; j < tabLength-i-1; j++) {
                if (tableau[j]>tableau[j+1]){
                    buf=tableau[j];
                    tableau[j]=tableau[j+1];
                    tableau[j+1]=buf;
                }
            }
        }

    }
    private static void quicksort(int[] tableau, int intGauche, int intDroit){
        //compléxité:pire=O(n^2)
        //           meilleur=O(nlog(n))
        //temps avec AMD Ryzen 7 5800X3D 4.20Ghz 8 coeurs et une taille divisée par 1000: 166ms
        if(intGauche<intDroit){

            int part=partition(tableau,intGauche,intDroit);
            quicksort(tableau, intGauche, part-1);
            quicksort(tableau, part+1, intDroit);
        }

    }

    private static int partition(int[] tableau, int intGauche, int intDroit){
        int p=tableau[intDroit];
        int indP=intGauche-1;
        for (int i = intGauche; i < intDroit; i++) {

            if(tableau[i]<=p){
                indP++;
                swap(tableau,indP,i);
            }
        }
        swap(tableau,indP+1,intDroit);
        return indP+1;
    }
    private static void swap(int[]tab,int a,int b){
        int buf=tab[a];
        tab[a]=tab[b];
        tab[b]=buf;
    }

    private static void triJava(int[] tableau){
        //temps avec AMD Ryzen 7 5800X3D 4.20Ghz 8 coeurs et une taille divisée par 1000: 339ms
        Arrays.sort(tableau);
    }

}