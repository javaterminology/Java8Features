package com.raja.javaeight.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerForEach {

	public static void main(String[] args) {
		List<String> list = Arrays.asList();
		Consumer<String> c1 = s1->list.add(s1); //list::add
		Consumer<String> c2 = s2->System.out.println(s2); //System.out::println
		Consumer<String> c3 = c1.andThen(c2);
		



	}

}
