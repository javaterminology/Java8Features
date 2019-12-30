package com.raja.javaeight.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachPredicate {

	public static void main(String[] args) {
		
		List<String> elementsList = Arrays.asList("raja","sekhar","reddy");

		/*
		 * Consumer<String> c = new Consumer<String>() {
		 * 
		 * @Override public void accept(String t) { System.out.println(t); } };
		 */
		
		List<String> result = new ArrayList<String>();
		
		Consumer<String> c = t -> System.out.println(t);
		
		Consumer<String> r = t -> result.add(t);

		
		elementsList.forEach(c.andThen(r));
		
		System.out.println("Result list size:"+result.size());
	}

}
