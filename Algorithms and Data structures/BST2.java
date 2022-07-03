
import edu.princeton.cs.algs4.Queue;


public class BST2<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST
    
    /*innre klass Node, som representerar alla node i trädet, varje node har key, value och referens till
    vänster och höger "child" och integern size som är total antalet nodes i subtree
    */
    
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

 
    public BST2() {
    }

 
    ////////////////////////för iterator
    //kollar om trädet är tomt, isåfall blir root noll, vilket gör size noll 
    public boolean isEmpty() {
        return size() == 0;
    }

   
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    //börja från root, work you way down to get the key
    //kollar om key finns i trädet
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

   
     /*Detta söker efter node recursivt genom dess key, och sedan returnerar dess value. DEt börjar från root, 
     om det är mindre så går den till vänster, om det är större går den åt höger. Om trädet är tomt/null-->exeption.  */
    public Value get(Key key) {// variabel x är vår root
        return get(root, key);  //sålänge vår root x inte är tomt, vill vi jömföra vår x key, rooten och search key
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key); // vi vill jämföra  vår key på node x och key som letas efter  //cmp jämgört med X
        //gå till vänster om det är större, vänste om 
        if      (cmp < 0) return get(x.left, key);  //gå vänster om cmp<x , if the key is smaller than the current node.
        else if (cmp > 0) return get(x.right, key); //om den är större gå till höger
        else              return x.val; //we found the key, if it not bigger smalller we found the key
    }

    /*för put finns det 2 cases, om key finns i trädet, så är det bara reseta value
    om det inte finns vill vi lägga till den*/
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
         
            return;
        }
        root = put(root, key, val);
       // assert check();
    }
    
    //we are always comparing the keys with each other, not the values
//här genomför vi recursion
    private Node put(Node x, Key key, Value val) {
        
        //increment the value with 1, evertime we find a key.
/*om x är null, returnera en referens till ett ny node som associerar key med value, efter vi returnerar den
sätts den till root genom recursion
     */
        
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    public Key min() {
       // if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    
    public Key max() {
      //  if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 

 
   
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }

 
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 

 
     }
