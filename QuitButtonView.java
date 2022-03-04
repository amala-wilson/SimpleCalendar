import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class defines the quit button view portion of the header view
 * @author amalachirayil
 *
 */
public class QuitButtonView extends JPanel{
	
	// Components that make up the quitbuttonview
	private JButton quitBtn;
	private ActionHandler handler;
	
	/**
	 * Constructor that constructs the QuitButtonView object
	 * @param handler - ActionHandler object
	 */
	public QuitButtonView(ActionHandler handler) {
		this.handler = handler;
		init();
	}
	
	/**
	 * Initializes the view of the quit button with added functionality
	 */
	private void init() {
		quitBtn = new JButton("Quit");
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.quit();
			}
		});
		
		add(quitBtn);	
	}
}