package com.jedrzej.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.jedrzej.config.Logger;
import com.jedrzej.model.Car;
import com.jedrzej.model.CarDealer;
import com.jedrzej.services.CarService;
import com.jedrzej.validation.Validation;

public class ModyfiCarView {
	
	private static Label markLabel = new Label("Marka:");
	private static Label modelLabel = new Label("Model:");
	private static Label mileageLabel = new Label("Przegieg:");
	private static Label yearsLabel = new Label("Rocznik:");
	private static Label decriptionLabel = new Label("Przebieg:");
	
	private static TextField markField = new TextField();
	private static TextField modelField = new TextField();
	private static TextField mileageField = new TextField();
	private static TextField yearsField = new TextField();
	private static TextArea descriptionArea = new TextArea();
	
	private static Button updateButton = new Button("Aktualizuj samochod");

	public static void run(final Stage secondStage, final CarService carService, String nameCar, String nameCarDealer) {
		String [] result = nameCar.split(" ");
		final Car car = carService.findCar(Integer.parseInt(result[2]));
		final CarDealer carDealer = carService.findCarDealer(nameCarDealer);
		
		markField.setText(car.getMark());
		modelField.setText(car.getModel());
		mileageField.setText(car.getMileage());
		yearsField.setText(car.getYears()+"");
		descriptionArea.setText(car.getDescription());
		
        GridPane playerGrid = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(300);
        playerGrid.getColumnConstraints().addAll(column1, column2); 
        playerGrid.setPadding(new Insets(10, 10, 10, 10));
        
        playerGrid.add(markLabel, 0,0);
        playerGrid.add(markField, 1,0);
        playerGrid.add(modelLabel, 0,1);
        playerGrid.add(modelField, 1,1);
        playerGrid.add(mileageLabel, 0,2);
        playerGrid.add(mileageField, 1,2);
        playerGrid.add(yearsLabel, 0,3);
        playerGrid.add(yearsField, 1,3);
        playerGrid.add(decriptionLabel, 0,4);
        playerGrid.add(descriptionArea, 1,4);

		VBox leftBox = new VBox();
		leftBox.getChildren().addAll(playerGrid, updateButton);
		leftBox.setAlignment(Pos.TOP_CENTER);
		leftBox.setSpacing(30);
		
		Scene secondScene = new Scene(leftBox, 420, 350);
		secondStage.setTitle("Modify Car");
		secondStage.setScene(secondScene);
		secondStage.show();
		
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if 	(markField.getText().isEmpty() ||
						modelField.getText().isEmpty() ||
						yearsField.getText().isEmpty() ||
						descriptionArea.getText().isEmpty() ||
						mileageField.getText().isEmpty()){
					Logger.log("Puste pola w widoku modyfikacji Car");
				} else if (!Validation.isNumeric(yearsField.getText())){
					Logger.log("Pole rocznik w widoku dodawania Car zawiera litery");
				} else if (!Validation.isNumeric(mileageField.getText())){
					Logger.log("Pole przebieg w widoku dodawania Car zawiera litery");
				} else {
					Car sam = new Car();
					sam.setId(car.getId());
					sam.setMark(markField.getText());
					sam.setYears(Integer.parseInt(yearsField.getText()));
					sam.setDescription(descriptionArea.getText());
					sam.setMileage(mileageField.getText());
					sam.setModel(modelField.getText());
					sam.setCarDealer(carDealer);
					
					carService.updateCar(sam);
					Logger.log("Zmodyfikowano samochod "  + sam.getMark());
					secondStage.getScene().getWindow().hide();
				}
				
			}
		});
	}
    
}
