package com.chiyi.user.entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestRecordEntity {

    String id;
    String motorNo;
    String operator;
    Timestamp testDate;
    String testDateStr;
    float totalEnergy;
    float effectiveEnergy;
    float efficiency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMotorNo() {
        return motorNo;
    }

    public void setMotorNo(String motorNo) {
        this.motorNo = motorNo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Timestamp getTestData() {
        return testDate;
    }

    public void setTestData(Timestamp testData) {
        this.testDate = testData;
    }

    public void setTestDateStr() {
        this.testDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.testDate);
    }

    public String getTestDateStr() {
        return testDateStr;
    }

    public float getTotalEnergy() {
        return totalEnergy;
    }

    public void setTotalEnergy(float totalEnergy) {
        this.totalEnergy = totalEnergy;
    }

    public float getEffectiveEnergy() {
        return effectiveEnergy;
    }

    public void setEffectiveEnergy(float effectiveEnergy) {
        this.effectiveEnergy = effectiveEnergy;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(float efficiency) {
        this.efficiency = efficiency;
    }

    public TestRecordEntity() {
    }
}
