package com.sample.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NumberReduce {

    public static void main(String[] args) {

	int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	// 1st argument, init value = 0
	int sum = Arrays.stream(numbers)
		.reduce(0, (a, b) -> a + b);
	int sum1 = Arrays.stream(numbers)
		.reduce(0, Integer::sum); // 55
	int sum2 = Stream.of(numbers)
		.flatMapToInt(n -> Arrays.stream(n))
		.reduce(0, (a, b) -> a + b);
	System.out.println("sum : " + sum); // 55
	System.out.println("sum1 : " + sum1); // 55
	System.out.println("sum2 : " + sum2); // 55

// ## 1 sum of even number
	System.out.println("1. output --sum even-----");
	List<Integer> list1 = Arrays.asList(11, 33, 44, 21, 44);
	int even = list1.stream()
		.filter(x -> x % 2 == 0)
		.reduce(0, (a, b) -> a + b);
	System.out.println(even);

// ## 2 min number
	System.out.println("2. min number-----");
	int min = Arrays.stream(numbers)
		.reduce(0, (a, b) -> a < b ? a : b); // 0
	int min1 = Arrays.stream(numbers)
		.reduce(0, Integer::min);
	System.out.println(min);

// ## 3 Join Strings
	System.out.println("3. jon Strings -------");
	String[] strings = { "a", "b", "c", "d", "e" };

	// |a|b|c|d|e , the initial | join is not what we want
	String reduce = Arrays.stream(strings)
		.reduce("", (a, b) -> a + "|" + b);
	System.out.println(reduce);

// 4. map and reduce example
	
	/*
	 * List<Invoice> invoices = Arrays.asList(new Invoice("A01",
	 * BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)), new Invoice("A02",
	 * BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)), new Invoice("A03",
	 * BigDecimal.valueOf(4.99), BigDecimal.valueOf(2)));
	 * 
	 * BigDecimal sum = invoices.stream() 
	 * .map(x -> x.getQty().multiply(x.getPrice())) 	// map 
	 * .reduce(BigDecimal.ZERO, BigDecimal::add); 		//reduce
	 * 
	 * System.out.println(sum); // 49.955 
	 * System.out.println(sum.setScale(2,RoundingMode.HALF_UP)); // 49.96
	 */	  
	 
    }

}

/*
 * class Invoice {
 * 
 * String invoiceNo; BigDecimal price; BigDecimal qty;
 * 
 * // getters, stters n constructor }
 */