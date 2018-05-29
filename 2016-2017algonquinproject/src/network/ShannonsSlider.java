/*
 * Lab3
 * network package
 * ShannonsSlider.java
 * This java file extends from ShannonsPanel.java 
 */
package network;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * class of the view and extends from JPanel and this is the second kind of view.
 * This view allow user to slide the value of band and snr to get the value of mdr
 * in a bar chart 
 * 
 * @author Wang,Tao
 * @version 1.0
 */
public class ShannonsSlider extends ShannonsPanel{

	/**
	 * private variable for serialVersionID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * private variables for store the values of bandwidth and snr
	 * */
	private double band, snr;

	/**
	 * ShnnonsController type reference variable
	 * */
	private ShannonsController controller ;

	/**
	 * An object of JSlider for bandwidth value 
	 */
	private JSlider sliderBand ;

	/**
	 *  An object of JSlider for snr
	 */
	private JSlider sliderSNR ;
     
	/**
	 * 
	 *chart object of shannons 
	 */
     private JFreeChart chart;
     
     /**
      *data set for shannons 
      */
     private DefaultCategoryDataset dataset;

	/**
	 * Constructor
	 * @param ctl ShannonsController
	 * */
public ShannonsSlider(ShannonsController ctl) {
		// TODO Auto-generated constructor stub
		super(ctl);
		//super();
		setController(ctl);
		initGUI();
	}
	/**
	 * 
	 * Method for set the controller
	 * @param ctl ShannonsController
	 */
	public void setController(ShannonsController ctl){
		this.controller=ctl;
	}

	/**
	 * Method for initialize the GUI
	 * 
	 */
	public void initGUI(){
        JPanel panel=new JPanel();
		// load all subcomponents into the second calculator panel
		//this.add(getMaxDataRateLBL());
		panel.add(createBandWidthPanel());
		panel.add(createSignalToNoisePanel());
		panel.setLayout(new GridLayout(2,1));
		this.add(panel);
		this.add(graphOfShannons());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
		// set the layout for the panel
		this.setLayout(new GridLayout(1, 2, 5, 5));
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
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		// check if the observable is an instance of ShannonsMode
		if (o instanceof ShannonsModel) {
			try{
				ShannonsModel model = (ShannonsModel) o;
				// nofity the observer and show the new result
				getMaxDataRateLBL().setText("BandWidth : " + model.getBandwidth() + "  snr : " + model.getSignalToNoise() + ". " + model.toString());
				sliderBand.setValue((int)model.getBandwidth());
				sliderSNR.setValue((int)model.getSignalToNoise());
				//set the value of the bar chart
				dataset.setValue(model.getBandwidth(), "values", "Band Width");
				dataset.setValue(model.getSignalToNoise(), "values", "Signal noise rate");
				dataset.setValue(model.getMaxinumDataRate(), "values", "Max data rate");
	
				
			}
			catch(Exception e){
				e.getMessage();
			}
		}


	}
	/**
	 * Method for creating the JPanel of snr
	 * 
	 * @return return a JPanel object of signal noise rate
	 */
	@Override
	public JPanel createSignalToNoisePanel() {
		// TODO Auto-generated method stub
		//create a panel for snr slider
		JPanel panel=new JPanel();
		//create label for snr
		JLabel labelSNR = new JLabel("Please Slides the Signal Noise Rate in DB");
		labelSNR.setFont(new Font("Serif", Font.PLAIN, 20));
		sliderSNR = new JSlider(JSlider.HORIZONTAL, -1000, 1000, 0);

		// set the ticks for the signal noise rate slider
		sliderSNR.setMajorTickSpacing(200);
		sliderSNR.setMinorTickSpacing(20);
		sliderSNR.setPaintTicks(true);
		sliderSNR.setPaintLabels(true);
		// set the listener of the snr slider
		sliderSNR.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				// get the value of snr from slider
				JSlider source = (JSlider) e.getSource();
				snr = source.getValue();
				// set the value of snr
				controller.setSignalToNoise(snr);

			}
		});
		//Add all components into panel
		panel.add(labelSNR);
		panel.add(sliderSNR);
		panel.setLayout(new GridLayout(2,1,0,0));
		//panel.setBackground(Color.WHITE);
        //panel.setBorder(BorderFactory.createLineBorder(Color.black));

		return panel;
	}
	/**
	 * Method for creating a JPanel object
	 * 
	 * @return return a JPanel for the band width
	 */
	@Override
	public JPanel createBandWidthPanel() {
		// TODO Auto-generated method stub
		//create a Jpanel for the Jslider
		JPanel panel=new JPanel();
		//create a label for band width
		JLabel labelBand = new JLabel("Please slides the Band width in hertz ");
		labelBand.setFont(new Font("Serif", Font.PLAIN, 20));
		sliderBand = new JSlider(JSlider.HORIZONTAL, 0, 100000, 0);
		// set the ticks for the band width slider
		sliderBand.setMajorTickSpacing(10000);
		sliderBand.setMinorTickSpacing(1000);
		sliderBand.setPaintTicks(true);
		sliderBand.setPaintLabels(true);
		// set the listener for the band slider
		sliderBand.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				// get the value of band width from the slider
				JSlider source = (JSlider) e.getSource();
				band = source.getValue();
				// set the value of band
				controller.setBandWidth(band);

			}
		});
		//add all sub component into panel
		panel.add(labelBand);
		panel.add(sliderBand);
		panel.setLayout(new GridLayout(2,1,5,5));
		//panel.setBackground(Color.WHITE);
       // panel.setBorder(BorderFactory.createLineBorder(Color.black));

		return panel;
	}
	/**
	 * Method for create a chart graph
	 * @return graphOfShannons
	 *         return a Barchart
	 * */
	public ChartPanel graphOfShannons (){

		//create a dataset
		dataset=new DefaultCategoryDataset();
		dataset.addValue(0, "values", "Band Width");
		dataset.addValue(0, "values", "Signal noise rate");
		dataset.addValue(0, "values", "Max data rate");
		//create a bar chart
	    chart =ChartFactory.createBarChart3D("Shannons Theorem", "Results", "values", dataset, PlotOrientation.VERTICAL, false, false, false);
		ChartPanel frame=new ChartPanel(chart);
		//create a panel for load the chart
		frame.setVisible(true);
        frame.setBorder(BorderFactory.createLineBorder(Color.black));
        return frame;
	}
}
