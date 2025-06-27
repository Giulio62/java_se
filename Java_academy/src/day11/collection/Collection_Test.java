package day11.collection;

import java.util.List;

import java.util.*;

public class Collection_Test {

	public static void main(String[] args) {
		List<Integer> numeriList = new ArrayList<>();
		numeriList.add(9);
		numeriList.add(10);
		numeriList.add(11);
		numeriList.remove(2);
		
		for(Integer i:numeriList) {
			System.out.println(i);
		}
		
		Iterator iter =numeriList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		List <String> strList =new LinkedList<>();
		strList.add("Fantozzi");
		strList.add("Pierino");
		strList.add("Monnezza");
		//strList.remove(0);
		strList.remove("Fantozzi");
		for(String s:strList) {
			System.out.println(s);
		}
		
		for(int s=0; s<strList.size();s++) {
			System.out.println(strList.get(s));
		}
		
		Iterator iterList =strList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		Stack<String> stackPila =new Stack();
		stackPila.push("Anna");
		stackPila.push("Franco");
		stackPila.push("Gianni");
		String rimosso=stackPila.pop();
		//System.out.print(false);
	}

}
