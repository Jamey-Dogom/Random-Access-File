/* Jamey Dogom
   Comp. 282
   Project 4 */   

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.plaf.OptionPaneUI;


public class Driver4 {
	static public void main(String args[]) throws IOException {
        String fileName = "info.dat";
        String command = "";
         BufferedReader buffer = new BufferedReader(
                new InputStreamReader(System.in));
         		Record[] record = new Record[1];
                 System.out.print("Welcome to Hasher - found file info.dat");                
                 while(true)
                 {
                	 System.out.println("\nCommand");
                 command = buffer.readLine();
                 String[] commands = command.split(" ");
                 if(commands[0].equals("insert"))
                 {
                	                	
                	 record[0] = new Record(commands[2],Long.parseLong(commands[1]));
                	 File f = new File(fileName);
                     RandomAccessFile out = new RandomAccessFile(f, "rw");
                     for (Record r : record)
                     {
                        r.writeData(out);
                     }
                     out.close();
                     System.out.println("inserted");                   
                 }
                 else if(commands[0].equals("find"))
                 {
                     RandomAccessFile in = new RandomAccessFile(fileName, "r");   
                     int n = (int)(in.length() / Record.RECORD_SIZE);
                     Record[] records = new Record[n];

                     for (int i = n - 1; i >= 0; i--)
                     {  
                        records[i] = new Record();
                        in.seek(i * Record.RECORD_SIZE);
                        records[i].readData(in);
                     }
                     in.close();
                     boolean found = false;
                     for (Record e : records) 
                     {                      
                        if(e.getID() == Integer.parseInt(commands[1]))
                        {
                        	System.out.println(e);
                        	found = true;
                        }
                        
                     }
                     if(found == false)
                    	 System.out.println("No Such Items");
                 }
                 else if(commands[0].equals("quit"))
                 {
                	 System.exit(1);
                 }
                 else System.out.println("False Command:");
                 }
              }
    }