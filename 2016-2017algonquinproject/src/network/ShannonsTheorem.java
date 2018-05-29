/*
 * Lab3
 * network package
 * ShannonsTheorem.java
 * This java file extends from ShannonsModel.java 
 */
package network;

import java.awt.GridLayout;
import java.util.Observer;
import javax.swing.JFrame;

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
	 * Method of main, start point of the program
	 * 
	 * @param args String value
	 */
	public static void main(String[] args) {
	     // create an new shannonsTheorem object and call the initGUI Method
	    ShannonsTheorem theorem=new ShannonsTheorem();
		theorem.initGUI();
	}
		
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
	/**
	 *Method for initialize the GUI of this project 
	 */
	private  void initGUI(){
		// create an new theorem object and load it into the new shannonspanel object
		//ShannonsTheorem theorem=new ShannonsTheorem();
		ShannonsTextField panel1=new ShannonsTextField(this);
		ShannonsSlider panel2=new ShannonsSlider(this);
		ShannonsCounter panel3=new ShannonsCounter(this);
        // register an new observer for this ShannonsModel object
		this.addObserver(panel1);
		this.addObserver(panel2);
		this.addObserver(panel3);
		//create a new frame
		JFrame frame= new JFrame();
		//add the shannonspanel object into the frame object
		frame.add(panel1);
		frame.add(panel2);
		//frame.add(panel2.graphOfShannons());
		frame.add(panel3);
		//frame.add(panel3.getPanelOfMdr());
		
		//set the properties of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLayout(new GridLayout(3,1,5,5));;
		//set the postion of window shown in screen
		frame.setBounds(500, 50, 1200, 600);
		
	}
}
