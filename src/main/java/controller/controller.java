package controller;

import java.util.Observable;
import java.util.Observer;

import com.example.flightcontroller.HelloController;
import model.model;

public class controller implements Observer {

    model m;
    HelloController helloController;

    public controller(model m,HelloController helloController) {
        this.m = m;
        this.helloController = helloController;
        m.addObserver(this);
        helloController.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        m.setAileron(helloController.getAileron());
        m.setElevators(helloController.getElevator());
    }

}
