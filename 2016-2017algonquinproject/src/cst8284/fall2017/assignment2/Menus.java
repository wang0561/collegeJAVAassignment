package cst8284.fall2017.assignment2;

import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javafx.concurrent.Worker;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;

public class Menus {

	/**** Generic Menu/Menu Item Properties ****/
	private static MenuItem mnuItm;
	private static Menu mnu;

	/********* Address Bar Properties **********/
	private static VBox topPanel = new VBox();
	private static HBox rightPanel = new HBox();
	private static HBox hbxAddressBar;
	private static VBox historyBar;
	private static VBox codeBar;
	private static TextField txtfldAddress;
	private static Button btnGo;
	private static boolean toggleAddress = true;
	private static boolean toggleHistory = true;
	private static boolean toggleCode = true;
	private static Text code = new Text();

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
		mnu = new Menu("_File");
		mnu.getItems().addAll(getMnuItmRefresh(wv), getMnuItmExit());
		return mnu;
	}

	private static Menu getMnuSettings() {
		mnu = new Menu("_Settings");
		mnu.getItems().addAll(getMnuItmAddressBar(), getMnuItmSaveStartupPage(), getMnuItmHistory(), getMnuItmCode());
		return mnu;
	}

	private static Menu getMnuBookmarks() {
		mnu = new Menu("_Bookmarks");
		mnu.getItems().addAll(getMnuItmBookmarks(mnu));
		loadBookmarksToMenu(mnu);
		return mnu;
	}

	private static Menu getMnuHelp() {
		mnu = new Menu("_Help");
		mnu.getItems().addAll(getMnuItmJavaHelp(), getMnuItmAbout());
		return mnu;
	}

	/*************** MenuItems ***************/
	private static MenuItem getMnuItmRefresh(WebView wv) {
		mnuItm = new MenuItem("Refresh");
		mnuItm.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
		mnuItm.setOnAction((ActionEvent e) -> wv.getEngine().reload());
		return mnuItm;
	}

	private static MenuItem getMnuItmExit() {
		mnuItm = new MenuItem("Exit");
		mnuItm.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
		mnuItm.setOnAction((ActionEvent e) -> Platform.exit());
		return mnuItm;
	}

	private static MenuItem getMnuItmSaveStartupPage() {
		mnuItm = new MenuItem("Save Current Page as Startup");
		mnuItm.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
		mnuItm.setOnAction((ActionEvent e) -> {
			String currentURL = getCurrentURL();
			if (currentURL.length() > 0) { // if the currentURL is not ""...
				ArrayList<String> al = new ArrayList<>();
				al.add(currentURL); // ...load it into the ArrayList and save it to the file
				FileUtils.storeURLsToFile(al, "default.web");
			}
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmAddressBar() {
		mnuItm = new MenuItem("Show/Hide Address Bar");
		mnuItm.setAccelerator(KeyCombination.keyCombination("Ctrl+Y"));
		mnuItm.setOnAction((ActionEvent e) -> {
			if (toggleAddress)
				topPanel.getChildren().add(hbxAddressBar);
			else
				topPanel.getChildren().remove(hbxAddressBar);
			toggleAddress = !toggleAddress;
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmHistory() {
		mnuItm = new MenuItem("Show/hide History Bar");
		mnuItm.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));
		mnuItm.setOnAction((ActionEvent e) -> {
			if (toggleHistory)
				rightPanel.getChildren().add(historyBar);
			else
				rightPanel.getChildren().remove(historyBar);
			toggleHistory = !toggleHistory;

		});

		return mnuItm;
	}

	private static MenuItem getMnuItmCode() {
		mnuItm = new MenuItem("Show/hide HTML/JavaScript code");
		mnuItm.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
		mnuItm.setOnAction((ActionEvent e) -> {
			if (toggleCode) {
				rightPanel.getChildren().add(codeBar);
			} else
				rightPanel.getChildren().remove(codeBar);
			toggleCode = !toggleCode;

		});

		return mnuItm;
	}

	private static void loadXMLCode(WebView wv) {
		// get the DOM code
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter stringWriter = new StringWriter();
			transformer.transform(new DOMSource(wv.getEngine().getDocument()), new StreamResult(stringWriter));
			String xml = stringWriter.getBuffer().toString();
			// System.out.println(xml);
			code.setText(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static MenuItem getMnuItmBookmarks(Menu mnuBookmarks) {
		mnuItm = new MenuItem("Add Bookmark");
		mnuItm.setAccelerator(KeyCombination.keyCombination("Ctrl+U"));
		mnuItm.setOnAction((ActionEvent e) -> {
			addBookmarkToMenu(mnuBookmarks, getCurrentURL());
			getBookmarks().add(getCurrentURL());
			FileUtils.storeURLsToFile(getBookmarks(), "bookmarks.web");
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmJavaHelp() {
		mnuItm = new MenuItem("Java Help");
		mnuItm.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
		mnuItm.setOnAction((ActionEvent e) -> goToURL("https://www.google.ca/search?q=java"));
		return mnuItm;
	}

	private static MenuItem getMnuItmAbout() {
		/* From Marco Jakob, code.makery, */
		/* http://code.makery.ch/blog/javafx-dialogs-official/ */
		mnuItm = new MenuItem("About");
		mnuItm.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));
		mnuItm.setOnAction((ActionEvent e) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("Dave's Browser");
			alert.setContentText("Code by Prof. Dave Houtman, �2017");
			alert.showAndWait();
		});
		return mnuItm;
	}

	public static HBox loadRightPanel(WebView wv) {
		historyBar = createHistoryBar(wv);
		codeBar = createCodeBar(wv);
		return rightPanel;
	}

	private static VBox createCodeBar(WebView wv) {
		VBox result = new VBox();
		Label codeLabel = new Label("Code");
		wv.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
			@Override
			public void changed(ObservableValue ov, State oldState, State newState) {

				if (newState == Worker.State.RUNNING) {
					Menus.setURL(wv.getEngine().getLocation());
					// System.out.println(wv.getEngine().getLocation());
				}
				if (newState == Worker.State.SUCCEEDED) {
					loadXMLCode(wv);
				}

			}
		});

		// //get the DOM code
		// try {
		// TransformerFactory transformerFactory = TransformerFactory
		// .newInstance();
		// Transformer transformer = transformerFactory.newTransformer();
		// StringWriter stringWriter = new StringWriter();
		// transformer.transform(new DOMSource(wv.getEngine().getDocument()),
		// new StreamResult(stringWriter));
		// String xml = stringWriter.getBuffer().toString();
		// System.out.println(xml);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		result.getChildren().addAll(codeLabel, code);
		return result;
	}

	public static VBox createHistoryBar(WebView wv) {
		Label history = new Label("History");
		VBox result = new VBox();

		// get the list of the history
		ObservableList<Entry> observablelist = wv.getEngine().getHistory().getEntries();

		ListView<Entry> list = new ListView<Entry>();

//		observablelist.addListener(new ListChangeListener() {
//			@Override
//			public void onChanged(ListChangeListener.Change change) {
//				List<String> arraylist = new ArrayList<String>();
//				for (int i = 0; i < observablelist.size(); i++) {
//					arraylist.add(observablelist.get(i).getTitle());
//					// System.out.println("id is " +i);
//					// System.out.println(observablelist.get(i).getTitle());
//					System.out.println(arraylist.get(i));
//
//				}
//
//				ObservableList<String> titles = FXCollections.observableList(arraylist);
//				list.setItems(titles);
//			}
//		});
		// System.out.println(observablelist.get(0).getTitle());
		// ObservableList<String> titles = FXCollections.observableList(arraylist);

		// ObservableList<String> titles = FXCollections.observableArrayList();
		// for(int i = 0; i<observablelist.size();i++) {
		// titles.add(observablelist.get(i).getTitle());
		// }
		// list.setItems(titles);
		 list.setItems(observablelist);

		// forward and back backward button

		Button back = new Button("\u23F4");
		back.setOnAction((ActionEvent e) -> {
			int currentIndex = wv.getEngine().getHistory().getCurrentIndex();

			Platform.runLater(new Runnable() {
				public void run() {
					if (currentIndex > 0)
						wv.getEngine().getHistory().go(-1);
					else {
						System.out.println("last Page");
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("About");
						alert.setContentText("This is the last page");
						alert.showAndWait();
					}
				}
			});
		});

		Button forward = new Button("\u23F5");
		forward.setOnAction((ActionEvent e) -> {
			int currentIndex = wv.getEngine().getHistory().getCurrentIndex();

			Platform.runLater(new Runnable() {
				public void run() {
					if (currentIndex + 1 < observablelist.size())
						wv.getEngine().getHistory().go(1);
					else {
						System.out.println("first Page");
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("About");
						alert.setContentText("This is the First page");
						alert.showAndWait();
					}
				}
			});
		});

		// styling buttons
		back.setPrefWidth(100);
		forward.setPrefWidth(100);
		// load everything into the panel
		result.getChildren().addAll(history, list, back, forward);
		return result;
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
		// System.out.println(getCurrentURL());

		// ready to load URL in to engine

		btnGo.setOnAction((ActionEvent e) -> {
			try {
				String testException = getCurrentURL();
				URL test = new URL(testException);
				wv.getEngine().load(testException);
			} catch (MalformedURLException ex1) {
				// do nothing
				System.out.println("MalformedURLException");
			} catch (StringIndexOutOfBoundsException ex2) {
				// do nothing
				System.out.println("StringIndexOutOfBoundsException");
			} catch (IllegalArgumentException ex3) {
				// do nothing
				System.out.println("IllegalArgumentException");
			} catch (Exception ex4) {
				System.out.println("ERROR");
				ex4.printStackTrace();
			}

		});

		HBox hbx = new HBox();
		hbx.getChildren().addAll(lblEnterURL, txtfldAddress, btnGo);
		hbx.setHgrow(txtfldAddress, Priority.ALWAYS);

		txtfldAddress.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ENTER)) {
					btnGo.fire();
				}
			}

		});
		return hbx;
	}

	public static void setURL(String URL) {
		txtfldAddress.setText(URL);
	}

	private static String getCurrentURL() {
		return txtfldAddress.getText();
	}

	public static void goToURL(String URL) {
		setURL(URL);
		btnGo.fire();
	}

	/*************** Bookmarks Methods ***************/

	public static ArrayList<String> getBookmarks() {
		return bookmarkURLs;
	}

	public static void setBookmarks(ArrayList<String> al) {
		bookmarkURLs = al;
	}

	private static void loadBookmarksToMenu(Menu mnu) {
		if (FileUtils.fileExists("bookmarks.web")) {
			setBookmarks(FileUtils.getURLsFromFile("bookmarks.web"));
			for (String url : bookmarkURLs)
				addBookmarkToMenu(mnu, url);
		}
	}

	// https://stackoverflow.com/questions/37260118/javafx-menuitem-does-not-react-on-mouseevent-clicked
	private static void addBookmarkToMenu(Menu mnu, String URL) {
		Label lbl = new Label(URL);
		mnuItm = new CustomMenuItem(lbl);
		// use label as action node since menuItem doesnt supoort the handler

		ContextMenu cm = new ContextMenu();
		MenuItem cmItem = new MenuItem("REMOVE BOOKMARK");
		cmItem.setOnAction((ActionEvent e) -> {
			FileUtils.removeURLFromFile("bookmarks.web", lbl.getText(), mnu);
			mnu.getItems().clear();
			mnu.getItems().addAll(getMnuItmBookmarks(mnu));
			loadBookmarksToMenu(mnu);
		});

		cm.getItems().add(cmItem);

		lbl.setOnMouseClicked(evt -> {
			if (evt.getButton() != MouseButton.PRIMARY) {
				cm.show(lbl, evt.getScreenX(), evt.getScreenY());
				// System.out.println("Right");
			} else {
				goToURL(URL);
			}
		});
		// mnuItm.setOnAction((ActionEvent e) -> {
		// goToURL(URL);
		// //System.out.println();
		// });

		if (mnu.getItems().size() == 1)
			mnu.getItems().add(new SeparatorMenuItem());
		mnu.getItems().add(mnuItm); // Add new URL to Menu

	}

}
