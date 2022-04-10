package com.example.flightcontroller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Observable;


public class HelloController extends  Observable{

    @FXML
    Canvas joystick;
    boolean mousePushed;
    double jx,jy;
    double middelX;
    double middelY;

    double aileron,elevator;

    public double getAileron(){
        return aileron;
    }

    public double getElevator(){
        return elevator;
    }

    public HelloController() {
        mousePushed= false;
        jx=0;
        jy=0;
        aileron = 0;
        elevator = 0;
    }

    void paint(){
        GraphicsContext gc = joystick.getGraphicsContext2D();
        middelX = joystick.getWidth()/2;
        middelY = joystick.getHeight()/2;
        gc.clearRect(0,0,joystick.getWidth(),joystick.getHeight());
        gc.strokeOval(jx-50,jy-50,100,100);
        aileron =(jx-middelX)/middelX;
        elevator=(jy-middelY)/middelY;
        setChanged();
        notifyObservers();
        System.out.println(aileron+","+elevator);
    }

    public void mouseDown(MouseEvent mouseEvent){
        if(!mousePushed) {
            mousePushed = true;
            System.out.println("mouse is down");
        }
    }

    public void mouseUp(MouseEvent mouseEvent){
        if(mousePushed) {
            mousePushed = false;
            System.out.println("mouse is up");
            jx = middelX;
            jy = middelY;
            paint();
        }
    }

    public void mouseMove(MouseEvent mouseEvent){
        if(mousePushed) {
            jx = mouseEvent.getX();
            jy = mouseEvent.getY();
            paint();
        }
    }


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


}