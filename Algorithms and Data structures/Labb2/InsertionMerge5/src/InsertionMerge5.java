//Sara 2020
/*
Compare the execution times for sorting large arrays of integers with insertionsort and merge sort. 
When should one select mergesort over insertionsort? 
*/
import java.util.Arrays;
import java.util.Random;

public class InsertionMerge5 {
  
   
     public static void insertionSort(int[] ar){
            for(int i = 1; i < ar.length; i++){
                for(int j = i; j > 0 && ar[j-1] > ar[j]; j--){  //då j är större större än 0 och elementet som kommer innan j är större än j EXCHANGE!
                    int temporary = ar[j];
                    ar[j] = ar[j-1];
                    ar[j-1] = temporary;
                }
            }
        }
          //////nu presenteras Merge sort
        
    private static int [] auxiliary;    //skapade auxilary array.
    public static void sortM(int [] a) {
        auxiliary= new int[a.length];  //aux array som är lika långt som a[]
        mergeSort(a, 0, a.length-1);    //anropa metoden mergesort
        }
        
    
    //denna method delar upp arrayen, flera ggr mha recursive calls to mergesort till vi har en enda element i arrayen (vi har separerat
// hela arrayen). sedan mergas alla elementer tillbaka till arrayen.
    
    public static void mergeSort(int [] a, int lo, int hi) {  //metoden tar emot första indexet och  sista indexet av arrayen
            if (hi <= lo){  //om vi bara har ett element i array, för om hi=lo innebär det att det finns bara ett element. return.
                return;
            }
            int mid = lo + (hi - lo)/2;  //Dela arreyen till 2 för att bestämma mid, alltså ddet som är i mitten.
            mergeSort(a, lo, mid);   // anropa på mergeSort för att kuna fortsätta dela vänstra arrayen till 2.  sortera från left to mid
            mergeSort(a, mid+1, hi);   //sortera från middle to rigth.
            merge(a, lo, mid, hi);    //kalla på merge för att kunna merga de tillbaka till orginella array.
}
   
    
    public static void merge(int [] a, int lo, int mid, int hi){  //denna metod mergar/lägger upp  arrayen den sorterande arrayen
            int i = lo;  //vänstra sidan av array, i är iteratorn för vänstra array
            int j = mid+1;  //högre sidan av array
            //k är iteratorn för originella array.
            for (int k = lo; k <= hi; k++) {  //loopa från första elemntet i left till sista.
                auxiliary[k] = a[k];   //spara elememt till aux array.
            }
            
            
            //här kopieras allt tillbaka till originalla array
            for (int k = lo; k <= hi; k++){               //loppa igenom arrayen från vänster till höger
            
                //om "i" ligger i bestämda vänsta sidan, den kollar om det ligger i vänster array
                if (i > mid){                             //Efter att i har itererat genom hela vänstra array och sorterat den.
                   a[k] = auxiliary[j++];                 //spara arrayen från högra sidan i orignella array
           
                   // a[k]= auxiliary [j];   //samma som ovan
                    //j++;
                }
                //om j ligger  bestämda högra sidan,                
                else if (j > hi ){                          //Efter att j har itererat genom hela högra array och sorterat den. 
                    a[k] = auxiliary[i++];                  //spara arrayen från vänstra sidan i orignella array
                }
                else if (auxiliary[i] < auxiliary[j]){      //vi jämför om aux[i], elementen på vänstra sidan är mindre än aux[j] för att först sortera minsta element först
                a[k] = auxiliary[i++];              //vi stoppar in elemneter från vänstra sidan, i origniella array först, sedan i++
                }
                else {   //om aux[i]!<aux[j], så stoppar in j,  elementen från högra sidan i arrayen.
                    a[k] = auxiliary[j++];
            }
}
}
   
      
    public static void main(String[] args) {
       Random randomNr= new Random();
       Integer lengthArray= 4000;
       int[] mergeLength = new int [lengthArray];
       int[] insertLength = new int [lengthArray]; 
       
            
       for(int i=0; i<mergeLength.length; i++){
           int ammountNr= randomNr.nextInt(10000); 
           mergeLength[i]=ammountNr;
           insertLength[i]=ammountNr;
       }
       //räkna tiden för insertion
       long executionTimeBefore= System.nanoTime();
       insertionSort(insertLength);
       
    //  System.out.print(Arrays.toString(insertLength));
       long executionTimeAfter= System.nanoTime();  //system timer, i nanoseconds
       System.out.println();       
       System.out.println("Sorting with Insertion sort takes:"+ (executionTimeAfter-executionTimeBefore)+ " nanoseconds to execute");         

     System.out.println();
       //räkna tiden för merge
       executionTimeBefore= System.nanoTime();
       sortM(mergeLength); 
   //  System.out.print(Arrays.toString(mergeLength));       
       executionTimeAfter= System.nanoTime();
       System.out.println();
        System.out.println("Sorting with mergeSort takes:"+ (executionTimeAfter-executionTimeBefore)+ " nanoseconds to execute");  
            
   }
}
  

