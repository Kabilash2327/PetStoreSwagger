package org.tests;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class trialPro {
	
	public static void main(String[] args) {
		
		Map<Integer, String> m = new TreeMap<Integer, String>();
		m.put(29,"Kabi");
		m.put(21,"Dharun");
		m.put(28,"Anand");
		
		Set<Entry<Integer, String>> entrySet = m.entrySet();
		
		for (Entry<Integer, String> entry : entrySet) {
			System.out.println(entry);
		}
	}	
}
