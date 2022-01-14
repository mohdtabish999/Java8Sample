package com.sample.stream2.peek;

import java.util.Arrays;
import java.util.List;

public class PeekExample {

    public static void main(String[] args) {

// Many examples are using the .count() as the terminal operation for .peek(), for example:
	List<String> l = Arrays.asList("A", "B", "C", "D");

	long count = l.stream().peek(System.out::println).count();  // for debugging

	System.out.println(count); // 4

	// However, for Java 9 and above, the peek() may print nothing:
	List<String> l1 = Arrays.asList("A", "B", "C", "D");

	long count1 = l1.stream().peek(System.out::println).count();

	System.out.println(count1); // 4
	
// Since Java 9, if JDK compiler is able computing the count directly from the stream (optimization in Java 9), it didn’t traverse the stream, so there is no need to run peek() at all.	
	
    }

    
}
