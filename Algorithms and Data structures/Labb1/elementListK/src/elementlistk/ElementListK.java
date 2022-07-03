//2020
/*UPpgift 5
Implement a generalized queue which allows the user to remove the kth element from the queue.
Assume the most recently added element has index 1. 
You should print the content of the list after each insertion/deletion of an element. 
*/
//Sara

package elementlistk;

public class ElementListK <Item> {
    
    private class Node{  //vi skapar Node, vi ropar på detta varje gång vi använder node.
    Item item;
    Node next;  
    
    
    public Node (Item item){
        this.item= item;
    }
    }
    Node first= null;  //vi vill börja med tom lista.    

    public boolean isEmpty() {  //boolean som kollar om listan är tomm
    return first == null; }  //vi vill börja med tom lista. dvs innan vi pushar in data i queeun.
    
    
    
      public void enqueueAtFront (Item item){
      Node newN= new Node (item);  //lade till node i början, för den "recently added element should be at index 1"
      if(isEmpty()) {
          first = newN;     
      }
      else{      
      newN.next=first;   //länka nodet som NewN pekar på till det nodet som tidigare var first
      first= newN;   //Sedan gör newN till first då first pekar på newN
      } 
    
      
      while(newN!=null){
          System.out.print(newN.item+ "");
          newN=newN.next;
      }
     
      System.out.println();
    }


    public Item dequeueK (int k){  //the k element that we want to delete
      Node newN= first;
       Node prevN= null; //pekar inte på någonting
       int i= 1;  //vi utgår ifrån att index börjar från 1 och fortsätter tills den hittar k.
       while(i<k){
       prevN=newN;  
       newN= newN.next;   //newN flyttar på sig tills den hittar k.     PrevNligger ett steg bakom newN
       i++;
       
       }                
        
      if(newN != first){   //Sålänge newN inte är fortfarande first.  länka den till ellementet som kommer efter K
           prevN.next=newN.next;  //prevN som låg bakom newN alltså K'th, är nu länkad till det der element som ligger efter newN på så sätt tog jag bort Kt'h element
       }
      
      
      Item remvoveditem= newN.item;    //jag sparade det nodet jag togbort i removeditem.
           newN= first;          //neN pekar på samma som first pekar på      
           
           while (newN!=null){
               System.out.print(newN.item+ "");
               newN=newN.next;
           }       
           System.out.println();  
           return remvoveditem;
    }   
    

 
    public static void main(String[] args) {   
        
 ElementListK<String> elementq = new ElementListK<>();
		System.out.println("Here are the elements in the list:");
		elementq.enqueueAtFront("[A], ");  //index 4
		elementq.enqueueAtFront("[B], ");  //b ligger på index 3 i listan
		elementq.enqueueAtFront("[c], ");  //index 2
		elementq.enqueueAtFront("[D], ");   //index 1
		System.out.println(elementq.dequeueK(3)+ " is removed");
                
}
}
//vi lägger till i början. Det senatse noden vi har insertat blir första indexet.

/*[A], 
[B], [A], 
[c], [B], [A], 
[D], [c], [B], [A], 
[D], [c], [B], [A], 
[B],  is removed*/











//best case: 
//på länkad lista behöver den gå igenom hela listan för att komma åt någon element. Man kan inte referera till index nummret.
//best case: insertion vs deletion from begining O(1)
// Worst case: insertion/removing from the end or middle; O(N)