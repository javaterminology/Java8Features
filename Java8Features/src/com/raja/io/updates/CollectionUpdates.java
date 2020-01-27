package com.raja.io.updates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUpdates {

	
	//new methods on the collections api  - stream(),parallelStream(),spliterator()
	
	//spliterator - is able to split the collection or stream and parallelize the processing of that stream/collection
	
	//forEach on Iterable
	
	//removeIf on collection api
	
	//replaceAll() - does not return anything
	//sort()
	public static void main(String[] args) {
		
		Collection<String> strings = Arrays.asList("one","two","three","four");

		Collection<String> list = new ArrayList<String>(strings);

		boolean b = list.removeIf(s -> s.length()>4);
		
		System.out.println(list.stream().collect(Collectors.joining(", ")));
		
		list.forEach(System.out::print);
		
		
		List<String> al = Arrays.asList("one","two","three","four");
		
		al.replaceAll(String::toUpperCase);
		
		System.out.println(al.stream().collect(Collectors.joining(", ")));
		System.out.println("-------------------");
		al.sort(Comparator.naturalOrder());
		al.forEach(System.out::println);



		
		
	}

}
