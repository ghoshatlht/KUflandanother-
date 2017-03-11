package com.samya;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane; 


public class Anagramatic 
{

	public static void main(String[] args) throws FileNotFoundException {
        String anagram = input();
        List<String> anagrams = getAnagrams(anagram, readFile(anagram));
        String output = formatOutput(anagrams);
        JOptionPane.showMessageDialog(null,
            "The anagram "+anagram+" has "+anagrams.size()+" matches, they are:\n\n"+output);
    }


    private static String input() {
        return JOptionPane.showInputDialog(null, "Enter the word or words you would like to be processed");
    }

    private static List<String> readFile(String anagram) throws FileNotFoundException {
        List<String> list = new ArrayList<String>();
        try (Scanner s = new Scanner(new File("words.txt"))) 
        {
            while(s.hasNext()) {
                list.add(s.next());
            }
        }
        return list;
    }

    private static List<String> getAnagrams(String anagram, List<String> words) {
        List<String> list = new ArrayList<String>();
        List<Character> a, b;
        for(String word : words) {
            if(anagram.length() == word.length()) {
                a = new ArrayList<Character>();
                b = new ArrayList<Character>();
                for(int i = 0; i < word.length(); i++) {
                    a.add(anagram.charAt(i));
                    b.add(word.charAt(i));
                }
                if(a.containsAll(b)){
                    list.add(word);
                }
            }
        }
        return list;
    }


    private static String formatOutput(List<String> words) {
        String formattedWords = "[";
        for(int i = 0; i < words.size(); i++) {
            formattedWords += words.get(i);
            if(i % 7 == 0) formattedWords += "\n";
            else formattedWords += ", ";
        }
        formattedWords += "]";
        return formattedWords;
    }
	
}
