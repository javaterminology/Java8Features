package com.raja.io.updates;

import java.util.StringJoiner;
import java.util.stream.IntStream;


//from JDK 7 StringBuffer also efficient as StringBuilder since jvm will identify if it is running in multithreaded environment then jvm automatically removes synchronization

//for StringJoiner u can add prefix and postfix

//String class itself having static method join to concatenate strings but if we want to add postfix then use StringJoiner class.
public class StringJoinerExamples {
	
	
	public static void main(String args[]) {
	
		String s = "Hello World!";
		IntStream characterStream = s.chars();
		characterStream.mapToObj(letter -> (char)letter)
		.map(Character::toUpperCase)
		.forEach(System.out::print);
		
		
		String[] a = {"one","two","three"};
		
		StringJoiner sj = new StringJoiner(", ","{","}");//added {} as post fix parameter
		
		sj.add("one").add("two").add("three");
		
		System.out.println("Result: "+sj.toString());
		
		String ss = String.join(", ", a);
		
		System.out.println(ss);
		
	}
	
	
	
	

}
