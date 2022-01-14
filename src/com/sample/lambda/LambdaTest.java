package com.sample.lambda;

import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

public class LambdaTest {

	public static void main(String args[]) {
	
		List<String> list = Arrays.asList("node", "java", "python", "ruby");
		
		// lambda expressions
		//Consumer Functional interface, foreach is default method addedd in iterable interface
		list.forEach(str -> System.out.println(str)); // uses the collection’s iterator(whichever is specified)., iteration order of the Iterable,
		list.stream().forEach(System.out::println);  // Order is not defined, used for iteration in a group of objects by converting a collection into the stream 
		
		
		
		FunctionalDraw.drawStatic(); 
		FunctionalDraw d = ()->System.out.println("Draw Me");
		d.draw();
		d.drawDefault();
		d.drawDefault2();
		
		//if there is only one statement, you may or may not use return keyword. You must use return keyword when lambda expression contains multiple statements.
		Addable addLambda = (a,b)->a+b;
		Addable addLambdaReturn = (a,b)-> {return (a+b);};
		System.out.println(addLambda.add(10, 20));
		System.out.println(addLambdaReturn.add(20, 30));
		
	}
    
}
