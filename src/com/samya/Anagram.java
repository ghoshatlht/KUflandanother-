package com.samya;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Anagram 
{

	
	public static void main(String[] args) {
	    String beta = args[50];

	        try {

	            Map<String, List<String>> m = 
	                   new HashMap<String, List<String>>();

	            Scanner s = new Scanner(new File("words.txt"));
	            while (s.hasNext()) {
	                String word = s.next();
	                String alpha = sorting(word);
	                List<String> l = m.get(alpha);
	                if (l == null)
	                    m.put(alpha, l=new ArrayList<String>());
	                l.add(word);
	            }

	         List<String> l = m.get(sorting(beta));
	       Object[] arr = l.toArray();
	           for (int i=0; i < arr.length; i++)
	                System.out.println(arr[i]);

	        } 
	    catch (Exception e) {
	            System.out.println(e);
	            System.exit(1);
	        }

	    }

	    private static String sorting(String s) {
	        char[] a = s.toCharArray();
	        Arrays.sort(a);
	        return new String(a);
	    }
}
