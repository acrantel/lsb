
/*
 * Copyright (C) Serena Li. All rights reserved
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LSB 
{
	public static void main(String[] args) throws IOException
	{	
		String name = "<filename>";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(name));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printHexStream(br, 4);
	}
	
	public static void printHexStream(BufferedReader br, final int numberOfColumns) throws IOException{
		int j = 0;
		String[] lsbs = new String[1000]; // the amount of lsbs to read
		int next;
	    String binary;
	    int skip = 54; // the amount to skip in the beginning (file header, etc.)
	    while (br.ready() && j < 1000) {
	    	next = br.read();
	    	if (j >= skip) {
		    	binary = Integer.toBinaryString(next);
		    	lsbs[j-skip] = binary.substring(binary.length()-1);
	    	}	
	        j++;
	    }
	    // combining singular lsbs into 8 bits
	    String[] combinedlsbs = new String[140];
	    for (int i = 0; i < combinedlsbs.length; i++)
	    {
	    	combinedlsbs[i] = "";
	    }
	    
	    //printing out the raw lsb bits
	    int k = 0;
	    for (int i = 0; i < lsbs.length; i++)
	    {
			if ((i+1)%8 == 0) {
	    		combinedlsbs[k] += lsbs[i];
	    		System.out.print(lsbs[i] + " " + k + "  ");
	    		k++;
	    	}else {
	    		combinedlsbs[k] += lsbs[i];
	    		System.out.print(lsbs[i]);
	    	}
	    }
	    System.out.println(combinedlsbs[0]);
	    System.out.println();
	    for (int i = 0; i < combinedlsbs.length; i++)
	    {
	    	if (combinedlsbs[i] != null)
	    		System.out.print(((char)Integer.parseInt(combinedlsbs[i], 2)));
	    }//*/
	}
}
