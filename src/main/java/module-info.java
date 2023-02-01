module com.paringanalyzer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.paring.analyzer to javafx.fxml;
    exports com.paring.analyzer;
    exports com.paring.analyzer.service;
    opens com.paring.analyzer.service to javafx.fxml;
    exports com.paring.analyzer.controller;
    opens com.paring.analyzer.controller to javafx.fxml;
}