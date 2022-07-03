//2020
/*
Write a program based on DFS which can answer questions of the type: "Find the a path from X to Y" 
Which should result in a list of vertices traversed from X to Y if there is a path.
*/
import edu.princeton.cs.algs4.In;                                        //används för att läsa inptut från stdint

public class Ugraph1 {
    
    public static class Graph {                                          //adjecency list graph implentation
        private final int V;                                             //antalet verticer
        private int E;                                                   //antalet edges
        private Bag<Integer>[] adj;                                      //bagarray:  för adjecency list
        
         
        //denna metod/constuctor skapar en tomt grf med antal verticer
        public Graph(int V) {                                            //Vi sparar alla adjecent städer i bag, tills vi använder de.
            this.V = V;
            this.E = 0;
            adj = (Bag<Integer>[]) new Bag[V];                           //en array av vertex för städerna, har skapas en array med antalet veritcer
            for (int v = 0; v < V; v++)                                  //iterera genom de
            {
                
                adj[v] = new Bag<Integer>();                             //skapar empty bag av integer so sparas till adj[v]
            }
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        //lägg till edge mellan v och w två adjecenta verticer      (edgeTO  save known paths to each vertex)
        public void addEdge(int v, int w) {                              //för att skapa en path mellan 2 efter varandra/adjecent vertex i bag array
            adj[v].add(w);                                               //lägger w i v bag array
            adj[w].add(v);                                               //lägger v i w bag array
            E++;                                                         //öka antalet edge då detta sker
        }      
       
        public Iterable<Integer> adj(int v) {  //Iterera igenom alla adjecenta verticer för v, sen returnera adjecenta till den
            return adj[v];
        }
    }
    
 

    public static class DepthFirstSearch {

        private boolean[] marked;                                       //markera besökta verticer
        private int[] edgeTo;                                           //array för path till annan vertice
        private final int s;                                            //source: första staden

        public DepthFirstSearch(Graph G, int s) {                       //tar argumneterna G-graf och s-source            
            //intialiserar arrayerna
            marked = new boolean[G.V()];                                //skapa en boolean array för att se till ocm en vertice är besökt
            edgeTo = new int[G.V()];                                    //skapa en array med elementerna vertex/städer och och fördela den to arrayen edgeTO
            this.s = s;
            dfs(G, s);                                                  //anropa G och source, source är den första location
        }

        
        //DFS: besöka alla omarkerade verticer adjecent till v med recursion
        private void dfs(Graph G, int v) {
            marked[v] = true;                                           //då vi besöker vertexen v, som är source
                                                                        //efter att ha markerat besök alla omarkerade verticer adjecent till den
            for (int w : G.adj(v)) {                                    //spara varje adjecent städer till v på, varje w
                if (!marked[w]) {                                       //då en vertex är inte markerad, 
                    edgeTo[w] = v;                                      //fördela förra vertex till arrayen edgeTo, to keep truck of where it came from.
                    dfs(G, w);                                          //sker rekursivt, genom att skicka nya argumenter.och backtracking
                }
            }
        }

        public boolean hasPathTo(int v) {                               //boolean metod som returnera om v är markerad
            return marked[v];
        }

        public Iterable<Integer> pathTo(int v) {                        //v är destinationen, pathTO den sista argumenten är v
            Stack<Integer> path = new Stack<Integer>();                 //skapa stack           
            for (int x = v; x != s; x = edgeTo[x]) {                    //börja från sista destinations v, och loopa tills 
                path.push(x);                                           //vi pushar i alla x i stacken
             
            }
            path.push(s);                                               //pusha nu source i stacken. i for loppen hade vi inte tagit hänsyn till source.
            return path;
        }
    }
   
    //st:   string, integer  -->  a | 1
    //keys: string[]         -->  1 | a
    
 //definerar grafen med string, instead of index
     public static class SymbolGraph {

        private BST2<String, Integer> st;                               //anropar binary search tree som tar argumenterna string=key, value, integers
        private String[] keys;                                          //inverted index. skapa arrayen keys
        private Graph G;

        
        public SymbolGraph(String filename, String sp) {                //har parametrarna för dbasen och städerna,  //filnamn=key ,
            st = new BST2<>();                                          //skapa ny symboltable alltså av binary search tree
            In in = new In(filename);                                   //använder in för att kunna läsa från databasen
          
           
            while (in.hasNextLine()) {                                  //så länge den har efterkommande linje
                String[] a = in.readLine().split(sp);                   //splittra varje ord med mellanslag och sedan spara de i arrayen
                
                for (int i = 0; i < a.length; i++) {                    //iterera genom arrayen
                    if (!st.contains(a[i])) {                           //om bst inte innehåller den , det inte finns i trädet

                        st.put(a[i], st.size());                        //då det inte finns lägg den i trädet. value är storlekten på trädet
                    }
                }
            }            
            
            //vi spara allt från trädet i arrayen keys, associerar string med index          
            keys = new String[st.size()];                          //skapar en array av längden av storleken p åträdet. sparar vi på keys storleken p trädet
            for (String name : st.keys()) {                        //keys() returnerar ord/städerna.spara varje key från trädet på vraiablen namn
                keys[st.get(name)] = name;                         //få ut indexet från trädet för variablen namn och spara nman på rätt pos inuti arrayen.
            }
            
            
           // bygger grafen genom att rita upp pathen mha edge
            G = new Graph(st.size());                               //skapa en graf medstorleken av trädet /antalet ord i filen
            in = new In(filename);                                  //läs från databas filen och sparas i "in"

            while (in.hasNextLine()) {                              //sålänge vi har nästa linje 
                String[] a = in.readLine().split(sp);

                int v = st.get(a[0]);                               //tilldela första elemnet arrayen till source=v
                for (int i = 1; i < a.length; i++) {

                    G.addEdge(v, st.get(a[i]));                     // anropa metoden edgeTO med source vertex och andra verticer, spara sedan i grafen
                }
            }

        }

        
        public int index(String s) {   //går in på trädet och hämtar index associerat med den staden/key
            return st.get(s);
        }

        public String name(int v) {   //returnera namnet på staden
            return keys[v];
        }
        
        public Graph G() {
            return G;
        }
    }
    

    public static void main(String[] args) {
        String dbFile = "C:\\Users\\User\\Documents\\NetBeansProjects\\Algoritmer och datastruktur\\Labb4\\graph1\\src\\graph1\\database.txt";
        SymbolGraph syG = new SymbolGraph(dbFile, " ");
        Graph G = syG.G();
        int startLocation = syG.index("TN");                                    //begynnesle address
        int finalDestination = syG.index("TX");   
        DepthFirstSearch dfs = new DepthFirstSearch(G, startLocation);

        if (dfs.hasPathTo(finalDestination)) {                                  //om final destination vertexen är markerad
            System.out.print("Väg från " + syG.name(startLocation) + " till " + syG.name(finalDestination) + ":\n");
            
            
            for (int j : dfs.pathTo(finalDestination)) {                        //spara pathen vi hade på stack på variablen j
                if (j == startLocation) {
                    System.out.print("Väg: " + syG.name(j));                    //skriv ut source
                } else {
                    System.out.print("--" + syG.name(j));                       //skriv ut path
                }
            }
            System.out.println();
        } else {
            System.out.println("INGEN VÄG!");
        }
    }
}




/*Väg från AL till SC:
Väg: AL--TN--VA--NC--SC


AL TN
TN VA
NC VA
NC SC




*/


/*
Väg från AL till FL:
Väg: AL--TN--VA--NC--SC--GA--FL


AL--TN
TN--VA
NC--VA
NC--SC
GA--SC
FL--GA

*/


