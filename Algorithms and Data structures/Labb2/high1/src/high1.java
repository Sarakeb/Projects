//Sara 2020
import java.util.Scanner;

public class high1 {
    
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) { //börja på andra elementeni arrayen a[1]
          //  for (int j = i; j > 0 && isLess(a[j], a[j - 1]); j--) {  //den  jämför den med den som
                
                for (int j = i; j > 0; j--){  //börja från i, och dekrementera 
                if(isLess(a[j], a[j - 1])){  //om vi hittar där elementen på en viss index är mindre är elementet på vänstra sidan
                exchange(a, j, j - 1); //excahnge
                display(a); 
                System.out.println();
                }
            }
        }
    }
    
    

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;  //spara det som var på temporary på rätt position
    }
    private static boolean isLess(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;  //om x är mindre än y då returnera 1, annars returnerar den -1  
    }
   
    
    public static void display(Comparable[] a){
    for (int i = 0; i < a.length; i++) {
    System.out.print(a[i] + " ");
      }
    
}
    
    public static void main(String[] args) {
        Integer[] a;
       Scanner scan = new Scanner(System.in); {
       System.out.print("Choose the maximal size of array: ");
       int arraysize = scan.nextInt();
       a = new Integer[arraysize];
         for(int i = 0; i < a.length; i++) {
       System.out.print("Enter number:");
       a[i] = scan.nextInt()*-1;   
       
     
       }
       sort(a);
       for(int i = 0; i < arraysize; i++){
            a[i] *= -1;  //multiplicera med -1
            System.out.print(a[i] + "   ");
        }
       
    }
    }
}
    /*

 input [1, 2, 4, 3, 5, 0]

-2 -1 -4 -3 -5 0 
-2 -4 -1 -3 -5 0 
-4 -2 -1 -3 -5 0 
-4 -2 -3 -1 -5 0 
-4 -3 -2 -1 -5 0 
-4 -3 -2 -5 -1 0 
-4 -3 -5 -2 -1 0 
-4 -5 -3 -2 -1 0 
-5 -4 -3 -2 -1 0 
5   4   3   2   1   0





*/