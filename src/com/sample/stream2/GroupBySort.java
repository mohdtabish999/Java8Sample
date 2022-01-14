package com.sample.stream2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBySort {

    public static void main(String[] args) {

	List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
	
	Map<String, Long>result = items.stream()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//.entrySet()
		//.forEach(System.out::print);
	System.out.println(result);
	
        //Sort a map and add to finalMap
	 Map<String, Long> finalMap = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
	
	
	List<Item> items2 = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

	Map<String, Long> counting = items2.stream()
		.collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

	System.out.println(counting);
	Map<String, Integer> sum = items2.stream()
		.collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

	System.out.println(sum);
	
	
    }
  
}
