/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gerard
 */


import myADT.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StackTest {

    /**
     * @param args the command line arguments
     */
    
        public static void main(String[] args)
{ // Create a stack and push/pop strings as directed on StdIn.

 FileInputStream is;
        try {
            is = new FileInputStream(new File("tobe.txt"));
             System.setIn(is);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FCStackTest.class.getName()).log(Level.SEVERE, null, ex);
        }    
      
Stack<String> s = new Stack<String>();
while (!StdIn.isEmpty())
{
String item = StdIn.readString();
if (!item.equals("-"))
s.push(item);
else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
}
StdOut.println("(" + s.size() + " left on stack)");
}
    }
    

