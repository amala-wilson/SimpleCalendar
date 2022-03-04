import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This class defines the view to display the events (right side portion of the calendar application
 * @author amalachirayil
 *
 */
public class EventPanelView extends JPanel{
	
	// Components that make up the event panel view
	private JLabel dateLabel;
	private List<EventView> eventViewList;
	private JPanel events;
	
	private SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm a");
	private SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yy"); 
	
	/**
	 * Constructor that constructs the EventPanelView object
	 */
	public EventPanelView() {
		events = new JPanel();
		events.setLayout(new GridLayout(24, 1, 0, 0));
		
		JScrollPane scroll = new JScrollPane(events);
		
		dateLabel = new JLabel("");
		
		add(dateLabel);
		add(scroll);
		
		eventViewList = new ArrayList<>();
		
		init();
		
		setSize(600, 200);
		setPreferredSize(new Dimension(600, 200));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setAlignmentX(CENTER_ALIGNMENT);
	}
	
	/**
	 * Function that initializes the initial view of the event panel
	 */
	private void init() {
		for(int i=0; i< 24; i++) {
			String title = "";
			int j = i; //
			String ampm = "AM";
			if(j > 12) {
				j %= 12;
				ampm = "PM";
			}
			else if(j == 12) {
				ampm = "PM";
			}
			
			if(j<10) {
				title = "0"+j+":00 "+ampm;
			}
			else if(j <= 12) {
				title = ""+j+":00 "+ampm;
			}
			
			EventView ev = new EventView(title);
			events.add(ev);
			eventViewList.add(ev);
		}
	}
	
	/**
	 * Sets the data of events with its corresponding date
	 * @param date - date of event
	 * @param eventList - list of events
	 */
	public void setData(String date, List<Event> eventList) {		
		dateLabel.setText(date);
		
		List<Event> todayEvents = new ArrayList<>();
		for(Event em: eventList) {
			if(date != null && date.equals(em.getEventDate())) {
				todayEvents.add(em.copy());
			}
		}
		
		for(EventView ev: eventViewList) {
			ev.clear();
			for(Event m: todayEvents) {
				if(m.getStartTime().equals(ev.getTitle())) {
					ev.setAllocated(true); //
					ev.setTitle(m.getEventTitle());
				}
			}
		}
	}
	
	/**
	 * Verifies if a time slot on the event panel view is available
	 * @param date - date of event
	 * @param startTime - start time of event
	 * @param endTime - end time of event
	 * @param eventList - list of events
	 * @return result
	 */
	public boolean isSlotAvailable(String date, String startTime, String endTime, List<Event> eventList) {	
		boolean result = true;		
		
		try {
			List<Event> todayEvents = new ArrayList<Event>();
			for(Event em: eventList) {
				if(date != null && date.equals(em.getEventDate())) {
					todayEvents.add(em.copy());
				}
			}
			
			Date d = sdfDate.parse(date);
			Date sTime = sdfTime.parse(startTime);
			Date eTime = sdfTime.parse(endTime);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(sTime);
			calendar1.set(Calendar.DATE, calendar.get(Calendar.DATE));
			
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(eTime);
			calendar2.set(Calendar.DATE, calendar.get(Calendar.DATE));
		
			for(Event m: todayEvents) {
				Date mTime = sdfTime.parse(m.getStartTime());
				Calendar calendar3 = Calendar.getInstance();
				calendar3.setTime(mTime);
				calendar3.set(Calendar.DATE, calendar.get(Calendar.DATE));
					
				Date mETime = sdfTime.parse(m.getEndTime());
				Calendar calendar4 = Calendar.getInstance();
				calendar4.setTime(mETime);
				calendar4.set(Calendar.DATE, calendar.get(Calendar.DATE));
				
				if((calendar1.after(calendar3) || calendar1.equals(calendar3)) &&
						calendar2.before(calendar4) || calendar2.equals(calendar4)){
					result = false;
					break;
				}
			}
		}catch (Exception ex) {
//			ex.printStackTrace(s);
			;
		}
		return result;
	}
}