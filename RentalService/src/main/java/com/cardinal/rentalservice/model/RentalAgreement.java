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
	
	
}
