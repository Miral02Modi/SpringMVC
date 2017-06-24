package com.bridgeit.PathVariable.controller;

import java.beans.PropertyEditorSupport;


public class StudentNameEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String name1) throws IllegalArgumentException {
		
		if((name1.contains("Mr.")) || name1.contains("Ms.")){
			setValue(name1);
			return;
		}else{
			name1 = "Mr."+name1;
			setValue(name1);
			return;
		}
	}
}
