package com.paring.analyzer.util;

import com.paring.analyzer.model.ParingResult;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.paring.analyzer.model.ParingResult.getParingResultString;
import static com.paring.analyzer.model.RateTable.allRate;

public class Util {

    public static void printText(List<ParingResult> result, TextArea resultText) {
        resultText.clear();
        StringBuilder resultString = new StringBuilder();
        String midRate = midRate(result);
        resultString.append("Среднее значение: " + midRate + "\n");
        resultString.append("----------------\n");
        result.stream()
                .forEach(s -> {
                    resultString.append(getParingResultString(s, allRate));
                    resultString.append("----------------\n");
                });
        resultText.setText(resultString.toString());
    }

    public static String midRate(List<ParingResult> paringResult) {
        AtomicInteger allSumRate = new AtomicInteger();
        paringResult.stream()
                .forEach(par -> allSumRate.addAndGet(Integer.valueOf(par.getSumRate())));
        return String.valueOf(Double.valueOf(allSumRate.get()) / 36);
    }

    public static void setOrkTeamRateData(TextField p1,
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
        p1.setText("Necr");
        p2.setText("Nid");
        p3.setText("Vot");
        op1.setText("Ork");
        op2.setText("Gsc");
        op3.setText("Mar");
        p1op1.setText("7");
        p1op2.setText("7");
        p1op3.setText("6");
        p2op1.setText("6");
        p2op2.setText("7");
        p2op3.setText("2");
        p3op1.setText("5");
        p3op2.setText("9");
        p3op3.setText("5");
    }

    public static void setAocTeamRateData(TextField p1,
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
        p1.setText("Necr");
        p2.setText("Nid");
        p3.setText("Vot");
        op1.setText("Ts");
        op2.setText("AM");
        op3.setText("Gk");
        p1op1.setText("3");
        p1op2.setText("5");
        p1op3.setText("6");
        p2op1.setText("6");
        p2op2.setText("3");
        p2op3.setText("5");
        p3op1.setText("4");
        p3op2.setText("7");
        p3op3.setText("5");
    }

    public static void setChaosTeamRateData(TextField p1,
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
        p1.setText("Necr");
        p2.setText("Nid");
        p3.setText("Vot");
        op1.setText("CKnight");
        op2.setText("DA");
        op3.setText("Lucius");
        p1op1.setText("6");
        p1op2.setText("7");
        p1op3.setText("7");
        p2op1.setText("5");
        p2op2.setText("7");
        p2op3.setText("7");
        p3op1.setText("6");
        p3op2.setText("9");
        p3op3.setText("10");
    }
}
