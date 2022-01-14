package com.sample.stream1.iterate;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamIterate {

    public static void main(String[] args) {

// ## 1. print numbers 0 to 9	
	System.out.println(" 1. print serial numbers-------------");
	Stream.iterate(0, n -> n + 1)		// returns infinite stream 0 1 2
		.limit(10)			// returns the first n elements
		.forEach(System.out::print);	// 

// ## 2. print odd numbers
	System.out.println(" 2. print odd numbers----------------");
	Stream.iterate(1, n -> n + 2)
		.limit(10)			// not equals to < than, its print 10 odd numbers 
		//.filter(x -> x % 2 != 0)
		.forEach(System.out::print);
	
	
// ## 2.Fibonacci example
	System.out.println(" 2. Fibonacci example----------------");      // seed is first element
	Stream.iterate(new int[]{0,1},n->new int[]{n[1], n[0] + n[1]})    // seed, f(seed), f(f(seed))
	.limit(22)
	.map(n->n[0])			// otherwise array object will be printed
	.forEach(System.out::print);
	
	System.out.println(" 2. Fibonacci example 222----------------");
	Stream.iterate(new int[]{0,1},n->new int[]{n[1], n[0] + n[1]})
	.limit(22)
	//.map(n->n[0])			// otherwise array object will be printed
	//.forEach(x->System.out.print(Arrays.toString(x))) // returns initaial value array
	.forEach(x->System.out.print(x[0]));
	
	System.out.println(" 2. Fibonacci sum metod2----------------");	
	
	int sum = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(n -> n[0]) // Stream<Integer>
                .mapToInt(n -> n)
                .sum();

        System.out.println("Fibonacci 10 sum : " + sum);
	   
	
	
    }

}
