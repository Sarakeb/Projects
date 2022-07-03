//Sara 
//2020 teori uppgoíft 2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class teori2<Key extends Comparable<Key>, Value> { //key och value är generic type

    private Node root = null;                           //en länk till rooten för trädet

    /*innre klass Node, som representerar alla node i trädet, varje node har key, value och referens till
    vänster och höger "child" och integern size som är total antalet nodes i subtree
     */
    private class Node {                                //skapade instance variables inuti clssen node        

        private Key key;                                // sorted by key
        private Value val;                              // associated data
        private Node left;
        private Node right;                             // left and right subtrees
        private int size;                               //counter for number of nodes in subtree

        public Node(Key key, Value val, int size) {     //skapar constructor som tar key och value som argument
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public boolean contains(Key key) {                  //boolean method som kollar om key finns i trädet
        return gets(key) != null;                       //returnerade då key inte ärnull,
    }

    //vi börjar från root
    public Value gets(Key key) {                        //anropar metoden get
        return get(root, key);
    }

    /*Detta söker efter node recursivt genom dess key, och sedan returnerar dess value. Det börjar från root, 
     om det är mindre så går den till vänster, om det är större går den åt höger. Om trädet är tomt/null-->exeption.  */
    //recursion sker för att 
    private Value get(Node x, Key key) {                 // variabel x är vår root
        if (x == null) {
            return null;                                 //sålänge vår root x inte är tomt, vill vi jömföra vår x key, rooten och search key
        }

        int cmp = key.compareTo(x.key);                  // jämför den sökta key med rooten/x 

        if (cmp < 0) {                                   //om key är mindre än rooten. gå till vänster om det är större, vänste om 
            return get(x.left, key);                     //gå till vänster , returnra recursivt
        } else if (cmp > 0) {
            return get(x.right, key);                    //om key är större än rooten gå till höger
        } else {
            return x.val;                                //HIT! we found the key, 
        }
    }

    /*för put finns det 2 cases, om key finns i trädet, så är det bara reseta value
    om det inte finns vill vi lägga till den*/
    public void puts(Key key, Value val) {
        root = put(root, key, val);                      //invoke en recurive method som börjar från root

    }


    /*om x är null, returnera en referens till ett ny node som associerar key med value, efter vi returnerar den
sätts den till root genom recursion*/
    private Node put(Node x, Key key, Value val) {
        if (x == null) {                                 //om rooten är null
            return new Node(key, val, 1);                //skapa new node och returnera den
        }

        int cmp = key.compareTo(x.key);                  //jämför den sökta key  med rooten/ Node x

        if (cmp < 0) {                                   //om sökta key är mindre än vår current key/rooten gå till vänster, 
            x.left = put(x.left, key, val);              //recursivt till den hamnar på rätt plats
        } else if (cmp > 0) {                              //om sökta key är större än vår current key/rooten gå till höger, 
            x.right = put(x.right, key, val);            //om key är stööre än current node gå till höger
        } else {
            x.val = val;                                 //HIT! det vi ville inserta fanns redan där, så in reset
        }

        return x;
    }

   /* public boolean isEmpty() {                           //kollar om trädet är tomt, isåfall blir root noll, vilket gör size noll
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }*/

    /*
    börja från root och traversa trädet genom recursion, till sista child left, om den inte hade andra child
    skriv ut den, och sedan kolla om den har något på höger.*/
    void inorderTraverse() {   //börja från root
        in_order(root);
    }

    //inorder:left root right
    //left root right
    void in_order(Node root) {
        if (root != null) {                             //sålänge root inte är null
            in_order(root.left);  //den anropar sig själv med left parameter: upprepas till vi har nått sista vänster child., sker recursivt tills vi har kört alla på vänstra sidan
            System.out.print(" " + root.key); //Sedan skriv ut rooten
            in_order(root.right);
        }
    }

    //post: left right root
    void postorderTraverse() {
        post_order(root);
    }

    void post_order(Node root) {
        if (root != null) {
            post_order(root.left);  //den anropar sig själv med left parameter: upprepas till vi har nått sista vänster child.
            post_order(root.right);  //den anropar sig själv med right parameter: upprepas till vi har nått sista höger child.
            System.out.print(" " + root.key);  //skriv ut rooten
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        String[] str = {"W", "O", "E", "C", "A", "L", "H"};
        teori2<String, Integer> st = new teori2<String, Integer>();

        for (int i = 0; i < str.length; i++) {
            String key = str[i];
            st.puts(key, i);
        }
        //root left right
        System.out.println("pre-order");  //samma order som vi har skickat in
        //skriv ut i pre-order
        for (String s : str) //str arrayen fördelas till varje S
        {
            System.out.print(s + " ");
        }

        System.out.println();
        System.out.println("In-order");
        st.inorderTraverse();
        System.out.println();
        System.out.println("Post-order");
        st.postorderTraverse();
        System.out.println();
    }

}

/*en array */
