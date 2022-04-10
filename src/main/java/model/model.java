package model;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

public class model extends Observable {

    HashMap<String,String> properties;
    Socket fg;
    PrintWriter out2fg;
    public model(String propertiesFileName) {
        try {
            properties= new HashMap<>();
            BufferedReader in = new BufferedReader(new FileReader(propertiesFileName));
            String line;
            while((line = in.readLine()) != null){
                String  sp[] = line.split(",");
                properties.put(sp[0],sp[1]);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.get("port"));
        try {
             fg = new Socket(properties.get("ip"),port);
             out2fg = new PrintWriter(fg.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    aileron,set /controls/flight/aileron
//    elevators,set /controls/flight/elevator
//    rudder,set /controls/flight/rudder
//    throttle,set /controls/flight/throttle

    public void setAileron(double x){
        String command = properties.get("aileron");
        out2fg.println(command+" "+x);
        out2fg.flush();
    }
    public void setElevators(double x){
        String command = properties.get("elevators");
        out2fg.println(command+" "+x);
        out2fg.flush();
    }
    public void setRudder(double x){
        String command = properties.get("rudder");
        out2fg.println(command+" "+x);
        out2fg.flush();
    }
    public void setThrottle(double x){
        String command = properties.get("throttle");
        out2fg.println(command+" "+x);
        out2fg.flush();
    }

    @Override
    public void finalize(){
        try {
            out2fg.close();
            fg.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

