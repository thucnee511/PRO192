/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Developer extends Employee {

    protected String teamName;
    protected String programmingLanguages;
    protected int expYear;

    public Developer() {
    }

    public Developer(String teamName, String programmingLanguages, int expYear) {
        this.teamName = teamName;
        this.programmingLanguages = programmingLanguages;
        this.expYear = expYear;
    }

    public Developer(String empID, String empName, int baseSal, String teamName, int expYear) {
        super(empID, empName, baseSal);
        this.teamName = teamName;
        this.expYear = expYear;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    @Override
    public double getSalary() {
        if (expYear < 3) {
            return baseSal;
        } else if (expYear < 5) {
            return baseSal + expYear * 1000000;
        } else {
            return baseSal + expYear * 2000000;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "_" + teamName + "_[" + programmingLanguages + "]_" + expYear;
    }

}
