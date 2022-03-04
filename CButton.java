import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class defines the functionality of the create Button displayed on the Calendar View
 * @author amalachirayil
 *
 */
public class CButton extends JButton implements ActionListener {
	
	// Defining the day and Action Handler attributes of the create button
	int day;
	private ActionHandler handler;
	
	/**
	 * Constructor that constructs CButton object
	 * @param msg
	 */
	public CButton(String msg) {
		super(msg);
	}
	
	/**
	 * Consutructor that constructs CButton object
	 * @param day - day the user clicked on to set event
	 * @param handler - Action Handler object
	 */
	public CButton(int day, ActionHandler handler) {
		super();
		
		this.day = day;
		this.handler = handler;
		
		addActionListener(this);
	}
	
	/**
	 * Sets the day the user clicked on
	 * @param day - day
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * Retrieves the day
	 * @return
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Defines the action performed by this button
	 */
	public void actionPerformed(ActionEvent e) {
		if(handler != null) {
			handler.updateDay(getDay());
		}
	}
}