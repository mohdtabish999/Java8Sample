package com.sample.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

    public static void main(String[] args) {

//## 1. Streams filter() and collect()
	System.out.println("1. output ----------------");
	List<String> list = Arrays.asList("node", "java", "python", "ruby");
	list.stream()
		.filter(e -> !e.startsWith("p"))
		.collect(Collectors.toList()) // // collect the output and convert streams to a List
		.forEach(System.out::println);

	List<Integer> list2 = Arrays.asList(20, 23, 24, 23, 24);
	list2.stream()
		.filter(e -> !(e.intValue() == 20))
		.collect(Collectors.toList())
		.forEach(System.out::println);

	list2.stream()
		.distinct()
		.forEach(System.out::println);

//2. ### Streams filter(), findAny() and orElse()
// see use findFirst(), in parallel operation useful, findAny() is non-deterministic.
	System.out.println("2. output ----------------");
	List<String> nameList = Arrays.asList("Tabish", "Roy", "Bunty", "Bubly");
	String name1 = nameList.stream()
		.filter(e -> e.length() > 2)
		.findAny()
		.orElse(null);
	System.out.println(name1);

// ## 3. Streams filter() and map()
	// map( is used to map all elements getout all elements)
	System.out.println("3. output ----------------");
	List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
		new Person("lawrence", 40));
	String name2 = persons.stream()
		.filter(p -> p.getAge() > 20)
		.map(Person::getName) //.map(p -> p.getName())
		.findAny()
		.orElse(null);
	System.out.println(name2);

	persons.stream()
		.map(p -> p.getName())    //List to String
		.forEach(System.out::println);
	
// ## 4. Streams map()	toUpperCase
	System.out.println("4. output ----------------");
	
	List<String> alphabet = Arrays.asList("a","b","c");
	alphabet.stream()
		.map(String::toUpperCase) //.map(s -> s.toUpperCase())
		.forEach(System.out::println);

// ## 5. Streams map()	list of objects
		System.out.println("5. output ----------------");
		List<Person> persons2 = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
			new Person("lawrence", 40));
		persons2.stream().map(p->p.getName()).forEach(System.out::println);
		
		persons2.stream()
			.map(p ->{ 
			    p.setAge(20);
			    p.setName("A");
			    return p;})
			//.forEach(s->  System.out.println(s.toString()));
		.forEach(System.out::println);	
// ## flatMap example ( 2 levels Stream into one Stream level or a 2d array into a 1d array.)

// ## 6. filter out null value from Streams 
		System.out.println("6. Filter out null ----------------");		
		List<String> listNull = Arrays.asList("node", "java", null, "python", "ruby",null);
		List<String> nonNull = listNull.stream().filter(x->x!=null).collect(Collectors.toList());
		System.out.println(nonNull);
		
// ## 7. HashMap to stream
		System.out.println("7. HashMap to Stream ----------------");
		HashMap<String,String> hm= new HashMap();
		hm.put("1","abc");
		hm.put("2","def");
		hm.put("3","ghi");
		
		System.out.println(hm.values());
		List<String> listName = hm.keySet()
			.stream()
			.collect(Collectors.toList());
		List<String> listName2 = hm.entrySet()
			.stream()
			.map(e -> e.getKey())
			.collect(Collectors.toList());
		
		System.out.println(listName);
		System.out.println(listName2);
		
    }
}