package com.cardinal.rentalservice.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("dateUtility")
public class DateUtility {
	
	public boolean isDate(String date){
		
		Pattern pattern = Pattern.compile("^20\\d{2}-(0\\d|1\\d)-(0\\d|1\\d|2\\d|30|31)$");
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
		
		
	}

}
