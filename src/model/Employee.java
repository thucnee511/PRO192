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
public abstract class Employee implements Comparable<Employee> {

    protected String empID;
    protected String empName;
    protected double baseSal;

    public Employee() {
    }

    public Employee(String empID, String empName, int baseSal) {
        this.empID = empID;
        this.empName = empName;
        this.baseSal = baseSal;
    }

    public abstract double getSalary();

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getBaseSal() {
        return baseSal;
    }

    public void setBaseSal(double baseSal) {
        this.baseSal = baseSal;
    }

    @Override
    public String toString() {
        return empID + "_" + empName + "_" + baseSal;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.baseSal == o.baseSal) {
            String name = this.empName.substring(this.empName.lastIndexOf(" "));
            String _name = o.empName.substring(o.empName.lastIndexOf(" "));
            return name.compareTo(_name);
        } else {
            return Double.compare(this.baseSal, o.baseSal);
        }
    }
}
