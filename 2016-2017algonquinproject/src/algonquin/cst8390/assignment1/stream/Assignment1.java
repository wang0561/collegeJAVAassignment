package algonquin.cst8390.assignment1.stream;

/*THIS IS AN NEW IMPLEMENTATION USING BY JAVA8 STREAM API TO SOVLE THE COLLECTIONS AGGREGATION OPERATION*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author Wang,Tao
 */
public class Assignment1 extends Application {
	/**
	 * ArrayList for store the objects of Mydata
	 */
	private ArrayList<Mydata> listOfMydata;
	private DecimalFormat df = new DecimalFormat(".00");
	private static boolean type = false;
    private Map<String,Double> map ;
    private Map<String,Double> mapOfStreet ;
	/**
	 * Main method of this program
	 *
	 * @param args
	 *            a string array to enter the program
	 */
	public static void main(String[] args) {
		Application.launch(args);
		// Assignment1 a=new Assignment1();
		// a.readCSVFile("property_tax_report.csv");

	}

	/**
	 * This is the start point of the application
	 *
	 * @param primaryStage
	 *            the main stage of starting the application
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// read a CSV file and load the objects of mydata into Arraylist<Mydata>

		listOfMydata = new ArrayList<>();
		readCSVFile("property_tax_report.csv");
		// create a GridPane as the root node
		GridPane root = new GridPane();
		// load all labels into root
		root.setHgap(80);
		root.setVgap(100);
		root.setPadding(new Insets(5, 5, 5, 5));
		root.setStyle("-fx-background-color: #ffffff;" + "-fx-border-style:solid inside;" + "-fx-border-width:3;");
		root.add(getLableOfAvePrinc(), 0, 0, 2, 2);
		root.add(getLabelOfPriceSd(), 2, 0, 2, 2);
		root.add(getLabelOfAveOfAge(), 4, 0, 2, 2);
		root.add(getLabelOfAgeSD(), 0, 2, 2, 2);
		root.add(getLabelOfTotalValueChanged(), 2, 2, 2, 2);
		root.add(getLabelOfMaxValue(), 4, 2, 2, 2);
		root.add(getLabelOfMinValue(), 4, 4, 2, 2);
		root.add(getPieChart(), 6, 0, 2, 4);
		root.add(getLineChart(), 0, 7, 8, 2);
		// root.add(getLineChart(), 0, 4, 4, 0);
		Scene scene = new Scene(root, 1800, 1500);
		primaryStage.setTitle("2015 CSV for House");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private long getNumberOfHouse(double low, double high, ArrayList<Mydata> list) {

	/*NEW STREAM API SOLUTION*/	
		long count=list.stream().filter(data -> data.getCurrentValue() > low && data.getCurrentValue() < high).collect(Collectors.toList()).size();
				
