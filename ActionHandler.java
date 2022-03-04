/**
 * Interface that defines the key functionalities of the overall calendar application
 * @author amalachirayil
 *
 */
public interface ActionHandler {
	/**
	 * Function that defines the functionality of the calendar moving to the left (previous day) day-by-day
	 */
	void moveCalenderLeft();
	
	/**
	 * Function that defines the functionality of the calendar moving to the right (next day) day-by-day
	 */
	void moveCalenderRight();
	
	/**
	 * Function that updates the day so the display on the calendar can change accordingly
	 * @param day - day on calendar
	 */
	void updateDay(int day);
	
	/**
	 * Function that creates an event (Functionality of create button)
	 */
	void createEvent();
	
	/**
	 * Function that adds an event
	 * @param eventTitle - title of event
	 * @param date - event date
	 * @param start time - start time of event
	 * @param end time - end time of event
	 */
	void addEvent(String eventTitle, String date, String startTime, String endTime);
	
	/**
	 * Functionality of the quit Button
	 */
	void quit();
}