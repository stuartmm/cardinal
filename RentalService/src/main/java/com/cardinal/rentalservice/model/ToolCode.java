package com.cardinal.rentalservice.model;

public enum ToolCode {
	LADW (ToolType.LADDER, ToolBrand.WERNER, 1.99, true, true, false),
	CHNS (ToolType.CHAINSAW, ToolBrand.STIHL, 1.49, true, false, true),
	JAKR (ToolType.JACKHAMMER, ToolBrand.RIDGID, 2.99, true, false, false),
	JAKD (ToolType.JACKHAMMER, ToolBrand.DEWALT, 2.99, true, false, false);

	private final ToolType toolType;
	private final ToolBrand toolBrand;
	private final double dailyPrice;
	private final boolean weekday;
	private final boolean weekend;
	private final boolean holiday;
	
	private ToolCode(ToolType toolType, ToolBrand toolBrand, double dailyPrice, boolean weekday, boolean weekend, boolean holiday) {
		this.toolType = toolType;
		this.toolBrand = toolBrand;
		this.dailyPrice = dailyPrice;
		this.weekday = weekday;
		this.weekend = weekend;
		this.holiday = holiday;
	}
	
	public ToolType getToolType() {
		return toolType;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public boolean isWeekday() {
		return weekday;
	}

	public boolean isWeekend() {
		return weekend;
	}

	public boolean isHoliday() {
		return holiday;
	}

	public ToolBrand getToolBrand() {
		return toolBrand;
	}
	
}
