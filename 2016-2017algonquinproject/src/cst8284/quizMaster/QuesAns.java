/*File Name:QuizMain.java
 * Author: Tao Wang 040857654
 * course:CST8284 300 Fall 2016
 * Assignment: 2
 * Date:Nov 27th,2016
 * Professor: David B Houtman
 * purpose: create a class to describe a QA Object
 */
package cst8284.quizMaster;

import java.io.Serializable;
/**
 * This class is abstract class to describe the Question and answer 
 * @author  David B Houtman
 * @version 1.0
 * @since javac 1.8.0_102
 * 
 */
@SuppressWarnings("serial")
public abstract class QuesAns implements Serializable {

	public abstract String getQuestion();

	public abstract void setQuestion(String question);

	public abstract String getExplanation();

	public abstract void setExplanation(String explanation);

	public abstract String getAuthor();

	public abstract void setAuthor(String author);

	public abstract int getCorrectAnswerNumber();

	public abstract void setCorrectAnswerNumber(int correctAnswer);

	public abstract int getDifficulty();

	public abstract void setDifficulty(int difficulty);

	public abstract int getPoints();

	public abstract void setPoints(int points);

	public abstract String[] getAnswers();

	public abstract void setAnswers(String[] answers);

	public abstract boolean isCorrect();

	public abstract void setResult(boolean b);

}
