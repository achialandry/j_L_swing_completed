package ca.ciccc.landryachia.model;

import java.time.temporal.WeekFields;
import java.util.HashMap;

/**
 * Date Class with constructor that takes 3 arguments to create a date object for giving precise calender dates.
 * @author Landry Achia
 *
 */
public class Date {
	/**
	 * day integer variable for day of the month
	 */
	private int day;
	
	/**
	 * int month variable for month of the year
	 */
	private int month;
	
	/**
	 * int year variable for year 
	 */
	private int year;
	
	/**
	 * int number of days is thirty, depending on month of the calenda year
	 */
	private final int NUMBER_OF_DAYS_IS_THIRTY = 30;
	
	/**
	 * int number of days thirty one depending on month of the calender year
	 */
	private final int NUMBER_OF_DAYS_IS_THIRTY_ONE = 31;
	
	/**
	 * int twenty eight days for non leap year for the month of feb
	 */
	private final int NUMBER_OF_DAYS_IS_TWENTY_EIGHT = 28;
	
	/**
	 * int number of days in february month for leap year for the month of february 
	 */
	private final int NUMBER_OF_DAYS_IS_TWENTY_NINE = 29;
	
	/**
	 * array of strings to hold all the months
	 */
	private final String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "Octobeer", "November", "December" };
	
	/**
	 * array of string for weekdays in the week
	 */
	private final String[] weekDays = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
	
