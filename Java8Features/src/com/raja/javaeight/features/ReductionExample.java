package com.raja.javaeight.features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class ReductionExample {
	//https://www.baeldung.com/java-stream-reduce
	//reduction stream operations allow us to produce one single result from a sequence of elements, 
	//by applying repeatedly a combining operation to the elements in the sequence.
	/*
	 * 
	 * Identity – an element that is the initial value of the reduction operation and the default result if the stream is empty
	   Accumulator – a function that takes two parameters: a partial result of the reduction operation and the next element of the stream
       Combiner – a function used to combine the partial result of the reduction operation when the reduction is parallelized, or when there's a mismatch between the types of the accumulator arguments and the types of the accumulator implementation*/
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		BinaryOperator<Integer> bo = (subtotal , element) -> subtotal + element;
		Integer sum = list.stream().reduce(0, bo);//if identity element is 10 then sum is 31
		//10+1+2+3+4+5+6 = 31
		//Integer sum = list.stream().reduce(0, Integer::sum);
		//Integer sum = list.stream().reduce(0, Integer::max);
		System.out.println(sum);
		
		List<Integer> list1 = Arrays.asList(11,1,3,6,33,12);
		BinaryOperator<Integer> bo1 = (subtotal1 , element1) -> subtotal1 + element1;
		
		//Optional<Integer> optionalSum = list1.stream().reduce(bo1);
		Optional<Integer> maxValue = list1.stream().max(Comparator.naturalOrder());
		
		if(maxValue.isPresent()) {
			Integer maxval = maxValue.get();
			System.out.println("maxval = "+maxval);
		}

	}

}
