package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	String character = ""; 
    	for(int i = 0; i<characters.length; i++) {
    		character += String.valueOf(characters[i]);
    		
    	}
        return str + character;
    }
    
    public static String reverse(String str) {
    	String temp = "";
    	for(int i = str.length()-1; i>=0; i--) {
    		temp += String.valueOf(str.charAt(i));
    		
    	}
        return temp;
    }
    
    public static String insert(String str, int index, char newChar) {
    	String temp = "";
    	char[] list = str.toCharArray();
    	for(int i = 0; i<list.length; i++) {
    		if(i == index) {
    			temp += newChar;
    		}
    		temp += list[i];

    	}
        return temp;
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	String temp = "";
    	char[] list = str.toCharArray();
    	for(int i = 0; i<list.length; i++) {
    		if(i<startIndex || i>endIndex) {
    			temp+= list[i];
    		}
    	}
        return temp;
    }
}