package cst8284.fall2017.assignment2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;

public class MyJavaFXBrowser extends Application {

	@Override
	public void start(Stage primaryStage) {
		
	    WebPage currentPage = new WebPage();
		WebView webView = currentPage.getWebView();
		
		BorderPane root = new BorderPane();
		root.setTop(Menus.loadTopPanel(webView));
		root.setRight(Menus.loadRightPanel(webView));
		
		String startupURL = (FileUtils.fileExists("default.web"))?FileUtils.getURLsFromFile("default.web").get(0):"https://www.google.ca/";
		Menus.goToURL(startupURL);
		root.setCenter(webView);

		Scene scene = new Scene(root, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	@Override
	public void stop() {
		FileUtils.storeURLsToFile(Menus.getBookmarks(), "bookmarks.web");
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
