import java.io.Serializable;

/**
 * This class defines the information required by the user in order to create an event. It uses
 * the Serialiable interface so that the user defined events can be taken as input from a file and
 * likewise, save the user defined events.
 * @author amalachirayil
 *
 */
public class Event implements Serializable {
		
	private String eventTitle;
	private String dateOfEvent;
	private String startTime;
	private String endTime;
	
	/**
	 * Constructor that creates an Event object.
	 */
	public Event(String eventTitle, String dateOfEvent, String startTime, String endTime) {
		setEventTitle(eventTitle);
		setEventDate(dateOfEvent);
		setStartTime(startTime);
		setEndTime(endTime);
	}
	
	/**
	 * Sets the event title of the event object with the given user defined event title.
	 * @param eventTitle the title of the event defined by the user
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
	/**
	 * Retrieves the event title of the user defined event.
	 * @return title of event
	 */
	public String getEventTitle() {
		return (this.eventTitle);
	}
	
	/**
	 * Sets the event date of the event object with the given user defined event date.
	 * @param dateOfEvent the date of the event defined by the user
	 */
	public void setEventDate(String dateOfEvent) {		
		this.dateOfEvent = dateOfEvent;
	}
	
	/**
	 * Retrieves the event date of the user defined event
	 * @return date of event
	 */
	public String getEventDate() {
		return dateOfEvent;
	}
	
	/**
	 * Sets the start time of the event object with the given user defined start time.
	 * @param startTime the start time of the event defined by the user
	 */
	public void setStartTime(String startTime) {		
		this.startTime = startTime;	
	}
	
	/**
	 * Retrieves the start time of the user defined event.
	 * @return start time of the event
	 */
	public String getStartTime() {
		return startTime;
	}
	
	/**
	 * Sets the end time of the event object with the given user defined end time.
	 * @param endTime the end time of the event defined by the user
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Retrieves the end time of the user defined event.
	 * @return end time of the event
	 */
	public String getEndTime() {
		return endTime;
	}
	
	/**
	 * Creates an event object
	 * @return event
	 */
	public Event copy() {
		return new Event(eventTitle, dateOfEvent, startTime, endTime);
	}
}
