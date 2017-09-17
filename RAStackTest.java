
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import myADT.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gerard
 */
public class RAStackTest {

    public static void main(String[] args) {
        // TODO code application logic here
     // In in = new In(args[0]); 
        FileInputStream is;
        try {
            is = new FileInputStream(new File("tobe.txt"));
             System.setIn(is);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FCStackTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        StackArray<String> s;
s = new StackArray<String>();
while (!StdIn.isEmpty())
{
String item = StdIn.readString();
if (!item.equals("-")) {
     s.push(item);
     Iterator<String> it = s.iterator();
while (it.hasNext()) {
    String t = it.next();
   // StdOut.print(t+ "\n");
}


}
else if (!s.isEmpty()) StdOut.print(s.pop() + " ");

} 
StdOut.println("(" + s.size() + " left on stack)"); }  
    
}
