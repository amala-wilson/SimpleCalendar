import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * This class defines the header view portion of the entire calendar application which includes the left, right, and
 * quit buttons
 * @author amalachirayil
 *
 */
public class HeaderView extends JPanel{
	
	// Defining the different components that are part of the header view
	private LeftRightButtonView leftPanel;
	private QuitButtonView quitButton;
	private ActionHandler handler;
	
	/**
	 * Constructs a HeaderView object
	 * @param handler
	 */
	public HeaderView(ActionHandler handler) {
		this.handler = handler;
		init();
	}
	
	/**
	 * Initializes the header view
	 */
	private void init() {
		leftPanel = new LeftRightButtonView(handler);	
		quitButton = new QuitButtonView(handler);
		
		add(leftPanel);
		add(quitButton);
		
		setLayout(new GridLayout(1, 2));
	}
}