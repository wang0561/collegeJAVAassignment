package algonquin.cst8284.lab5;

import javafx.stage.*;
import javafx.stage.FileChooser.ExtensionFilter;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class WordDump extends Application {
	private File fileName;
	private ObservableList<String> data;
	private ListView<String> listV ;
	private ArrayList<String> list;
	//private static int iCount;

	public File getFileName() {
		return fileName;
	}

	public void setFileName(File f) {
		fileName = f;
	}

	public File getFileHandle(Stage primaryStage) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Open text File");
		fc.getExtensionFilters().addAll(new ExtensionFilter("txt Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		File file = fc.showOpenDialog(primaryStage);

		setFileName(file);
		return file;
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		File f = getFileHandle(primaryStage);
		if (f==null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("No File Name Enterd");
			alert.setContentText("No file name entered,Do you wish exit(ok) or continue(cancel)");
			ButtonType ok = new ButtonType("ok");
			ButtonType cancel = new ButtonType("cancel");
			alert.getButtonTypes().setAll(ok, cancel);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ok) {
				Platform.exit();
				System.exit(0);
			} else {
				start(primaryStage);
			}
		} else {
			list=getFileContent(f);

			displayStage(list,primaryStage);


		}
	}

	private void displayStage(ArrayList<String> list, Stage stage) throws IOException {

		Scene scene = new Scene(getPane(list), 600, 400);
		stage.setScene(scene);
		stage.setTitle("Welcome to WordDump");
		stage.show();
	}
	public BorderPane getPane(ArrayList<String> list) throws IOException{
      
		data = FXCollections.observableArrayList(list);

		listV = new ListView<String>();
		listV.setItems(data);
		listV.getPadding();
		listV.setPrefSize(300, 400);


		Button alp = new Button("Alphabetical order");
		Button reverse = new Button("Reverse order");

		GridPane pane =new GridPane();
		pane.add(alp,8,2);
		pane.add(reverse,8,3);


		BorderPane bp = new BorderPane();
		bp.setLeft(listV);
		bp.setRight(pane);

		alp.setOnAction(e->{
			Collections.sort(list);
		//	iCount++;
			Stage stage = new Stage();
			stage = (Stage) alp.getScene().getWindow();
			try {
				displayStage( list, stage);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});

		reverse.setOnAction(e->{
			Collections.reverse(list);
		//	iCount++;
			Stage stage = new Stage();
			stage = (Stage) alp.getScene().getWindow();
			try {
				displayStage( list, stage);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});


		return bp;
	}

	public  ArrayList<String> getFileContent(File f) throws IOException {

		ArrayList<String> list = null ;

		if (f.isFile() && f.exists()) {
			try {
				@SuppressWarnings("resource")
				Scanner file =new Scanner(f);
				list= new ArrayList<String>();

				while (file.hasNext()) {

					list.add(file.next());
				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		}
		return list;
	}

	public static void main(String args[]) {

		Application.launch(args);

	}

}
