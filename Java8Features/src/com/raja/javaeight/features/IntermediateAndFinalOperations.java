package com.raja.javaeight.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.xml.bind.Marshaller.Listener;

public class IntermediateAndFinalOperations {

	public static void main(String[] args) {

		Stream<String> s = Stream.of("one","two","three","four","five");
		Predicate<String> p1 = Predicate.isEqual("two");
		Predicate<String> p2 = Predicate.isEqual("three");
		List<String> list = new ArrayList<String>();
		
		s
		.peek(System.out::println)
		.filter(p1.or(p2))
		.peek(list::add)
		//.peek(System.out::println);//it returns stream and it is intermediary operation
		.forEach(t->System.out.println(t));// it does not return stream and it is final operation
		
		System.out.println("List size:"+list.size());
		
		
	}

}
