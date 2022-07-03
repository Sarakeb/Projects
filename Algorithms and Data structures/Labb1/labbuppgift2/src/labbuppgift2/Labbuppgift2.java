
import java.util.Iterator;

public class Labbuppgift2<Item> implements Iterable<Item> {
	private Node first; 					// link to least recently added node
	private Node last; 						// link to most recently added node
	private int N; 							// number of items on the queue

	private class Node { 					// nested class to define nodes
		Item item;
		Node next;
		Node prev;
	}

	public boolean isEmpty() { 				
		return last == null;
	}

	/*
	 * Number of elements in the list
	 */

	public int size() {
		return N;
	}

	/*
	 * We have two different implementations for adding an element to the queue
	 * depending on if we want to add it to the front or back end of the queue.
	 */

	public void enqueuefront(Item item) { 	// Add item to the front of the list.
		Node oldfirst = first; 				// behåll en referens till första noden
		first = new Node(); 				// skapa den nya första noden
		first.item = item;

		if (isEmpty()) {
			last = first; 					// null
		} else {
			oldfirst.prev = first; 			// den gamla första nodens prev-referens ska peka på nya första
			first.prev = last; 				// Nya första nodens prev ska peka på sista noden (circular)
			last.next = first; 				// Sista nodens next pekar på first (circular)
			first.next = oldfirst; 			// första nodens next pekar på den föregående första noden (andra noden)
		}

		N++; // öka antalet element i kön
	}

	public void enqueueback(Item item) { 	// Add item to the end of the list.
		Node oldlast = last;
		last = new Node();
		last.item = item;

		if (isEmpty()) {
			first = last;
		} else {
			last.next = first;
			last.prev = oldlast;
			first.prev = last;
			oldlast.next = last;

		}

		N++;
	}

	/*
	 * We have two different implementations for removing an element from the queue
	 * depending on if we want to remove it from the front or back end of the queue.
	 */

	public Item dequeuefront() { 			// Remove item from the beginning of the list.
		Item item = first.item; 			// ta datan från första elementet (det som ska tas bort)
		last.next = first; 					// circular
		first = first.next; 				// nya firstreferensen pekar på andra noden

		if (isEmpty()) {
			first = null;
			last = null;
		}

		else {
			first.prev = last; 				// last referear till nya first (förra 2a noden)
		}

		N--; 								// minska antalet element i kön

		return item;
	}

	public Item dequeueback() { 			// Remove item from the back end of the list.
		Item item = last.item; 				// ta datan från sista elementet
		last.next = first; 					// circular
		last = last.prev; 					// nya lastreferensen

		if (isEmpty()) {
			first = null;
			last = null;
		}

		else {
			first.prev = last; 				// first.prev pekar på nya last
		}

		N--;
		return item;
	}


	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		private int i = 0;

		public boolean hasNext() {
			return i < N; 					// make sure that the program does not print out to infinity
		}

		public void remove() {
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			i++; 							// make sure that the program does not print out to infinity
			return item;
		}
	}

	public static void main(String[] args) {
		Labbuppgift2<String> list = new Labbuppgift2<String>();
		String s = "Hej";
		String t = "På";
		String u = "dig";

		list.enqueuefront(s);
		list.enqueueback(t);
		list.enqueueback(u);
		
		list.dequeuefront();

		if (list.isEmpty()) {
			String v = "The list is empty.";
			System.out.println(v);
		}

		else {

			for (String q : list) {
				System.out.print("|" + q + "|");

			}

		}

	}

}
































/*package labbuppgift2;

import java.util.*;

public  class Labbuppgift2 {   
	   
	
	public static void main (String[] args) {
	
	
	Scanner input = new Scanner (System.in);
        Stack<String> stack = new Stack<>();
	System.out.println("Enter something to be reversed: ");
	String text = input.nextLine(); //
	char c;
	for(int i=0; i<text.length(); i++){
            c = text.charAt(i);
            stack.push(Character.toString(c)); //change the char to string, 
	}
	
	
	while (!stack.empty()) {
		System.out.print(stack.pop());
		
	}  
	
}
	
}*//*

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException; 
public class Labbuppgift2<Item> implements Iterable<Item> {
private int n; // number of elements on queue
private Node first; // beginning of queue 
private Node last; // end of queue 


private class Node <E> {
private Item item;
private Node next; 
private Node prev; 

private Node (E dataItem) { 	
this.data = dataItem; 		
this.next = null; 		
this.prev = null; } }


public Main() { 
first = null;
last = null; n = 0; 
}


public boolean isEmpty() {
return first == last; 
}



public void add (Node <E> Item, E item) { 		
Node <E> insert = new Node(item); 		
insert.next = Item; 		
insert.prev = Item.prev; 		
Item.prev.next = insert; 		
Item.prev = insert;
n++; 
    
}



public E remove(Node <E> Item) { 
Item.prev.next = Item.next; 
Item.next.prev = Item.prev;
n--; 
return Item.data; 
    
}






public Iterator<Item> iterator() { 
return new ListIterator(); } // an iterator, doesn't implement remove() since it's optional
private class ListIterator implements Iterator<Item> {
private Node current = first; 
@Override
public boolean hasNext(); 
void remove();
public Item next() {
Item item = current.item; 
current = current.next; return item; }
}

public static void main(String[] args) {
Labbuppgift2<String> queue = new Labbuppgift2<String>();
while (!StdIn.isEmpty()) { 
String item = StdIn.readString(); 
if (!item.equals("-")) queue.enqueue(item);
else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
} 
StdOut.println("(" + queue.size() + " left on queue)"); 
    
} 
    
}


*/








