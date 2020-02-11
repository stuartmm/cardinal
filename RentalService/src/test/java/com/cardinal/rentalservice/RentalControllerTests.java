/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cardinal.rentalservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RentalControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testOne() throws Exception{
	
		this.mockMvc.perform(get("/rentalService/submitOrder")
				.param("toolcode", "JAKR") 
				.param("rentalDayCount", "5")
				.param("discountPercent", "101")
				.param("checkoutDate", "2015-09-03"))
				.andDo(print()).andExpect(status().isBadRequest());

	}
	
	@Test
	public void testTwo() throws Exception{
	
		this.mockMvc.perform(get("/rentalService/submitOrder")
				.param("toolcode", "LADW") 
				.param("rentalDayCount", "3")
				.param("discountPercent", "10")
				.param("checkoutDate", "2020-07-02"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.tool").value("LADW"))
				.andExpect(jsonPath("$.brand").value("WERNER"))
				.andExpect(jsonPath("$.type").value("LADDER"))
				.andExpect(jsonPath("$.rentalDayCount").value("3"))
				.andExpect(jsonPath("$.checkoutDate").value("2020-07-02"))
				.andExpect(jsonPath("$.dueDate").value("2020-07-05"))
				.andExpect(jsonPath("$.chargeableDays").value("3"))
				.andExpect(jsonPath("$.dailyRentalCharge").value("1.99"))
				.andExpect(jsonPath("$.discountPercent").value("10"))
				.andExpect(jsonPath("$.totalAmountWithoutDiscount").value("5.97"))
				.andExpect(jsonPath("$.discountAmount").value("0.6"))
				.andExpect(jsonPath("$.finalCharge").value("5.37"));
	}
	
	@Test
	public void testThree() throws Exception{
	
		this.mockMvc.perform(get("/rentalService/submitOrder")
				.param("toolcode", "CHNS") 
				.param("rentalDayCount", "5")
				.param("discountPercent", "25")
				.param("checkoutDate", "2015-07-02"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.tool").value("CHNS"))
				.andExpect(jsonPath("$.brand").value("STIHL"))
				.andExpect(jsonPath("$.type").value("CHAINSAW"))
				.andExpect(jsonPath("$.rentalDayCount").value("5"))
				.andExpect(jsonPath("$.checkoutDate").value("2015-07-02"))
				.andExpect(jsonPath("$.dueDate").value("2015-07-07"))
				.andExpect(jsonPath("$.chargeableDays").value("4"))
				.andExpect(jsonPath("$.dailyRentalCharge").value("1.49"))
				.andExpect(jsonPath("$.discountPercent").value("25"))
				.andExpect(jsonPath("$.totalAmountWithoutDiscount").value("5.96"))
				.andExpect(jsonPath("$.discountAmount").value("1.49"))
				.andExpect(jsonPath("$.finalCharge").value("4.47"));
	}
	
	
	@Test
	public void testFour() throws Exception{
	
		this.mockMvc.perform(get("/rentalService/submitOrder")
				.param("toolcode", "JAKD") 
				.param("rentalDayCount", "6")
				.param("discountPercent", "0")
				.param("checkoutDate", "2015-09-03"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.tool").value("JAKD"))
				.andExpect(jsonPath("$.brand").value("DEWALT"))
				.andExpect(jsonPath("$.type").value("JACKHAMMER"))
				.andExpect(jsonPath("$.rentalDayCount").value("6"))
				.andExpect(jsonPath("$.checkoutDate").value("2015-09-03"))
				.andExpect(jsonPath("$.dueDate").value("2015-09-09"))
				.andExpect(jsonPath("$.chargeableDays").value("6"))
				.andExpect(jsonPath("$.dailyRentalCharge").value("2.99"))
				.andExpect(jsonPath("$.discountPercent").value("0"))
				.andExpect(jsonPath("$.totalAmountWithoutDiscount").value("17.94"))
				.andExpect(jsonPath("$.discountAmount").value("0.0"))
				.andExpect(jsonPath("$.finalCharge").value("17.94"));

	}
	
	@Test
	public void testFive() throws Exception{
	
		this.mockMvc.perform(get("/rentalService/submitOrder")
				.param("toolcode", "JAKR") 
				.param("rentalDayCount", "9")
				.param("discountPercent", "0")
				.param("checkoutDate", "2015-07-02"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.tool").value("JAKR"))
				.andExpect(jsonPath("$.brand").value("RIDGID"))
				.andExpect(jsonPath("$.type").value("JACKHAMMER"))
				.andExpect(jsonPath("$.rentalDayCount").value("9"))
				.andExpect(jsonPath("$.checkoutDate").value("2015-07-02"))
				.andExpect(jsonPath("$.dueDate").value("2015-07-11"))
				.andExpect(jsonPath("$.chargeableDays").value("9"))
				.andExpect(jsonPath("$.dailyRentalCharge").value("2.99"))
				.andExpect(jsonPath("$.discountPercent").value("0"))
				.andExpect(jsonPath("$.totalAmountWithoutDiscount").value("26.91"))
				.andExpect(jsonPath("$.discountAmount").value("0.0"))
				.andExpect(jsonPath("$.finalCharge").value("26.91"));

	}
	
	@Test
	public void testSix() throws Exception{
	
		this.mockMvc.perform(get("/rentalService/submitOrder")
				.param("toolcode", "JAKR") 
				.param("rentalDayCount", "4")
				.param("discountPercent", "50")
				.param("checkoutDate", "2020-07-02"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.tool").value("JAKR"))
				.andExpect(jsonPath("$.brand").value("RIDGID"))
				.andExpect(jsonPath("$.type").value("JACKHAMMER"))
				.andExpect(jsonPath("$.rentalDayCount").value("4"))
				.andExpect(jsonPath("$.checkoutDate").value("2020-07-02"))
				.andExpect(jsonPath("$.dueDate").value("2020-07-06"))
				.andExpect(jsonPath("$.chargeableDays").value("4"))
				.andExpect(jsonPath("$.dailyRentalCharge").value("2.99"))
				.andExpect(jsonPath("$.discountPercent").value("50"))
				.andExpect(jsonPath("$.totalAmountWithoutDiscount").value("11.96"))
				.andExpect(jsonPath("$.discountAmount").value("5.98"))
				.andExpect(jsonPath("$.finalCharge").value("5.98"));

	}
}
