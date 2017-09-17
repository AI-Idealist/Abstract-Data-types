
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myADT.StackArrayFixed;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gerard
 */
public class FCStackTest {

    /**
     * @param args the command line arguments
     */
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
       
        StackArrayFixed<String> s;
s = new StackArrayFixed<String>(100);
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
    
