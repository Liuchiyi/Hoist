package com.chiyi.user.entity;

public class MotorEntity {
    String id;
    String manufacturer;
    String pattern;
    String testNum;
    String avgEfficiency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getTestNum() {
        return testNum;
    }

    public void setTestNum(String testNum) {
        this.testNum = testNum;
    }

    public String getAvgEfficiency() {
        return avgEfficiency;
    }

    public void setAvgEfficiency(String avgEfficiency) {
        this.avgEfficiency = avgEfficiency;
    }
}
