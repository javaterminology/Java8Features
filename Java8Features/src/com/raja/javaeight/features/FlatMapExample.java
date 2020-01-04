package com.raja.javaeight.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
		List<Integer> list2 = Arrays.asList(2,4,6);
		List<Integer> list3 = Arrays.asList(3,5,7);
		
		List<List<Integer>> list = Arrays.asList(list1,list2,list3);
		
		Function<List<?>, Integer> size = List::size;//map operation functional interface Function<>
		Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();//flatMap function retuns stream of streams 
		//and finally returns flattened stream
		list.stream()
		//.map(size)
		//.map(flatmapper) - if we use flatmapper for map function it returns 3 stream objects 
		.flatMap(flatmapper)//it returns stream of streams and finally return flattened stream 
		.forEach(System.out::println);

		
		//peek,foreach will take Consumer as parameter
		//filter - will take predicate as parameter
		//map() ,flatMap() - takes mappers as parameter - mapper is functional interface of Function<>

		
	}

}
