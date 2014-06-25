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

import com.jedrzej.model.Car;
import com.jedrzej.model.CarDealer;
import com.jedrzej.services.CarService;

public class ModyfiCarView {

	public static void run(final Stage secondStage, final CarService carService, String nameCar, String nameCarDealer) {
		String [] result = nameCar.split(" ");
		final Car car = carService.findCar(Integer.parseInt(result[2]));
		final CarDealer carDealer = carService.findCarDealer(nameCarDealer);
		
		Label markLabel = new Label("Marka:");
		Label modelLabel = new Label("Model:");
		Label mileageLabel = new Label("Przebieg:");
		Label yearsLabel = new Label("Rocznik:");
		Label decriptionLabel = new Label("Opis:");
		
		final TextField markField = new TextField(car.getMark()) ;
		final TextField modelField = new TextField(car.getModel());
		final TextField mileageField = new TextField(car.getMileage());
		final TextField yearsField = new TextField(car.getYears()+"");
		final TextArea descriptionArea = new TextArea(car.getDescription());
		
		Button updateButton = new Button("Aktualizuj samochod");
		
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
		secondStage.setTitle("Add Car");
		secondStage.setScene(secondScene);
		secondStage.show();
		
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if 	(markField.getText().isEmpty() ||
						modelField.getText().isEmpty() ||
						yearsField.getText().isEmpty() ||
						descriptionArea.getText().isEmpty() ||
						mileageField.getText().isEmpty()){
					System.out.println("Pusto");
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
					secondStage.getScene().getWindow().hide();
				}
				
			}
		});
		

	}
    
}
