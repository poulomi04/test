package org.poulomi.test.test3.resources.service;

import java.util.ArrayList;
import java.util.List;

import org.poulomi.test.test3.resources.MyModel;

public class ServiceClass {
	static List<MyModel> myList=new ArrayList<MyModel>();
	
	public ServiceClass() {
		
	}

	public List<MyModel> getAllModels(){
		
		  MyModel m1=new MyModel("Poulomi", "Mukherjee", 33);
		  
		  MyModel m2=new MyModel("Chinky", "Mukherjee", 32); 
		  myList.add(m1);
		  myList.add(m2);
		 
		 
		return myList;

	}
	
	public void addMyModel(MyModel myModel) {
		myList.add(myModel);
	}
}
