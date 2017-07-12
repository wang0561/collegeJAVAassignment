package algonquin.practise;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class EventHandlerDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Application.launch(args);
	}
@override
     public void start(Stage stage){
	Scene scene = new Scene(getPane(),450,680);
	stage.setTitle("MoveText");
	stage.setScene(scene);
	stage.show();

}
public BorderPane getPane() {
	// TODO Auto-generated method stub
	Text text= new Text("Javafx programming");
	Pane centerPane=new Pane();
	centerPane.getChildren().add(text);
	centerPane.setPrefWidth(450);
	centerPane.setPrefHeight(680);
	Button btLeft = new Button("Left");
	Button btRight = new Button("Right");
	HBox bottomPane = new HBox(20);
	
	bottomPane.getChildren().addAll(btLeft, btRight);
	bottomPane.setAlignment(Pos.CENTER);
	bottomPane.setStyle("-fx-border-color: green");
	BorderPane mainPane = new BorderPane();
	mainPane.setCenter(centerPane);
	mainPane.setBottom(bottomPane);

	//LeftHandler btLeftClick = new LeftHandler();
	btLeft.setOnAction((ActionEvent e) -> System.out.println("left button click event just happened"));//different from line49
	//RightHandler btRightClick = new RightHandler();
	btRight.setOnAction(e->System.out.println("right button click event just happened"));//can't use format like ()->expression.why?
	return mainPane;
}
	/*private static class LeftHandler implements EventHandler<ActionEvent>{
		
	public void handle(ActionEvent e){
		
		System.out.println("left button click event just happened");
	}
	}
	private class RightHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent e){
			
			System.out.println("right button click event just happened");
		}
			
	}*/
	
}
	
	
	

