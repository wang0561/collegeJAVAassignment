/*File Name:FileUtils.java
 * Author: Tao Wang 040857654
 * course:CST8284 300 Fall 2016
 * Assignment: 2
 * Date:Nov 27th,2016
 * Professor: David B Houtman
 * purpose: create a class to handle the file
 */
package algonquin.cst8284.assignment2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
/**
 *This class is a class containing static methods that perform basic file I/O operations.
 *@author Tao Wang ,  David B Houtman
 *@version 2.0
 *@see java.io.File
 *     java.io.FileInputStream
 *     java.io.ObjectInputStream
 *     java.util.ArrayList
 *     javafx.stage.FileChooser
 *@since javac 1.8.0_102
 *
 */
public class FileUtils {
    /**
     * 
     *The name of the file's absolutely path
     */
	private static String QuizFileAbsolutePathAndName = "";// the file's absolutely path
	/**
	 *Get a file from a FileChooser dialog
	 *@param primaryStage The Stage to show the dialog
	 *@return Return a File object be choosen
	 * 
	 */
    public static File getFileHandle(Stage primaryStage) {
    	
       //create a dialog of file chooser 
		FileChooser fc = new FileChooser();
		fc.setTitle("Open Quiz File");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Quiz Files", "*.quiz"),
				new ExtensionFilter("All Files", "*.*"));
		File quizFile = fc.showOpenDialog(primaryStage);

		setFileName(quizFile);
		return (quizFile);
	}
    /**
     * 
     *Get a Arraylist of QA type to store all QA object
     *@param absPath The file's absolutely path 
     *@return Return a Arraylist of storing all QA object read from a file  
     * 
     * 
     */
  	public static ArrayList<QA> getQAArray(String absPath) {
		//define a new arraylist object to store the qa object
  		ArrayList<QA>  qaAr = new ArrayList<QA>();
		//define a boolean variable to control the loop of file input
  		boolean isDone=true;
		//loop a process of file input and store the qa object into the arraylist
  		try  (
				FileInputStream fis = new FileInputStream(absPath);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			try{// try to  add the aq object into arraylist
				while(isDone){
					qaAr.add((QA)ois.readObject());
				}//catch the excseptions 
			}catch(EOFException e )
			{
				isDone=false;
				//System.out.println("null");
            }catch(NullPointerException e){
				System.out.println("object is null");
				e.printStackTrace();
			}
			finally{
				ois.close();//close the stream
				fis.close();
			}
		}catch(  IOException | ClassNotFoundException   e){
			System.out.println("file not found");
			e.printStackTrace();
		}
		return qaAr;
	}
    
    /**
     *Set the file's absolutely path
     *@param f Pass A File object into the method
     * 
     */
	private static void setFileName(File f) {
		QuizFileAbsolutePathAndName = (FileExists(f)) ? f.getAbsolutePath() : "";
	}
    /**
     *Get the file's name
     *@return Return the file's absolutely path
     * 
     * 
     */
	public static String getFileName() {
		return QuizFileAbsolutePathAndName;
	}
    /**
     * Get the file's name
     * @param f pass a File object 
     * @return Return the file's absolutely path
     */
	public static String getFileName(File f) {
		return f.getAbsolutePath();
	}
    /**
     * Check if the file is exist
     * @param f pass a File Object
     * @return Return the boolean result to determine if the file exist
     * 
     */
	private static Boolean FileExists(File f) {
		return (f != null && f.exists() && f.canRead() && f.isFile());
	}


}
