//2020
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

   
    public int size() {
        return n;
    }

    //enqua item i sluttet
    public void enqueue(Item item) {
        Node<Item> 
        oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else          
            oldlast.next = last;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) 
            last = null;   // to avoid loitering
        return item;
    }

    public Iterator<Item> iterator() { return new ListIterator(); }

        private class ListIterator implements Iterator<Item> {
            private Queue.Node current = first;

            public boolean hasNext() { return current != null; }

            public Item next() {
              //  if (!hasNext()) throw new NoSuchElementException();
                Item item = (Item) current.item;
                current = current.next;
                return item;
            }
        }
    }