//Sara 
//2020 uppgoíft 2
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class OrderedST2<Key extends Comparable<Key>, Value> {

    private Key[] keys;                                    //skapar array för keys
    private Value[] vals;                                  //skapar array för value
    private int N;                                         //längden/storleken på arrayen

    public OrderedST2(int capacity) {   //constructor
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];   //
    }

    public int size() {                                     //antal key value par
        return N;
    }

    public boolean isEmpty() {                              //boolean method som kollar om arrayen är tomt
        return N == 0;
    }
    
    public int rank(Key key) {                             //på rank sker binary search.  Rank returnerar vilken index den sökta key har. 

        int lo = 0;                                        //vänstra sidan
        int hi = N - 1;                                    //högra sidan
        while (lo <= hi) {                                 //så länge vänster och höger inte är lika, dvs så länge vi inte har single element i array
            int mid = lo + (hi - lo) / 2;                  //bestämmer mid  genom att dela arrayen för två
            int cmp = key.compareTo(keys[mid]);            //cmp är current key som har jömförts med middle
            if (cmp < 0) {                                 //då sökta key är mindre än mid
                hi = mid - 1;                              // vi bestämmer ny hi, och bortser den högra sidan av arrayen. 
            } else if (cmp > 0) {                          //då sökta key är större än mid
                lo = mid + 1;                              //bestämmer ny lo
            } else {
                return mid;                                //HIT!we found it
            }
        }
        return lo;                                         //vi uppdaterar lo genom att returnera för nästa iteration. 
    }


    public Value get(Key key) {
        if (isEmpty()) {
            return null;                                    //om vi inte har några keys, bara returnera 
        }

        int i = rank(key); //ger index nummret för sökta    //anropa på rank, som ger oss antalet keys som är mindre än current key
        if (i < N && keys[i].compareTo(key) == 0) {         // kollar om key på indexet matchar med den sökta

            return vals[i];                                 //den key som vi letar efter fanns i arrayen, vi returnerar vals/antal ggr det förekom
        } else {
            return null;                                    //annars om det inte finns vi returnerar null
        }
    }

    public void put(Key key, Value val) {

        int i = rank(key);   //
        if (i < N && keys[i].compareTo(key) == 0) {         //kollar om key finns
            vals[i] = val;                                  //om det finns redan uppdatera värdet
            return;
        }
        for (int j = N; j > i; j--) {                       //börja från högra sidan av arrayen
            keys[j] = keys[j - 1];                          //vi flyttar på keys i arrayen åt höger
            vals[j] = vals[j - 1];                          //vi flyttar på value i arrayen åt höger
        }
        keys[i] = key;                                      //vi sätter/put sökta key key på plats
        vals[i] = val;                                      //vi sätter/put value på plats
        N++;
    }

    

    public boolean contains(Key key) {                    //boolean method som kollar att nyckeln finns, och returnerar nyckeln
        return get(key) != null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String home = System.getProperty("user.home");
        File file = new File(home + File.separator + "Documents" + File.separator + "NetbeansProjects" + File.separator + "Algo2020" + File.separator
                + "Labb3" + File.separator + "OrderedST2" + File.separator + "src" + File.separator + "text.txt");
        Scanner scan = new Scanner(file);
        Scanner input = new Scanner(System.in);
        System.out.println("Hur många ord ska läsas in? : ");
        int userIn = input.nextInt();

        OrderedST2<String, Integer> st = new OrderedST2<String, Integer>(userIn);  //vi skapar en objekt av klaasen OrderedST2, med parametrarna string och integer
        int iter = 0;                                     //variabeln som ska kolla på antal keys
        String key;
        String frequentWord = "";                         //skapade tom sträng

        st.put(frequentWord, 0);                          //från början put tom key och value 0

        long timeBefore = System.nanoTime();
        while (scan.hasNextLine() && iter < userIn) {    //sålänge vi har ord som ska läsas, och den är mindre än antal ord som matades in
            key = scan.next();                           //vi spara det vi läser in på key

            //då key inte finns
            if (!st.contains(key)) {                     //då key förrekommer första ggn, lägg value till 1 i put metoden
                st.put(key, 1);                          //vi lägger nycklen inte finns, lägg till den och value blir 1, förekommer första ggn
                  
            } else {
                st.put(key, st.get(key) + 1);            //  om den redan finns öka antalet på value 1 ggn 
            }

            
            if (st.get(key) > st.get(frequentWord)) {    //jämförs key med mostfreq om den är större uppdatera mostfreq
                frequentWord = key;
            }

            iter++;
        }
        long timeAfter = System.nanoTime();
        System.out.println("Mest frekventa ordet: '" + frequentWord + "' och förekom  :" + st.get(frequentWord)+ " gånger");
        System.out.println("Tiden det tog totalt är: " + (double) (timeAfter - timeBefore) / 1000000 + ": ms");    
        System.out.println("Antalet ord som lästes: " + iter);
    }
}
//den 



/*
Best Case- O(1) i.e. constant.
Average Case- O(logn).
Worst Case- O(logn).

*/
