package com.sample.stream1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class FlatMapExample2 {

    public static void main(String[] args) {

	 List<Order> orders = findAll();

//	 ## order and lineitems	
	 BigDecimal sumOfLineItems = orders.stream()	// <Stream<Order>
	 .map(o->o.getLineItems())			// Stream<List<LineItem>>
	 .flatMap(x->x.stream())               		 // Stream<LineItem>
	 .map(l->l.getTotal())				// Stream<BigDecimal>
	 .reduce(BigDecimal.ZERO,BigDecimal::add); 	// reduce to sum all


	 // sum the order's total amount
	 BigDecimal sumOfOrder = orders.stream()
		 .map(order -> order.getTotal()) 		// Stream<BigDecimal>
		 .reduce(BigDecimal.ZERO, BigDecimal::add);     // reduce to sum all

	 System.out.println(sumOfLineItems); // 3194.20
	 System.out.println(sumOfOrder); // 3194.20
    
    }   
    
 // create dummy records
    private static List<Order> findAll() {

        LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

        return Arrays.asList(order1, order2, order3);

    }
}
