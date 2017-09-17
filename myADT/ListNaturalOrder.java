package myADT;

import Sort.Fruit;
import java.util.Comparator;
import java.util.Iterator;

public class ListNaturalOrder<Item extends Comparable> implements Iterable<Item> {

    Node first;
       
    private class Node {
        Item item;
        Node next;
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
    
    public void addBetween(Item pitem ) { // voeg op basis van waarde
        
          Node current = first;
          Node last = first;
    
          while (current != null) {
                if (more(current.item, pitem)) {
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
       if (less(pitem,getMin())) 
       { 
           this.addFirst(pitem);
           return;
       }   
       if (more(pitem,getMax())) 
       { 
           this.Addlast(pitem);
           return;
       } 
      addBetween(pitem);
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
        
        if (less(pitem, getMin())) 
       { 
           this.delFirst();
           return;
       }   
       if (more(pitem,getMax())) 
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
    
    
    
    public Iterator<Item> iterator() {
       return new ListIterator();
    }
    
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }
    
     private static boolean more(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
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
      
         
         ListNaturalOrder<Integer> mylist1 = new ListNaturalOrder<Integer>();  
         mylist1.add(5);
         mylist1.add(10);
        //mylist1.add(6); 
        //mylist1.add(20);
        //mylist1.add(18);
        // mylist1.add(12);
       
          
          for(Integer temp1: mylist1){
		   System.out.println("element :" + temp1 );
          }   
          
            System.out.println("-------------");
        // mylist1.del(10);
         mylist1.del(3);
            mylist1.del(5);
           for(Integer temp1: mylist1){
		   System.out.println("element :" + temp1 );
          } 
           
           
           ListNaturalOrder<Fruit> mylist2 = new ListNaturalOrder<Fruit>();  
           Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70);
	   Fruit apple = new Fruit("Apple", "Apple description",100);
	   Fruit orange = new Fruit("Orange", "Orange description",80);
	   Fruit banana = new Fruit("Banana", "Banana description",90);
           mylist2.add(pineappale);
           mylist2.add(apple);
           mylist2.add(orange);
           mylist2.add(banana);
       for(Fruit temp2: mylist2){
		 System.out.println("fruits " + " " + temp2.getFruitName() +
			", Quantity : " + temp2.getQuantity());
          }
        System.out.println("-------------");
              
          Fruit orange1 = new Fruit("Orange", "Orange description",80);
          
           System.out.println("-------------");
           
            System.out.println(orange.equals(orange1));
          
          mylist2.del(orange1);
       for(Fruit temp3: mylist2){
		 System.out.println("fruits " + " " + temp3.getFruitName() +
			", Quantity : " + temp3.getQuantity());
          }
          
        
       
       /*
       
       
         ListNaturalOrder<String> mylist = new ListNaturalOrder<String>();
        mylist.add("to");
        mylist.add("be");
        mylist.add("or");
        mylist.add("not");
        mylist.add("to");
        mylist.add("be");
             
         for(String temp: mylist){
		System.out.println("element :" + temp );
         }            
         
          mylist.del("be");
          mylist.del("be");
             
         for(String temp: mylist){
		System.out.println("element :" + temp );
         } 
       
       
        
     */  
    }
}

