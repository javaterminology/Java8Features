package com.raja.javaeight.features;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsExample {

	public static void main(String[] args) {
		
		Stream<String> s = Stream.of("one","two","three","four");
		
		Predicate<String> p1 = e -> e.length()>3;
		Predicate<String> p2 = Predicate.isEqual("one");
		
		s.filter(p1.or(p2)).forEach(t -> System.out.println(t));

		//peek method is same like foreach method whereas foreatch doesnot return stream but 
		//peek method will return stream
		//stream does not hold any data
		//Stream is typed interface it provide ways to process large/small amounts of data
		//Stream is an Object on which u can define some operations
	}

}
