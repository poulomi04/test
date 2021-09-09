package org.poulomi.test.test3.resources;

import java.util.ArrayList;
import java.util.List;

import org.poulomi.test.test3.resources.service.ServiceClass;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyModel m1=new MyModel("Poulomi", "Mukherjee", 33);
		
		  MyModel m2=new MyModel("Chinky", "Mukherjee", 32);
		ServiceClass class1 = new ServiceClass();
		List<MyModel> myList=new ArrayList<MyModel>();
		myList.add(m1);
		myList.add(m2);
		class1.addMyModel(null);

	}

}
