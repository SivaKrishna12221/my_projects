package com.siva.initBinders;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public class LocalDateBinder extends  PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		String[] ldts = text.split("-");
		int year=Integer.parseInt(ldts[0]);
		int month=Integer.parseInt(ldts[1]);
		int day=Integer.parseInt(ldts[2]);
		LocalDate ld=LocalDate.of(year, month, day);
		setValue(ld);
		
	}
}
