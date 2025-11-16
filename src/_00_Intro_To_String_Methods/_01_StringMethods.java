package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
       if(s1.length()>s2.length()) {
    	   return s1;
       }
       return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	if(s.contains("underscores")) {
    		s = s.replace(' ', '_');
    		return s;
    	}
        return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	s1 = s1.trim();
    	s2 = s2.trim();
    	s3 = s3.trim();
    	String space1 = s1.substring(s1.indexOf(' ')+1);
    	String space2 = s2.substring(s2.indexOf(' ')+1);
    	String space3 = s3.substring(s3.indexOf(' ')+1);
        if (space1.compareTo(space2) <= 0 && space1.compareTo(space3) <= 0) {
            return s1;
        } else if (space2.compareTo(space1) <= 0 && space2.compareTo(space3) <= 0) {
            return s2;
        } else {
            return s3;
        }
    	
    	
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int total = 0;
    	for(int i = 0;i<s.length(); i++)
    		if(Character.isDigit(s.charAt(i))) {
    			total+=Character.getNumericValue(s.charAt(i));

    		}
        return total;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	int count = 0;
    	String len = substring;
    	for(int i =0; i<s.length(); i++) {
    		if(i<= s.length()-len.length()) {
        		if(s.substring(i, i+len.length()).equals(len)) {
        			count+=1;
        		}
    		}


    		
    		
    		
    		
    	}
    	
        return count;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	byte[] b = s.getBytes();
    	byte b1 = (byte) key;
        return Utilities.encrypt(b,b1);

    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	byte s1 = (byte) key;
        return Utilities.decrypt(s, s1);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	int count = 0;
    	String[] arrayS =  s.split(" ");
    	for(int i = 0; i<arrayS.length; i++) {
    		if(arrayS[i].length()>=substring.length()) {
    	   		if(arrayS[i].substring(arrayS[i].length()-substring.length()).equals(substring)) {
        			count+=1;
        		}
    		}
 
    	}

    	return count;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	int beg = s.indexOf(substring);
    	int end = s.lastIndexOf(substring);
    	return end - (beg+substring.length());
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	s = s.trim().toLowerCase();
    	String hold = "";
    	String ne = "";

    	for(int i = s.length()-1; i>=0; i--) {
    		if(String.valueOf(s.charAt(i)).matches("[a-z0-9]")) {
        		hold += s.charAt(i);

    		}
    	}
    	for(int i = 0; i<s.length(); i++) {
    		if(String.valueOf(s.charAt(i)).matches("[a-z0-9]")) {
        		ne += s.charAt(i);

    		}
    	}
    	if(ne.equals(hold)) {
            return true;

    	}
    	
    	return false;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
