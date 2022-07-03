//Sara 2020
/*Experiment with the cut-off to insertionsort in merge. How is the execution time affected by different values for the cut-off? 
A suitable range for cut-off values to test with could be [0-30]. Upload code, tests and a graphs.*/
import java.util.Arrays;
import java.util.Random;  

public class InsertionCutOff6 {   
    
    static int CUTOFF; //Värdet när den övergår från mergeSort till insertion sort
    static final int ARRAYLENGTH=1000;   //längden på arrayen
    static final int CUTOFF_NR = 30;  //antal cutoff-value
    static long executionTimeBefore, executionTimeAfter, executionTime ;    
     
  
  
    public static void sort(int[] a, int NrCutoff){
        CUTOFF = NrCutoff;  //sparar  antalet på cutoff value.
        int[] auxilary = new int[a.length];
        sortMerge(a, auxilary, 0, a.length-1); //anropa på sortMerge
    }

  
 
  public static void sortMerge(int[] a, int[] auxilary, int low, int high){
      /*om arraylängden kommer ner till cutoff value då ska vi övergå till insertionSort istället. Annars fortsätter vi med 
      MergeSort tills den blir lik amed cutoff value*/
      
        if (high <= low + CUTOFF) {  //sålänge det 
      //if (high-low <= CUTOFF){   //high-low --> om antalet elemnter vi har, om den är mindre eller lika med cutoff value. då INSERTION_SORT!
            insertionSort(a, low, high);
        return;   //annars fortsätt med mergeSort
        }        
            int mid = low + (high - low) / 2;  //Dela arreyen till 2 för att bestämma mid, alltså ddet som är i mitten.
            sortMerge(a, auxilary, low, mid); // anropa på mergeSort för att kuna fortsätta dela arrayen till 2.  sortera från left to mid
            sortMerge(a, auxilary, mid + 1, high); //sortera från middle to rigth.
            merge(a, auxilary, low, mid ,high);  //kalla på merge för att kunna merga de tillbaka till orginella array.
        }

    public static void merge(int[] a, int[] auxilary, int low, int mid, int high){
        for(int k = low; k <= high; k++) {
            auxilary[k] = a[k];
        }

        int i = low, j = mid + 1;    //i:högra sidan av array, i är iteratorn för vänstra array
        //j: vänstra sidan av array
        
         //här kopieras allt tillbaka till originalla array
        for(int k = low; k <= high; k++){  //loppa igenom arrayen från vänster till höger
          
            if(i > mid ){   //Efter att i har itererat genom hela vänstra array och sorterat den.
                a[k] = auxilary[j++]; //spara arrayen från vänstra sidan i orignella array
            } 
            
            else if (j > high){   ///Efter att j har itererat genom hela högra array och sorterat den
                a[k] = auxilary[i++]; //spara arrayen från vänstra sidan i orignella array
            }
            else if (auxilary[j] < auxilary[i]) { //vi jämför om aux[j], elementen på högra sidan är mindre än aux[i] för att först sortera minsta element först
                a[k] = auxilary[j++];    //vi stoppar in elemneter från högra sidan, i origniella array först, sedan j++
            } else {
                a[k] = auxilary[i++]; //annars stoppa in i,  elementen från vänstra sidan i arrayen.
            }
        }
    }
  
   
    public static void insertionSort(int[] array, int lo, int h){
        for (int i = lo; i <= h; i++) {
            for (int j = i; j > lo && j > 0 && array[j - 1] > array[j]; j--) {  //då j är större större än 0 och elementet som kommer innan j är större än j EXCHANGE!
                int temporary = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temporary;
            }
        }
    }
    

    public static void main (String args[]) {       
        
        
   
        int a[] = new int[ARRAYLENGTH];
        Random random = new Random();
        for(int i = 0; i < ARRAYLENGTH; i++) {
            a[i] = random.nextInt(5000);
        }

        for(int i = 0; i < CUTOFF_NR + 1; i++) {  //"+1" för att arrayen börjar från 0
            executionTimeBefore = System.nanoTime();
            InsertionCutOff6.sort(a, i);
            executionTimeAfter = System.nanoTime();
            
          executionTime = executionTimeAfter - executionTimeBefore; 
          System.out.println("Cutoff value " + i + ":");
          System.out.println("Time: " + (executionTimeAfter - executionTimeBefore)+ " Nanoseconds"); //delade med 1000 för att få den till ms
          System.out.println("");
        //  System.out.println(executionTimeAfter - executionTimeBefore);
         
          

//   System.out.println(Arrays.toString(a));
        }
    }
   }
    
 //cutoff 0: utan cutoff den långsammaste


/*891201
464600
161799
136300
136200
162401
220700
121400
130100
135701
132800
137000
242300
126099
122800
443500
322800
130900
115400
127400
117401
115401
114800
115900
346099
56499
37700
38100
43501
42701
49301*/


/*586500
210800
163501
88501
134701
103401
147799
147299
164000
129600
134101
136000
134899
109300
125901
101000
153200
134500
108700
110401
108899
106699
111700
160699
107200
105999
110100
108999
112100
112800
54100*/


/*1007700
208300
157599
136500
126400
132600
607101
127700
279500
121400
133300
139799
131699
121600
121700
114700
133199
116399
115000
112400
118900
109499
147700
109600
110201
114500
114900
642200
63301
41200
33200*/


/*1071800
259700
223400
178301
161600
135000
238401
227200
156801
134500
156599
157701
162699
136900
137800
142900
155801
143800
135201
144700
144100
137100
150699
143700
139200
147301
149301
114000
156901
121900
113000*/