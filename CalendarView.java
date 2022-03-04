import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * This class defines the calendar view and lays out the portion of the overall calendar application
 * @author amalachirayil
 *
 */
public class CalendarView extends JPanel {

	// Components that define the calendar view
	private JPanel dates;
	private List<CButton> buttonList;
	private ActionHandler handler;
	
	/**
	 * Constructor that creates a CalendarView object
	 * @param handler
	 */
	public CalendarView(ActionHandler handler) {
		this.handler = handler;
		init();
	}
	
	/**
	 * Initializes the Calendar View of the overall application
	 */
	public void init() {
		dates = new JPanel();
		buttonList = new ArrayList<CButton>();
		
		initDates();
		
		add(dates);
		
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(boxLayout);
		setAlignmentX(LEFT_ALIGNMENT);
	}
	
	/**
	 * Initializes the dates of the calendar
	 */
	private void initDates() {		
		for(int i=1; i<=49; i++) {
			String msg = ""+i;
			boolean lbl = false;
			if(i == 1) {
				msg = "S";
				lbl = true;
			}else if(i == 2) {
				msg = "M";
				lbl = true;
			}else if(i == 3) {
				msg = "T";
				lbl = true;
			}else if(i == 4) {
				msg = "W";
				lbl = true;
			}else if(i == 5) {
				msg = "T";
				lbl = true;
			}else if(i == 6) {
				msg = "F";
				lbl = true;
			}else if(i == 7) {
				msg = "S";
				lbl = true;
			}
			
			CButton btn = null;
			
			if(lbl) {
				btn = new CButton(msg);
			}else {
				btn = new CButton(i, handler);
			}
			
			btn.setPreferredSize(new Dimension(40, 40));
			btn.setEnabled(!lbl);
			btn.setRequestFocusEnabled(true);
			btn.setFocusable(true);

			buttonList.add(btn);
			dates.add(buttonList.get(i-1));
		}
		dates.setLayout(new GridLayout(7, 7, 0, 0));
	}
	
	/**
	 * Sets the data of the calendar with the provided calendar data object
	 * @param data - calendar data object
	 */
	public void setData(CalendarData data) {
		if(data != null) {
			GregorianCalendar calendar = data.getGregorianCalendar();
			int min = calendar.getActualMinimum(GregorianCalendar.DAY_OF_MONTH);
			int max = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			int currDay = calendar.get(GregorianCalendar.DAY_OF_MONTH);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(calendar.getTime());
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.clear(Calendar.MINUTE);
			cal.clear(Calendar.SECOND);
			cal.clear(Calendar.MILLISECOND);

			// get start of the month
			cal.set(Calendar.DAY_OF_MONTH, 1);
			
			int firstDay = cal.get(Calendar.DAY_OF_WEEK);
			
			for(int i=7; i< 6+firstDay;i++) {				
				CButton btn = buttonList.get(i);
				btn.setEnabled(false);
				btn.setVisible(false);
			}
			
			for(int i=6+firstDay, j = 1; i<49; i++, j++) {				
				CButton btn = buttonList.get(i);
				if(min <= j && j <= max) {
					btn.setText(""+j);
					btn.setEnabled(true);
					btn.setVisible(true);
					btn.setDay(j);
					
					if(currDay == j) {
						SwingUtilities.invokeLater(new Runnable() {							
							public void run() {
								btn.requestFocusInWindow();	
							}
						});	
					}
				}else {
					btn.setEnabled(false);
					btn.setVisible(false);
				}
			}
		}
	}
}