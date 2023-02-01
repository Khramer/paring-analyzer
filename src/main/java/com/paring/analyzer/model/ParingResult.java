package com.paring.analyzer.model;

import java.text.MessageFormat;
import java.util.Map;

public class ParingResult {

    private Integer v;
    private String ourDef;
    private String getOurDef;
    private String enDef;
    private String getEnDef;
    private String lastOurPlayer;
    private String lastEn;
    private Integer sumRate;

    public ParingResult() {
    }

    public ParingResult(Integer v, String ourDef, String getOurDef, String enDef, String getEnDef, String lastOurPlayer, String lastEn, Integer sumRate) {
        this.v = v;
        this.ourDef = ourDef;
        this.getOurDef = getOurDef;
        this.enDef = enDef;
        this.getEnDef = getEnDef;
        this.lastOurPlayer = lastOurPlayer;
        this.lastEn = lastEn;
        this.sumRate = sumRate;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getOurDef() {
        return ourDef;
    }

    public void setOurDef(String ourDef) {
        this.ourDef = ourDef;
    }

    public String getGetOurDef() {
        return getOurDef;
    }

    public void setGetOurDef(String getOurDef) {
        this.getOurDef = getOurDef;
    }

    public String getEnDef() {
        return enDef;
    }

    public void setEnDef(String enDef) {
        this.enDef = enDef;
    }

    public String getGetEnDef() {
        return getEnDef;
    }

    public void setGetEnDef(String getEnDef) {
        this.getEnDef = getEnDef;
    }

    public String getLastOurPlayer() {
        return lastOurPlayer;
    }

    public void setLastOurPlayer(String lastOurPlayer) {
        this.lastOurPlayer = lastOurPlayer;
    }

    public String getLastEn() {
        return lastEn;
    }

    public void setLastEn(String lastEn) {
        this.lastEn = lastEn;
    }

    public Integer getSumRate() {
        return sumRate;
    }

    public void setSumRate(Integer sumRate) {
        this.sumRate = sumRate;
    }

    public static String getParingResultString(ParingResult paringResult, Map<String, Map<String, Integer>> allRate) {
        String v = String.valueOf(paringResult.getV());
        String ourDef = paringResult.getOurDef();
        String getOurDef = paringResult.getGetOurDef();
        String enDef = paringResult.getEnDef();
        String getEnDef = paringResult.getGetEnDef();
        String lastOurPlayer = paringResult.getLastOurPlayer();
        String lastEn = paringResult.getLastEn();
        String sumRate = String.valueOf(paringResult.getSumRate());

        Integer oneParRate = allRate.get(ourDef).get(getOurDef);
        Integer twoParRate = allRate.get(getEnDef).get(enDef);
        Integer threeParRate = allRate.get(lastOurPlayer).get(lastEn);

        return MessageFormat.format("{0} и {2} \n{0} -{7}- {1} | {2} -{8}- {3} | {4} -{9}- {5} = {6} \n", ourDef, getOurDef, enDef, getEnDef, lastOurPlayer, lastEn, sumRate, oneParRate, twoParRate, threeParRate);
    }
}
