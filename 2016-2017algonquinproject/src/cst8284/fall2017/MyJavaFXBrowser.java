package cst8284.fall2017;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MyJavaFXBrowser extends Application {

	@Override
	public void start(Stage primaryStage) {
		
	    WebPage currentPage = new WebPage();
		WebView webView = currentPage.getWebView();
		
		BorderPane root = new BorderPane();
		root.setTop(Menus.loadTopPanel(webView));
		
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
