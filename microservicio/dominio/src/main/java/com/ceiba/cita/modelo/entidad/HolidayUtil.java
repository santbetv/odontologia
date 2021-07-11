package com.ceiba.cita.modelo.entidad;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HolidayUtil {

	
	private int year;
	private int easterMonth;
	private int easterDay;
	private ArrayList<String> holidays;

	/**
     * Class constructor. Initializes this class with the given year.
     * @param year Year to be used as reference.
     */
    public HolidayUtil(int year) {
        this.year = year;
        this.holidays = new ArrayList<>();
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        this.easterMonth = (h - m + r + 90) / 25;
        this.easterDay = (h - m + r + this.easterMonth + 19) % 32;
        this.easterMonth--;
        this.holidays.add("0:1");               // Primero de Enero
        this.holidays.add("4:1");               // Dia del trabajo 1 de mayo
        this.holidays.add("6:20");              //Independencia 20 de Julio
        this.holidays.add("7:7");               //Batalla de boyaca 7 de agosto
        this.holidays.add("11:8");              //Maria inmaculada 8 de diciembre
        this.holidays.add("11:25");             //Navidad 25 de diciembre
        this.calculateEmiliani(0, 6);           // Reyes magos 6 de enero
        this.calculateEmiliani(2, 19);          //San jose 19 de marzo
        this.calculateEmiliani(5, 29);          //San pedro y san pablo 29 de junio
        this.calculateEmiliani(7, 15);          //Asuncion 15 de agosto
        this.calculateEmiliani(9, 12);          //Descubrimiento de america 12 de octubre
        this.calculateEmiliani(10, 1);          //Todos los santos 1 de noviembre
        this.calculateEmiliani(10, 11);         //Independencia de cartagena 11 de noviembre
        this.calculateOtherHoliday(-3, false);  //jueves santos
        this.calculateOtherHoliday(-2, false);  //viernes santo
        this.calculateOtherHoliday(40, true);   //Asención del señor de pascua
        this.calculateOtherHoliday(60, true);   //Corpus cristi
        this.calculateOtherHoliday(68, true);   //Sagrado corazon
    }

	/**
	 * Move a holiday to monday by emiliani law
	 * 
	 * @param month Original month of the holiday
	 * @param day   Original day of the holiday
	 */
	private void calculateEmiliani(int month, int day) {
		Calendar date = Calendar.getInstance();
		date.set(this.year, month, day);
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			date.add(Calendar.DATE, 1);
			break;
		case 3:
			date.add(Calendar.DATE, 6);
			break;
		case 4:
			date.add(Calendar.DATE, 5);
			break;
		case 5:
			date.add(Calendar.DATE, 4);
			break;
		case 6:
			date.add(Calendar.DATE, 3);
			break;
		case 7:
			date.add(Calendar.DATE, 2);
			break;
		default:
			break;
		}
		this.holidays.add(date.get(Calendar.MONTH) + ":" + date.get(Calendar.DATE));
	}

	/**
	 * Calculate holidays according to easter day
	 * 
	 * @param days     Number of days after (+) or before (-) of easter day
	 * @param emiliani Indicates whether the emiliani law affects
	 */
	private void calculateOtherHoliday(int days, boolean emiliani) {
		Calendar date = Calendar.getInstance();
		date.set(this.year, this.easterMonth, this.easterDay);
		date.add(Calendar.DATE, days);
		if (emiliani) {
			this.calculateEmiliani(date.get(Calendar.MONTH), date.get(Calendar.DATE));
		} else {
			this.holidays.add(date.get(Calendar.MONTH) + ":" + date.get(Calendar.DATE));
		}
	}

	/**
	 * Indicates if a day is a holiday
	 * 
	 * @param month Month in which the day is contained
	 * @param day   Day to evaluate
	 * @return true if the day is a holiday, false otherwise
	 */
	public boolean isHoliday(int month, int day) {
		return this.holidays.contains(month + ":" + day);
	}

	/**
	 * Get the year
	 * 
	 * @return int representation of the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Get the next available business day from a given date and days amount
	 * 
	 * @param date Start date to count from
	 * @param days Number of days to count
	 * @return Date representation of the next business day
	 */
	public static Date getNextBusinessDay(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		HolidayUtil lobHolidayUtil = new HolidayUtil(calendar.get(Calendar.YEAR));
		while (days > 0) {
			calendar.add(Calendar.DATE, 1);
			if (calendar.get(Calendar.YEAR) != lobHolidayUtil.getYear()) {
				lobHolidayUtil = new HolidayUtil(calendar.get(Calendar.YEAR));
			}
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek != 1 && dayOfWeek != 7
					&& !lobHolidayUtil.isHoliday(calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE))) {
				days--;
			}
		}
		return calendar.getTime();
	}

	/**
	 * Get the amount of business days between two dates
	 * 
	 * @param dateInit Start date
	 * @param dateEnd  End date
	 * @return Amount for business days
	 */
	public static int countBusinessDays(Date dateInit, Date dateEnd) {
		Calendar limitDay = Calendar.getInstance();
		int days = 0;
		if (dateEnd != null) {
			limitDay.setTime(dateEnd);
		}
		Calendar startDay = Calendar.getInstance();
		startDay.setTime(dateInit);
		HolidayUtil lobHolidayUtil = new HolidayUtil(startDay.get(Calendar.YEAR));
		while (startDay.getTime().before(limitDay.getTime())) {
			startDay.add(Calendar.DATE, 1);
			if (startDay.get(Calendar.YEAR) != lobHolidayUtil.getYear()) {
				lobHolidayUtil = new HolidayUtil(startDay.get(Calendar.YEAR));
			}
			int dayOfWeek = startDay.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek != 1 && dayOfWeek != 7
					&& !lobHolidayUtil.isHoliday(startDay.get(Calendar.MONTH), startDay.get(Calendar.DATE))) {
				days++;
			}
		}
		return days;
	}
}
