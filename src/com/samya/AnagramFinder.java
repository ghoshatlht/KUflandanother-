package com.samya;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnagramFinder 
{

final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static List<String> readSmallTextFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    return Files.readAllLines(path, ENCODING);
	  }
	
	/*static class Timer {
		static long startTime;
		static long endTime;
		private static boolean isRunning;
		
		static void start() {
			isRunning = true;
			startTime = System.currentTimeMillis();
			System.out.println("Timer running...");
		}
		
		static void stop() {
			isRunning = false;
			endTime = System.currentTimeMillis();
			System.out.printf("Timer complete at %d.\nTOTAL TIME: %dms\n", endTime, (endTime - startTime));
			System.out.println();
		}
		
		static void reset() {
			isRunning = false;
			startTime = 0;
		}
		
		static boolean isRunning() {
			return isRunning;
		}
	}*/
	
	public static List<List<String>> find(String fileName) throws IOException {
		Map<String, List<String>> tempListOfAnagrams = new HashMap<String, List<String>>();
		List<String> listOfWords = readSmallTextFile(fileName);
		for(String s : listOfWords) {
			char[] c = s.toUpperCase().toCharArray();
			Arrays.sort(c);
			List<String> l = tempListOfAnagrams.get(String.valueOf(c));
			if(l == null) {
				l = new ArrayList<String>();
			} 
			l.add(s);
			tempListOfAnagrams.put(String.valueOf(c), l);
		}
		List<List<String>> anagrams = new ArrayList<List<String>>();
		for(Map.Entry<String, List<String>> e : tempListOfAnagrams.entrySet()) {
			if(e.getValue().size() > 1) {
				anagrams.add(e.getValue());
			}
		}
		return anagrams;
	}
		
	public static void main(String[] args) {
		try {
			//Timer.start();
			List<List<String>> anagramsLists = find("words.txt");
			//Timer.stop();
			
			for(List<String> l : anagramsLists) {
				for(String s : l) {
					System.out.print(s + ", ");
				}
				System.out.println();
			}
			System.out.println("\nTotal Sets Found: " + anagramsLists.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
