package com.paring.analyzer.model;

import javafx.scene.control.TextField;

import java.util.List;
import java.util.Map;

public class RateTable {

    public static Map<String, Map<String, Integer>> allRate;
    public static Map<String, Integer> p3Map;
    public static Map<String, Integer> p2Map;
    public static Map<String, Integer> p1Map;
    public static List<String> playerNames;
    public static List<String> enemyNames;

    public static void initializedTable(TextField p1,
                                 TextField p2,
                                 TextField p3,
                                 TextField op1,
                                 TextField op2,
                                 TextField op3,
                                 TextField p1op1,
                                 TextField p1op2,
                                 TextField p1op3,
                                 TextField p2op1,
                                 TextField p2op2,
                                 TextField p2op3,
                                 TextField p3op1,
                                 TextField p3op2,
                                 TextField p3op3) {
        playerNames = List.of(p1.getText(), p2.getText(), p3.getText());
        enemyNames = List.of(op1.getText(), op2.getText(), op3.getText());

        p1Map = Map.of(
                op1.getText(), Integer.valueOf(p1op1.getText()),
                op2.getText(), Integer.valueOf(p1op2.getText()),
                op3.getText(), Integer.valueOf(p1op3.getText())
        );

        p2Map = Map.of(
                op1.getText(), Integer.valueOf(p2op1.getText()),
                op2.getText(), Integer.valueOf(p2op2.getText()),
                op3.getText(), Integer.valueOf(p2op3.getText())
        );

        p3Map = Map.of(
                op1.getText(), Integer.valueOf(p3op1.getText()),
                op2.getText(), Integer.valueOf(p3op2.getText()),
                op3.getText(), Integer.valueOf(p3op3.getText())
        );

        allRate = Map.of(
                p1.getText(), p1Map,
                p2.getText(), p2Map,
                p3.getText(), p3Map
        );
    }
}
