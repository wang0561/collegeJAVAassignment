package shannons.jfx_version;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(homepage(), 800,800);
		stage.setTitle("Shannons Theorem");
		stage.setScene(scene);
		stage.show();
	}

	private Parent homepage() {
		VBox vb = new VBox();
		ShannonsTheorem controller = new ShannonsTheorem();
		TextPanel p1 = new TextPanel(controller);
		SliderPanel p2 = new SliderPanel(controller);
		MeterPanel p3 = new MeterPanel(controller);
		controller.addObserver(p1);
		controller.addObserver(p2);
		controller.addObserver(p3);
		vb.getChildren().addAll(p1,p2,p3);
		vb.setSpacing(10);
		vb.setPadding(new Insets(10));
		vb.setStyle("-fx-background-color: #ffffff;" + "-fx-border-style:solid inside;" + "-fx-border-width:3;");
		return vb;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
