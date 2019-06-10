package shannons.jfx_version;

import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SliderPanel extends HBox implements Observer {

	final static Label labelB = new Label("Please slides the Band Width in hertz");
	final static Label labelS = new Label("Please slides the SNR in DB");
	Slider sliderB = new Slider(0,100000,0);
	Slider sliderS = new Slider(-1000,1000,0);
	double band, snr;
	final CategoryAxis xAxis = new CategoryAxis();
	final NumberAxis yAxis = new NumberAxis();
	
	@SuppressWarnings("rawtypes")
	XYChart.Series series;
	
	BarChart<String, Number> bc;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		ShannonsModel model = (ShannonsModel)o;
		if (model instanceof ShannonsModel) {
			try {
			sliderB.setValue(model.getBandwidth());
			sliderS.setValue(model.getSignalToNoise());
			
			series= new XYChart.Series();
			series.getData().add(new XYChart.Data("Band Width", model.getBandwidth()));
			series.getData().add(new XYChart.Data("SNR", model.getSignalToNoise()));
			series.getData().add(new XYChart.Data("Max rate",model.getMaxinumDataRate()));
			bc.getData().remove(0);
			bc.getData().add(series);
			}catch(Exception e) {}
		}

	}
	ShannonsController controller;

	public SliderPanel(ShannonsController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		// TODO Auto-generated method stub
		this.getChildren().add(slidePane());
		this.getChildren().add(chartPane());
		this.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Node chartPane() {
		// TODO Auto-generated method stub
		

		xAxis.setLabel("Results");
		yAxis.setLabel("Values");
		bc = new BarChart<String, Number>(xAxis, yAxis);
		
		bc.setTitle("Shannons Theorem");
		
		series= new XYChart.Series();
		series.getData().add(new XYChart.Data("Band Width", 0));
		series.getData().add(new XYChart.Data("signal", 0));
		series.getData().add(new XYChart.Data("Max Rate", 0));

		bc.getData().add(series);
		return bc;
	}

	private Node slidePane() {
		VBox vb = new VBox();
		sliderB.setMajorTickUnit(10000);
		sliderB.setMinorTickCount(1000);
		sliderB.setShowTickLabels(true);
		sliderB.setShowTickMarks(true);
		sliderB.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				band = (Double)arg2;
				controller.setBandWidth(band);
			}});
		
		sliderS.setMajorTickUnit(200);
		sliderS.setMinorTickCount(20);
		sliderS.setShowTickLabels(true);
		sliderS.setShowTickMarks(true);
		
		sliderS.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				snr = (Double)arg2;
				controller.setSignalToNoise(snr);
			}});
		vb.getChildren().addAll(labelB,sliderB, labelS,sliderS);
		vb.setSpacing(10);
		vb.setPadding(new Insets(10));
		return vb;
	}

}
