package zcom.sample.test;

import java.util.ArrayList;
import java.util.Collection;

public class TestNullPassMethod {
    public void display(String s) {
	System.out.println("String"+s);
    }


    
    public void display(Object i) {
	System.out.println("Object"+i);
    }

    public static void main(String[] args) {
	TestNullPassMethod a = new TestNullPassMethod();
	a.display(null);
	
	String s=null;
	a.display(s);
	
	
	Collection<Integer> c=new ArrayList<Integer>();
	c.add(12);
	c.add(123);
	c.add(32);
	c.add(null);
	c.add(3);
	c.remove(34);
	System.out.println(c);

    }
   
}
