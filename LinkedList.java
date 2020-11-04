/******************************************************************************                                        
 *  Compilation:  javac LinkedList.java                                                                                
 *  Execution:    java LinkedList                                                                                      
 *  Dependencies: Picture.java                                                                                         
 ******************************************************************************/
 
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.File;
import java.awt.Color;
 
public class LinkedList<Item> implements Iterable<Item> { // to enable for each syntax                            
    private int n;          // number of elements                                                                      
    private Node first;     // beginning of the list                                                                   
    private Node last;      // end of the list
    private Node current;
    
    // helper linked list class                                                                                        
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
 
    /** Initializes an empty list. */
    public LinkedList() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() { return n == 0; }
    public int size() { return n; }

    /* add to beginning of list */
    public void addFirst(Item item) {
        Node oldfirst = first;
        first = new Node();
        if (last == null)
            last = first;
        first.item = item;
        first.next = oldfirst;
        oldfirst.prev = first;
        //oldfirst = first.prev; ---------------------------------------------
        n++;
    }

    /* add to end of list */
    public void addLast(Item item) {
        Node temp = new Node();
        temp.item = item;
        if (last == null) {
            first = temp;
            last = temp;
        }
        else {
            last.next = temp;
            temp.prev = last;
            last = temp;
        }
        n++;
    }

    /** Removes the item at the beginning of the list. **/
    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("List empty");
        Item item = first.item;        // save item to return                                                          
        first = first.next; 
        // delete first node    
        first.prev = null;
        n--;        // return the saved item                                                        
    }
    
    public void remove(Item v){
        Node current = first;
        if (isEmpty())
            throw new NoSuchElementException("List empty");
        int count = 0;
        if(current.item == v){
            removeFirst();
            return;
        }   

        if(last.item == v) {
            last = last.prev;
            last.next = null;
            n--;
            return;
        } 

        while(current.item != v && current.next != null){
            current = current.next;
        }

        if(current.item == v){
            current.next.prev = current.prev;
            current.prev.next = current.next;
            n--;
            return;
        }
        return;
    }
 
    /** Returns (but does not remove) the first element in the list. */
    public Item getFirst() {
        if (isEmpty())
            throw new NoSuchElementException("List empty");
        return first.item;
    }
 
    /**                                                                                                                
     * Returns an iterator to this list that traverses the items from first to last.                                   
     */

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
 
    // The Iterator<T> interface contains methods hasNext(), remove(), next()                                          
    // (remove() is optional)                                                                                          
    public class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    /**                                                                                                                
     * Returns an iterator to this list that traverses the items from first to last.                                   
     */
    public Iterator<Item> revIterator() {
        return new reverseIterator();
    }
    
    public class reverseIterator implements Iterator<Item> {
        private Node current = last;
        public boolean hasNext(){
            return current!= null;
        }
        public Item next() {
        if (!hasNext()) throw new NoSuchElementException();
        Item item = current.item;
        current = current.prev;
        return item;
        }
    }
    /** Unit test with some pictures */
    public static void pause(int t) {     /** stops for t milliseconds */
        try {
            Thread.sleep(t);
        } 
        catch (Exception e) {}
    }
    public void printList(){
        Node current = first;
        while (current != null){
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // get the list of all file names                                                                              
        Integer[] array = new Integer[]{1,2,3,4,5,6,7};
        // create a collection of these objects                                                                        
        LinkedList<Integer> num = new LinkedList<Integer>();
        for (Integer i: array)     /** array implements iterable */
            num.addLast(i);
        
        num.printList();
        num.remove(1);
        num.remove(2);
        num.remove(4);
        num.remove(6);
        num.printList();           
                                                                                                   
    }                                                                                                           
}
