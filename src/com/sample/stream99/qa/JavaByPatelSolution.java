package com.sample.stream99.qa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaByPatelSolution {
  /*
    https://javabypatel.blogspot.com/2018/06/java-8-stream-practice-problems.html
   
    Get student with exact match name "jayesh"
    Get student with matching address "1235"
    Get all student having mobile numbers 3333.
    Get all student having mobile number 1233 and 1234
   5. Create a List<Student> from the List<TempStudent>
    Convert List<Student> to List<String> of student name
    Convert List<students> to String
    8.Change the case of List<String>
    Sort List<String>
    Conditionally apply Filter condition, say if flag is enabled then.
    */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	List<Student> listStudents = new JavaByPatelSolution().assignValue();
	
	//Get student with exact match name "jayesh"
	Optional<Student> student = listStudents.stream().filter(x->x.getName().equalsIgnoreCase("jayesh")).findFirst(); //Collectors.toList());
	System.out.println(student.isPresent() ? student.get().getName():"No value found");
	System.out.println("--------------------");
	
	//Get student with matching address "1235"
	Optional<Student> stud2 = listStudents.stream().filter(x->x.getAddress().getZipcode().equalsIgnoreCase("1235")).findFirst();
	String stud22 = listStudents.stream().filter(x->x.getAddress().getZipcode().equalsIgnoreCase("1235")).map(x->x.getName()).findFirst().orElse(null);
	System.out.println(stud2.isPresent()?stud2.get().getAddress().getZipcode():"Student not presrnt");
	System.out.println(stud2);
	System.out.println("--------------------\n");
	
	//Get all student having mobile numbers 3333.
	 listStudents.stream()  //Stream<Student>
		.filter(x->x.getMobileNumbers().stream().anyMatch(m->m.getNumber()=="3333"))
		.forEach(System.out::println);
	
	 
	List<Student> studentNumber2 = listStudents.stream()  //Stream<Student>
	 .filter(x->x.getMobileNumbers().stream().anyMatch(y->y.getNumber().equals("3333"))).collect(Collectors.toList()) ;
	studentNumber2.stream().forEach(System.out::println);
System.out.println("\n-------------------- student having mobile number 1233 and 1234");  
	  
	// Get all student having mobile number 1233 and 1234
	List<Student> studentNumber3 = listStudents.stream()  //Stream<Student>
		 .filter(x->x.getMobileNumbers().stream().anyMatch(y->y.getNumber().equals("1234")||y.getNumber().equals("1233"))).collect(Collectors.toList()) ;
		studentNumber3.stream().forEach(System.out::println);
		
System.out.println("\n-------------------- 5. Create a List<Student> from the List<TempStudent>");  
	
    TempStudent tmpStud1 = new TempStudent("Jayesh1", 201, new Address("12341"),
    	Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
    TempStudent tmpStud2 = new TempStudent("Khyati1", 202, new Address("12351"),
    	Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
    
    List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
    
    List<Student> studentList = tmpStudents.stream()
    	.map(tmpStud -> new Student(tmpStud.name, tmpStud.age, tmpStud.address, tmpStud.mobileNumbers))
    	.collect(Collectors.toList());

System.out.println(studentList);

System.out.println("\n--------------------  Convert List<Student> to List<String> of student name");

        List<String> nameList = listStudents.stream()
        	.map(e -> e.getName())
        	.collect(Collectors.toList());
        
        nameList.forEach(System.out::println);  

        
        /*****************************************************
        Convert List<students> to String
       *****************************************************/
       System.out.println("\n--------------------  Convert List<students> to String");
       String name = listStudents.stream()
           .map(Student::getName)
           .collect(Collectors.joining(","));
       System.out.println(name);
       System.out.println("--------------------  Upper case");
       
       //Chnage the case of List<String>
       List<String> nameListUpper = listStudents.stream()
       	.map(e -> e.getName().toUpperCase())
       	.collect(Collectors.toList());
       
       nameListUpper.forEach(System.out::println);  
       
       System.out.println("--------------------  sort");
       List<String> nameList2 = listStudents.stream()
	       	.map(e -> e.getName())
	       	.collect(Collectors.toList());
       
       nameList2.stream().sorted().forEach(System.out::println);

       System.out.println("--------------------  sorted with if consition");
        
       /*****************************************************
       Conditionally apply Filter condition, say if flag is enabled then
       *****************************************************/
      boolean sortConditionFlag = true;

      Stream<Student> conditionalFilterResult = listStudents.stream()
          .filter(std -> std.getName().startsWith("J"));

      if(sortConditionFlag){
          conditionalFilterResult = conditionalFilterResult.sorted(Comparator.comparing(Student::getName));
         // conditionalFilterResult.sorted().forEach(System.out::println);  classcastexception its for comparable
      }

      System.out.println("Before sorting :");
      listStudents.forEach(s -> System.out.println(s.getName()));

      List<Student> list = conditionalFilterResult.collect(Collectors.toList());
      System.out.println("After filter and conditional sorting :");
      list.forEach(s -> System.out.println(s.getName()));

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Student> assignValue(){
	
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
     
            Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
     
            Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
     
            List<Student> students = Arrays.asList(student1, student2, student3);
	    return students;
    }

}
