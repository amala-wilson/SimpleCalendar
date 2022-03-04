import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class defines each of the rows in the event panel
 * @author amalachirayil
 *
 */
public class EventRow extends JPanel{
	
	// Component that makes up the event row
	private JLabel label;
	
	/**
	 * Constructor that constructs the EventRow object
	 */
	public EventRow() {
		label = new JLabel();

		add(label);

		setPreferredSize(new Dimension(300, 30));		
		setBackground(Color.LIGHT_GRAY);
	}
	
	/**
	 * Sets the label of the event row
	 * @param txt
	 */
	public void setLabel(String txt) {
		label.setText(txt);
	}
	
	/**
	 * Clears the event row
	 */
	public void clear() {
		label.setText("");
	}
}