
/*
 * File Name:QuizMain.java
 * Author: Tao Wang 040857654
 * course:CST8284 300 Fall 2016
 * Assignment: 2
 * Date:Nov 27th,2016
 * Professor: David B Houtman
 * Purpose:This file is a the  start point of the Assignment2 project and build
 *         the javafx GUI for the program
 *Reference:
 * 1.Wendi Jollymore (2015).Alert Dialogs.[webpage].retrieved data from
 * http://www-acad.sheridanc.on.ca/~jollymor/prog24178/javafx7.html
 * 2. Timosy Cope(2015).JavaFX open new window.[webpage].retrieved data from
 *http://stackoverflow.com/questions/15041760/javafx-open-new-window
 *3.Jakob Jenkov(2015).JavaFX GridPane.[webpage].retrieved data from 
 *http://tutorials.jenkov.com/javafx/gridpane.html
 *4.JavaFX Tutorial - JavaFX Transitions.[webpage].retrieved data from 
 *http://www.java2s.com/Tutorials/Java/JavaFX/1000__JavaFX_Transitions.htm
 *5.Dmitry Kostovarov, Create a DropShadow.[webpage].retrieved data from
 *http://docs.oracle.com/javafx/2/visual_effects/drop_shadow.htm#CEGFADCA
 *6.JavaFX Tutorial - JavaFX Menu[webpage].retrieved data from 
 *http://www.java2s.com/Tutorials/Java/JavaFX/0560__JavaFX_Menu.htm
 *7.Dmitry Kostovarov(2012).Animation Basics.[webpage].retrieved data from 
 *http://docs.oracle.com/javafx/2/animations/basics.htm
 */
package algonquin.cst8284.assignment2;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * QuizMain Class is extends from Application class and use for creating a javafx application
 * @author Wang, Tao
 * @version 1.0
 * @see cst8285.quizMaster.FileUtils
 *      cst8285.quizMaster.BadQAAnswerChoice
 *      cst8285.quizMaster.AnswerPane
 *      cst8285.quizMaster.QuesAns
 *      cst8285.quizMaster.QA
 *      javafx.application.Application;
 *      javafx.application.Platform;
 *      javafx.scene.control.Alert.AlertType;
 * @since javac 1.8.0_102
 *      
 */

public class QuizMain extends Application {
    /**
      The name of An ArrayList with type of QA
     */
	private ArrayList<QA> QAList;// arraylist to store QA objects
	/**
	 *The name of an correct answer counter 
	 */
	private static int countCorrect;// counter for corrected question the user have
	/**
	 *The name of an panel counter 
	 */
	private static int iCount = 0;//counter for the question and answer panel
	/**
	 the final 
	 */
	private File  f;//a variable to store file object
	/**
	 * This method overide the superclass's start method
	 * @param primaryStage The main entry point for all JavaFX applications
	 * 
	 */

