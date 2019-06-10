package shannons.jfx_version;

import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class TextPanel extends VBox implements Observer {

	public final static String strB = "Please enter the Band width in hertz";
	public final static String strS = "Please enter the Signal Noise Rate in DB";
	private final Label labelB = new Label(strB);
	private final Label labelS = new Label(strS);
	private Label labelR = new Label();
	private TextField textB = new TextField();
	private TextField textS = new TextField();
	double band, signal;

	@Override
	public void update(Observable o, Object arg1) {
		ShannonsModel model = (ShannonsModel) o;
		if (model instanceof ShannonsModel) {
			textB.setText(model.getBandwidth() + "");
			textS.setText(model.getSignalToNoise() + "");
			labelR.setText(
					"BandWidth: " + model.getBandwidth() + " snr: " + model.getSignalToNoise() + model.toString());
		}
	}

	ShannonsController controller;

	public TextPanel(ShannonsController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {

		this.getChildren().addAll(rateDisplay(), entryB(), entryS());
		this.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	}

	private Node entryS() {
		HBox hb = new HBox();
		
		textS.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				try {
					signal = Double.parseDouble(arg2);
					controller.setSignalToNoise(signal);
				} catch (Exception ex) {
					labelR.setText("SNR must be a number, enter the correct value.");
				}
			}
		});
		hb.setSpacing(10);
		hb.setPadding(new Insets(10));
		hb.getChildren().addAll(labelS, textS);
		return hb;
	}

	private Node entryB() {
		HBox hb = new HBox();
		textB.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				
				try {
					band = Double.parseDouble(arg2);
					controller.setBandWidth(band);
				} catch (Exception ex) {
					labelR.setText("Band width must be a positive number, enter the correct value.");
				}
				
			}
		});
		hb.setSpacing(10);
		hb.setPadding(new Insets(10));
		hb.getChildren().addAll(labelB, textB);
		return hb;
	}

	private Node rateDisplay() {
		// TODO Auto-generated method stub
		HBox hb = new HBox();
		labelR.setText("BandWidth: " + band + " snr: " + signal + "The result of Max Data Rate is: " + 0);
		hb.getChildren().add(labelR);
		return hb;
	}
}
