package myADT;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package myADT;

/**
 *
 * @author gerard
 */

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueueArray<Item> implements Iterable<Item> {

   private Item[] RQ;
   private int highest; // hoogste index in de array 
   private int first; // eerst gebruikte entry (eerste index)
   private int last; // laatst gebruitke entry (laatste index)
   private int choosen; // gekozen entry (index) om te verwijderen
    
   public RandomizedQueueArray()           // construct an empty randomized
                                      // queue
       {
           RQ = (Item[]) new Object[4];
           first = 0;
           last = 0;
           highest = RQ.length-1;
           choosen = -1;
       }

       
    private void resize(int max) {
        if (max > highest)  {
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0; i < highest; i++) {
            temp[i] = RQ[(first + i) % RQ.length];
             }
        RQ = temp;
        first = 0;
        highest = RQ.length - 1;
        //last  = highest;
      } 
    }
        
   public boolean isEmpty()           // is the queue empty?
   {
       return last == 0;
   }
   
   public int size()                  // return the number of items on
                                      // the queue
   {
       return last;
   }


   private void swap(int i, int j)
   {
       Item t = RQ[j];
       RQ[j] = RQ[i];
       RQ[i] = t;
   }
   
   public void enqueue(Item item)     // add the item
   {
       // double size of array if necessary and recopy to front of array

       if (item == null) throw new NullPointerException();
       //System.out.println("last = " + last + "length=" + RQ.length +"hoogste"+ highest);
       if (last == highest) resize(2*RQ.length);   // double size of array if necessary
       RQ[last++] = item;                        // add item
      // if (last == RQ.length) last = 0;          // wrap-around waarom,?
       //count++;
       //System.out.println("e" + last + " " + highest + "" + " " + RQ.length );

      
   }

    //public void dump()
     //  {
      //     StdOut.printf("----------------------\n");
     //   for (Item i : RQ) StdOut.printf("ARRAY: %s\n", i);
     
  // }
     

   public Item dequeue()              // delete and return a random item
   {
       if (isEmpty()) throw new NoSuchElementException();

       Item item = sample();
           
      
        for (int i = choosen;i < last; i++) {
             int j = i+1; 
             RQ[i] = RQ[j];
         }
        highest--;
        last--;
        if (highest > 0 && highest == RQ.length/4) resize(RQ.length/2); 
        return item;
   }
   
   
   public Item sample()               // return (but do not delete) a
                                      // random item
   {
         if (isEmpty()) throw new NoSuchElementException();
       choosen = StdRandom.uniform(last);
       return RQ[choosen];
   }

   
   public Iterator<Item> iterator() {   // return an independent iterator over items in random order
		return new RandomizedQueueIterator(); 
	}
   
   private class RandomizedQueueIterator implements Iterator<Item> {
              
		Item[] IQ;//IteratorQueue
		int current;
		
		public RandomizedQueueIterator(){
                    
		IQ = (Item[]) new Object[last];/// dirty cast
                
		for(int i=0;i<last;i++) IQ[i] = RQ[i];
		StdRandom.shuffle(IQ);
                current = 0;
		}
		
		@Override
		public boolean hasNext() {
			return current<last;
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new java.util.NoSuchElementException();
			Item selItem = IQ[current];
			current ++;
			return selItem;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

}
