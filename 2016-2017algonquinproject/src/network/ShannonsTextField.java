/*
 * lab3 project
 * package network
 * ShannonsTextField.java 
 * This class is for loading three kind of calcualtors One
 * is the textfield input, one is the slider, and one is an "+" /"-" counter.
 * Any value of the three calcualtors content changed, the observer will be nofitied and make the change
 * to the max data rate based on the new state.
 */
package network;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * class of the view and extends from JPanel.
 * This is the first kind of view for the shannons theorem.
 * This view allow user type the value of the band and snr
 * and show the result of mdr in the JLabel.
 * 
 * @author Wang,Tao
 * @version 1.0
 */
public class ShannonsTextField extends ShannonsPanel {

	/**
	 * A long serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A ShannonsController for store the value of a shannoncontroller or
	 * subclass object
	 * 
	 */
	private ShannonsController controller;

	/**
	 * Text Field for snr 
	 */
	private JTextField textOfSNR;

	/**
	 *Text Field for band width 
	 */
	private JTextField textOfBand;

	/**
	 * Method implemented for observer interface, for updating the changes to
	 * the observers
	 * 
	 * @param o
	 *            observable object
	 * @param arg
	 *            Object
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		// check if the observable is an instance of ShannonsModel
		if (o instanceof ShannonsModel) {
			try{
				ShannonsModel model = (ShannonsModel) o;
				// nofity the observer and show the new result
				getMaxDataRateLBL().setText("BandWidth : " + model.getBandwidth() + "  snr : " + model.getSignalToNoise() + ". " + model.toString());
				textOfBand.setText(new Double(model.getBandwidth()).toString());
				textOfSNR.setText(new Double(model.getSignalToNoise()).toString());
			}
			catch(Exception e){
				e.getMessage();
			}
		}
	}


	/**
	 * 
	 * Method for set the controller
	 * @param ctl ShannonsController
	 */
	public void setController(ShannonsController ctl) {
		// set controller
		this.controller = ctl; 
	}

	/**
	 * Method for initialize the GUI
	 * 
	 */
	public void initGUI() {
		//add components into this panel
		this.add(getMaxDataRateLBL());
		this.add(createBandWidthPanel());
		this.add(createSignalToNoisePanel());
		// set the shannonspanel background and layout
        this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(new GridLayout(3, 1, 10, 10));

	}



	/**
	 * Method for creating the JPanel of snr
	 * 
	 * @return return a JPanel object of signal noise rate
	 */
	@Override
	public JPanel createSignalToNoisePanel() {
		// create a panel for the snr
		JPanel pane = new JPanel();
		// label for notify user
		JLabel label = new JLabel("Please enter the Signal Noise Rate in DB ");
		label.setFont(new Font("Serif", Font.PLAIN, 25));
		// text field for snr
		textOfSNR = new JTextField(30);
		textOfSNR.setText("0");

		textOfSNR.setEditable(true);
		// load all subcomponents into the panel of band width
		pane.add(label);
		pane.add(textOfSNR);
		// set listener for the textfield of snr
		/**
		 * Inner class for update the insert value
		 * 
		 * @author Wang,Tao
		 */
		textOfSNR.getDocument().addDocumentListener(new DocumentListener() {

			/**
			 * Method for update value change
			 * @param e DocumentEvent object
			 * */
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				// call update method of inner class
				update();
			}
			/**
			 * Method for update value change
			 * @param e DocumentEvent object
			 * */
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				// call update method of inner class
				update();
			}
			/**
			 * Method for update value change
			 * @param e DocumentEvent object
			 * */
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				// call update method of inner class
				update();

			}

			public void update() {

				try {
					// get value from user input and catch exceptions

					controller.setSignalToNoise(Double.parseDouble(textOfSNR.getText()));

				} catch (NumberFormatException e) {
					//notify user for errors
					getMaxDataRateLBL().setText("Signal Noise Rate must be a number");
				}
			}
		}

				);
		//pane.setBackground(Color.white);

		return pane;

	}

	/**
	 * Method for creating a JPanel object
	 * 
	 * @return return a JPanel for the band width
	 */
	@Override
	public JPanel createBandWidthPanel() {
		// panel for the band width
		JPanel pane = new JPanel();
		// label for notify the user to input
		JLabel label = new JLabel("Please enter the Band width in hertz ");
		label.setFont(new Font("Serif", Font.PLAIN, 25));
		// text field for band width
		textOfBand = new JTextField(30);
		textOfBand.setText("0");
		// load subcomponents into panel
		pane.add(label);
		pane.add(textOfBand);
		// set listener for the textfield of band width
		/**
		 * Inner class for implement document listenner
		 * @author Wang,Tao
		 * */
		textOfBand.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Method for update value change
			 * @param e DocumentEvent object
			 * */
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				// call update method of inner class
				update();

			}
			/**
			 * Method for update value change
			 * @param e DocumentEvent object
			 * */
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				// call update method of inner class
				update();

			}
			/**
			 * Method for update value change
			 * @param e DocumentEvent object
			 * */
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				// call update method of inner class
				update();

			}

			/**
			 * Method for update the value changed
			 */
			public void update() {
				try {
					//get value from user input

					controller.setBandWidth(Double.parseDouble(textOfBand.getText()));

				} catch (NumberFormatException e) {
					//notify user for errors
					getMaxDataRateLBL().setText("Band width must be a positive number");
				}
			}
		});
		//pane.setBackground(Color.white);
		return pane;
	}

	/**
	 * Constructor of ShannonsPanel
	 * 
	 * @param ctl
	 *            An ShannonsController referenced variable
	 * 
	 */
	public ShannonsTextField(ShannonsController ctl) {
		super(ctl);
		// set the controller
		setController(ctl);
		// initialize the GUI
		initGUI();

	}

}
