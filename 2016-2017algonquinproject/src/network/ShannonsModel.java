/*
 * lab3
 * package network
 * ShannonsModel.java
 */
package network;

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Observable;

/**
 * Class for encapuslate the date of shannons calculation
 * This class is the model in this project
 * 
 * @author wang,Tao
 * @version 1.0
 */
public class ShannonsModel extends Observable {
	/**
	 * private double B stand for bandwidth
	 */
	private double bandWidth;
	/**
	 * private double SNR stand for Signal To Noise
	 */
	private double signalToNoise;

	/**
	 * private decimalFormat df stand for the format of the double result
	 */
	private DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Method getter of Bandwidth
	 * 
	 * @return Bandwidth
	 */
	public double getBandwidth() {
		return bandWidth;
	};

	/**
	 * Method to get SignalToNoise
	 * 
	 * @return SignaltoNoise
	 */
	public double getSignalToNoise() {
		return signalToNoise;
	}

	/**
	 * Method to get maximum data rate
	 * 
	 * @param hertz
	 *            The Value of bandWidth
	 * @param SNR
	 *            The value of SNR
	 * @return Return the value of maximum data rate
	 */

	private double getMaxinumDataRate(double hertz, double SNR) {
		// define a double variable of mdr
		double mdr = 0;
		// computering a mdr
		mdr = hertz * (Math.log(1 + Math.pow(10, SNR / 10)) / Math.log(2));
		// return mdr
		return mdr;
	}

	/**
	 * Method to getter of MDR
	 * 
	 * @return MaxinumDataRate
	 */
	public double getMaxinumDataRate() {
		// call overloading method
		return getMaxinumDataRate(bandWidth, signalToNoise);
	}

	// setters
	/**
	 * Method to set the Bandwidth
	 * 
	 * @param bindWidth
	 *            The value of bindwidth
	 */
	public void setBandwidth(double bandWidth) {
		if (bandWidth < 0)
			throw new NumberFormatException();

		// set the value of bindWidth
		this.bandWidth = bandWidth;
		//if bandwidth changed, notify all observers
		setChanged();
		notifyObservers();
	}

	/**
	 * Method to set SignalToNoise
	 * 
	 * @param signalToNoise
	 *            value of signalToNoise
	 */
	public void setSignalToNoise(double signalToNoise) {
		// set the value of SNR

		this.signalToNoise = signalToNoise;
		//if snr changed, notify all observers
		setChanged();
		notifyObservers();
	}

	/**
	 * constructor of ShannonsModel
	 */
	public ShannonsModel() {
	}

	/**
	 * return the result of string format of maximum data rate
	 * 
	 * @return result String of result
	 */
	@Override
	public String toString() {
		// return a value of the max data rate
		return "The result of Max Data Rate is " + df.format(getMaxinumDataRate());
	}
}
