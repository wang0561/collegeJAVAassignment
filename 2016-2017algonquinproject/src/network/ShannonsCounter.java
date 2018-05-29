/*
 * Lab3
 * network package
 * ShannonsCounter.java
 * This java file extends from ShannonsPanel.java 
 */
package network;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
/**
 * class of the view and extends from JPanel, the third
 * method for showing the result of shannons theorem in a 
 * line chart
 * 
 * @author Wang,Tao
 * @version 1.0
 */
public class ShannonsCounter extends ShannonsPanel {

	
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

	/*
	 * label of the band width value
	 */
	private JLabel labelBand ;

	/*
	 *label of the snr value 
	 */
	private JLabel labelSNR;

	/** The meter chart (dial). */
	private JFreeChart meterchart ;
	/** The dataset. */
	private DefaultValueDataset data ;

	/** The meter plot (dial). */
	private MeterPlot plot;


	/**
	 * Constructor
	 * @param ctl ShannonsController
	 * */
	public ShannonsCounter(ShannonsController ctl) {
		// TODO Auto-generated constructor stub
		super(ctl);
		//super();
		setController(ctl);
		initGUI();
	}
	/**
	 * 
	 * Method for set the controller
	 */
	public void setController(ShannonsController ctl){
		this.controller=ctl;
	}

	/**
	 * Method for initialize the GUI
	 * 
	 */
	@Override
	public void initGUI(){
          JPanel panel=new JPanel();
		// add the two panel into the third panel of calculator
		//this.add(getMaxDataRateLBL());
		panel.add(createBandWidthPanel());
		panel.add(createSignalToNoisePanel());
		// set background and layout for the calculator panel
		//this.setBackground(Color.white);
		panel.setLayout(new GridLayout(2,1));
		this.add(panel);
		this.add(getPanelOfMdr());
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
		// check if the observable is an instance of ShannonsModel
		if (o instanceof ShannonsModel) {
			try{
				ShannonsModel model = (ShannonsModel) o;
				// nofity the observer and show the new result
				super.getMaxDataRateLBL().setText("BandWidth : " + model.getBandwidth() + "  snr : " + model.getSignalToNoise() + ". " + model.toString());
				labelBand.setText(new Double(model.getBandwidth()).toString());
				labelSNR.setText(new Double(model.getSignalToNoise()).toString());
				data.setValue(model.getMaxinumDataRate());
			}catch(Exception e){e.getMessage();}
		}
	}
	/**
	 * Method for creating a JPanel object
	 * 
	 * @return return a JPanel for snr
	 */
	@Override
	public JPanel createSignalToNoisePanel() {
		// TODO Auto-generated method stub
		//create panel for snr
		JPanel panel = new JPanel();
		// label for showing the current snr
		JLabel label = new JLabel("set the signal noise rate");
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		// create four buttons for counter the snr
		JButton buttonPlus = new JButton("+");
		JButton buttonSub = new JButton("-");

		buttonPlus.setFont(new Font("Serif", Font.PLAIN, 20));
		buttonSub.setFont(new Font("Serif", Font.PLAIN, 20));
		// create  label for show the snr
		labelSNR = new JLabel("0");

		// load all subcomponents for the signal noise rate
		panel.add(label);
		panel.add(buttonPlus);
		panel.add(labelSNR);
		panel.add(buttonSub);
		panel.setLayout(new GridLayout(1,4));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));

		//panel.setBackground(Color.WHITE);

		// set button listener
		buttonPlus.addActionListener(e -> {
			// if button clicked, the snr incremented by 10
			snr = Double.parseDouble(labelSNR.getText());
			snr += 100;
			// set the value of snr
			controller.setSignalToNoise(snr);
			labelSNR.setText(new Double(snr).toString());

		});
		// set button click listener
		buttonSub.addActionListener(e -> {
			// if button clicked, the value of snr will decremented by 10
			snr = Double.parseDouble(labelSNR.getText());
			snr -= 100;
			// set the value of signal noise rate
			controller.setSignalToNoise(snr);
			labelSNR.setText(new Double(snr).toString());

		});
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
		//create panel for band width
		JPanel panel = new JPanel();
		// label for showing the current band width
		JLabel label = new JLabel("Set the band width ");
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		// create four buttons for counter the band width 
		JButton buttonPlus = new JButton("+");
		buttonPlus.setFont(new Font("Serif", Font.PLAIN, 20));
		JButton buttonSub = new JButton("-");
		buttonSub.setFont(new Font("Serif", Font.PLAIN, 20));
		// create label for show the bind width
		labelBand = new JLabel("0");

		// load all subComponents for the band width panel
		panel.add(label);
		panel.add(buttonPlus);
		panel.add(labelBand);
		panel.add(buttonSub);
		panel.setLayout(new GridLayout(1,4));
		//panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		// set the listener for the buttons
		buttonPlus.addActionListener(e -> {
			// if button clicked, band width incremented by 50
			band = Double.parseDouble(labelBand.getText());
			band += 1000;
			// set the band width of the controller
			controller.setBandWidth(band);
			labelBand.setText(new Double(band).toString());

		});
		// set button listener
		buttonSub.addActionListener(e -> {
			band = Double.parseDouble(labelBand.getText());
			// if band is postive, button clicked by decremented of 50
			if (band > 0) {
				band -= 1000;
				controller.setBandWidth(band);
				labelBand.setText(new Double(band).toString());
			}

		});
		return panel;
	}
	
	
	/**
	 * Method for create the panel of max data rate
	 * @return JPanel
	 * */
	public ChartPanel getPanelOfMdr(){
		//set the datasets
		  data = new DefaultValueDataset(0.0);
		
		//create the meter chart
		  plot=new MeterPlot(this.data);
	    //set the properties of the plot
		  plot.setUnits("Max Data Rate");
          plot.setRange(new Range(0,1000000 ));
          plot.setNeedlePaint(Color.darkGray);
          plot.setDialBackgroundPaint(Color.gray);
          plot.setDialOutlinePaint(Color.yellow);
          plot.setDialShape(DialShape.CIRCLE);
          plot.setMeterAngle(260);
          plot.setTickLabelsVisible(true);
          plot.setTickLabelFont(new Font("Dialog", Font.BOLD, 10));
          plot.setTickLabelPaint(Color.red);
          plot.setTickSize(50000.0);
          plot.setTickPaint(Color.yellow);
          plot.setTickLabelFormat(NumberFormat.getCurrencyInstance());
          //create the chart
		  meterchart=new JFreeChart("Value of Max Data Rate",
                JFreeChart.DEFAULT_TITLE_FONT,
                this.plot, false);
		  //load the chart in the panel
		ChartPanel panel=new ChartPanel(meterchart);
		return panel;

	}
}