        return count;
	}

	/**
	 * Method of getting the line chart
	 * 
	 * @return return a line chart to show the number of homes increment by
	 *         value
	 * 
	 */
	@SuppressWarnings("unchecked")
	private Node getLineChart() {
		// TODO Auto-generated method stub

		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();

		xAxis.setLabel("House values");
		yAxis.setLabel("Homes number");

		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		lineChart.setTitle("House Value Per $25000");
		// defining a series
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName("2015 Property Tax House Values");
		// populating the series with data
		try {
			//System.out.println("CHECK TIME START : " + new Date());
			for (int i = 0; i < 3000; i += 25) {

				series.getData().add(new XYChart.Data<>(i, getNumberOfHouse(i * 1000, (i + 2.5) * 1000, listOfMydata)));

			}
			//System.out.println("CHECK TIME END : " + new Date());
		} catch (Exception e) {
			System.out.println("exception run");
		}

		lineChart.getData().addAll(series);
		lineChart.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 2){
						openStagebyHouseValue();
					}
				}
			}
		});
		return lineChart;
	}

	/**
	 * Method for getting the minimum value of the houses
	 * 
	 * @return return the vbox contains the information of min value
	 */
	private Node getLabelOfMinValue() {
		// TODO Auto-generated method stub
		Label label = new Label("  Min Value  ");
		label.setStyle("-fx-font: 30px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		Text text = new Text(df.format(getMinValueOfHouse(listOfMydata)));
		VBox vb = new VBox();
		vb.getChildren().addAll(label, text);
		vb.setStyle("-fx-font-size:20");
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 2){
						openStagebyHouseValue();
					}
				}
			}
		});

		return vb;
	}

	/**
	 * Method of getting the max value of house
	 * 
	 * @return return the value of house which has the max
	 */
	private Node getLabelOfMaxValue() {
		// TODO Auto-generated method stub
		Label label = new Label("Max Value  ");
		label.setStyle("-fx-font: 30px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		Text text = new Text(df.format(getMaxValueOfHouse(listOfMydata)));
		VBox vb = new VBox();
		vb.getChildren().addAll(label, text);
		vb.setStyle("-fx-font-size:20");
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 2){
						openStagebyHouseValue();
					}
				}
			}
		});

		return vb;
	}

	/**
	 * 
	 * Method of getting the label of total value changed
	 * 
	 * @return return the vbox contains information of
	 * 
	 */
	private Node getLabelOfTotalValueChanged() {
		// TODO Auto-generated method stub
		Label label = new Label("Total Value Change  ");
		label.setStyle("-fx-font: 30px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		Text text = new Text(df.format(totalValueChanged(listOfMydata)));
		VBox vb = new VBox();
		vb.getChildren().addAll(label, text);
		vb.setStyle("-fx-font-size:20");
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 2){
						openStagebyHouseValue();
					}
				}
			}
		});
		return vb;
	}

	/**
	 * Method for get the label of house age SD
	 * 
	 * @return return the vbox contains information of house age SD
	 * 
	 */
	private Node getLabelOfAgeSD() {
		// TODO Auto-generated method stub
		Label label = new Label("House Age Standard of Deviation");
		label.setStyle("-fx-font: 30px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		Text text = new Text(df.format(SDOfHouseAge(listOfMydata)));
		VBox vb = new VBox();
		vb.getChildren().addAll(label, text);
		vb.setStyle("-fx-font-size:20");
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 2){
						openStagebyHouseAge();
					}
				}
			}
		});
		return vb;
	}

	private Node getLabelOfAveOfAge() {
		// TODO Auto-generated method stub
		Label label = new Label("Average House Age  ");
		label.setStyle("-fx-font: 30px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		Text text = new Text("  " + df.format(AveAgeOfHouse(listOfMydata)));
		VBox vb = new VBox();
		vb.getChildren().addAll(label, text);
		vb.setStyle("-fx-font-size:20");
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 2){
						openStagebyHouseAge();
					}
				}
			}
		});
		return vb;
	}

	/**
	 * Method for get a vbox contains the label of price SD
	 * 
	 * @return return vbox contains the label of price SD
	 */
	private Node getLabelOfPriceSd() {
		// TODO Auto-generated method stub
		Label label = new Label("House Price Standard Deviation  ");
		label.setStyle("-fx-font: 30px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		Text text = new Text("  " + df.format(SDOfHousePrice(listOfMydata)));
		VBox vb = new VBox();
		vb.getChildren().addAll(label, text);
		vb.setStyle("-fx-font-size:20");
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 2){
						openStagebyHouseValue();
					}
				}
			}
		});
		return vb;
	}

	/**
	 * 
	 * Method for get the node of average price
	 * 
	 * @return return vbox contains average information
	 * 
	 */
	private Node getLableOfAvePrinc() {
		// TODO Auto-generated method stub
		Label label = new Label("Average House Princing  ");
		label.setStyle("-fx-font: 30px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		Text text = new Text("  " + df.format(AveHousePrice(listOfMydata)));
		VBox vb = new VBox();
		vb.getChildren().addAll(label, text);
		vb.setStyle("-fx-font-size:20");
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 2){
						openStagebyHouseValue();
					}
				}
			}
		});
		return vb;
	}

	/**
	 * Method for calculating the average house price
	 * 
	 * @return Average house price
	 * @param list
	 *            list of Mydata
	 */
	private double AveHousePrice(ArrayList<Mydata> list) {

        /*NEW JAVA STREAM SOLUTION*/
		return list.stream().mapToDouble(Mydata:: getCurrentValue).average().getAsDouble();
	}

	/**
	 * Method for calculating house price SD
	 * 
	 * @param list
	 *            list of Mydata
	 * @return return the value of SD
	 */
	private double SDOfHousePrice(ArrayList<Mydata> list) {
		double mean = AveHousePrice(list);
		double temp = 0;
		for (int i = 0; i < list.size(); i++) {
			temp += (list.get(i).getCurrentValue() - mean) * (list.get(i).getCurrentValue() - mean);
		}
		double standD = Math.sqrt(temp / list.size());
		return standD;

	}

	/**
	 * Method for calculating the average age of house
	 * 
	 * @param list
	 *            list of Mydata
	 * @return return the value of average age
	 */

	private double AveAgeOfHouse(ArrayList<Mydata> list) {

		/*NEW JAVA STREAM SOLUTION*/
        return list.stream().mapToDouble(Mydata::getHouseAge).average().getAsDouble();
	}

	/**
	 * Method for calculating SD of house age
	 * 
	 * @param list
	 *            list of Mydata
	 * @return return the value of the house age SD
	 */
	private double SDOfHouseAge(ArrayList<Mydata> list) {
		double mean = AveAgeOfHouse(list);
		double temp = 0;
		for (int i = 0; i < list.size(); i++) {
			temp += (list.get(i).getHouseAge() - mean) * (list.get(i).getHouseAge() - mean);

		}
		double standD = Math.sqrt(temp / list.size());
		return standD;
	}

	/**
	 * 
	 * Method for calculating the total changed value of house
	 * 
	 * @param list
	 *            list of Mydata
	 * @return return the value of total value changed
	 */
	private double totalValueChanged(ArrayList<Mydata> list) {

			return list.stream().mapToDouble(data->data.getCurrentValue()-data.getPreValue()).sum();
	}

	/**
	 * class for create a comparator to sort the list by value
	 * 
	 * @author Wang,Tao
	 */
	public class SortByValue implements Comparator<Mydata> {
		/**
		 * This method overide the compare(Object obj1, Object obj2) of the
		 * interface Comparator
		 * 
		 * @param o1
		 * @param o2
		 * @return return a int value of negative,0 or positive to compare the
		 *         two Mydat objects
		 */

		@Override
		public int compare(Mydata o1, Mydata o2) {
			int temp = (int) (o1.getCurrentValue() - o2.getCurrentValue());
			// check if the values are equal, compare the street name
			return temp;
		}
	}

	/**
	 * 
	 * Method for get the Maximum value of the house
	 * 
	 * @param list
	 *            list of Mydata
	 * @return return the Max value of the objects stored in the ArrayList
	 */
	private double getMaxValueOfHouse(ArrayList<Mydata> list) {
		list.sort(new Assignment1().new SortByValue());
		return list.get(list.size() - 1).getCurrentValue();

	}

	/**
	 * Method for get the minimum value of houses
	 * 
	 * @param list
	 *            list of Mydata
	 * @return return the min value of houses
	 */
	private double getMinValueOfHouse(ArrayList<Mydata> list) {
		list.sort(new Assignment1().new SortByValue());
		return list.get(0).getCurrentValue();
	}

	/**
	 * Method of getting a pie chart
	 * 
	 * @return return the chart to show the property types
	 * 
	 */
	private Node getPieChart() {
		// TODO Auto-generated method stub
		int countOne = 0;
		int countTwo = 0;
		int countCom = 0;

		for (int i = 0; i < listOfMydata.size(); i++) {
			switch (listOfMydata.get(i).getzoneGategory()) {

			case "One Family Dwelling":
				countOne++;
				continue;
			case "Multiple Family Dwelling":
				countTwo++;
				continue;
			case "Commercial":
				countCom++;
				continue;
			default:
				continue;
			}
		}
		double one = 100 * countOne / (countOne + countTwo + countCom);
		double two = 100 * countTwo / (countOne + countTwo + countCom);
		double com = 100 * countCom / (countOne + countTwo + countCom);
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Single Family", one), new PieChart.Data("Multiple Family", two),
				new PieChart.Data("Commercial", com));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Property Types");
		chart.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 2){
						openStagebyHouseValue();
					}
				}
			}
		});
		return chart;

	}

	// a inner class for the average by street name
	public class StreetAverage {
		private String street;
		private double average;

		StreetAverage(String street, double average) {
			this.setStreet(street);
			this.setAverage(average);
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public double getAverage() {
			return average;
		}

		public void setAverage(double average) {
			this.average = average;
		}

		public String toString() {
			return street + "\t\t\t" + average;
		}

	}

	/**
	 * Method to get a ObservableList
	 * @param map A TreeMap 
	 * @return return a ObservableList of StreetAverage
	 * 
	 */
	protected ObservableList<StreetAverage> getAveViewByStreet(Map<String, Double> map) {
		
		
		ObservableList<StreetAverage> data = FXCollections.observableArrayList();
		Iterator<Entry<String, Double>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Double> me = it.next();
			String key = me.getKey();
			double mean = Double.parseDouble(df.format(me.getValue()));
			data.add(new StreetAverage(key, mean));
			
		}
		return data;
	}

	protected void openOtherStage(boolean type) {
		
		BorderPane root = new BorderPane();
		Stage newStage = new Stage();
		Scene newScene = new Scene(root, 1500, 800);

		/*JAVA STREAM SOLUTION*/
		if (type)
		mapOfStreet = listOfMydata.stream().collect(Collectors.groupingBy(Mydata::getStreetName,Collectors.averagingDouble(Mydata::getCurrentValue)));
		else
			mapOfStreet = listOfMydata.stream().collect(Collectors.groupingBy(Mydata::getStreetName,Collectors.averagingDouble(Mydata::getHouseAge)));
		// create a table for show the average values by street name
		TableView<StreetAverage> tableStreet = new TableView<>();
		// create two columns for the table view
		TableColumn<StreetAverage, String> streetCol = new TableColumn<>("Street Name");
		streetCol.setMinWidth(200);
		streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
		streetCol.setStyle("-fx-alignment: CENTER;");

		TableColumn<StreetAverage, Double> aveCol = new TableColumn<>("Average values");
		aveCol.setMinWidth(200);
		aveCol.setCellValueFactory(new PropertyValueFactory<>("average"));
		aveCol.setStyle("-fx-alignment: CENTER;");

		tableStreet.setItems(getAveViewByStreet(mapOfStreet));
		tableStreet.getColumns().addAll(streetCol, aveCol);

		BorderPane bp = new BorderPane();
		// root.getChildren().addAll(tableStreet,bp);
		root.setLeft(tableStreet);
		root.setCenter(bp);
		tableStreet.setEditable(true);
		// TableView table=new TableView();

		tableStreet.setOnMouseClicked(getHandler(tableStreet,bp,root,streetCol));

		// Tell the stage which scene to display
		newStage.setScene(newScene);

		// make the stage visible
		newStage.show();
	}
	/**
	 * Method to open a new stage
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected void openStagebyHouseValue() {
		// GridPane root=new GridPane();
		type=true;
		openOtherStage(type);
	}
	protected void openStagebyHouseAge() {
		// GridPane root=new GridPane();
		type=false;
		
		openOtherStage(type);
	}
	private EventHandler<MouseEvent> getHandler(TableView<StreetAverage> tableStreet, BorderPane bp ,BorderPane root,TableColumn<StreetAverage, String> streetCol){
		return new EventHandler<MouseEvent>() {@Override
			public void handle(MouseEvent mouseEvent) {
			if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
				if(mouseEvent.getClickCount() == 2){

					try{	TablePosition<StreetAverage, String> pos = tableStreet.getSelectionModel().getSelectedCells().get(0);
					int row = pos.getRow();
					StreetAverage item = tableStreet.getItems().get(row);
					TableColumn<StreetAverage, String> col = streetCol;
					String data = col.getCellObservableValue(item).getValue();
					Text text = new Text(
							"The street name is: " + data + ". The average value by postal code shown on right");
					bp.setCenter(text);
					TableView<PostCodeAverage> table = getTableByPostalCode(data,type);
					root.setRight(table);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			}
		}};
	}

	/**
	 * Class for postal code and average value
	 * 
	 * @author Wang,Tao
	 * @version 1.0
	 */
	public class PostCodeAverage {
		private String PostCode;
		private double average;

		public PostCodeAverage(String p, double a) {
			this.setPostCode(p);
			this.setAverage(a);
		}

		public String getPostCode() {
			return PostCode;
		}

		public void setPostCode(String postCode) {
			PostCode = postCode;
		}

		public double getAverage() {
			return average;
		}

		public void setAverage(double average) {
			this.average = average;
		}
	}

	/**
	 * Method to get a table view of postal code and average value
	 * 
	 * @param data
	 *            A value of a street name
	 * @return return a Tableview
	 */
	@SuppressWarnings("unchecked")
	private TableView<PostCodeAverage> getTableByPostalCode(String data, boolean type) {
		// TODO Auto-generated method stub
	
		
		// create a list for deposit the post code from the same street name
        if(type)
	    map = listOfMydata.stream().filter(Mydata->Mydata.getStreetName().equals(data)).collect(Collectors.groupingBy(Mydata::getPostalCode,Collectors.averagingDouble(Mydata::getCurrentValue)));
        else
        	map = listOfMydata.stream().filter(Mydata->Mydata.getStreetName().equals(data)).collect(Collectors.groupingBy(Mydata::getPostalCode,Collectors.averagingDouble(Mydata::getHouseAge)));
        // create a table view to show the average value by postal code
		TableView<PostCodeAverage> tablePost = new TableView<>();

		TableColumn<PostCodeAverage, String> postCol = new TableColumn<>("Postal Code");
		postCol.setMinWidth(200);
		postCol.setCellValueFactory(new PropertyValueFactory<>("PostCode"));
		postCol.setStyle("-fx-alignment: CENTER;");

		TableColumn<PostCodeAverage, Double> aveCol = new TableColumn<>("Average Value");
		aveCol.setMinWidth(200);
		aveCol.setCellValueFactory(new PropertyValueFactory<>("average"));
		aveCol.setStyle("-fx-alignment: CENTER;");
		tablePost.setItems(getAveViewByPostalCode(map));
		tablePost.getColumns().addAll(postCol, aveCol);
		return tablePost;
	}

	/**
	 * Method for get a observablelist include the post code and average
	 * 
	 * @param map
	 *            A treemap with generic of string and arraylist
	 * @return return a observablelist
	 */
	protected ObservableList<PostCodeAverage> getAveViewByPostalCode(Map<String,Double> map) {
		
		ObservableList<PostCodeAverage> data = FXCollections.observableArrayList();
		Iterator<Entry<String, Double>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Double> me = it.next();
			String key = me.getKey();
			double mean = Double.parseDouble(df.format(me.getValue()));
			data.add(new PostCodeAverage(key, mean));
			
		}
		return data;
	}

	/**
	 * This is the basic parts of reading a CSV file.
	 * 
	 * @param filename
	 *            The string representing a filename to open.
	 */
	public void readCSVFile(String filename) {// define six variables for store
		// the value retrieved from
		// string []

		double buildYear = 0;
		double currentValue = 0;
		double prevalue = 0;
		int i = 0;
		String name = null;
		String postcode = null;
		String type = null;

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
			String line = "";

			while ((line = reader.readLine()) != null) {

				// Split the line by commas
				if (i > 0) {
					String[] partsOfLine = line.split(",");
					// The array partsOfLine should now hold everything in the
					// line between commas

					name = partsOfLine[12];
					postcode = partsOfLine[13];
					type = partsOfLine[5];
					if (name == null || postcode == null || type == null) {
						continue;
					} else {
						// if the record contains any bad data, ignore this
						// record and move on next one.
						try {
							buildYear = Double.parseDouble(partsOfLine[24]);
							currentValue = Double.parseDouble(partsOfLine[19]);
							prevalue = Double.parseDouble(partsOfLine[22]);
						} catch (Exception e) {
							continue;

						}

						listOfMydata.add(new Mydata(name, postcode, type, (2015 - buildYear), prevalue, currentValue));

					}
				}

				i++;

			}
			//	System.out.println("Total number of records from CSV file are " + i);
		} catch (IOException ioe) {
			System.out.println("Problem reading csv: " + ioe.getMessage());
		}

	}

}
