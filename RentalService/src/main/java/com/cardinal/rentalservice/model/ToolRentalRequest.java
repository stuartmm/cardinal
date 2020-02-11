package com.cardinal.rentalservice.model;

import java.time.LocalDate;

public class ToolRentalRequest {
	
	private ToolCode toolCode;
	private int rentalDayCount;
	private int discountPercent;
	private LocalDate checkoutDate;
	
	public ToolRentalRequest(ToolCode toolCode, int rentalDayCount, int discountPercent, LocalDate checkoutDate){
		this.toolCode = toolCode;
		this.rentalDayCount = rentalDayCount;
		this.discountPercent = discountPercent;
		this.checkoutDate = checkoutDate;
	}

	public ToolCode getToolCode() {
		return toolCode;
	}

	public void setToolCode(ToolCode toolCode) {
		this.toolCode = toolCode;
	}

	public int getRentalDayCount() {
		return rentalDayCount;
	}

	public void setRentalDayCount(int rentalDayCount) {
		this.rentalDayCount = rentalDayCount;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
	

}
