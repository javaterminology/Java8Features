package com.raja.io.updates;

import java.util.Comparator;

import com.raja.javaeight.features.Person;

public class ComparatorUpdates {
	
	//JDK 7 - Compare 2 person objects with their Last name
	//required null checks for person/person name
	Comparator<Person> compareLastName = new Comparator<Person>() {

		@Override
		public int compare(Person o1, Person o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};
	
	
	//JDK8
	
	Comparator<Person> comparepLastNameThenAge = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
	

}
