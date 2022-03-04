import java.util.GregorianCalendar;

/**
 * This class sets and retrieves the appropriate gregorian calendar
 * @author amalachirayil
 *
 */
public class CalendarData {
	
	// Defines calendar
	private GregorianCalendar calendar;
	
	/**
	 * Constructor that creates a Calendar Data
	 */
	public CalendarData() {
		calendar = new GregorianCalendar();
	}
	
	/**
	 * Sets the calendar with the given calendar
	 * @param calendar - provided calendar
	 */
	public void setGregorianCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
	}
	
	/**
	 * Retrieves the calendar
	 * @return calendar
	 */
	public GregorianCalendar getGregorianCalendar() {
		return calendar;
	}
}