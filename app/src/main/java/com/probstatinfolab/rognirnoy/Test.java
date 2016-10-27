package com.probstatinfolab.rognirnoy;

/**
 * Created by RONY on 25-10-16.
 */
public class Test {

    String testName, testFee, testPlace, testPrerequisite;

    public Test(String testName, String testFee, String testPlace, String testPrerequisite) {
        this.testName = testName;
        this.testFee = testFee;
        this.testPlace = testPlace;
        this.testPrerequisite = testPrerequisite;
    }

    public String getTestName() {
        return testName;
    }

    public String getTestPlace() {
        return testPlace;
    }

    public void setTestPrerequisite(String testPrerequisite) {
        this.testPrerequisite = testPrerequisite;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setTestFee(String testFee) {
        this.testFee = testFee;
    }

    public void setTestPlace(String testPlace) {
        this.testPlace = testPlace;
    }

    public String getTestPrerequisite() {
        return testPrerequisite;
    }

    public String getTestFee() {
        return testFee;
    }
}

