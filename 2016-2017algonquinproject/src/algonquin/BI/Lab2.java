package algonquin.BI;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.distribution.NormalDistribution;

public class Lab2 extends Application{
	private NormalDistribution  nDist ;
	private double mean, median, deviation, wAve; 
	private ArrayList<Double> list;
	private ObservableList<Double> data;
	private ListView<Double> listV ;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button go=new Button("Go!");
		go.setMaxWidth(800);

		TextField tMean=new TextField();
		//TextField tMean1=new TextField();
		tMean.setPromptText("0");
		TextField tDeviation=new TextField();
		//TextField tDeviation1=new TextField("Alternative Hypothesis");
		tDeviation.setPromptText("10");
		TextField tN=new TextField();

		HBox.setMargin(tMean, new Insets(0,10,10,30));
		HBox.setMargin(tDeviation, new Insets(0,10,10,8));
		HBox.setMargin(tN, new Insets(0,10,10,50));

		HBox h1=new HBox();
		HBox.setHgrow(tMean, Priority.ALWAYS);
		HBox h2=new HBox();
		HBox.setHgrow(tDeviation, Priority.ALWAYS);
		HBox h3=new HBox();
		HBox.setHgrow(tN, Priority.ALWAYS);

		h1.getChildren().addAll(new Text("Enter Mean:"),tMean);
		h2.getChildren().addAll(new Text("Enter Deviation:"),tDeviation);
		h3.getChildren().addAll(new Text("Enter   N:"),tN);

		VBox.setMargin(h1, new Insets(0,10,5,10));
		VBox.setMargin(h2, new Insets(0,10,5,10));
		VBox.setMargin(h3, new Insets(0,10,5,10));

		VBox vb=new VBox();
		VBox.setMargin(go, new Insets(10,0,10,0));
		vb.getChildren().addAll(go,h1,h2,h3);

		go.setOnAction(e -> {
			double m= Double.parseDouble(tMean.getText());
			double a= Double.parseDouble(tDeviation.getText());
			int n=new Integer(tN.getText());
			nDist=new NormalDistribution(m,a);
			list = new ArrayList<Double>();
			for(int i=0;i<n;i++)
			{
				list.add(nDist.sample());

			}

			Collections.sort(list);
			Stage newStage = new Stage();
			TextField tf = new TextField();
			tf.setText(String.format("Mean: %f  Max: %f  Min:%f  SD:%f Median:%f WeightedAverage:%f", getMean(list), list.get(n-1), list.get(0), 
					getDeviation(list), getMedian(list), getwAve(list)));
			HBox hb=new HBox();
			hb.getChildren().add(tf);
			data = FXCollections.observableArrayList(list);

			listV = new ListView<Double>();
			listV.setItems(data);
			listV.getPadding();
			listV.setPrefSize(300, 400);

			VBox vb2=new VBox();
			vb2.getChildren().addAll(tf,listV);

			Scene newScene = new Scene(vb2, 800,500);
			newStage.setScene(newScene);
			newStage.show();

		});

		Scene scene = new Scene(vb, 800, 200);
		primaryStage.setTitle("calculation");
		primaryStage.setScene(scene);
		primaryStage.show();

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	public double getMean(List<Double> list) {
		double sum = 0.0;
		for(double a : list)
			sum += a;
		mean=sum/list.size();
		return mean;
	}



	public double getMedian(List<Double> list) {



		if (list.size() % 2 == 0) 
		{
			median= (list.get((list.size() / 2) - 1 )+ list.get(list.size() / 2)) / 2.0;
		} 
		else{
			median=list.get(list.size()/2);
		}
		return median;
	}

	public  double getVariance(List<Double> list)
	{
		double mean = getMean(list);
		double temp = 0;
		for(double a :list)
			temp += (a-mean)*(a-mean);
		return temp/list.size();
	}
	public double getDeviation(List<Double> list) {
		deviation=Math.sqrt(getVariance(list));
		return deviation;
	}

	public double getwAve(List<Double> list) {
		double sum=0.0;
		for(int i=0,n=10; i<10;i++,n--){
			sum+=n*list.get(i);
		}
		wAve=sum/55;
		return wAve;
	}


}



