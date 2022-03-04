import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

/**
 * This class defines the different components that make up the event dialog box which appears when the create button
 * is clicked upon
 * @author amalachirayil
 *
 */
public class EventDialog{
	
	// Components that make up the event dialog box
	private JDialog dialog;
	private JPanel view;
	private JTextField textField;
	private JTextField textFrom;
	private JButton saveButton;
	private JTextField dateTextField;
	private JTextField eventTextField;
	
	private ActionHandler handler;
	
	/**
	 * Constructor that constructs the EventDialog object
	 * @param mainView - calendar app view
	 * @param handler - Action Handler object
	 */
	public EventDialog(CalendarAppView mainView, ActionHandler handler) {
		this.view = new JPanel();
		this.handler = handler;
		
		dialog = new JDialog();
		dialog.setSize(new Dimension(400, 100));
		dialog.add(view);
		
		createUI();
		
		dialog.setTitle("Create Event");
		dialog.setLocationRelativeTo(mainView);
        dialog.setModal(true);
        dialog.setVisible(false);
        dialog.setAlwaysOnTop(true);    
	}
	
	/**
	 * Displays the date the user clicked on
	 * @param date - user clicked date
	 */
	public void show(String date) {
		dateTextField.setText(date);
		dateTextField.setEnabled(false);
		eventTextField.setText("");
		
		dialog.setVisible(true);
	}
	
	/**
	 * Functionality that hides the event dialog box after the user clicks on the save button
	 */
	public void hide() {
		dialog.setVisible(false);
	}
	
	/**
	 * Creates the UI for the user to create an event
	 */
	private void createUI() {
		JPanel topView = new JPanel();
		JPanel buttonPanel = new JPanel();
				
		eventTextField = new JTextField(30);
		
		topView.add(eventTextField);
		topView.add(buttonPanel);
		
		BoxLayout boxLayout = new BoxLayout(topView, BoxLayout.PAGE_AXIS);
		topView.setLayout(boxLayout);
		
		dateTextField = new JTextField(7);		
		textFrom = new JTextField(7);
		
		JLabel lblTo = new JLabel("to");
		
		textField = new JTextField(7);
		
		textFrom.setText("09:00 AM");
		textField.setText("10:00 AM");
		
		saveButton = new JButton("SAVE");
		
		buttonPanel.add(dateTextField);
		buttonPanel.add(textFrom);
		buttonPanel.add(lblTo);
		buttonPanel.add(textField);
		buttonPanel.add(saveButton);
		
		this.view.add(topView);
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				handler.addEvent(eventTextField.getText(), 
						dateTextField.getText(), 
						textFrom.getText(),
						textField.getText());
				hide();
			}
		});
	}
}