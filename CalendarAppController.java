import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This class defines the controller of the overall calendar application
 * @author amalachirayil
 *
 */
public class CalendarAppController{

	// Defines the model and view that calendar controller is going to interact with
	private CalendarAppModel model;
	private CalendarAppView calendarAppView;
	
	/**
	 * Constructs a CalendarAppController object
	 */
	public CalendarAppController() {		
		init();
		loadEvents(model);
	}
	
	/**
	 * Function that defines the functionality of the calendar application
	 */
	private void init() {
		calendarAppView = new CalendarAppView(new ActionHandler() {
			public void moveCalenderLeft() {
				model.addDay(-1);
				calendarAppView.setData(model);
			}

			public void moveCalenderRight() {
				model.addDay(1);
				calendarAppView.setData(model);
			}

			public void updateDay(int day) {
				model.setDay(day);
			}

			public void createEvent() {
				calendarAppView.showEventDialog(model);
			}

			public void addEvent(String eventTitle, String date, String startTime, String endTime) {
				
				if(calendarAppView.validSlot(date, startTime, endTime, model.getEventList())){
					model.addEvent(eventTitle, date, startTime, endTime);
				}
				else {
					calendarAppView.showWarning();
				}
			}

			public void quit() {
				writeEvents(model);
				calendarAppView.exit();				
			}
		});
		
		/**
		 * Creates the calendar model
		 */
		model = new CalendarAppModel(calendarAppView);
	}
	
	/**
	 * Loads events from a file into the model
	 * @param model
	 */
	private void loadEvents(CalendarAppModel model) {
		
		ObjectInputStream objectinputstream = null;
		try {
			model.getEventList().clear();
			
			FileInputStream streamIn = new FileInputStream("events.txt");
		    objectinputstream = new ObjectInputStream(streamIn);
		    
		    ArrayList<Event> events = null;
		    do {
		    	events = (ArrayList<Event>) objectinputstream.readObject();
		        if(events != null){
		        		for(Event em: events) {
		        			model.getEventList().add(em);
		        		}
		        } 
		    } while (events != null);
		} catch (Exception e) {
		   // e.printStackTrace();
			;
		} finally {
		    if(objectinputstream != null){
		        try {
					objectinputstream .close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					;
				}
		    } 
		}
		calendarAppView.setData(model);
	}
	
	/**
	 * Writes events to a file after application is quit
	 * @param model
	 */
	private void writeEvents(CalendarAppModel model) {
		FileOutputStream fout;
		
		try {
			fout = new FileOutputStream("events.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(model.getEventList());
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			;
		} catch (IOException e) {
//			e.printStackTrace();
			;
		}
	}
}