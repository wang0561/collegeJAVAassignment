package algonquin.cst8284.lab3;

import javafx.stage.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class WordDump extends Application {
	private static final String Iterator = null;
	private String fileName;
	private static int wordCtr;
	private FileInfo fileInfo;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String f) {
		fileName = f;
	}

	public static int getWordCtr() {
		return wordCtr;
	}

	public static void incrWordCtr() {
		wordCtr++;
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		// ask user to enter filename .
		System.out.println("Please enter your filename");
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);
		String filename = stdin.nextLine();
		setFileName(filename);// set file name
		File file = new File(getFileName());// load LWL.TXT into file
											// object
		Text text = new Text(getFileContent(file));// open the file, store
													// the content,
													// wordctr is the number
													// of words.
		fileInfo = new FileInfo(file);// store the new object into fileInfo
										// call constructor, output the info
										// of the file.
		Text info = new Text(fileInfo.getInfoString());// store the output
														// of getinfostring
														// in the text
														// "info"
		text.setFont(Font.font(12));
		info.setFont(Font.font(12));
		Pane centerPane = new Pane();// create center pane object
		BorderPane mainPane = new BorderPane();// create border pane object
		ScrollPane sp = new ScrollPane();// create scroll pane object
      //  Button b =new Button("ok");
    	centerPane.getChildren().add(info);// load info into centerpane
		centerPane.setMaxWidth(450);
		centerPane.setMaxHeight(250);
		centerPane.setPadding(new Insets(5, 10, 5, 2));
		// modify scroll pane
		sp.setContent(text);// load text into sp
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);// hidden
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);// Visible
		sp.setPrefWidth(140);
		sp.setPadding(new Insets(2, 3, 3, 10));

		mainPane.setLeft(sp);// load sp into mainpane
		mainPane.setCenter(centerPane);// load centerpane into mainpane

		Scene scene = new Scene(mainPane, 640, 480);// create scene and load
													// mainpane into it
		primaryStage.setScene(scene);// load scene into stage
		primaryStage.setTitle("welcome to WordDump");
		primaryStage.show();
		

	}

	public static String getFileContent(File f) throws IOException {
  
		
		  StringBuilder sb=new StringBuilder();
		//String line = "";
		//String content = "";
		if (f.isFile() && f.exists()) {
			try {
				@SuppressWarnings("resource")
				int i=0;
				BufferedReader bfr=new BufferedReader(new FileReader(f));
				/*while (fileIn.hasNext()) {
					sb.append( fileIn.next()+"\n") ;
					//content += line + "\n";
					incrWordCtr();*/
				//BufferedWriter bw = new BufferedWriter(new FileWriter(sb.toString()));
				while((i=bfr.read())!=-1){
					sb.append(bfr.readLine()+"\n");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static void main(String args[]) {

		Application.launch(args);

	}

}
