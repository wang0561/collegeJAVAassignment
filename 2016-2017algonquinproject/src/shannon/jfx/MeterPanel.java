package shannons.jfx_version;

import java.util.Observable;
import java.util.Observer;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MeterPanel extends HBox implements Observer {

	final Label labelB = new Label("Band Width");
	final Label labelS = new Label("SNR");
	Label valueB = new Label("0.0");
	Label valueS = new Label("0.0");
	Button btnB1 = new Button("+");
	Button btnB2 = new Button("-");
	Button btnS1 = new Button("+");
	Button btnS2 = new Button("-");
	double band, snr;
	Gauge gauge ;
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		ShannonsModel model = (ShannonsModel) o;
		if (model instanceof ShannonsModel) {
			band = model.getBandwidth();
			snr = model.getSignalToNoise();
			valueB.setText(model.getBandwidth() + "");
			valueS.setText(model.getSignalToNoise() + "");
			gauge.setValue(model.getMaxinumDataRate());
		}
	}

	ShannonsController controller;

	public MeterPanel(ShannonsController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		this.getChildren().addAll(counterPane(), meterPane());
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

	private Node counterPane() {
		GridPane gp = new GridPane();
		btnB1.setOnAction(e -> {
			band += 500;
			controller.setBandWidth(band);
		});
		btnB2.setOnAction(e -> {
			if (band > 500) {
				band -= 500;
				controller.setBandWidth(band);
			}else if(band<=500 && band>0){
				band = 0;
				controller.setBandWidth(band);
			}
		});
		btnS1.setOnAction(e -> {
			snr += 30;
			controller.setSignalToNoise(snr);
		});
		btnS2.setOnAction(e -> {
			snr -= 30;
			controller.setSignalToNoise(snr);
		});
		btnB1.setMinWidth(100);
		btnB2.setMinWidth(100);
		btnS1.setMinWidth(100);
		btnS2.setMinWidth(100);
		valueB.setMinWidth(100);
		valueB.setMaxWidth(100);
		valueS.setMinWidth(100);
		valueS.setMaxWidth(100);
		
		gp.add(labelB, 0, 0);
		gp.add(btnB1, 1, 0);
		gp.add(valueB, 2, 0);
		gp.add(btnB2, 3, 0);

		gp.add(labelS, 0, 1);
		gp.add(btnS1, 1, 1);
		gp.add(valueS, 2, 1);
		gp.add(btnS2, 3, 1);

		return gp;
	}

	private Node meterPane() {

		// TODO Auto-generated method stub
		
	    gauge= GaugeBuilder.create().skinType(Gauge.SkinType.SLIM)
                .title("Max Rate").decimals(0).maxValue(100000).value(0.0)
                .build();  
	    gauge.setBarColor(Color.rgb(77, 208, 255));  
        gauge.setBarBackgroundColor(Color.rgb(39,44,50));  
        gauge.setAnimated(true);
	    VBox vb = new VBox();
	    vb.getChildren().add(gauge);
		return vb;
	}
	
}
