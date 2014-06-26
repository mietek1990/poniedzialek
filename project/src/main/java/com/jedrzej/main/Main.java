package com.jedrzej.main;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jedrzej.aspect.SpringAspect;
import com.jedrzej.config.Logger;
import com.jedrzej.model.Car;
import com.jedrzej.model.CarDealer;
import com.jedrzej.services.CarDealerService;
import com.jedrzej.services.CarService;
import com.jedrzej.views.AddCarDealerView;
import com.jedrzej.views.AddCarView;
import com.jedrzej.views.ModyfiCarDealerView;
import com.jedrzej.views.ModyfiCarView;
	
public class Main extends Application {
	
//	AnnotationConfigApplicationContext context;
	ApplicationContext context;
	CarService carService;
	CarDealerService carDealerService;
	private static Logger logger;
	SpringAspect springAspect;
	
	static List<Stage> allStage = new ArrayList<Stage>();
	
	Button addCarDealer;
	Button deleteCarDealer;
	Button addCar;
	Button deleteCar;
	
	
	ObservableList<String> dataListLeft = FXCollections.observableArrayList();
	ListView<String> listLeft = new ListView<String>(dataListLeft);

	ObservableList<String> dataListRight = FXCollections.observableArrayList ();
	ListView<String> listRight = new ListView<String>(dataListRight);
	
	public void start(Stage stage) throws IOException {
			addCar = new Button("Add car");
			deleteCar = new Button("Delete car");
			addCarDealer = new Button("Add Car Dealer");
			deleteCarDealer = new Button("Delete Car Dealer");
			
			addCar.setDisable(true);
			deleteCar.setDisable(true);
			deleteCarDealer.setDisable(true);
			
			BorderPane border = new BorderPane();
			
			VBox vTop = new VBox();
		
			HBox actionPanelCarDealer = new HBox();
			actionPanelCarDealer.setPadding(new javafx.geometry.Insets(20));
			actionPanelCarDealer.setAlignment(Pos.CENTER);
			actionPanelCarDealer.setSpacing(80);
			actionPanelCarDealer.getChildren().addAll(addCarDealer, deleteCarDealer);
			
			HBox actionPanelCar = new HBox();
			actionPanelCar.setPadding(new javafx.geometry.Insets(10));
			actionPanelCar.setAlignment(Pos.CENTER);
			actionPanelCar.setSpacing(80);
			actionPanelCar.getChildren().addAll(addCar, deleteCar);
			
			vTop.getChildren().addAll(actionPanelCarDealer, actionPanelCar);
			
			border.setTop(vTop);
			HBox hCenter = new HBox();
			hCenter.setAlignment(Pos.CENTER);
			HBox listPanel = new HBox();
			listPanel.setPadding(new javafx.geometry.Insets(20, 100, 100, 100));

			listPanel.getChildren().addAll(listLeft, listRight);
			hCenter.getChildren().add(listPanel);
			border.setCenter(hCenter);
			
			Scene scene = new Scene(border,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Car Dealer");
			stage.setScene(scene);
			stage.show();
			
			allStage.add(stage);
			
			 stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		          public void handle(WindowEvent we) {
		              System.out.println("Stage is closing");
		              
		              for(int i = 0; i < allStage.size(); i++) 
		            	  allStage.get(i).getScene().getWindow().hide();
		          }
		      });    
			 
			initBean();
			initActions();
			initListCarDealer();
	}
	private void initBean() throws IOException{
		System.setProperty("spring.profiles.active", "development");
	    context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		context = new AnnotationConfigApplicationContext(AllConfiguration.class); gcnfdjghc
		carDealerService = context.getBean(CarDealerService.class);
		carService = context.getBean(CarService.class);
		logger = context.getBean(Logger.class);
		
       CarDealer carDealer = (CarDealer)context.getBean("carDealer");
 
       carDealerService.addCarDealer(carDealer);
		
		
	}
	private void initActions() {
		
		listLeft.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {                   
					Stage secondStage = new Stage();
					allStage.add(secondStage);
					ModyfiCarDealerView.run(secondStage, carDealerService, listLeft.getSelectionModel().getSelectedItem());
					
					secondStage.setOnHidden(new EventHandler<WindowEvent>() {
						@Override
						public void handle(WindowEvent arg0) {
							initListCarDealer();
						}
					});
				} else {
					logger.log("Pobierze samochody z komisu o nazwie " + listLeft.getSelectionModel().getSelectedItem());
					initListCar(listLeft.getSelectionModel().getSelectedItem());
					addCar.setDisable(false);
					deleteCar.setDisable(true);
					deleteCarDealer.setDisable(false);
				}
			}
		});	
		
		
		listRight.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {                   
					Stage secondStage = new Stage();
					allStage.add(secondStage);
					ModyfiCarView.run(secondStage, carService, listRight.getSelectionModel().getSelectedItem(), listLeft.getSelectionModel().getSelectedItem());
					
					secondStage.setOnHidden(new EventHandler<WindowEvent>() {
						@Override
						public void handle(WindowEvent arg0) {
							initListCar(listLeft.getSelectionModel().getSelectedItem());
						}
						
					});
				} else {
					logger.log("Pobierze samochod o nazwie: " + listRight.getSelectionModel().getSelectedItem());
					addCar.setDisable(true);
					deleteCar.setDisable(false);
					deleteCarDealer.setDisable(true);
				}
			}
		});
		
		addCarDealer.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				logger.log("Dodaje komis");
				Stage secondStage = new Stage();
				allStage.add(secondStage);
				AddCarDealerView.run(secondStage, carDealerService);
				
				secondStage.setOnHidden(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent arg0) {
						initListCarDealer();
					}
				});
			}
		});
		
		addCar.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				logger.log("Dodaje samochod");
				Stage secondStage = new Stage();
				allStage.add(secondStage);
				AddCarView.run(secondStage, carService, listLeft.getSelectionModel().getSelectedItem());
				
				secondStage.setOnHidden(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent arg0) {
						initListCar(listLeft.getSelectionModel().getSelectedItem());
					}
				});
			}
		});

		deleteCar.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				carService.deleteCar(listRight.getSelectionModel().getSelectedItem());
				initListCar(listLeft.getSelectionModel().getSelectedItem());
			}
		});
		deleteCarDealer.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				carDealerService.deleteCarDealer(listLeft.getSelectionModel().getSelectedItem());
				initListCarDealer();
				dataListRight.clear();
			}
		});
	}
	
	private void initListCarDealer(){
		
		dataListLeft.clear();
		
		List <CarDealer> listCarDealers = carDealerService.listCarDealear();
		
		for (int i = 0; i < listCarDealers.size(); i++)
			dataListLeft.add(listCarDealers.get(i).getName());
	}
	
	private void initListCar(String nameCarDealer){

		dataListRight.clear();
		
		List<Car> listCar = carService.listCar(nameCarDealer);	
		for (int i = 0; i < listCar.size(); i++)
			dataListRight.add(listCar.get(i).getMark() + " " + listCar.get(i).getModel() + " " + listCar.get(i).getId());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
