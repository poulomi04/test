package org.poulomi.test.test3.resources;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MyModels")
public class MyModels {

	List<MyModel> modelList;
	
	

	public MyModels() {
	}

	public List<MyModel> getModelList() {
		return modelList;
	}

	public void setModelList(List<MyModel> modelList) {
		this.modelList = modelList;
	}
	
	
}
