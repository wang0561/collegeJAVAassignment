package cst8284.fall2017;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class Menus {

	/**** Generic Menu/Menu Item Properties ****/
	private static MenuItem mnuItm;
	private static Menu mnu;

	/********* Address Bar Properties **********/
	private static VBox topPanel = new VBox();
	private static HBox hbxAddressBar;
	private static TextField txtfldAddress;
	private static Button btnGo;
	private static boolean toggleAddress = true;

	/********* Bookmarks Properties **********/
	private static ArrayList<String> bookmarkURLs = new ArrayList<>();

	
	/**************** MenuBar ****************/
	public static MenuBar getMenuBar(WebView wv) {
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(getMnuFile(wv), getMnuSettings(), getMnuBookmarks(), getMnuHelp());
		return menuBar;
	}

	
	/***************** Menu ******************/
	private static Menu getMnuFile(WebView wv) {
		mnu = new Menu("File");
		mnu.getItems().addAll(getMnuItmRefresh(wv), getMnuItmExit());
		return mnu;
	}

	private static Menu getMnuSettings() {
		mnu = new Menu("Settings");
		mnu.getItems().addAll(getMnuItmAddressBar(), getMnuItmSaveStartupPage());
		return mnu;
	}

	private static Menu getMnuBookmarks() {
		mnu = new Menu("Bookmarks");
		mnu.getItems().addAll(getMnuItmBookmarks(mnu));
		loadBookmarksToMenu(mnu);
		return mnu;
	}

	private static Menu getMnuHelp() {
		mnu = new Menu("Help");
		mnu.getItems().addAll(getMnuItmJavaHelp(), getMnuItmAbout());
		return mnu;
	}

	
	/*************** MenuItems ***************/
	private static MenuItem getMnuItmRefresh(WebView wv) {
		mnuItm = new MenuItem("Refresh");
		mnuItm.setOnAction((ActionEvent e) -> wv.getEngine().reload());
		return mnuItm;
	}

	private static MenuItem getMnuItmExit() {
		mnuItm = new MenuItem("Exit");
		mnuItm.setOnAction((ActionEvent e) -> Platform.exit());
		return mnuItm;
	}

	private static MenuItem getMnuItmSaveStartupPage() {
		mnuItm = new MenuItem("Save Current Page as Startup");
		mnuItm.setOnAction((ActionEvent e) -> {
			String currentURL = getCurrentURL();
			if (currentURL.length() > 0) {                  // if the currentURL is not ""...
				ArrayList<String> al = new ArrayList<>();
				al.add(currentURL);							// ...load it into the ArrayList and save it to the file
				FileUtils.storeURLsToFile(al, "default.web");
			}			
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmAddressBar() {
		mnuItm = new MenuItem("Show/Hide Address Bar");
		mnuItm.setOnAction((ActionEvent e) -> {
			if (toggleAddress)
				topPanel.getChildren().add(hbxAddressBar);
			else
				topPanel.getChildren().remove(hbxAddressBar);
			toggleAddress = !toggleAddress;
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmBookmarks(Menu mnuBookmarks) {
		mnuItm = new MenuItem("Add Bookmark");
		mnuItm.setOnAction((ActionEvent e) -> {
			addBookmarkToMenu(mnuBookmarks, getCurrentURL());
			getBookmarks().add(getCurrentURL());
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmJavaHelp() {
		mnuItm = new MenuItem("Java Help");
		mnuItm.setOnAction((ActionEvent e) -> goToURL("https://www.google.ca/search?q=java"));
		return mnuItm;
	}

	private static MenuItem getMnuItmAbout() {
		/* From Marco Jakob, code.makery, */
		/* http://code.makery.ch/blog/javafx-dialogs-official/ */
		mnuItm = new MenuItem("About");
		mnuItm.setOnAction((ActionEvent e) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("Dave's Browser");
			alert.setContentText("Code by Prof. Dave Houtman, ©2017");
			alert.showAndWait();
		});
		return mnuItm;
	}
	
	public static VBox loadTopPanel(WebView wv) {
		hbxAddressBar = createAddressBar(wv);  
		MenuBar mb = getMenuBar(wv);
	    topPanel.getChildren().add(mb);
	    return topPanel;
	}

	
	/*************** Address Bar Methods ***************/
	public static HBox createAddressBar(WebView wv) {

		Label lblEnterURL = new Label("Enter URL:");
		lblEnterURL.setPadding(new Insets(4, 4, 4, 4));

		txtfldAddress = new TextField();
		
		btnGo = new Button("Go");
		btnGo.setOnAction((ActionEvent e) -> wv.getEngine().load(getCurrentURL()));
		
		HBox hbx = new HBox();	
		hbx.getChildren().addAll(lblEnterURL, txtfldAddress, btnGo);
		HBox.setHgrow(txtfldAddress, Priority.ALWAYS);
		return hbx;
	}
	
	public static void setURL(String URL) {txtfldAddress.setText(URL);}
	private static String getCurrentURL() {return txtfldAddress.getText();}
	
	public static void goToURL(String URL) {
		setURL(URL);
		btnGo.fire();
	}

	
	/*************** Bookmarks Methods ***************/
	
	public static ArrayList<String> getBookmarks(){return bookmarkURLs;}
	public static void setBookmarks(ArrayList<String> al) { bookmarkURLs = al;}
	
	private static void loadBookmarksToMenu(Menu mnu) {
		if (FileUtils.fileExists("bookmarks.web")){
			setBookmarks(FileUtils.getURLsFromFile("bookmarks.web"));
			for (String url: bookmarkURLs)
				addBookmarkToMenu(mnu, url);
		}
	}
	
	private static void addBookmarkToMenu(Menu mnu, String URL) { 
		mnuItm = new MenuItem(URL);
		mnuItm.setOnAction((ActionEvent e) -> goToURL(URL));
		if (mnu.getItems().size() == 1)
			mnu.getItems().add(new SeparatorMenuItem());
		mnu.getItems().add(mnuItm); // Add new URL to Menu
	}

}
