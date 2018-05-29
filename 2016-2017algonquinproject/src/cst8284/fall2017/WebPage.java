package cst8284.fall2017;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebPage {
	
	private WebView webview = new WebView();
	private WebEngine engine;
	
	public WebEngine createWebEngine(Stage stage) {
		
		WebView wv = getWebView();
		engine = wv.getEngine();
		
		engine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
			@Override
			public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
				if (newState == Worker.State.RUNNING) {
					stage.setTitle(engine.getLocation());
				}
			}
		});
		return engine;
	}
	
	public WebView getWebView() {
		return webview;
	}
	
	public WebEngine getWebEngine() {
		return engine;
	}
}
