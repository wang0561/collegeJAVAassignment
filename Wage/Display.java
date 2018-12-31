package wage.display.javafx;
/*
 * 
 * using "Extract required libraries in to generated jar file"
 * */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;

public class Display extends Application {

	private final static Label Hlabel = new Label("Enter Hours: ");
	private final static Label Rlabel = new Label("Enter Rates: ");
	private final static Label Nlabel = new Label("Enter Name: ");
	private final static Label Alabel = new Label("Enter Age: ");
	private final static Label Glabel = new Label("Gender : ");
	private final static ObservableList<String> options = FXCollections.observableArrayList("Male", "Female", "Other");
	private static final ComboBox<String> Gender = new ComboBox<String>(options);
	private TextField nField = new TextField();
	private TextField hField = new TextField();
	private TextField rField = new TextField();
	private TextField aField = new TextField();
	private GridPane pane1 = new GridPane();
	private static Button button = new Button("Calculate");

	private String name, gender;
	private double hour, rate;
	private int age;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		button.setOnAction(getHandler());
		pane1.setHgap(10);
		pane1.setVgap(10);

		pane1.add(Nlabel, 0, 0);
		pane1.add(Glabel, 0, 1);
		pane1.add(Alabel, 0, 2);
		pane1.add(Hlabel, 0, 3);
		pane1.add(Rlabel, 0, 4);
		pane1.add(button, 0, 5);

		pane1.add(nField, 1, 0);
		pane1.add(Gender, 1, 1);
		pane1.add(aField, 1, 2);
		pane1.add(hField, 1, 3);
		pane1.add(rField, 1, 4);

		Scene scene = new Scene(pane1, 400, 400);
		stage = new Stage();
		stage.setTitle("Enter the Information form:");
		stage.setScene(scene);
		stage.show();

	}

	private EventHandler<ActionEvent> getHandler() {
		// TODO Auto-generated method stub
		return new EventHandler<ActionEvent>() {
			StringBuilder sb = new StringBuilder();
			Person person;
			Wage wage;

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				initData();
				if (checkData()) {

					wage = new Wage(hour, rate);
					person = new Person(wage, name, gender, age);
					Stage stage = new Stage();

					Text text = new Text(person.toString());
					Button button = new Button("Export");
					button.setOnAction(wirteToFile());
					VBox vb = new VBox();
					vb.getChildren().add(text);
					vb.getChildren().add(button);

					Scene scene = new Scene(vb, 400, 300);
					stage.setScene(scene);
					stage.setTitle("Result ");
					stage.show();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Invalid input");
					alert.setContentText("Invalid input, please correct the " + sb.toString());
					sb = new StringBuilder();
					alert.showAndWait();
				}
			}

			private EventHandler<ActionEvent> wirteToFile() {
				// TODO Auto-generated method stub
				return new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String str = person.toString();
						File file = new File(name + ".txt");
						FileOutputStream fis = null;
						/*
						 * if write into excel/csv file, use StringBuider and PrintWriter instead.
						 * 
						 * */
						try {
							if (!file.exists())
								file.createNewFile();
							fis = new FileOutputStream(file);
							byte[] bytes = str.getBytes();
							fis.write(bytes, 0, bytes.length);
						} catch (IOException e) {
							
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Failed");
							alert.setContentText(
									"cannot export the data to the file " + file.getName() + e.getMessage());
							
							alert.showAndWait();
						}finally {
							try {
								fis.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("SUCCESSFUL");
						alert.setContentText("The file " + file.getName() + "has been created.");
						sb = new StringBuilder();
						alert.showAndWait();
					}

				};
			}

			private boolean checkData() {
				boolean correct = true;
				if (name.equals("")) {
					correct = false;
					sb.append("name,");
				}
				if (age == 0) {
					correct = false;
					sb.append("age,");
				}
				if (gender == null) {
					correct = false;
					sb.append("gender,");
				}
				if (hour == 0) {
					correct = false;
					sb.append("hour,");
				}
				if (rate == 0) {
					correct = false;
					sb.append("rate,");
				}

				return correct;
			}
		};
	}

	private void initData() {

		name = nField.getText();
		gender = Gender.getValue();

		try {
			age = Integer.parseInt(aField.getText());
			hour = Double.parseDouble(hField.getText());
			rate = Double.parseDouble(rField.getText());

		} catch (Exception e) {

		}

	}
}
