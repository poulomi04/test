package lambdaTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestLambda2 {
public static void main(String[] args) {
	List<People> peopleList= Arrays.asList(
			new People("Charles","Dickens",33),
			new People("William", "Wordsworth",44),
			new People("Thomas","Carlyle",55),
			new People("Lewis", "Carroll",31)
			);
	
//Sort the list by last name
			/*
			 * Collections.sort(peopleList, new Comparator<People>() {
			 * 
			 * @Override public int compare(People o1, People o2) { return
			 * o2.getLastName().compareTo(o1.getLastName()); }
			 * 
			 * });
			 */
	
	Collections.sort(peopleList, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
	
//Create a method that prints all elements in the list
	
	/*
	 * for(People people:peopleList) { System.out.println(people); }
	 */
	printConditionally(peopleList, p->true,System.out::println);
	
//Create a method that prints all people that has last name starting C
	/*
	 * for(People people:peopleList) { if(people.getLastName().startsWith("C")) {
	 * System.out.println(people); } }
	 */
	printConditionally(peopleList, p->p.getLastName().startsWith("C"),p->System.out.println(p.getFirstName()));

}

	public static void printConditionally(List<People> peopleList, Predicate<People> predicate,Consumer<People> consumer) {
		for(People people:peopleList) {
			if(predicate.test(people)) {
				consumer.accept(people);
			}
		}
	}

}
