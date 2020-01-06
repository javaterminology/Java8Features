package com.raja.javaeight.features;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();
		try(		
				BufferedReader br = new BufferedReader(
						new InputStreamReader(
								CollectorsExample.class.getResourceAsStream("person.txt")));

				Stream<String> stream = br.lines();
				){

			stream.map(line -> {
				String[] arr = line.split(" ");
				Person p = new Person(arr[0].trim(),Integer.parseInt(arr[1]));
				persons.add(p);
				return p;
			}
					).forEach(System.out::println);



		}catch (Exception e) {
		}

		Optional<Person> opt1 =
				persons.stream()
				.filter(p -> p.getAge()>20)
				.min(Comparator.comparing(Person::getAge));

		System.out.println("Youngest person ="+opt1);
		
		
		Map<Integer ,List<Person>> map =
				persons
				 .stream()
				 .collect(Collectors.groupingBy(Person::getAge)
						 );
		
		System.out.println("map ="+map);

		Map<Integer ,Long> map1 =
				persons
				 .stream()
				 .collect(Collectors.groupingBy(Person::getAge,
						 Collectors.counting())
						 );
		
		System.out.println("map1 ="+map1);
		
		Map<Integer ,String> map2 =
				persons
				 .stream()
				 .collect(Collectors.groupingBy(Person::getAge,
						 Collectors.mapping(Person::getName,
								 Collectors.joining(", ")))
						 
						 );
		
		System.out.println("map2 ="+map2);
		
		Map<Integer ,List<String>> map3 =
				persons
				 .stream()
				 .collect(Collectors.groupingBy(Person::getAge,
						 Collectors.mapping(Person::getName,
								 Collectors.toList()))
						 
						 );
		
		System.out.println("map3 ="+map3);
		
		Map<Integer ,Set<String>> map4 =
				persons
				 .stream()
				 .collect(Collectors.groupingBy(Person::getAge,
						 Collectors.mapping(Person::getName,
								 Collectors.toCollection(TreeSet::new)))
						 
						 );
		
		System.out.println("map4 ="+map4);

	}

}
