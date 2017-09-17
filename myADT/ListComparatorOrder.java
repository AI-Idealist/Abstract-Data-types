
package myADT;

import Sort.Fruit;
import java.util.Comparator;
import java.util.Iterator;

public class ListComparatorOrder<Item extends Comparable> implements Iterable<Item> {
    
    private Comparator comp;
    Node first;
       
    private class Node {
        Item item;
        Node next;
    }
    
    public ListComparatorOrder(Comparator comparator) {
        comp = comparator;
    }
    
     public void addFirst(Item pitem) {
        Node oldfirst = first;
        first = new Node();
        first.item = pitem;
        first.next = oldfirst;
       }
    
    public void Addlast(Item pitem) { // voeg achteraan
      
        Node current = first;
        while (current.next!=null) {
            current = current.next;    
            }
        Node nw = new Node();
        nw.item = pitem;
        current.next = nw;
        nw.next = null;
     }
    
    
    public void addBetween(Item pitem,Comparator comparator ) { // voeg op basis van waarde
        
          Node current = first;
         Node last = first;
    
          while (current != null) {
                if (more(current.item, pitem, comparator)) {
                  Node nw = new Node();
                  nw.item = pitem;
                  last.next = nw;
                  nw.next = current;
                  return;
                  }                 
                last = current;           
                current = current.next;
          }  
          this.Addlast(pitem);
  }
   
    public void add(Item pitem) {
      
        if (isEmpty()) { // lege lijst
            this.addFirst(pitem);
            return;
        }
       if (less(pitem,getMin(),comp)) 
       { 
           this.addFirst(pitem);
           return;
       }   
       if (more(pitem,getMax(),comp)) 
       { 
           this.Addlast(pitem);
           return;
       } 
      addBetween(pitem,comp);
    }
  
     public void delFirst(){
       first = first.next;
    }
    
     public void delLast() { 
      
        Node current = first;
        Node last = first;
        
          while (current.next!=null)
            {
            last = current;
            current = current.next;    
            }
           last.next = null;
   
    }
    
     public void delBetween(Item pitem) { // voeg op basis vnan waarde
        
          Node current = first;
          Node last = first;
    
          while (current != null) {
                if (current.item.equals(pitem)) {
                  last.next = current.next;
                  return;
                  }                 
                last = current;           
                current = current.next;
          }  
      }
     
    
    
    
    public void del(Item pitem) {
      
        if (isEmpty()) return;
        if (!contains(pitem)) return;
        
       if (less(pitem, getMin(),comp)) 
       { 
           this.delFirst();
           return;
       }   
       if (more(pitem,getMax(),comp)) 
       { 
           this.delLast();
           return;
       } 
      delBetween(pitem);
    }  
    
    
    
     public boolean contains(Item pitem) {
         Node current = first;
    
         while (current != null) {
                if (current.item.equals(pitem))  return true;
          current = current.next;  
         }
         return false;
    }   
         
       
    public void clear() {
        first = null;
        
    }
    
     public boolean isEmpty() {
        return (first==null);
    }
   
    public Item getMin() {
        return first.item;   
    }
    
    public Item getMax() {
        Node current = first;
          while (current.next!=null)
            {
            current = current.next;    
            }
        return current.item;         
     } 
    
    
    
    
     private static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) <= 0;
    }
   
    private static boolean more(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) > 0;
    }
    
    public Iterator<Item> iterator() {
       return new ListIterator();
    }
    
    
    
     private class ListIterator implements Iterator<Item> {

        private Node current = first;
        
        public boolean hasNext() {
            return (current != null);
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        
    }
    
     public static void main(String[] args) {
         
    
    
           ListComparatorOrder<Fruit> mylist3 = new ListComparatorOrder<Fruit>(Fruit.FruitNameComparator);  
           Fruit pineappale1 = new Fruit("Pineapple", "Pineapple description",70);
	   Fruit apple1 = new Fruit("Apple", "Apple description",100);
	   Fruit orange2 = new Fruit("Orange", "Orange description",80);
	   Fruit banana1 = new Fruit("Banana", "Banana description",90);
           mylist3.add(pineappale1);
           mylist3.add(apple1);
           mylist3.add(orange2);
           mylist3.add(banana1);
       for(Fruit temp3: mylist3){
		 System.out.println("fruits " + " " + temp3.getFruitName() +
			", Quantity : " + temp3.getQuantity());
          }
       
       Fruit orange3 = new Fruit("Orange", "Orange description",80);
       mylist3.del(orange3);
       
        for(Fruit temp3: mylist3){
		 System.out.println("fruits " + " " + temp3.getFruitName() +
			", Quantity : " + temp3.getQuantity());
          }      
       
     }
    
}
