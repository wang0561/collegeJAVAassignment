package cst8284.quizMaster;
/*File Name:QuizMain.java
 * Author: Tao Wang 040857654
 * course:CST8284 300 Fall 2016
 * Assignment: 2
 * Date:Nov 27th,2016
 * Professor: David B Houtman
 * purpose: create a class of Exception extends from Excetpion to describe if a question has error answer number
 */


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * BadQAAnswerChoice Class is extends from java.lang.Exception and describe a custom exception used in the program
 *@author Wang, Tao
 *@version 1.0
 *@see  javafx.scene.control.Alert
 *      javafx.scene.control.Alert.AlertType
 *@since javac 1.8.0_102
 * 
 * 
 */
public class BadQAAnswerChoice extends Exception {

	/**
	 * The name of a serialVersionUID
	 *{@value} serialVersionUID
	 * 
	 */
    
	private static final long serialVersionUID = 1L;
// constructor of class
    /**
     *Constructor of the BadQAAnswerChoice class 
     */  
	public BadQAAnswerChoice(){
       super();
      
       }
       /**
        * 
        *Display a error message to user 
        */
    public   void  alertShow(){
       //create a dialog of alert to inform the user
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bad Question");
		alert.setContentText("This question has bug, you will get 1 mark automatically");
	    alert.showAndWait();
		
    }
    
  
	}

