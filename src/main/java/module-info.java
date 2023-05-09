module com.example.eksamen {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.eksamen to javafx.fxml;
    exports com.example.eksamen;
}