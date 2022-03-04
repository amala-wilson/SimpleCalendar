import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class defines the a portion of the view of the components displayed in the header view which 
 * includes the previousButton and nextButton
 * @author amalachirayil
 *
 */
public class LeftRightButtonView extends JPanel{
	
	// Declaring the components defined in the left right button view
	private JButton previousButton;
	private JButton nextButton;
	private ActionHandler handler;
	
	/**
	 * Constructor that constructs a LeftRightButtonView object
	 * @param handler - ActionHandler object
	 */
	public LeftRightButtonView(ActionHandler handler) {
		this.handler = handler;
		init();
	}
	
	/**
	 * Initializes the view of the LeftRightButtonView with added functionlity for each of the buttons
	 */
	private void init() {
		previousButton = new JButton("<");
		previousButton.setPreferredSize(new Dimension(40, 40));
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.moveCalenderLeft();
			}
		});
		
		nextButton = new JButton(">");
		nextButton.setPreferredSize(new Dimension(40, 40));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.moveCalenderRight();
			}
		});
		
		add(previousButton);
		add(nextButton);
	}
}