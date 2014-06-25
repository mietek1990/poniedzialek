package com.jedrzej.aspect;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@Component
@Aspect
public class SpringAspect {
	public SpringAspect(){
		System.out.println("SpringAspect utworzony");
	}
//	@Before("execution(* com.jedrzej.services.CarDealer.*(..))")
	@Before("execution(* com.jedrzej.services.CarService.listCar(..))")
	public void logBeforeInitListRight(JoinPoint joinPoint) {
		
		String text = "AspectSpring logBefore : " + joinPoint.getSignature().getName();
		
		Label textLabel = new Label(text);

		System.out.println(text);
		
		final Float[] values = new Float[] {-1.0f};
		final ProgressIndicator[] pins = new ProgressIndicator[values.length];
		
		Group root = new Group();
        Scene scene = new Scene(root, 300, 150);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(text);
 
        final ProgressIndicator pin = pins[0] = new ProgressIndicator();
        pin.setProgress(values[0]);
        final VBox vb = new VBox();
        vb.setSpacing(30);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(pin,textLabel);

        scene.setRoot(vb);
        stage.show();
}
	
	@Before("execution(* com.jedrzej.services.CarService.updateCar(..))")
	public void logBeforeUpdateCar(JoinPoint joinPoint) {
		
		String text = "AspectSpring logBefore : " + joinPoint.getSignature().getName();
		
		Label textLabel = new Label(text);

		System.out.println(text);
		
		final Float[] values = new Float[] {-1.0f};
		final ProgressIndicator[] pins = new ProgressIndicator[values.length];
		
		Group root = new Group();
        Scene scene = new Scene(root, 300, 150);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(text);
 
        final ProgressIndicator pin = pins[0] = new ProgressIndicator();
        pin.setProgress(values[0]);
        final VBox vb = new VBox();
        vb.setSpacing(30);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(pin,textLabel);

        scene.setRoot(vb);
        stage.show();
}
	@Before("execution(* com.jedrzej.services.CarService.addCar(..))")
	public void logBeforeAddCar(JoinPoint joinPoint) {
		
		String text = "AspectSpring logBefore : " + joinPoint.getSignature().getName();
		
		Label textLabel = new Label(text);

		System.out.println(text);
		
		final Float[] values = new Float[] {-1.0f};
		final ProgressIndicator[] pins = new ProgressIndicator[values.length];
		
		Group root = new Group();
        Scene scene = new Scene(root, 300, 150);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(text);
 
        final ProgressIndicator pin = pins[0] = new ProgressIndicator();
        pin.setProgress(values[0]);
        final VBox vb = new VBox();
        vb.setSpacing(30);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(pin,textLabel);

        scene.setRoot(vb);
        stage.show();
}
	
	@Before("execution(* com.jedrzej.services.Car*.delete*(..))")
	public void logBeforeDelete(JoinPoint joinPoint) {
		
		String text = "AspectSpring logBefore : " + joinPoint.getSignature().getName();
		
		Label textLabel = new Label(text);

		System.out.println(text);
		
		final Float[] values = new Float[] {-1.0f};
		final ProgressIndicator[] pins = new ProgressIndicator[values.length];
		
		Group root = new Group();
        Scene scene = new Scene(root, 300, 150);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(text);
 
        final ProgressIndicator pin = pins[0] = new ProgressIndicator();
        pin.setProgress(values[0]);
        final VBox vb = new VBox();
        vb.setSpacing(30);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(pin,textLabel);

        scene.setRoot(vb);
        stage.show();
}
	
	@After("execution(* com.jedrzej.services.CarDealerService.addCarDealer(..))")
	public void logAfter(JoinPoint joinPoint) {
 
		String text = "AspectSpring logAfter : " + joinPoint.getSignature().getName();
		
		Label textLabel = new Label(text);

		System.out.println(text);
		final Float[] values = new Float[] {-1.0f};
		final ProgressIndicator[] pins = new ProgressIndicator[values.length];
		
		Group root = new Group();
        Scene scene = new Scene(root, 300, 150);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(text);
 
        final ProgressIndicator pin = pins[0] = new ProgressIndicator();
        pin.setProgress(values[0]);
        final VBox vb = new VBox();
        vb.setSpacing(30);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(pin, textLabel);
        
        scene.setRoot(vb);
        stage.show();
}
	
//	final Float[] values = new Float[] {-1.0f, 0f, 0.6f, 1.0f};
//	final Label [] labels = new Label[values.length];
//	final ProgressBar[] pbs = new ProgressBar[values.length];
//	final ProgressIndicator[] pins = new ProgressIndicator[values.length];
//	final vbox vbs [] = new vbox [values.length];
//
//	    @Override
//	    public void start(Stage stage) {
//	        Group root = new Group();
//	        Scene scene = new Scene(root, 300, 150);
//	        scene.getStylesheets().add("progresssample/Style.css");
//	        stage.setScene(scene);
//	        stage.setTitle("Progress Controls");
//	 
//	 
//	        for (int i = 0; i < values.length; i++) {
//	            final Label label = labels[i] = new Label();
//	            label.setText("progress:" + values[i]);
//	 
//	            final ProgressBar pb = pbs[i] = new ProgressBar();
//	            pb.setProgress(values[i]);
//	 
//	            final ProgressIndicator pin = pins[i] = new ProgressIndicator();
//	            pin.setProgress(values[i]);
//	            final vbox vb = vbs[i] = new vbox();
//	            vb.setSpacing(5);
//	            vb.setAlignment(Pos.CENTER);
//	            vb.getChildren().addAll(label, pb, pin);
//	        }
//	 
//	        final VBox vb = new VBox();
//	        vb.setSpacing(5);
//	        vb.getChildren().addAll(vbs);
//	        scene.setRoot(vb);
//	        stage.show();
//	    }
}
