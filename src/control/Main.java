/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CompanyManagement;
import model.Employee;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        try {
            CompanyManagement cm = new CompanyManagement("/input/ListOfEmployees.txt", "/input/PLInfo.txt");
            Menu menu = new Menu();
            menu.setOptions("Read all Employees and print to screen|"
                    + "Show staff proficient in a Programming Language|"
                    + "Show Tester has a height salary|"
                    + "Show Employee's highest salary|"
                    + "Show Leader of the Team has most Employees|"
                    + "Sort Employees as descending salary|"
                    + "Write file|"
                    + "Exit", "\\|");
            while (true) {
                menu.printMenu();
                int choice = menu.getChoice();
                switch(choice){
                    case 1:
                        cm.printEmpList(cm.getEmployeeFromFile("/input/ListOfEmployees.txt", "/input/PLInfo.txt"));
                        break;
                    case 2:
                        String pl = DataInput.getString("Enter programming language: ");
                        cm.printEmpList(cm.getDeveloperByProgrammingLanguage(pl));
                        break;
                    case 3:
                        double value = DataInput.getNumber("Enter salary value: ", ">>Error input");
                        cm.printEmpList(cm.getTestersHaveSalaryGreaterThan(value));
                        break;
                    case 4:
                        System.out.println(cm.getEmployeeWithHigestSalary());
                        break;
                    case 5:
                        System.out.println(cm.getLeaderWithMostEmployees());
                        break;
                    case 6:
                        cm.printEmpList(cm.sorted());
                        break;
                    case 7:
                        cm.writeFile("/output/Reg2.txt", cm.getDeveloperByProgrammingLanguage("C++"));
                        cm.writeFile("/output/Reg3.txt", cm.getTestersHaveSalaryGreaterThan(4700000));
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Option invalid!!");
                        break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
