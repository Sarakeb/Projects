//Sara 2020
/*Augment the above implementation so that it prints the number of swaps performed when sorting the array.*/
import java.util.Scanner;
public class Insertion2 {
    
    public static int c = 0; // räknar antal antal exch
    
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && isLess(a[j], a[j - 1]); j--) { // så länge j är större än 0 och a[j] är mindre än elemnten på indexen innan. EXCHANGE!
                exchange(a, j, j - 1);
                display(a);
                System.out.println();
            }
        }
    }
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;    //spara det som var på temporary på rätt position     
        
        c++;  //då exchange har skett öka på antalet 
    }
    private static boolean isLess(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;   //om x är mindre än y då returnera 1, annars returnerar den -1  
    }
    
    //Skriver ut hela arrayen
    public static void display(Comparable[] a){
    for (int i = 0; i < a.length; i++) {
    System.out.print(a[i] + " ");
      }   
}
    
    public static void main(String[] args) {
        // TODO code application logic here
        Integer[] a;
       // try ( // TODO code application logic here 
       Scanner scan = new Scanner(System.in); {
       System.out.print("Choose the maximal size of array: ");
       int arraysize = scan.nextInt();
       a = new Integer[arraysize];
       for(int i = 0; i < a.length; i++) {
       System.out.print("Enter number:");
       a[i] = scan.nextInt();
       }    
       
      
		
	sort(a);
         System.out.println();
		System.out.println("Number of swaps: " + c);
		System.out.println();
    }
    }
}

/*
 input [1, 2, 4, 3, 5, 0] 
1 2 3 4 5 0 
1 2 3 4 0 5 
1 2 3 0 4 5 
1 2 0 3 4 5 
1 0 2 3 4 5 
0 1 2 3 4 5 

Number of swaps: 6

*/