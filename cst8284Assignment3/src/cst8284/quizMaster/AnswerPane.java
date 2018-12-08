package cst8284.quizMaster;

/*File Name:AnswerPane.java 
 * Author: TAO WANG;
 * course number:cst8284 300 2016F;
 * Professor: DAVID B HOUTMAN;
 * reference: JavaFX Tutorial - JavaFXRadioButton.[webpage].retrieved data from
 * http://www.java2s.com/Tutorials/Java/JavaFX/0420__JavaFX_RadioButton.htm
 */


import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
/**
 *AnswerPane is a class to describe the answer panel 
 * @author Wang, Tao
 * @version 1.0
 * @see javafx.scene.control.RadioButton
 *      javafx.scene.control.ToggleGroup
 *      javafx.scene.layout.VBox
 *  @since javac 1.8.0_102
 */
public class AnswerPane {

     /**
      *The name of  answer VBox
      */
	private VBox answerBox;// VBox of the answer
	/**
	 *The name of a ToggleGroup 
	 * 
	 */
	private ToggleGroup group;//variable to store group object
	/**
	 *The name of the RadioButton 
	 * 
	 */
	private RadioButton[] rbAr;//array to store radiobutton object
	/**
	 * 
	 *The Name of the String answer 
	 * 
	 */
	private String[] answers;//string array to store the answer
	/**
	 *Constructor of the class AnswerPane , for initializing the value of the string [] answer and set the radio button array's size
	 *@param answer Pass a String array which contains the answers 
	 */
 
	public AnswerPane(String[] answers) {//constructor to store the answer into the answers array and set the rbAr's size
		this.answers = answers;
		rbAr=new RadioButton[answers.length];
	}
    /**
     *Get a VBox to display the answers
     *@return Return a VBox and all Nodes loaded into it 
     * 
     * 
     */
	public VBox getAnswerPane() {
		
		answerBox = new VBox();// store a vbox object into answerbox
		answerBox.setPrefSize(1000, 150);
		group= new ToggleGroup();//store a group object into group
		for (int i = 0; i < answers.length; i++) {

			rbAr[i]=new RadioButton();//store radiobutton obj into rbAr
			rbAr[i].setText(answers[i]);
			rbAr[i].setToggleGroup(group);

			answerBox.getChildren().add(rbAr[i]);//load radiobutton obj into answerbox
		}
		return answerBox;
	}
    /**
     *Get the number of the choice selected by the user
     *@return Return a number of the choice selected 
     * 
     */
	public int getButtonSelected() {
		int i;  
		for(i=0;i<rbAr.length;i++){//check if answer is selected, use i to record the  answer number be selected
			if (rbAr[i].isSelected())
				break;
		}

		return (i+1);
	}
}
