package com.StriverSheet;

import java.util.HashMap;

public class Isomorphic_Strings {

	public static void main(String[] args) {
		String s = "egg", t = "add";

	}

	public static boolean isIsomorphic(String s, String t) {

		HashMap<Character,Character> map=new HashMap<>();
		
		 for(int i=0; i<s.length();i++) {
			 
			 char ch=s.charAt(i);
			 char replacement=t.charAt(i);
			 
			 if(!map.containsKey(ch)) {
				 if(!map.containsValue(replacement)) {
					 
					 map.put(ch, replacement);
				 }else {
					 return false;
				 }
				 
			 }else {
				    char mapped=map.get(ch);
				    if(mapped !=replacement) {
				    	return false;
				    }
			 }
			
		 }
		 return true;
		
	}
}