	@Override
	public void start(Stage primaryStage) {
		//call the slash panel assign it to a neww borderpane called root
		primaryStage.setTitle("Quiz Master");
		BorderPane root=getSplashPane("Welcome to QuizMaster");
		//define the menu called File
		Menu fileMenu= new Menu("File");
		//define two menuItem called open and exit
		MenuItem openMenuItem = new MenuItem("Open");
		MenuItem exitMenuItem = new MenuItem("Exit");
		//define the eventhandler of the open item
		openMenuItem.setOnAction(actionEvent ->{
			//show the file chooser dialog to user
			f=FileUtils.getFileHandle(primaryStage);
			String str = FileUtils.getFileName();
			//if the user click cancel, return to the quizmaster main page
			if(str==""){
				start(primaryStage );
			}else{
				//else, read the file and do the quiz
				QAList = FileUtils.getQAArray(FileUtils.getFileName(f));
				displayQA(0, QAList, primaryStage);
			}
		});
		//define the eventhandler of the exit item
		exitMenuItem.setOnAction(actionEvent -> showMissingFileNameAlert(primaryStage));
		//load open and exit item into filemenu
		fileMenu.getItems().addAll(openMenuItem, 
				new SeparatorMenuItem(), exitMenuItem);
		//define a new menubar
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		//load menubar into the root borderpane
		root.setTop(menuBar);
		//load filemenu into menubar
		menuBar.getMenus().addAll(fileMenu);
		//load root into scene
		Scene scene = new Scene(root, 1024, 512);
		//load scene into stage
		primaryStage.setScene(scene);
		primaryStage.show();



	}
 /**
  * show a dialog of alert for reminder the user
  * @param stage 
  * 
  * 
  */
	private void showMissingFileNameAlert(Stage stage){
		//define a new alert to confirm that if the user will exit the program
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Missing File Name");
		alert.setContentText("Press OK to exit program or Continue to do the quiz");
		Optional<ButtonType> response = alert.showAndWait();
		//if user click the button of ok, program will be closed.
		if (response.isPresent() && response.get() == ButtonType.OK) {
			Platform.exit();
			System.exit(0);
		}    
	}
/**
 * display the current stage of question
 * @param i number of question stage
 * @param qAList2 Arraylist of QA
 * @param stage current stage
 */
	private void displayQA(int i, ArrayList<QA> qAList2, Stage stage) {
		//define a new scene and load current qa panel into it
		Scene scene = new Scene(getCurrentQAPane(qAList2.get(i)), 1200, 400);
		stage.setScene(scene);
	}
/**
 * Get the panel of the result show
 * @param qAList2 Arraylist of QA
 * @param stage current Stage
 * @return return a GridPane include the quiz result
 */
	private Pane getQAResults(ArrayList<QA> qAList2, Stage stage) {
		//define a stringbuilder object to store the text information
		StringBuilder sb = new StringBuilder("Your quiz result shown below: \n");
		// define a int number to count the question have been answered
		int i = 1;
		for (QA qa : qAList2) {
			sb.append("Question number " + (i++) + " : " + (qa.isCorrect() ? "Correct" : "Wrong") + "\n");

		}
		sb.append("You made  " + countCorrect + "  correct answers and " + (qAList2.size() - countCorrect)
				+ " incorrect answers.\n" + "Your marks is  " + countCorrect + "/" + qAList2.size()+"\nDo You want do another quiz?");
		//define two new button to allow user do another quiz
		Button yButton=new Button("Yes");
		Button nButton=new Button("No");
		//define the result panel
		GridPane pane = new GridPane();
		pane.setPrefSize(300, 500);
		pane.setStyle("-fx-background-color: #ffffff;" + "-fx-border-style:solid inside;" + "-fx-border-width:3;");
		pane.setHgap(10);
		pane.setVgap(10);
		//create a text object to store the stringbuilder 
		Text text = new Text(sb.toString());
		text.setStyle("-fx-font: 25px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		//load the text object into a pane object
		Pane tPane = new Pane();
		tPane.getChildren().add(text);
		//load the two button into a new borderpane
		BorderPane dPane = new BorderPane();
		dPane.setLeft(yButton);
		dPane.setCenter(nButton);
		//load the two panel into the main gridpane
		pane.add(tPane, 7, 7);
		pane.add(dPane,7, 8);
		//set yes button' eventhandler
		yButton.setOnAction(e -> {
			iCount=0;
			countCorrect=0;
			start(stage);});
		//set the eventhandler of the no button
		nButton.setOnAction(e-> {
			Platform.exit();
			System.exit(0);
		});
		return pane;
	}
/**
 * Obtain the panel of the current question and all the nodes loaded into it
 * @param currentQA current QA object 
 * @return return A main panel and all nodes loaded into it
 *
 */

	private Pane getCurrentQAPane(QA currentQA) {

		//Define a gride panel
		GridPane pane = new GridPane();
		pane.setStyle("-fx-color:purple;");
		//define a hbox for loading the question 
		HBox questionPane = new HBox();
		questionPane.setAlignment(Pos.CENTER_LEFT);
		//load question into the qustion hbox
		questionPane.getChildren().add(new Text(currentQA.getQuestion()));
		//set questionPane's property
		questionPane.setPrefSize(600, 50);
		questionPane.setStyle("-fx-font-size:22");
		//set gridpane's gap 
		pane.setHgap(2);
		pane.setVgap(2);
		//define two buttun 'check' and 'next'
		Button bNext = new Button("next question");
		Button bCheck = new Button("check answer");
		bNext.setPadding(new Insets(10, 10, 10, 10));
		//declare a new answerpane
		AnswerPane ap = new AnswerPane(currentQA.getAnswers());
		//set 'next' button disable util 'check' clicked
		bNext.setDisable(true);
		//define a vbox to load the answerpane
		VBox vb = ap.getAnswerPane();
		//define a new gridpane to load the vbox and the 'check' button
		GridPane gPane = new GridPane();
		//set gpane's gap , size and style
		gPane.setHgap(5);
		gPane.setVgap(5);
		gPane.setPrefSize(1000, 300);
		gPane.setStyle("-fx-background-color: #ffffee;" + "-fx-border-style:solid inside;" + "-fx-border-width:3;"+ "-fx-font-size:22;");
		//load check button and vbox into the gpane
		gPane.add(vb, 2, 10, 2, 2);
		gPane.add(bCheck, 4, 12, 2, 2);
		GridPane.setMargin(bCheck, new Insets(10, 10, 10, 10));
		//load the gpane, next button and hbox into the main gridpane
		pane.add(questionPane, 2, 10, 2, 2);
		pane.add(gPane, 2, 12, 2, 3);
		pane.add(bNext, 5, 15, 5, 5);
		GridPane.setMargin(bNext, new Insets(10, 0, 10, 10));
		// check button EventHandler
		bCheck.setOnAction((e) -> {
			//if the user do not choose an answer, show a alert
			if (currentQA.getAnswers().length == (ap.getButtonSelected() - 1)) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("No Answer selected");
				alert.setContentText("You must choose one answer before you click [check answer] button");
				@SuppressWarnings("unused")
				Optional<ButtonType> result = alert.showAndWait();
			}
			//if the user choose an answer, check the answer is correct and record the result
			else {
				//define a text to store the correct answer notice
				Text text = new Text("Correct answer is choice number :  " + currentQA.getCorrectAnswerNumber());
				//load the text into gPane
				gPane.add(text, 2, 12);
				//set the radio button and check button in disable status
				vb.setDisable(true);
				bCheck.setDisable(true);
				//define a text1 to store the explanation of the question
				Text text1 = new Text("Explanation : " + currentQA.getExplanation());
				//set the font of the text1
				text1.setFont(Font.font(16));
				GridPane.setMargin(text1, new Insets(10, 15, 10, 10));
				//load the text1 into main gridpane
				pane.add(text1, 2, 15, 1, 1);
				//set the next button can be clicked
				bNext.setDisable(false);
				//check the answer is corret and record the result
				if (currentQA.getCorrectAnswerNumber() == ap.getButtonSelected()) {
					currentQA.setResult(true);
					countCorrect++;
				}
				//check if qustion has a bug and throw the exception, and give the user a free mark

				if(currentQA.getCorrectAnswerNumber()>currentQA.getAnswers().length){
					try{
						throw new BadQAAnswerChoice();
					}catch(BadQAAnswerChoice ex){
						ex.alertShow();}
					finally{
						currentQA.setResult(true);//set result true
						countCorrect++;//correct qusetion counter incremented by 1
					}
				}
			}
		});
		//next button Eventhandler
		bNext.setOnAction(e -> {
			iCount++;
			//check if the QA object has been read completed,if not, go to next question
			if (iCount < QAList.size()) {
				Stage stage = new Stage();
				stage = (Stage) bNext.getScene().getWindow();
				displayQA(iCount, QAList, stage);
			} else {
				//if all question has been completed, go to the result panel.
				Stage stage = new Stage();
				stage = (Stage) bNext.getScene().getWindow();
				stage.setScene(new Scene(getQAResults(QAList,stage), 800, 500));
			}
		});

		return pane;
	}
/**
 * Obtain a Transition 
 * @param str The String object need to be combined with Transition
 * @return return a Transition object 
*/
	private Transition getTransition(String str){
		//define a new text object
		final String content = str;
		final Text text = new Text(10, 20, "");
		//define a new transition object by using a inner class
		final Transition transition = new Transition() {
			{
				setCycleDuration(Duration.millis(2000));
			}//define a method to load the string into text object 
			protected void interpolate(double frac) {
				final int length = content.length();
				final int n = Math.round(length * (float) frac);
				text.setText(content.substring(0, n));
			}
		};
		//play a transition
		transition.play();
		return transition;
	}
/**
 * load the object of String into a Text object and add transitions to it
 * @param str The String objcet need to be loaded into the Text object
 * @return return a Text object
 * 
 */
	private Text getText(String str){
		//define a new text to store the string object
		Text text =new Text(str);
		//get a transition to str
		getTransition(str);
		//define pausetransition, translatetransition,pausetransition and rotatetransition objects
		PauseTransition pt = new PauseTransition(Duration.millis(3000));
		TranslateTransition tt = new TranslateTransition(Duration.millis(3000));
		tt.setFromX(-100f);
		tt.setToX(100f);
		tt.setAutoReverse(true);
		RotateTransition rt = new RotateTransition(Duration.millis(5000));
		rt.setByAngle(720f);
		rt.setAutoReverse(true);
		ScaleTransition st = new ScaleTransition(Duration.millis(3000));
		st.setByX(1.5f);
		st.setByY(1.5f);
		st.setAutoReverse(true);
		//define a paralletransition to load the four transion objects and text object into it
		ParallelTransition plt= new ParallelTransition(text, pt,  tt, st,rt);
		plt.play();

		return text;
	}
/**
 * Get a DropShadow object
 * @return return a DropShadow object which already motified
 * 
 * 
 */
	private DropShadow getShadow(){
		//create a new dropshadow object and set its properties
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0);
		ds.setOffsetX(3.0);
		ds.setColor(Color.GREY);
		return ds;
	}
	/**
	 *Get a slash panel
	 *@param str The words need to be loaded into the slash panel
	 *@return Return a BorderPane need to be loaded into Scene 
	 * 
	 */
	private BorderPane getSplashPane(String str) {
		//create a new borderpane 
		BorderPane bp = new BorderPane();
		//define a new text object and set its properties
		Text text= getText(str);
		text.setEffect(getShadow());
		text.setCache(true);
		text.setX(20.0f);
		text.setY(70.0f);
		text.setFill(Color.PURPLE);
		//load text into borderpane 
		bp.setCenter(text);
		return bp;
	}
/**
 *The method of the start point of the project
 *@param args An String Type Array
 *@see Application.launch(args) 
 * 
 * 
 */
	public static void main(String[] args) {
		//call launch method and run the application
		Application.launch(args);
	}
}