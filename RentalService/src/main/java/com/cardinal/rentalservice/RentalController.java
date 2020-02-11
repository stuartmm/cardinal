package com.cardinal.rentalservice;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cardinal.rentalservice.model.RentalAgreement;
import com.cardinal.rentalservice.model.ToolCode;
import com.cardinal.rentalservice.model.ToolRentalRequest;
import com.cardinal.rentalservice.utility.DateUtility;
import com.cardinal.rentalservice.utility.RentalAgreementUtility;

@RestController
@RequestMapping(value = "/rentalService")
public class RentalController {

	@Autowired
	private RentalAgreementUtility rentalAgreementUtility; 
	
	@Autowired
	private DateUtility dateUtility;
	
	
	@RequestMapping(value = "/submitOrder")
	public ResponseEntity<RentalAgreement> submitOrder(@RequestParam(value = "toolcode") String toolcode, @RequestParam(value = "rentalDayCount") int rentalDayCount,
			@RequestParam(value = "discountPercent") int discountPercent, @RequestParam(value = "checkoutDate") String checkoutDate) {
		
		ResponseEntity<RentalAgreement> response;
		RentalAgreement rentalAgreement;
	
		//validate tool code
		try {
			ToolCode.valueOf(toolcode);
		} catch (Exception e) {
			return new ResponseEntity<RentalAgreement>(HttpStatus.BAD_REQUEST);
		}
		
		// validate percent, day count, and date
		if(discountPercent > 100 || discountPercent < 0){
			return new ResponseEntity<RentalAgreement>(HttpStatus.BAD_REQUEST);
		} else if(rentalDayCount < 1){
			return new ResponseEntity<RentalAgreement>(HttpStatus.BAD_REQUEST);
		} else if(!dateUtility.isDate(checkoutDate)){
			return new ResponseEntity<RentalAgreement>(HttpStatus.BAD_REQUEST);
		}
		
		//yyyy-mm-dd
		int year = Integer.parseInt(checkoutDate.substring(0, 4));
		int month = Integer.parseInt(checkoutDate.substring(5, 7));
		int day = Integer.parseInt(checkoutDate.substring(8, 10));
		
		LocalDate checkout = LocalDate.of(year, month, day);
		ToolRentalRequest toolRentalRequest = new ToolRentalRequest(ToolCode.valueOf(toolcode), rentalDayCount, discountPercent, checkout);
		
		rentalAgreement = rentalAgreementUtility.calculateRentalAgreement(toolRentalRequest);
		System.out.println(rentalAgreement.toString());
		response = new ResponseEntity<RentalAgreement>(rentalAgreement, HttpStatus.OK);
		return response;
	}
	
	 
}
