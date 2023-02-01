package com.paring.analyzer.controller;

import com.paring.analyzer.model.ParingResult;
import com.paring.analyzer.service.CalculateService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Comparator;
import java.util.List;

import static com.paring.analyzer.model.ParingResult.getParingResultString;
import static com.paring.analyzer.model.RateTable.allRate;
import static com.paring.analyzer.model.RateTable.enemyNames;
import static com.paring.analyzer.model.RateTable.initializedTable;
import static com.paring.analyzer.model.RateTable.playerNames;
import static com.paring.analyzer.util.Util.printText;
import static com.paring.analyzer.util.Util.setAocTeamRateData;
import static com.paring.analyzer.util.Util.setChaosTeamRateData;
import static com.paring.analyzer.util.Util.setOrkTeamRateData;

public class Controller {

    @FXML
    private TextField op1;

    @FXML
    private TextField op2;

    @FXML
    private TextField op3;

    @FXML
    private TextField p1;

    @FXML
    private TextField p1op1;

    @FXML
    private TextField p1op2;

    @FXML
    private TextField p1op3;

    @FXML
    private TextField p2;

    @FXML
    private TextField p2op1;

    @FXML
    private TextField p2op2;

    @FXML
    private TextField p2op3;

    @FXML
    private TextField p3;

    @FXML
    private TextField p3op1;

    @FXML
    private TextField p3op2;

    @FXML
    private TextField p3op3;

    @FXML
    private TextArea resultText;

    @FXML
    private Button sortingInRate;

    @FXML
    private Button orkTeamButton;

    @FXML
    private Button chaosTeamButton;

    @FXML
    private Button calculated;

    @FXML
    private Button aocTeamButton;

    @FXML
    private Button sortingInDef;

    @FXML
    void initialize() {
        orkTeamButton.setOnAction(actionEvent -> {
            setOrkTeamRateData(p1, p2, p3, op1, op2, op3, p1op1, p1op2, p1op3, p2op1, p2op2, p2op3, p3op1, p3op2, p3op3);
            initializedTable(p1, p2, p3, op1, op2, op3, p1op1, p1op2, p1op3, p2op1, p2op2, p2op3, p3op1, p3op2, p3op3);
            List<ParingResult> result = CalculateService.calculation(playerNames, enemyNames, allRate);
            printText(result, resultText);
        });

        chaosTeamButton.setOnAction(actionEvent -> {
            setChaosTeamRateData(p1, p2, p3, op1, op2, op3, p1op1, p1op2, p1op3, p2op1, p2op2, p2op3, p3op1, p3op2, p3op3);
            initializedTable(p1, p2, p3, op1, op2, op3, p1op1, p1op2, p1op3, p2op1, p2op2, p2op3, p3op1, p3op2, p3op3);
            List<ParingResult> result = CalculateService.calculation(playerNames, enemyNames, allRate);
            printText(result, resultText);
        });

        aocTeamButton.setOnAction(actionEvent -> {
            setAocTeamRateData(p1, p2, p3, op1, op2, op3, p1op1, p1op2, p1op3, p2op1, p2op2, p2op3, p3op1, p3op2, p3op3);
            initializedTable(p1, p2, p3, op1, op2, op3, p1op1, p1op2, p1op3, p2op1, p2op2, p2op3, p3op1, p3op2, p3op3);
            List<ParingResult> result = CalculateService.calculation(playerNames, enemyNames, allRate);
            printText(result, resultText);
        });

        calculated.setOnAction(actionEvent -> {
            initializedTable(p1, p2, p3, op1, op2, op3, p1op1, p1op2, p1op3, p2op1, p2op2, p2op3, p3op1, p3op2, p3op3);
            List<ParingResult> result = CalculateService.calculation(playerNames, enemyNames, allRate);
            result.sort((o1, o2) -> Integer.valueOf(o2.getSumRate()) - Integer.valueOf(o1.getSumRate()));
            printText(result, resultText);
        });

        sortingInRate.setOnAction(actionEvent -> {
            List<ParingResult> result = CalculateService.calculation(playerNames, enemyNames, allRate);
            result.sort((o1, o2) -> Integer.valueOf(o2.getSumRate()) - Integer.valueOf(o1.getSumRate()));
            printText(result, resultText);
        });

        sortingInDef.setOnAction(actionEvent -> {
            List<ParingResult> result = CalculateService.calculation(playerNames, enemyNames, allRate);
            result.sort(Comparator.comparing(o -> getParingResultString(o, allRate)));
            printText(result, resultText);
        });

        sortingInDef.setOnAction(actionEvent -> {
            List<ParingResult> result = CalculateService.calculation(playerNames, enemyNames, allRate);
            result.sort(Comparator.comparing(o -> getParingResultString(o, allRate)));
            printText(result, resultText);
        });
    }
}
