module com.example.flightcontroller {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.flightcontroller to javafx.fxml;
    exports com.example.flightcontroller;
}