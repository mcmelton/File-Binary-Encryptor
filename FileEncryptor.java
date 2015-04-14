package main;

import java.io.IOException;
import java.util.*;
import java.io.File;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;



@SuppressWarnings("unused")
public class FileEncryptor{
    



	public static void main(String[] args) throws IOException{
        @SuppressWarnings("resource")
		Scanner sr = new Scanner(System.in);
        System.out.println("Enter File");
        String fileName = sr.nextLine();
        File efile = new File(fileName);
       
        encryptor(efile);
    }


    
	public static void encryptor(File file) throws IOException {
        InputStream in = new FileInputStream(file);
        @SuppressWarnings("resource")
		DataInputStream dataIn = new DataInputStream(in);
        @SuppressWarnings("resource")
		BufferedReader readIt = new BufferedReader(new InputStreamReader(in));
        
        OutputStream fileOut = new FileOutputStream(file.toString() + " Encrypted.txt");
        
        //ZIPOUTPUTSTREAM TAKES IN AN OUTPUTSREAM
        
        //ArrayList<Byte> list = new ArrayList<Byte>();
        //list.add((byte) in.read());
        
       // PrintStream fileCreate = new PrintStream(new FileOutputStream(new File(file.toString()), true));
        boolean run = true;
        byte numFile;
        Byte finByte;
       
        while(run){
        	try{
        	numFile = dataIn.readByte();
        	
        	//System.out.println(line);  
        	String s1 = Integer.toBinaryString(numFile);
        	if(s1.length() < 8){
        		while(s1.length() < 8){
        			s1 = ("0" + s1);
        		}
        	}
        	
        	ArrayList<Integer> bin = new ArrayList<Integer>();
        	String s2 = new String();
        	for(int i = 0; i < s1.length()-1; i++){
        		bin.add(i, (int)s1.charAt(i));
        		
        		if(bin.get(i) == 49){
        			bin.add(i, 0);
        		}else if (bin.get(i) == 48){
        			bin.add(i, 1);
        		}
        		s2 += bin.get(i);
				
        	}
        	
        	if(s2.length() < 8){
        		while(s2.length() < 8){
        			s2 = ("0" + s2);
        		}
        	}
        	finByte = Byte.parseByte(s2, 2);
        	
        	//System.out.println(finByte);
    		fileOut.write(finByte);
    		
        	
        	//fileCreate.write(numFile);
        		
        	} catch (EOFException e){
        		
        		run = false;
        		
        	}
        	
        	
        	}
        
        file.delete();
    	fileOut.close();
        
        }
        
        
      
        //C:\Users\meltmck15\workspace\Encryption\src\main\BIGG test.docx
        //C:\Users\meltmck15\workspace\Encryption\src\main\tester1.txt
        ////C:\Users\meltmck15\workspace\Encryption\testFile.txt
        

}



