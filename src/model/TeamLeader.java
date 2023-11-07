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
public class TeamLeader extends Developer {

    private double bonusRate;

    public TeamLeader() {
    }

    public TeamLeader(double bonusRate, String empID, String empName, int baseSal, String teamName, int expYear) {
        super(empID, empName, baseSal, teamName, expYear);
        this.bonusRate = bonusRate;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonusRate * super.getSalary();
    }
}
