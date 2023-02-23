module com.example.lelalou_assignmentone {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lelalou_assignmentone to javafx.fxml;
    exports com.example.lelalou_assignmentone;
}