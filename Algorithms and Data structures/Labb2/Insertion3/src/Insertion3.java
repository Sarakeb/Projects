//Sara 2020
/*Add a method which counts the number of inversions in the input array and prints a list of all inversions on the 
format [i,a[i]], [j, a[j]] where i and j are indices and a[i], a[j] are the values of the elements. Call the method 
from main() before the array is sorted. Calculate the time complexity for the algorithm.
*/

import java.util.Scanner;
public class Insertion3 {

    public static int count = 0; // antal exch
    
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && isLess(a[j], a[j - 1]); j--) {  // så länge j är större än 0 och a[j] är mindre än elemnten på indexen innan. EXCHANGE!
                exchange(a, j, j - 1);
                display(a);                
                System.out.println();
            }
        }
    }
    
 
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temporary = a[i];  //spara elemntet vi vill ändra plats på temporary. 
        a[i] = a[j];
        a[j] = temporary; //spara det som var på temporary på rätt position
        
        
        count++;
    }
    private static boolean isLess(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;    //om x är mindre än y då returnera 1 true, annars returnerar den -1  
    }
    
    public static void display(Comparable[] a){
    for (int i = 0; i < a.length; i++) {
    System.out.print(a[i] + " ");
    }    
}
    
        
    //inversion sker a[i]>a[j] men i<j --> dvs en element är större än en annan element, men elementen som var större har mindre index. 
    //dvs Om ett element som är mindre än andra elemnter men ligger på större index.
    
    
    /*Loopen itererar genom arrayen och för varje element kontrollerar den om några element till höger av den är av 
     lägre värde. Skriver ut varje inversion som behövs för att sortera arrayen.
    */
      public static void getInversion(Comparable[] a) {
         int inversionNr = 0; //räknar antalet inversion.        
       
         for(int i = 0; i < a.length-1; i++) {
               //om det finns någon  element till höger i som är lägre värde. Skriver ut varje inversion
             for(int j = i+1; j < a.length; j++) { //börja ett tal efter i
                 if(isLess(a[j], a[i])) { //om talet som kommer efter a[i] är mindre än a[i]
                     System.out.println("[" + i + "," + a[i] + "] and [" + j + "," + a[j] + "]");  //[index], element 
                     inversionNr++;
                     
                     
				}
			}
		}
         System.out.println();
         System.out.println(inversionNr + " is the ammount of inversions: ");
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
       
       
      
	getInversion(a);	
	sort(a);
       
         System.out.println();
		System.out.println("Number of swaps: " + count);
		System.out.println();
                
                 
    }
       
    }
}


/*
/*
 input [1, 2, 4, 3, 5, 0] 
mellan 

1 o 0   1 är större än 0 men 1s index är mindre än 0
2 o 0
4 o 3
4 o 0
3 o 0
5 o 0

*/

/*


[0,1] and [5,0]
[1,2] and [5,0]
[2,4] and [3,3]
[2,4] and [5,0]
[3,3] and [5,0]
[4,5] and [5,0]
















inversion count är hur nära en array är till att vara sorterad.
om array är sorterad är inversion count =0
inversion sker då  i detta fall a[i]>a[j] men i<j , alltså en index som kommer efter en viss index är större än själva indexet.
inversion sker då a[i]>a[j] men i<j, alltså en element ligger på större index men elemnten inuti indexen är mindre än elemnten som kommer efter.
gå igenom arrayen från början till slut, och in andra loopn, för varje element hitta antalet element som är mindre än det aktuella antalet upp till indexet med en annan slinga.
*/

