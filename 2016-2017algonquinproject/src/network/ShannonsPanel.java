
/*
 * Lab3
 * network package
 * ShannonsTheorem.java
 * This java file extends from ShannonsModel.java 
 */

package network;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *Abstract CLass data for the view of the shannons theorem
 * baNdwidth and SNR to calculate the value of max data rate
 * This class has three subclasses.
 * @author wang,Tao
 * @version 1.0
 */
public abstract class ShannonsPanel extends JPanel implements Observer {

	/**
	 * private serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * A JLabel for show the max data rate
	 */
	private JLabel maxDataRateLBL = new JLabel("Max data rate is?");

	/**
	 * Constructor
	 * @param ctl ShannonsController
	 * 
	 * */
	public ShannonsPanel(ShannonsController ctl) {
		// TODO Auto-generated constructor stub
		setController(ctl);
	}


	/**
	 * 
	 * Method for set the controller
	 * @param ctl ShannonsController
	 */
	public abstract void setController(ShannonsController ctl);
	/**
	 * Method for get a label to show the value of max data rate
	 * 
	 * @return return a label of maxdatarate
	 * 
	 */
	public JLabel getMaxDataRateLBL() {
		// set the font size of the label
		maxDataRateLBL.setFont(new Font("Serif", Font.PLAIN, 20));
		return maxDataRateLBL;
	}

	/**
	 * Method for set the label of max data rate
	 */
	public void setMaxDataRateLBL(JLabel mdrlbl) {
		// set max data rate label
		this.maxDataRateLBL = mdrlbl;
	}

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
	public abstract void update(Observable o, Object arg);
	/**
	 * Method for initialize the GUI
	 * 
	 */
	public abstract void initGUI();
	/**
	 * Method for creating the JPanel of snr
	 * 
	 * @return return a JPanel object of signal noise rate
	 */
	public abstract JPanel createSignalToNoisePanel();
	/**
	 * Method for creating a JPanel object
	 * 
	 * @return return a JPanel for the band width
	 */
	public abstract JPanel createBandWidthPanel();



}
