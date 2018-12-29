package public_service.employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Display extends Application {

	private ArrayList<Employee> listofEmp = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		initialize(stage);
		Scene scene = new Scene(getHomePage(), 800, 600);
		stage.setScene(scene);
		stage.show();

	}

	private Parent getHomePage() {
		// TODO Auto-generated method stub
		GridPane pane = new GridPane();
		pane.setHgap(80);
		pane.setVgap(100);
		pane.add(getEmpNumber(), 0, 0);
		pane.add(getDeptNumber(), 0, 1);
		pane.add(getPieChartOfUni(), 1, 0, 2, 2);
		pane.add(getTrendPane(), 0, 2, 2, 2);
		pane.setStyle("-fx-background-color: #ffffff;" + "-fx-border-style:solid inside;" + "-fx-border-width:3;");
		pane.setPadding(new Insets(5, 5, 5, 5));
		return pane;
	}

	private Node getTrendPane() {

		Map<Integer, Integer> map = getEmplByYearMap();
		List<Integer> years = new ArrayList<Integer>(map.keySet());
		years.sort(Comparator.comparingInt(Integer::valueOf));

		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();

		xAxis.setLabel("Year");
		yAxis.setLabel("Employee number");

		LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

		XYChart.Series<String, Number> series = new XYChart.Series<>();
		series.setName("Trend in years");
		for (int year : years) {

			int num = map.get(year);
			series.getData().add(new XYChart.Data<>(year + "", num));
		}
		lineChart.getData().add(series);
		return lineChart;
	}

	private Map<Integer, Integer> getEmplByYearMap() {
		// TODO Auto-generated method stub
		return listofEmp.stream()
				.collect(Collectors.groupingBy(Employee::getYear, Collectors.summingInt(Employee::getNumber)));
	}

	private Node getPieChartOfUni() {
		// TODO Auto-generated method stub
		int cpa = 0;
		int sa = 0;

		for (Employee emp : listofEmp) {

			if (emp.getUni().equals("SA"))
				sa++;
			else
				cpa++;
		}

		double cpaPercent = 100 * ((double) cpa / (cpa + sa));
		double saPercent = 100 * ((double) sa / (cpa + sa));

		ObservableList<PieChart.Data> pieChartData = FXCollections
				.observableArrayList(new PieChart.Data("SPA", saPercent), new PieChart.Data("CPA", cpaPercent));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Universe:");
		return chart;
	}

	private Node getDeptNumber() {

		VBox box = new VBox();
		Label dept = new Label("Total Departments:");
		Label num = new Label(getTotalDeptNumber() + "");
		num.setOnMouseClicked(mouseEvent -> {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				if (mouseEvent.getClickCount() == 2) {
					openDeptandnumberpage();
				}
			}
		});
		box.getChildren().add(dept);
		box.getChildren().add(num);
		box.setStyle("-fx-font-size:20");
		return box;
	}

	private void openDeptandnumberpage() {
		// TODO Auto-generated method stub

	}

	private int getTotalDeptNumber() {
		// TODO Auto-generated method stub
		return listofEmp.stream().collect(Collectors.groupingBy(Employee::getDept)).size();
	}

	private Node getEmpNumber() {
		// TODO Auto-generated method stub
		VBox box = new VBox();
		Label emp = new Label("Total Emp Number: ");
		Label num = new Label(getTotalEmpNumber() + "");
		box.getChildren().add(emp);
		box.getChildren().add(num);
		num.setOnMouseClicked(mouseEvent -> {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				if (mouseEvent.getClickCount() == 2) {
					openyearandnumberpage();
				}
			}
		});
		box.setStyle("-fx-font-size:20");
		return box;
	}

	private void openyearandnumberpage() {
		Stage stage = new Stage();
		TableView<YearAndNumber> table = getTableViewOfYearAndNumber();
		stage.setScene(new Scene(table, 600, 400));
		stage.show();
	}

	@SuppressWarnings("unchecked")
	private TableView<YearAndNumber> getTableViewOfYearAndNumber() {
		// TODO Auto-generated method stub
		TableView<YearAndNumber> table = new TableView<>();

		TableColumn<YearAndNumber, Integer> clnYear = new TableColumn<>("Year");
		clnYear.setMinWidth(200);
		clnYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
		clnYear.setStyle("-fx-alignment: CENTER;");

		TableColumn<YearAndNumber, Integer> clnNumber = new TableColumn<>("Empl Number");
		clnNumber.setMinWidth(200);
		clnNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
		clnNumber.setStyle("-fx-alignment: CENTER;");

		table.setItems(getObservablelistofYearAndNumber(getEmplByYearMap()));
		table.getColumns().addAll(clnYear, clnNumber);

		table.setOnMouseClicked(mouseEvent -> {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				if (mouseEvent.getClickCount() == 2) {
					int row = table.getSelectionModel().getSelectedCells().get(0).getRow();
					YearAndNumber yan = table.getItems().get(row);
					int year = clnYear.getCellObservableValue(yan).getValue().intValue();
					specificDeptandNum(year);
				}
			}
		});
		return table;
	}
	

	private void specificDeptandNum(int year) {
		Stage stage = new Stage();
		stage.setScene(new Scene(getSpecificTableOfDeptAndNum(year), 600, 600));
		stage.show();
	}

	@SuppressWarnings("unchecked")
	private TableView<DeptAndNumber> getSpecificTableOfDeptAndNum(int year) {
		TableView<DeptAndNumber> table = tableDeptandNum();
		table.setItems(getObservablelistofDeptAndNumber(year));
		return table;
	}
	private TableView<DeptAndNumber> tableDeptandNum(){
		
		TableView<DeptAndNumber> table = new TableView<>();

		TableColumn<DeptAndNumber, String> clnDept = new TableColumn<>("Department");
		clnDept.setMinWidth(200);
		clnDept.setCellValueFactory(new PropertyValueFactory<>("Dept"));
		clnDept.setStyle("-fx-alignment: CENTER;");

		TableColumn<DeptAndNumber, Integer> clnNumber = new TableColumn<>("Empl Number");
		clnNumber.setMinWidth(200);
		clnNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
		clnNumber.setStyle("-fx-alignment: CENTER;");
		table.getColumns().addAll(clnDept, clnNumber);
		return table;
	}
	private ObservableList<DeptAndNumber> getObservablelistofDeptAndNumber(int year) {
		List<Employee> list = listofEmp.stream().filter(e -> e.getYear() == year).collect(Collectors.toList());
		
		ObservableList<DeptAndNumber> data = FXCollections.observableArrayList();
		for (Employee em : list) {
			//System.out.println(em);
			data.add(new DeptAndNumber(em.getDept(), em.getNumber()));
		}
		return data;
	}

	private ObservableList<YearAndNumber> getObservablelistofYearAndNumber(Map<Integer, Integer> map) {
		ObservableList<YearAndNumber> data = FXCollections.observableArrayList();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			int year = entry.getKey();
			int number = entry.getValue();
			data.add(new YearAndNumber(year, number));
		}
		return data;
	}

	private int getTotalEmpNumber() {
		// TODO Auto-generated method stub
		return listofEmp.stream().mapToInt(Employee::getNumber).sum();
	}

	private void initialize(Stage stage) {

		readCSVFile(getFileHandle(stage).getAbsolutePath());
	}

	private static File getFileHandle(Stage primaryStage) {

		// create a dialog of file chooser
		FileChooser fc = new FileChooser();
		fc.setTitle("Open CSV File");
		fc.getExtensionFilters().addAll(new ExtensionFilter("CSV Files", "*.csv"),
				new ExtensionFilter("All Files", "*.*"));
		File csvFile = fc.showOpenDialog(primaryStage);

		return (csvFile);
	}

	private void readCSVFile(String filename) {
		// the value retrieved from
		// string []

		int year = 0;
		int number = 0;
		String uni = null;
		String dept = null;
		int i = 0;

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
			String line = "";

			while ((line = reader.readLine()) != null) {

				// Split the line by commas
				if (i > 0) {
					String[] partsOfLine = line.split(",");
					try {

						year = Integer.parseInt(partsOfLine[0]);
						uni = partsOfLine[1];
						dept = partsOfLine[2];
						number = Integer.parseInt(partsOfLine[3]);
						listofEmp.add(new Employee(year, number, dept, uni));
					} catch (Exception e) {

						continue;
					}

				}

				i++;

			}
			// System.out.println("Total number of records from CSV file are " + i);
		} catch (IOException ioe) {
			System.out.println("Problem reading csv: " + ioe.getMessage());
		}

	}

}
