/*
 * Lab3
 * network package
 * ShannonsTheorem.java
 * This java file extends from ShannonsModel.java 
 */
package shannons.jfx_version;

import java.util.Observer;

/**
 * CLass data for allow user to enter the value of 
 * bandwidth and SNR to calculate the value of max data rate
 * @author wang,Tao
 * @version 1.0
 */
public class ShannonsTheorem implements ShannonsController{
	/**
	 * private ShannonsModel model
	 * */
	private  ShannonsModel model;
	
		
	/**
	 *  constructor of ShannonsTheorem
	 */
	public ShannonsTheorem() {
		//initilizing the model
		model=new ShannonsModel();
		//set the current model
		setModel(model);
		
		
	}
	/**
	 * Method  getter of Bandwidth
	 * 
	 * @return Bandwidth
	 */
	public double getBandWidth() {
		return getModel().getBandwidth();
	}
	/**
	 * Method to set the Bandwidth
	 * 
	 * @param bindWidth The value of bindwidth
	 */
	public void setBandWidth(double bandWidth) {
		getModel().setBandwidth(bandWidth);
	}
	/**
	 *Method to  get SignalToNoise
	 * 
	 * @return SignaltoNoise
	 */
	public double getSignalToNoise() {
		return getModel().getSignalToNoise();
	}
	/**
	 * Method to set SignalToNoise
	 * 
	 * @param signalToNoise value of signalToNoise
	 */
	public void setSignalToNoise(double signalToNoise) {
		//set the value of SNR
		 getModel().setSignalToNoise(signalToNoise);
	}
	/**
	 * Method to getter of MDR
	 * 
	 * @return MaxinumDataRate
	 */
	public double getMaxinumDataRate() {
		//call overloading method
		return getModel().getMaxinumDataRate();
	}
    /**
     *Method for add an observer
     *@param o an observer object 
     * 
     */
	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
	getModel().addObserver(o);
	
		
	}
	/**
	 *Method for set the current model 
	 *@param model An object of ShannonsModel
	 */
	private void setModel(ShannonsModel model){
		this.model=model;
	}
	/**
	 *Method for getting the current model 
	 */
	private ShannonsModel getModel(){
		return model;
	}
	
}
