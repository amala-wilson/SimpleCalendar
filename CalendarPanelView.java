import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * This class defines the view of the calendar panel (displayed on left side of center view)
 * @author amalachirayil
 *
 */
public class CalendarPanelView extends JPanel {
	
	// Defining the components within the calendar panel view
	private JButton createButton;
	private CalendarView calendarView;
	private JLabel dateLabel;
	private ActionHandler handler;
	
	/**
	 * Constructs CalendarPanelView object
	 * @param handler - Action Handler that defines the functionality of the application
	 */
	public CalendarPanelView(ActionHandler handler) {
		this.handler = handler;
		init();
	}
	
	/**
	 * Initializes the Calendar Panel View with its components
	 */
	private void init() {
		createButton = new JButton("CREATE");
		createButton.setOpaque(true);
		createButton.setBackground(Color.RED);
		createButton.setForeground(Color.WHITE);
		createButton.setBorderPainted(false);
		
		Font createButtonFont = new Font(createButton.getFont().getName(), Font.BOLD, createButton.getFont().getSize());
		createButton.setFont(createButtonFont);
		
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				handler.createEvent();
			}
		});
		
		dateLabel = new JLabel("Date", SwingConstants.LEFT);
		dateLabel.setBorder(new EmptyBorder(4, 4, 4, 0));
		calendarView = new CalendarView(handler);
		
		add(createButton);
		add(dateLabel);
		add(calendarView);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setAlignmentX(LEFT_ALIGNMENT);
	}
	
	/**
	 * Sets the data of the calendar
	 * @param calendarData data of calendar
	 */
	public void setData(CalendarData calendarData) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");

		GregorianCalendar calendar = calendarData.getGregorianCalendar();
				
		dateLabel.setText(sdf.format(calendar.getTime()));
		calendarView.setData(calendarData);
	}	
}