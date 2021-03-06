package algonquin.cst8284.assignment1;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
/**
 * Author: TAO WANG;
 * course number:cst8284 300 2016F;
 * Professor: DAVID B HOUTMAN;
 * reference: JavaFX Tutorial - JavaFXRadioButton.[webpage].retrieved data from
 * http://www.java2s.com/Tutorials/Java/JavaFX/0420__JavaFX_RadioButton.htm
 */
public class AnswerPane {


	private VBox answerBox;
	private ToggleGroup group;
	private RadioButton[] rbAr;
	private String[] answers;

	public AnswerPane(String[] answers) {
		this.answers = answers;
		rbAr=new RadioButton[answers.length];
	}

	public VBox getAnswerPane() {
		
		answerBox = new VBox();
		answerBox.setPrefSize(1000, 150);
		group= new ToggleGroup();
		for (int i = 0; i < answers.length; i++) {

			rbAr[i]=new RadioButton();
			rbAr[i].setText(answers[i]);
			rbAr[i].setToggleGroup(group);

			answerBox.getChildren().add(rbAr[i]);
		}
		return answerBox;
	}

	public int getButtonSelected() {
		int i;  
		for(i=0;i<rbAr.length;i++){
			if (rbAr[i].isSelected())
				break;
		}

		return (i+1);
	}
}
