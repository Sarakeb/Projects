//2020
/*uppgift 6: Implement an ordered queue based on one of the implementations above.
The elements stored in the queue should be integer values. The elements should be ordered when insertion so 
that all elements are stored in ascending order.
You should print the content of the list after each insertion/deletion of an element.*/

//Sara
package uppgift6;

public class Uppgift6 <Item extends Comparable<Item>> {  //använde mig av comparable för att kunna jämföra 
      int count; 
    
    private class Node{  //vi skapar Node, vi ropar på detta varje gång vi använder node.
    Item item;
    Node next;  
    
    public Node (Item item){
        this.item= item;
    }
    }    
    Node first= null;  //vi vill börja med tom lista.

   

    public boolean isEmpty() {  //boolean som kollar om listan är tomm
    return first == null; 
    } 
    
    public String toString(){
        String s = "";
        Node n = first;  //börja från första node och skiva ut
        while(n != null){  
            s += n.item + " ";
            n = n.next;
        }
        return s;
    }
    
     public void add (Item item){
     Node n= first;  // n pekar på första elementet i listan. gör n til first
     Node newestN= new Node(item);  //läger till item 
     
     if(this.isEmpty()){  //om det är tomt i queuen
         first = newestN;  //de pekar på samma node 
         count++;
         display();
         
     } else{
         
         //har ska item jömföras med nästkommande item så att det blir i ordning. COmpareTo returnera 0 om två saker är lika med varandra
        while (n.next != null && item.compareTo(n.next.item) >= 0){ //kollar om vi är i sluttet av lista OCH NewstNode.item är mindre än noden som kommer efter. ((??om den är större än nästa item, 
            n=n.next; //om item är större, ska det länkas till
        }
    newestN.next= n.next; //elementet som kommer efter   
    n.next= newestN; 
        
   
     count++;
        display();
     }
     }
     
     
     public Item remove() {
    
    Item removedItem = first.item;  //sparar det nodet vi vill tabort i removeditem
    first = first.next;  //head pekar direkt på nästa elemntet, på så sätt tas den bort
     return removedItem;
     
     }
     
     
     public void display(){
          Node p = first;
        for(int i= 0; i < count ; i++ ){ //gå igenom hela listan.
        System.out.print(p.item);
        p = p.next;  //den pekar på nästa element i listan.
        }
        System.out.println(" ");
     }
     
    
    public static void main(String[] args) {   
        
Uppgift6<Integer> elementq = new Uppgift6<>();
		System.out.println("Here are the elementsin the list:");
		elementq.add(2);
		elementq.add(9);		
                elementq.add(6);
		elementq.add(4); 
                elementq.add(8); 
                elementq.add(3); 
                System.out.println("Elementer efter removing:");
                elementq.remove(); 
                
                
                
                
              
                System.out.println(elementq);               
               
                
		
}
}


















//best case: då man insertar i början av noden för det blir en konstant tid O(1)
//Worst case: då man ska inserta noden på slutet. DÅ behöver man gå igenom alla noder och sedan insetar noden på korrekt ställe och 
//ändra på dess adress för nästa nod



    
 