//	private final int[] weekDayIndex = { 0, 1, 2, 3, 4, 5, 6 };
	/**
	 * constant variable for diversor to check algorithm for number of days
	 */
	private final int DIVISOR_BY_TWELVE = 12;
	/**
	 * constant variable for divisor to check algorithm for number of days by dividing by 4
	 */
	private final int divisorOfRemainderOfYear = 4;

	/**
	 * Date Constructor that takes three parameters which will be instantiated to call date class object
	 * @param year int variable for the year
	 * @param month int variable the month
	 * @param day int variable for the day of the month
	 * @throws Exception handles erros when the day and months are invalid
	 */
	public Date(int year, int month, int day) throws Exception {
		setYear(year);
		setMonth(month);
		setDay(day);

	}

	/**
	 * method that gets day of the week and 
	 * @return the String  day of the week as per the date provided
	 */
	public String getDayOfTheWeek() {

//		String dayOfWeek = "";
		int indexOfDay =0, dateDivesorRemainder, howManyTwelves, howManyFours, dayOfMonth, monthCode = 0, weekDayCalTotal,
				dayAfterModBySeven = 0;
		howManyTwelves = dateLastTwoDigits() / DIVISOR_BY_TWELVE;
		dateDivesorRemainder = dateLastTwoDigits() - howManyTwelves * DIVISOR_BY_TWELVE;
		howManyFours = dateDivesorRemainder / divisorOfRemainderOfYear;
		dayOfMonth = day;
		monthCode = monthCode(month);
//		weekDayCalTotal = howManyTwelves + dateDivesorRemainder + howManyFours + dayOfMonth + monthCode;
//		dayAfterModBySeven = weekDayCalTotal % 7;
//		indexOfDay = dayAfterModBySeven;

		if (isLeapYear() && (month == 1 || month == 2)) {
			monthCode  -= 1;
//			weekDayCalTotal = howManyTwelves + dateDivesorRemainder + howManyFours + dayOfMonth + monthCode;
//			dayAfterModBySeven = weekDayCalTotal % 7;
//			indexOfDay = dayAfterModBySeven;
		}

		if (year >= 1600 && year <= 1699) {
			monthCode += 6;
//			weekDayCalTotal = howManyTwelves + dateDivesorRemainder + howManyFours + dayOfMonth + monthCode;
//			dayAfterModBySeven = weekDayCalTotal % 7;
//			indexOfDay = dayAfterModBySeven;
		} else if (year >= 1700 && year <= 1799) {
			monthCode += 4;
//			weekDayCalTotal = howManyTwelves + dateDivesorRemainder + howManyFours + dayOfMonth + monthCode;
//			dayAfterModBySeven = weekDayCalTotal % 7;
//			indexOfDay = dayAfterModBySeven;
		} else if (year >= 1800 && year <= 1899) {
			monthCode += 2;
//			weekDayCalTotal = howManyTwelves + dateDivesorRemainder + howManyFours + dayOfMonth + monthCode;
//			dayAfterModBySeven = weekDayCalTotal % 7;
//			indexOfDay = dayAfterModBySeven;
		} else if (year >= 2000 && year <= 2099) {
			monthCode += 6;
//			weekDayCalTotal = howManyTwelves + dateDivesorRemainder + howManyFours + dayOfMonth + monthCode;
//			dayAfterModBySeven = weekDayCalTotal % 7;
//			indexOfDay = dayAfterModBySeven;
		} else if (year >= 2100 && year <= 2199) {
			monthCode += 4;
//			weekDayCalTotal = howManyTwelves + dateDivesorRemainder + howManyFours + dayOfMonth + monthCode;
//			dayAfterModBySeven = weekDayCalTotal % 7;
//			indexOfDay = dayAfterModBySeven;
		}
		weekDayCalTotal = howManyTwelves + dateDivesorRemainder + howManyFours + dayOfMonth + monthCode;
		dayAfterModBySeven = weekDayCalTotal % 7;
		
//		System.out.println(dateLastTwoDigits());
//		System.out.println(howManyTwelves);
//		System.out.println(dateDivesorRemainder);
//		System.out.println(howManyFours);
//		System.out.println(dayOfMonth);
//		System.out.println(monthCode);
//		System.out.println(dayAfterModBySeven);
//		
			return weekDays[dayAfterModBySeven];
//		switch (indexOfDay) {
//		case 0:
//			dayOfWeek = weekDays[5];
//			break;
//		case 1:
//			dayOfWeek = weekDays[6];
//			break;
//		case 2:
//			dayOfWeek = weekDays[0];
//			break;
//		case 3:
//			dayOfWeek = weekDays[1];
//			break;
//		case 4:
//			dayOfWeek = weekDays[2];
//			break;
//		case 5:
//			dayOfWeek = weekDays[3];
//			break;
//		case 6:
//			dayOfWeek = weekDays[4];
//			break;
//		default:
//			break;
//		}
//		return dayOfWeek;
	}

	/**
	 * method to get the last two digits of the year inputed
	 * @return the last two digits for the year inputed by user
	 */
	private int dateLastTwoDigits() {
		int lastDigits = year % 100;
		return lastDigits;
	}

	/**
	 * method to get the month code for each month
	 * @param month code for months
	 * @return month codes for all the months
	 */
	private int monthCode(int month) {
		int monthCodeValue = 0;
		if (month == 1) {
			monthCodeValue = 1;
		} else if (month == 2) {
			monthCodeValue = 4;
		} else if (month == 3) {
			monthCodeValue = 4;
		} else if (month == 4) {
			monthCodeValue = 0;
		} else if (month == 5) {
			monthCodeValue = 2;
		} else if (month == 6) {
			monthCodeValue = 5;
		} else if (month == 7) {
			monthCodeValue = 0;
		} else if (month == 8) {
			monthCodeValue = 3;
		} else if (month == 9) {
			monthCodeValue = 6;
		} else if (month == 10) {
			monthCodeValue = 1;
		} else if (month == 11) {
			monthCodeValue = 4;
		} else if (month == 12) {
			monthCodeValue = 6;
		}

		return monthCodeValue;
	}

	/**
	 * method to return number of valid days in a month
	 * @return number of valid days in each calender month
	 */
	public int daysInMonths() {
		int daysInMonth = 0;

		switch (month) {
		case 1:

			daysInMonth = NUMBER_OF_DAYS_IS_THIRTY_ONE;

			break;
		case 2:

			if (isLeapYear()) {
				daysInMonth = NUMBER_OF_DAYS_IS_TWENTY_NINE;

			} else {
				daysInMonth = NUMBER_OF_DAYS_IS_TWENTY_EIGHT;
			}
			break;
		case 3:

			daysInMonth = NUMBER_OF_DAYS_IS_THIRTY_ONE;

			break;
		case 4:

			daysInMonth = NUMBER_OF_DAYS_IS_THIRTY;

			break;
		case 5:

			daysInMonth = NUMBER_OF_DAYS_IS_THIRTY_ONE;

			break;
		case 6:

			daysInMonth = NUMBER_OF_DAYS_IS_THIRTY;

			break;
		case 7:

			daysInMonth = NUMBER_OF_DAYS_IS_THIRTY_ONE;

			break;
		case 8:

			daysInMonth = NUMBER_OF_DAYS_IS_THIRTY_ONE;

			break;
		case 9:

			daysInMonth = NUMBER_OF_DAYS_IS_THIRTY;

			break;
		}

		return daysInMonth;
	}

	/**
	 * method that checks if a year is a leap year
	 * @return true if year is a leap year and false otherwise
	 */
	private boolean isLeapYear() {
		boolean answerYear = false;
		if ((year % 400 == 0 && year % 100 == 0) || (year % 4 == 0 && year % 100 == 0)) {
			answerYear = true;
		} else {
			answerYear = false;
		}
		return answerYear;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 *            
	 * @throws Exception handles errors when the day and months are invalid
	 */
	public void setDay(int day) throws Exception {
		if (day >= 1 && day <= 31) {
			this.day = day;
		}else {
			throw new Exception("Day is Invalid!");
		}
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * method to get the name of month in a human readable way
	 * @return the name of month
	 */
	public String getMonthName() {
		return months[getMonth() - 1];
	}

	/**
	 * method to add leading zeros to the day 
	 * @return day with leading zeros
	 */
	public String addZeroString() {
		return day < 10 ? "0" + day : "" + day;
	}

	/**
	 * @param month
	 *            the month to set
	 * @throws Exception handles errors when the day and months are invalid
	 */
	public void setMonth(int month) throws Exception {
		if (month >= 1 && month <= 12) {
			this.month = month;
		}else {
			throw new Exception("Invalid Month!");
		}
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		if (year >= 1600 && year <= 2100) {
			this.year = year;
		}
	}

}
