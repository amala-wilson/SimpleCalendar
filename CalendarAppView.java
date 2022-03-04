import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class defines the view of the calendar application by breaking the view into three parts: header view, center view,
 * and an event dialog box.
 * @author amalachirayil
 *
 */
public class CalendarAppView extends JFrame {
	
	// Defining the width and height of the frame
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 400;
	
	// Components that makes up the CalendarAppView
	private HeaderView headerView;
	private CenterView centerView;
	private ActionHandler handler;
	private EventDialog eventDialog;
	
	/**
	 * Constructs a CalendarAppView object
	 * @param handler - actionhandler object
	 */
	public CalendarAppView(ActionHandler handler) {
		this.handler = handler;
		init();
	}
	
	/**
	 * Displays the initial view of the calendar
	 */
	public void init() {
		headerView = new HeaderView(handler);
		centerView = new CenterView(handler);
		eventDialog = new EventDialog(this, handler);
	
		add(headerView, BorderLayout.NORTH);
		add(centerView, BorderLayout.CENTER);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Sets the dates of a month so that it can be displayed on the center view
	 * @param model
	 */
	public void setData(CalendarAppModel model) {
		centerView.setData(model);
	}
	
	/**
	 * Displays the date in the textfield when user clicks on a date and then clicks on the create button to
	 * add an event
	 * @param model - model of calendar
	 */
	public void showEventDialog(CalendarAppModel model) {
		eventDialog.show(model.getEventDate());
	}
	
	/**
	 * Closes the event dialog pop up box
	 */
	public void exit() {
		setVisible(false);
		dispose();
	}
	
	/**
	 * Checks validity of the event that is add
	 * @param date - date of event
	 * @param startTime - startTime of event
	 * @param endTime - endTime of event
	 * @param eventList - list of events
	 * @return
	 */
	public boolean validSlot(String date, String startTime, String endTime, List<Event> eventList) {
		return centerView.validSlot(date, startTime, endTime, eventList);
	}
	
	/**
	 * Displays a warning message if time conflict exists
	 */
	public void showWarning() {
		JOptionPane.showMessageDialog(this, "Time Conflict exists!", "Warning", JOptionPane.WARNING_MESSAGE);
	}
}
