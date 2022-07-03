/*
Uppgift 3
Implement a generic iterable FIFO-queue based on a double linked list. You should print the 
content of the list after each insertion/deletion of an element.
*/
//Sara 

package doublelinkedqueue;
import java.util.*;
//import java.util.Iterator;


public class DoubleLinkedQueue<Item>implements Iterable <Item> {   //item är place holder, för vi inte vet vilken typ av object som vi skickar vi använder oss av genereics
    private Node head;
    private Node last;
    
private class Node{  //vi skapar Node, vi ropar på detta varje gång vi använder node.
    Item item;
    Node next;
    Node previous;
    }


public boolean isEmpty() {  //boolean som kollar om listan är tomm
    return head == null; }  //vi vill börja med tom lista. dvs innan vi pushar in data i queeun.

//parts of the code is inspired from the book by Algorithms by Robert Sedgewick
    public void enqueue(Item item){  
        Node oldlast = last;   //infoga på sluttet. för att det är queue det är fifo, det infogas alltid på sluttet.
        last = new Node();
        last.item = item;
        last.next = null;
        last.previous = oldlast;
        
        if (isEmpty()) {    //om det är tomt så kommer den head=last , för vi har ingen annan eleemnt.
           head = last;
        }
        else {
            last.previous = oldlast;
            oldlast.next = last;  //så länge det är inte tomt så länkas den till sista.
            
           /* 
            
            last.next=head;
            head.previous=last;*/
        }
        last.next=head;
            head.previous=last;
     	}

    
  public Item dequeue(){   // fifo så det är den första som ska tas bort först
      Item item = head.item;    //vi sparar det nodet vi vill tabort i item
      head = head.next;   //head pekar direkt på nästa elemntet, på så sätt tas den bort
   /*   if (isEmpty()) {
          last = null;
      }*/
        return item;
	}

  
        
        //för att göra det möjligt iterablt
private class IterateNode implements Iterator<Item>{    //skapar inre class som implementera iterable interface, som ska iterarea listan med hjälp av 
    //hasprev, hasnexs och kollar om vi har någon annan node och returerar.
   
    private Node current = head;              //we use this to fetch data frpm enqueue and dequeue?
    
    public boolean hasPrev() {      //"Returns true if this list iterator has more elements when traversing the list in the reverse direction."
     // return current != head;
     return !current.equals(head);
    }
                
               // @Override
    public boolean hasNext(){    //används för att se om vi har element efter den sista Npode. så länge det fnns eölement brevid den är inte null
     //   return current != last;
     return !current.equals(last);
    }


    public Item next(){  // går igenom listan och returnerar den
        Item item = current.item;
        current = current.next;
        return item;
		}
	}

public Iterator<Item> iterator() {    //Vi returnerar iteratorNode 
            return new IterateNode();
	} 
    

        
        public static void main(String[] args) {
            
            DoubleLinkedQueue<String> doubleQueue = new DoubleLinkedQueue<>();  //skapade lista doublelinkQueue med string value
            System.out.println("The following are:");
            doubleQueue.enqueue("[Hej]");
            doubleQueue.enqueue("[Hello]");
            doubleQueue.enqueue("[Hi!!]");
            doubleQueue.enqueue("[lab1!]");
            doubleQueue.enqueue("[lab2]");

         
            doubleQueue.dequeue();
            
            System.out.println("The FIFO version:");
          for( String s : doubleQueue){  //for each string in doubleQueue print the following
            System.out.print(s + "  ");
                
            }
            System.out.println("");
            System.out.println("");
            System.out.println("here are the other elements:");
          while(!doubleQueue.isEmpty()){  //så länge listan inte är tomt
            System.out.println(doubleQueue.dequeue());  //skriv ut andra i listan
           }

    }
}
    
 

