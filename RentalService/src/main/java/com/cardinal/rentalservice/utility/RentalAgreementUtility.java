package com.cardinal.rentalservice.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.stereotype.Component;

import com.cardinal.rentalservice.model.RentalAgreement;
import com.cardinal.rentalservice.model.ToolRentalRequest;

@Component
public class RentalAgreementUtility {
	
	public RentalAgreement calculateRentalAgreement(ToolRentalRequest toolRentalRequest){
		
		LocalDate dueDate = toolRentalRequest.getCheckoutDate().plusDays(toolRentalRequest.getRentalDayCount());
		BigDecimal chargeableDays = new BigDecimal(getChargeableDays(toolRentalRequest));
		BigDecimal dailyPrice = new BigDecimal(toolRentalRequest.getToolCode().getDailyPrice()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal totalAmountWithoutDiscount = dailyPrice.multiply(chargeableDays).setScale(2, RoundingMode.HALF_UP);
		BigDecimal discountPercent = new BigDecimal(toolRentalRequest.getDiscountPercent());
		discountPercent = discountPercent.divide(new BigDecimal(100));
		BigDecimal discountAmount = totalAmountWithoutDiscount.multiply(discountPercent);
		BigDecimal finalCharge = totalAmountWithoutDiscount.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
		discountAmount = totalAmountWithoutDiscount.multiply(discountPercent).setScale(2, RoundingMode.HALF_UP);
		
		RentalAgreement rentalAgreement = new RentalAgreement(toolRentalRequest.getToolCode(), 
				toolRentalRequest.getToolCode().getToolBrand(), toolRentalRequest.getToolCode().getToolType(), 
				toolRentalRequest.getRentalDayCount(), toolRentalRequest.getCheckoutDate(),
				dueDate, getChargeableDays(toolRentalRequest), dailyPrice, toolRentalRequest.getDiscountPercent(), 
				totalAmountWithoutDiscount, discountAmount, finalCharge);
		
		return rentalAgreement;
	}
	
	
	private int getChargeableDays(ToolRentalRequest request){
		int chargeableDays = request.getRentalDayCount();
		if (request.getToolCode().isHoliday()){
			chargeableDays = chargeableDays - holidayCount(request);
		}
		if (request.getToolCode().isWeekend()){
			chargeableDays = chargeableDays - weekendCount(request);
		}
		return chargeableDays;
	}
	
	
	private int holidayCount(ToolRentalRequest request){
		
		int nonChargeableDays = 0; 
		LocalDate checkoutDate = request.getCheckoutDate();
		LocalDate datePointer = checkoutDate;
		//4th of July
		for(int i = 0; i < request.getRentalDayCount(); i++){
			if (datePointer.getMonth() == Month.JULY && datePointer.getDayOfMonth() == 4){
				nonChargeableDays += 1;
			}
			datePointer = datePointer.plusDays(1);
		}
		datePointer = checkoutDate;
		//labor day
		for(int i = 0; i < request.getRentalDayCount(); i++){
			if (datePointer.getMonth() == Month.SEPTEMBER && datePointer.getDayOfWeek() == DayOfWeek.MONDAY && datePointer.getDayOfMonth() <= 7){
				nonChargeableDays += 1;
			}
			datePointer = datePointer.plusDays(1);
		}
		return nonChargeableDays;
	}
	
	private int weekendCount(ToolRentalRequest request){
		int nonChargeableDays = 0;
		LocalDate datePointer = request.getCheckoutDate();
		for (int i = 0; i > request.getRentalDayCount(); i++){
			if (datePointer.getDayOfWeek() == DayOfWeek.SATURDAY || datePointer.getDayOfWeek() == DayOfWeek.SUNDAY){
				nonChargeableDays += 1;
			}
			datePointer = datePointer.plusDays(1);
		}
		return nonChargeableDays;
	}
	
}
