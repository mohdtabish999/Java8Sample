package com.sample.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {
	  String[][] array2d = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
	  
	  Stream<String[]> stream = Arrays.stream(array2d);
	  Stream<String[]> stream2 = Stream.of(array2d);

	  stream.filter(x -> {
	      for (String s : x) {
		  if (s.equals("a")) 
		      return false;
		  }
	      return true;
	  })
		  //.collect(Collectors.toList())
		  .forEach(x -> System.out.println(Arrays.toString(x)));
	  
// ## method2 
	  System.out.println("method 2 --------------");
	  String[] arr1 = Stream.of(array2d)			// Stream<String[]>
		  .flatMap(x -> Stream.of(x))   // // Stream<String>
		  .toArray(x->new String[x]); // (String::new) // [a, b, c, d, e, f]
	  
	  System.out.println(Arrays.toString(arr1));  

	  
// ## method 3 filter out a
	 // Stream<String[]>      -> flatMap ->	Stream<String>
	 // Stream<Set<String>>   -> flatMap ->	Stream<String>
	 // Stream<List<String>>  -> flatMap ->	Stream<String>
	 // Stream<List<Object>>  -> flatMap ->	Stream<Object>
	  
	  System.out.println("method 3 --------------");
	  Stream.of(array2d)                    //returns Stream<String[]>
	  .flatMap(x->Stream.of(x))              //Stream<String>
	  .filter(x->!x.equals("a"))
	  .forEach(System.out::println);
	  
// ## flatmap example 4 primitive type
	  System.out.println("method 4 --------------");
	  final Long[] longObjectArray = {1L, 2L, 3L};
	  final long[] longArray = {1, 2, 3};

	  Stream.of(longObjectArray).forEach(System.out::print); //That works just fine
	  Stream.of(longArray).forEach(System.out::println);     //That doesn't
	  
	  Stream<long[]> longArrayStream = Stream.of(longArray);
	  longArrayStream.flatMapToLong(x -> Arrays.stream(x)) // Stream<Long>
		  .forEach(System.out::print);
	  //OR 
	  Arrays.stream(longArray)
		  .forEach(System.out::print);
      }
}
