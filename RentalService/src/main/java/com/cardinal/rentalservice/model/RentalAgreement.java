package com.cardinal.rentalservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RentalAgreement {
	
	private ToolCode tool;
	private ToolBrand brand;
	private ToolType type;
	private int rentalDayCount;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private int chargeableDays;
	private BigDecimal dailyRentalCharge;
	private int discountPercent;
	private BigDecimal totalAmountWithoutDiscount;
	private BigDecimal discountAmount;
	private BigDecimal finalCharge;
	
	public RentalAgreement(ToolCode tool, ToolBrand brand, ToolType type,  int rentalDayCount, LocalDate checkoutDate, LocalDate dueDate,
			int chargeableDays, BigDecimal dailyRentalCharge, int discountPercent,
			BigDecimal totalAmountWithoutDiscount, BigDecimal discountAmount, BigDecimal finalCharge) {
		super();
		this.tool = tool;
		this.brand = brand;
		this.type = type;
		this.rentalDayCount = rentalDayCount;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.chargeableDays = chargeableDays;
		this.dailyRentalCharge = dailyRentalCharge;
		this.discountPercent = discountPercent;
		this.totalAmountWithoutDiscount = totalAmountWithoutDiscount;
		this.discountAmount = discountAmount;
		this.finalCharge = finalCharge;
	}

	public ToolCode getTool() {
		return tool;
	}

	public void setTool(ToolCode tool) {
		this.tool = tool;
	}
	
	public ToolBrand getBrand() {
		return brand;
	}

	public void setBrand(ToolBrand brand) {
		this.brand = brand;
	}

	public ToolType getType() {
		return type;
	}

	public void setType(ToolType type) {
		this.type = type;
	}

	public int getRentalDayCount() {
		return rentalDayCount;
	}

	public void setRentalDayCount(int rentalDayCount) {
		this.rentalDayCount = rentalDayCount;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public int getChargeableDays() {
		return chargeableDays;
	}

	public void setChargeableDays(int chargeableDays) {
		this.chargeableDays = chargeableDays;
	}

	public BigDecimal getDailyRentalCharge() {
		return dailyRentalCharge;
	}

	public void setDailyRentalCharge(BigDecimal dailyRentalCharge) {
		this.dailyRentalCharge = dailyRentalCharge;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public BigDecimal getTotalAmountWithoutDiscount() {
		return totalAmountWithoutDiscount;
	}

	public void setTotalAmountWithoutDiscount(BigDecimal totalAmountWithoutDiscount) {
		this.totalAmountWithoutDiscount = totalAmountWithoutDiscount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getFinalCharge() {
		return finalCharge;
	}

	public void setFinalCharge(BigDecimal finalCharge) {
		this.finalCharge = finalCharge;
	}
	
	@Override
	public String toString(){
		
		String rentalAgreementString = "";
		rentalAgreementString = rentalAgreementString + "Tool code: " + this.tool + "\n";
		rentalAgreementString = rentalAgreementString + "Tool type: " + this.tool.getToolType() + "\n";
		rentalAgreementString = rentalAgreementString + "Tool brand: " + this.tool.getToolBrand() + "\n";
		rentalAgreementString = rentalAgreementString + "Rental day count: " + this.rentalDayCount + "\n";
		
		rentalAgreementString = rentalAgreementString + "Checkout date: " + this.checkoutDate.getMonthValue() 
		+ "/" + this.checkoutDate.getDayOfMonth() + "/" + Integer.toString(this.checkoutDate.getYear()).substring(2, 4) + "\n";
		
		rentalAgreementString = rentalAgreementString + "Due date: " + this.dueDate.getMonthValue() 
		+ "/" + this.dueDate.getDayOfMonth() + "/" + Integer.toString(this.dueDate.getYear()).substring(2, 4) + "\n";
		
		rentalAgreementString = rentalAgreementString + "Chargeable days: " + this.chargeableDays + "\n";
		rentalAgreementString = rentalAgreementString + "Daily rental charge: " + "$" + this.tool.getDailyPrice() + "\n";
		rentalAgreementString = rentalAgreementString + "Discount percent: " + this.discountPercent + "\n";
		rentalAgreementString = rentalAgreementString + "Amount without discount: " + "$" + formatDollars(this.totalAmountWithoutDiscount.toString()) + "\n";
		rentalAgreementString = rentalAgreementString + "Discount amount: " + "$" + formatDollars(this.discountAmount.toString()) + "\n";
		rentalAgreementString = rentalAgreementString + "Final charge: " + "$" +  formatDollars(this.totalAmountWithoutDiscount.toString()) + "\n";
		
		return rentalAgreementString;
	}
	
	private String formatDollars(String dollars){
		
		String wholeDollars = dollars.substring(0, dollars.length() - 3);
		String formatDollars = "";
		for(int i = 0; i < wholeDollars.length(); i ++){
			if (i % 3 == 0 && i != 0){
				formatDollars = "," + formatDollars;
			}
			formatDollars = wholeDollars.charAt(wholeDollars.length() - i - 1) + formatDollars;
		}
		formatDollars = formatDollars + dollars.substring(dollars.length() - 3, dollars.length());
		return formatDollars;
	}
	
}
