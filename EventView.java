import java.util.*;
import javax.swing.*;

/**
 * This class defines the view of the events that displayed on the right side of the overall calendar application
 * @author amalachirayil
 *
 */
public class EventView extends JPanel{
	
	// Defining the different components of an day/event view
	private JLabel timeLabel;
	private EventRow eventRow;
	private String title;
	private boolean isAllocated;
	
	/**
	 * Constructs an event view object
	 * @param title
	 */
	public EventView(String title) {
		this.title = title;
		init();
	}
	
	/**
	 * Initializes the day view
	 */
	private void init() {
		JPanel view = new JPanel();
		
		timeLabel = new JLabel(title);
		eventRow = new EventRow();
		
		view.add(timeLabel);
		view.add(eventRow);
		
		add(view);
	}
	
	/**
	 * Retrieves title of day view
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets title of event
	 * @param title - event title
	 */
	public void setTitle(String title) {
		eventRow.setLabel(title);
	}
	
	public boolean isAllocated() {
		return isAllocated;
	}
	
	public void setAllocated(boolean isAllocated) {
		this.isAllocated = isAllocated;
	}
	
	/**
	 * Clears the area that displays the events
	 */
	public void clear() {
		setAllocated(false);
		eventRow.clear();
	}
}