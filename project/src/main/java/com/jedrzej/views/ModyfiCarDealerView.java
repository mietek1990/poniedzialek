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
import com.jedrzej.model.CarDealer;
import com.jedrzej.services.CarDealerService;


public class ModyfiCarDealerView {
	
	private static Label nameLabel = new Label("Nazwa:");
	private static Label adressLabel = new Label("Adres:");
	private static Label decriptionLabel = new Label("Opis:");
	
	private static TextField nameField = new TextField() ;
	private static TextField adressField = new TextField();
	private static TextArea descriptionArea = new TextArea();
	
	private static Button updateButton = new Button("Aktualizuj komis");

	public static void run(final Stage secondStage, final CarDealerService carDealerService, String nameCarDealer) {

		final CarDealer carDealerFromDatabase = carDealerService.findCarDealer(nameCarDealer);
	
        GridPane playerGrid = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(300);
        playerGrid.getColumnConstraints().addAll(column1, column2); 
        playerGrid.setPadding(new Insets(10, 10, 10, 10));
        
        playerGrid.add(nameLabel, 0,0);
        playerGrid.add(nameField, 1,0);
        playerGrid.add(adressLabel, 0,1);
        playerGrid.add(adressField, 1,1);
        playerGrid.add(decriptionLabel, 0,2);
        playerGrid.add(descriptionArea, 1,2);

		VBox box = new VBox();
		box.getChildren().addAll(playerGrid, updateButton);
		box.setAlignment(Pos.TOP_CENTER);
		box.setSpacing(30);
		
		Scene secondScene = new Scene(box, 420, 350);
		secondStage.setTitle("Modify CarDealer");
		secondStage.setScene(secondScene);
		secondStage.show();
		
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if 	(nameField.getText().isEmpty() ||
						adressField.getText().isEmpty() ||
						descriptionArea.getText().isEmpty()){
					System.out.println("Pusto");
					Logger.log("Puste pola w widoku modyfikacji CarDealer");
				} else {
					CarDealer komis = new CarDealer();
					komis.setId(carDealerFromDatabase.getId());
					komis.setName(nameField.getText());
					komis.setAdress(adressField.getText());
					komis.setDescription(descriptionArea.getText());
					
					carDealerService.modifyCarDealer(komis);
					Logger.log("Zmodyfikowano wpis "  + komis.getName());
					secondStage.getScene().getWindow().hide();
				}
				
			}
		});
	}
    
}
