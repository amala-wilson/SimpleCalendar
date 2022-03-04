import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * This class defines the center view of the calendar application which includes the calendar display and
 * day/event display
 * @author amalachirayil
 *
 */
public class CenterView extends JPanel {
	
	// Components/views that are part of the center view of calendar application
	private CalendarPanelView calendarPanelView;
	private EventPanelView eventPanelView;
	private ActionHandler handler;
	
	/**
	 * Constructs a CenterView object
	 * @param handler - ActionHandler class that implements key functionalities
	 */
	public CenterView(ActionHandler handler) {
		this.handler = handler;
		init();
	}
	
	/**
	 * Initializes the initial view of the center portion with calendar panel (left side) and event panel (right side)
	 */
	private void init() {
		calendarPanelView = new CalendarPanelView(handler);		
		eventPanelView = new EventPanelView();
		
		add(calendarPanelView);
		add(eventPanelView);
		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setAlignmentX(LEFT_ALIGNMENT);
	}
	
	/**
	 * Sets the corresponding data to the calendar panel view and event panel view by retrieving data from the model
	 * @param model
	 */
	public void setData(CalendarAppModel model) {
		calendarPanelView.setData(model.getCalendarData());
		eventPanelView.setData(model.getEventDate(), model.getEventList());
	}
	
	/**
	 * Checks if a slot in the event panel is available
	 * @param date - date of event
	 * @param startTime - start time of event
	 * @param endTime - end time of event
	 * @param eventList - list of events
	 * @return boolean value
	 */
	public boolean validSlot(String date, String startTime, String endTime, List<Event> eventList) {
		return eventPanelView.isSlotAvailable(date, startTime, endTime, eventList);
	}
}