
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myADT.RandomizedQueueArray;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gerard
 */
public class TestRQA {

    /**
     * @param args the command line arguments
     */
    
        public static void main(String[] args)
{ // Create a stack and push/pop strings as directed on StdIn.

 FileInputStream is;
        try {
            is = new FileInputStream(new File("./queues/tinyTale.txt"));
             System.setIn(is);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FCStackTest.class.getName()).log(Level.SEVERE, null, ex);
        }    
      
RandomizedQueueArray<String> rqa = new RandomizedQueueArray<String>();
while (!StdIn.isEmpty())
{
String item = StdIn.readString();
rqa.enqueue(item);

//StdOut.println("." + rqa.size() + "in queue");

}
//rqa.dump();
//rqa.dequeue();
//rqa.dump();

for (String item : rqa)  StdOut.println((rqa.iterator().next()));  
}        
}
