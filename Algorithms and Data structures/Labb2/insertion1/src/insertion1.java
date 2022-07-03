
//Sara 2020

/*question: 
Implement insertionsort. Augment the sorting process so that all the content of the array that is being sorted is printed after
each inner loop iteration. Write a unit test in main() which allows the user to define the size of the input (N) and then input 
(N) integers from stdin which is to be sorted.
*/
import java.util.Scanner;

public class insertion1 {
    
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
*/




