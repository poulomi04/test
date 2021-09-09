package lambdaTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TLMethodReference {
	
	
	
	public static void main(String[] args) {
		List<People> peopleList=Arrays.asList(
				new People("Charles","Dickens",33),
				new People("William", "Wordsworth",44),
				new People("Thomas","Carlyle",55),
				new People("Lewis", "Carroll",31)
				);
		
		//print all people names
		new TLMethodReference().printConditionally(peopleList, (p)-> true,  System.out::println);
		//print all people names if last name starts with c
		new TLMethodReference().printConditionally(peopleList, (p)-> p.getLastName().startsWith("C"), System.out::println);
	}
	
	public void printConditionally(List<People> peopleList,Predicate<People> predicate,
				Consumer<People> consumer) {
		for(People people:peopleList) {
			if(predicate.test(people)) {
				consumer.accept(people);
			}
		}
	}
	
	
	
	


}
