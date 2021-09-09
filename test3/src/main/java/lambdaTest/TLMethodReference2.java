package lambdaTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TLMethodReference2 {
	
	public static void main(String[] args) {
		List<People> peopleList=Arrays.asList(
				new People("Charles","Dickens",33),
				new People("William", "Wordsworth",44),
				new People("Thomas","Carlyle",55),
				new People("Lewis", "Carroll",31)
				);
		//print if age is less than 40
		//lambda form:
		new TLMethodReference2().printConditionally(peopleList, (p) -> p.getAge()<40?true:false, 
				(p) ->System.out.println());
		
		//method reference
		new TLMethodReference2().printConditionally(peopleList, TLMethodReference2::isAgeLessThan40, 
				System.out::println);

		}
	
	public static boolean isAgeLessThan40(People people) {
		if(people.getAge()<40)
			 return true;
		return false;
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
