package com.sample.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample1 {

    public static void main(String[] args) {
	  Developer o1 = new Developer();
	        o1.setName("mkyong");
	        o1.setPrice(20);
	        o1.addBook("Java 8 in Action");
	        o1.addBook("Spring Boot in Action");
	        o1.addBook("Effective Java (3nd Edition)");

	        Developer o2 = new Developer();
	        o2.setName("zilap");
	        o2.setPrice(30);
	        o2.addBook("Learning Python, 5th Edition");
	        o2.addBook("Effective Java (3nd Edition)");

	        List<Developer> list = new ArrayList<>();
	        list.add(o1);
	        list.add(o2);
	        
	        
// 1. ## book flat, map is optional(combine in flatmap).
	        
	       Set<String> l = list.stream()                // <Stream<Developer> 
               // .map(x -> x.getBook())     		    // Stream<Set<String>>
                .flatMap(x->x.getBook().stream())                     // Stream<String>
                .collect(Collectors.toSet());               // Set<String> 
	       l.forEach(System.out::println);
	       System.out.println("---------------------------------") ;
//2. Get Developer who has written book "Effective Java (3nd Edition)"
 
	       Set<Developer> d = list.stream()   //Stream<Developer>
	       //.map(x->x.getName())
	       .filter(a->a.getBook().stream().anyMatch(x->x.equalsIgnoreCase("Effective Java (3nd Edition)")))
	       .collect(Collectors.toSet());
	       
	       d.forEach(System.out::println);
	       
    }
}
