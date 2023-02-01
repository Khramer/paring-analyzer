package com.paring.analyzer.service;

import com.paring.analyzer.model.ParingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateService {
    private static List<ParingResult> paringResults = new ArrayList<>();

    public static List<ParingResult> calculation(List<String> players,
                                                 List<String> enemies,
                                                 Map<String, Map<String, Integer>> allRate) {
        paringResults.clear();
        Integer v = 0;
        for (String ourDef : players) {
            for (String enemyDef : enemies) {
                List<String> enemyRest = enemies.stream().filter(er -> !er.equals(enemyDef)).collect(Collectors.toList());
                List<String> ourRest = players.stream().filter(or -> !or.equals(ourDef)).collect(Collectors.toList());
                for (String getOurDef : enemyRest) {
                    for (String getEnemyDef : ourRest) {
                        String lastEnemy = enemyRest.stream().filter(e -> !e.equals(getOurDef)).findFirst().get();
                        String lastOurPlayer = ourRest.stream().filter(e -> !e.equals(getEnemyDef)).findFirst().get();
                        v++;
                        Integer sumRate = allRate.get(ourDef).get(getOurDef) + allRate.get(getEnemyDef).get(enemyDef) + allRate.get(lastOurPlayer).get(lastEnemy);
                        paringResults.add(new ParingResult(v, ourDef, getOurDef, enemyDef, getEnemyDef, lastOurPlayer, lastEnemy, sumRate));
                    }
                }
            }
        }
        return paringResults;
    }
}
