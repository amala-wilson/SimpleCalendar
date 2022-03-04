import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class defines the model for the calendar that is used to display to the user and allows the user to
 * view the events on the date the user clicked on
 * @author amalachirayil
 *
 */
public class CalendarAppModel {
	
	// Declaring the data and view that is used to store the calendar data and display the calendar, respectively
	private CalendarData calendarData;
	private CalendarAppView calendarAppView;
	// Declaring an array list to retrieve the list of events
	private ArrayList<Event> eventList;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	
	/**
	 * Constructor that creates an CalendarAppModel object
	 * @param calendarAppView - calendar view
	 */
	public CalendarAppModel(CalendarAppView calendarAppView) {
		this.calendarAppView = calendarAppView;
		calendarData = new CalendarData();

		eventList = new ArrayList<Event>();
		
		calendarAppView.setData(this);
	}
	
	/**
	 * Sets the current Calendar
	 * @param calendarData - data that is used to set the current calendar
	 */
	public void setCalendar(CalendarData calendarData) {
		this.calendarData = calendarData;
	}
	
	/**
	 * Retrieves the calendar data
	 * @return calendarData object
	 */
	public CalendarData getCalendarData() {
		return calendarData;
	}
	
	/**
	 * Set the day that user selected to the current calendar
	 * @param day - day the user clicked on
	 */
	public void setDay(int day) {
		calendarData.getGregorianCalendar().set(Calendar.DAY_OF_MONTH, day);
		
		calendarAppView.setData(this);
	}
	
	/**
	 * Provides the functionality to move the calendar day by day either to the previous or next day
	 * depending on the current date
	 * @param i - day
	 */
	public void addDay(int i) {
		calendarData.getGregorianCalendar().add(Calendar.DAY_OF_MONTH, i);
		
		calendarAppView.setData(this);
	}
	
	
	/**
	 * Gets the date of an event
	 * @return
	 */
	public String getEventDate() {
		return sdf.format(calendarData.getGregorianCalendar().getTime());
	}
	
	/**
	 * Adds an event to the existing list of events and also sets it up in the calendar view
	 * @param eventTitle - title of event
	 * @param date - date of event
	 * @param startTime - start time of event
	 * @param endTime - end time of event
	 */
	public void addEvent(String eventTitle, String date, String startTime, String endTime) {
		Event event = new Event(eventTitle, date, startTime, endTime);
		eventList.add(event);
		
		calendarAppView.setData(this);
	}
	
	/**
	 * Sets list of events
	 * @param eventList - list of events to be set
	 */
	public void setEventList(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}
	
	/**
	 * Retrieves list of events
	 * @return list of events
	 */
	public ArrayList<Event> getEventList(){
		return eventList;
	}	
}