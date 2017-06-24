package com.bridgeit.PathVariable.controller;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String name1) throws IllegalArgumentException {
		
		if(name1.contains("Mr.") || name1.contains("Ms.")){
			setAsText(name1);
		}else{
			name1 = "Ms."+name1;
			setValue(name1);
		}
		super.setAsText(name1);
	}
	
	@Override
	public void setValue(Object mobileNumber) {
		
		super.setValue(mobileNumber);
	}
}
