package streamstest;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lambdaTest.People;

public class ST1 {
public static void main(String[] args) {
	List<People> peopleList= Arrays.asList(
			new People("Charles","Dickens",33),
			new People("William", "Wordsworth",34),
			new People("Thomas","Carlyle",55),
			new People("Lewis", "Carroll",31),
			new People("Rabindranath", "Tagore", 44),
			new People("William", "Shakespeare",54)
			);
	
	//Print some random numbers
	//Stream of random numbers
	Stream<Double> randomStream=Stream.generate(Math::random);
	//randomStream.forEach(System.out::println);
	
	//Print the numbers from 1 to 100
	Stream<Integer> numStream=Stream.iterate(1,i->i+1);
	//numStream.forEach(System.out::println);
	
	//Print the contents of a file
	try{
		Stream<String> fileLines=Files.lines(Paths.get(""));
		fileLines.forEach(System.out::println);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	//Print all first names where age >40
	peopleList.
		stream().
		filter(p->p.getAge()>40).
		map(p->p.getFirstName()).
		forEach(System.out::println);
	
	//Testing Lazy and Eager Initialization with the same code as above
	//Lazy-- sysout does not print unless count is called. 
	System.out.println("Lazy test");
		Stream<Object> peopleStream =
			peopleList.stream().
			filter(p->{
				System.out.println("Inside filter");
				return p.getAge()>40?true:false;
				}
			).
			map(p->{
				System.out.println("Inside map");
				return p.getFirstName();
				});
		peopleStream.count();
		//Mapper
		System.out.println("Mapper");
		//Print all first names converted to upper case where age >40 with mapper
		peopleList.
			stream().
			filter(p->p.getAge()>40).
			map(p->p.getFirstName()).
			map(String::toUpperCase).
			forEach(System.out::println);
		
		
		//Converting an arraylist to a map using toMap on stream but if keys are duplicate an error will be thrown
		
		List<People> enhancedPeopleList=Arrays.asList(
										new People("1","Poulomi","Mukherjee",33),
										new People("2","Chinky","Mukherjee",32),
										new People("3","Prasenjit","Sarkar",34),
										new People("4","Gublu","Sarkar",33)
				);
		Map<String,People>  myMap=
					enhancedPeopleList.stream().collect(Collectors.toMap((p)->p.getId(), person-> person));
		System.out.println("map:"+myMap);
		
		//distinct and limit
		
		List<String> fruitList=Arrays.asList("Mango","Jackfruit","Papaya","Mango");
		fruitList.stream().distinct().forEach(System.out::println);
		fruitList.stream().distinct().limit(2).forEach(System.out::println);
		
		//findfirst and find any
		//find first and find any are different in multithreaded environment where find any will 
		//immediately return one match but find first will wait for all threads to finish and find the first match
		
		Optional<String> anyFruit=fruitList.stream().filter(s->s.equalsIgnoreCase("Mango")).findAny();
		System.out.println("Any fruit as Mango:"+anyFruit.get());
		
		
		Optional<String> firstFruit=fruitList.stream().filter(s->s.equalsIgnoreCase("Mango")).findFirst();
		System.out.println("First fruit as Mango:"+anyFruit.get());

		
		//Reduce
		//Find the sum of age of all people whose age >40
		Optional<Integer> ageSum=peopleList.
		stream().
		filter(p->p.getAge()>40?true:false).
		map(People::getAge).
		reduce(Integer::sum);
		
		System.out.println("Sum of age is : " + ageSum.get());
		
		//reduce with a seed value
		//Find the sum of the elements in the list and add 10 to it
		List<Integer> studentCountListPerSection= Arrays.asList(45,34,55,45);
		Integer ageSumAll=studentCountListPerSection.
				 					stream().reduce(10,(i,j)->i+j);
		System.out.println("Total:"+ ageSumAll);
		
		//Optional
		//Using same fruit example
		
		
		//the below would give a NoSuchElementException
		//Optional<String> optionalFruit=fruitList.stream().filter(s->s.equalsIgnoreCase("Tango")).findAny();
		//System.out.println("Optional test:" + optionalFruit.get());
		
		//to avoid
		Optional<String> optionalFruit=fruitList.stream().filter(s->s.equalsIgnoreCase("Tango")).findAny();
		if(optionalFruit.isPresent()) {
			System.out.println("Optional test:" + optionalFruit.get());
		}
}
}
