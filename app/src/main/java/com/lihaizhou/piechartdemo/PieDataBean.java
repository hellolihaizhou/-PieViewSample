package com.lihaizhou.piechartdemo;

/**
 * Created by Administrator on 2016/11/25 0025.
 */

public class PieDataBean {
    private String[] fruitNames;
    private int[] fruitSum;
    private float[] fruitPercentages;
    private float[] fruitAngles;
    private int[] colors;

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }

    public PieDataBean(String[] fruitNames,int[] fruitSum)
    {
        this.fruitNames = fruitNames;
        this.fruitSum = fruitSum;
    }
    public String[] getFuritNames() {
        return fruitNames;
    }

    public void setFuritNames(String[] furitNames) {
        this.fruitNames = furitNames;
    }

    public int[] getFruitSum() {
        return fruitSum;
    }

    public void setFruitSum(int[] fruitSum) {
        this.fruitSum = fruitSum;
    }

    public float[] getFruitPercentages() {
        return fruitPercentages;
    }

    public void setFruitPercentages(float[] fruitPercentages) {
        this.fruitPercentages = fruitPercentages;
    }

    public float[] getFruitAngles() {
        return fruitAngles;
    }

    public void setFruitAngles(float[] fruitAngles) {
        this.fruitAngles = fruitAngles;
    }
}
