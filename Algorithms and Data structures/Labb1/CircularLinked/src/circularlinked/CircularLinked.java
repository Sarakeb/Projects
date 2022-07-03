/*
Uppgift 4:
Implement a generic iterable circular linked list which allows the user to insert and remove elements to/from 
the front and back end of the queue. Be careful when designing the API. 
You should print the content of the list after each insertion/deletion of an element.
*/
//sara

package circularlinked;

import java.util.Iterator;


public class CircularLinked <Item> implements Iterable<Item> {
    private Node head;
    private Node last;
    
    
    
    int size;
    
private class Node{  //vi skapar Node, vi ropar på detta varje gång vi använder node.
    Item item;
    Node next;
    Node previous;
    }

public boolean isEmpty() {  //boolean som kollar om listan är tomm
    return head == null; }  //vi vill börja med tom lista. dvs innan vi pushar in data i queeun.



    public void addFirstEnqueue(Item n) {
        if(isEmpty()){  // då head är tomt. dvs vi börjar fån förta noden och bygger på.
            head = new Node();  //skapar första node.
            last=head;    //både last och head pekar på första node.
            last.item=n;  //enquear item inuti
            last.next=last;
            last.previous=last;
            
            size++;
            
            print(); 
           
        
        }
        else {
        Node oldfirst = head;
        head = new Node();
        head.item = n;
        head.next=oldfirst;   //gör den dubbel
        oldfirst.previous=head;  //gör den dubbel
        head.previous=last;       //cirkulär
        last.next=head;    //cirkulär
        
        
        size++;
         print();
        
        
        
          
   
        }
  
    } 
   
    
    public void addLastEnqueue (Item n) {
        
       if(isEmpty()){
       head = new Node();
       last=head;
       last.item=n;
       last.next=last;
       last.previous=last;
       
       size++;
         print(); 
       
       
       } else{   
        Node oldlast = last; //infoga på sluttet. för att det är queue det är fifo, det infogas alltid på sluttet
        last = new Node();
        last.item = n;
       last.next = head;
       //last.next = oldlast;
       oldlast.next=last;
        last.previous = oldlast;     
        
        
        head.previous=last;
        size++;
         print();
       }
     
    }
      
        public Item removeFirstDequeue() {
              if(head == last){
            head = null;
            //size = 0;
            print();
        }
            
         Item removedItem = head.item;  //sparar det nodet vi vill tabort i removeditem
         head = head.next;  //head pekar direkt på nästa elemntet, på så sätt tas den bort
         last.next = head;
         head.previous = last;
         return removedItem;
    }
	
   
        public Item removeLastDequeue() {
              if(head == last){
            head = null;
            //size = 0;
            print();
        }
              
         Item removedItem = last.item; 
         last = last.previous;
         last.next = head;
         head.previous = last;
         
         return removedItem;
    } 
        
        
 private class IterateNode implements Iterator<Item>{    //skapar inre class som implementera iterable interface, som ska iterarea listan med hjälp av 
    //hasprev, hasnexs och kollar om vi har någon annan node och returerar.
   
    private Node current = head;              //we use this to fetch data frpm enqueue and dequeue?  
    
    private boolean visited=false;   //Visted är false, från början för att vi har inte visited någonting
    
    public boolean hasPrev() {      //"Returns true if this list iterator has more elements when traversing the list in the reverse direction."
     // return current != head;
     return !current.equals(head);
    }
    
    //om den nuvarande inte är den första,då är den den nästa element.  det innebär att det finns en element (has )innan den. 
               
               // @Override
    public boolean hasNext(){    //används för att se om vi har element efter den sista Npode. så länge det fnns eölement brevid den är inte null
     //   return current != last;
    // return !current.equals(last);
     
     return !current.equals(head)||!visited;
    }
//Om den nuvarande inte är den första, och är visited då har den element som kommer efter. Dvs, den är inte den sista och har en element som komme refter

    public Item next(){  // går igenom listan och returnerar den
        Item item = current.item;  //nuvarande item sparas i item
        current = current.next;  //elementen efter current blir den nya nuvarande 
        
        visited=true;
        return item;
		}
	}

public Iterator<Item> iterator() {    //Vi returnerar iteratorNode 
            return new IterateNode();
	} 
    

 /*   private class QueueIterator implements Iterator<Item>{
        private Node current = head;
        
        public boolean hasNext() {  
            return current != last;
        }
        public Item next() {
            Item i = current.item;
            current = current.next;
            return i;
        }
    }
       public Iterator<Item> iterator() {  //returnerar Iterator
     return new QueueIterator();
}
*/
   public void print(){
        if(head == null) System.out.println("[ ]");  //om första element är tomt, ingen enqueue, skriv ut tomt
        if(head == last) System.out.println(head.item); //då vi har bara en element. Skriv ut den
        if(head !=last){  //då vi har andra elementer
            Node pointer = head;
            for(int i= 0; i < size ; i++ ){
            System.out.print(pointer.item);
               //if(pointer.next != null) System.out.print(",");
             //   else System.out.print("]");
                pointer = pointer.next;  //den pekar på nästa element i listan.
            }
            System.out.println("");
            
        }
}
 
 
  public static void main(String[] args) { 
CircularLinked<String> cq = new CircularLinked<>();
		
		cq.addLastEnqueue("[A]");
		cq.addLastEnqueue("[B]");
		cq.addLastEnqueue("[C]");
		cq.addFirstEnqueue("[D]");
		cq.addFirstEnqueue("[E]");
                cq.addFirstEnqueue("[F]");
                //  cq.addLastEnqueue("[Z]");
               cq.removeFirstDequeue();
                cq.removeLastDequeue();
                
		
            
              System.out.println("Here are the elements in circular linked list After dequeue:");
                              
		for(String s: cq) {
                    System.out.print(s+ " , ");
                    }		
                
              
           /*   for(int i = 0; i < 6; i++) {
		System.out.println(cq.removeLastDequeue());
               // System.out.println(cq.removeLastDequeue());
               
		}*/
              
              
		
}
	

}

/*
A
AB
ABC
DABC
EDABC
FEDABC

c går bort.


*/

/*[F] , [E] , [D] , [A] , [B] , [C]
[B]
[A]
[D]
[E]
[F]
*/