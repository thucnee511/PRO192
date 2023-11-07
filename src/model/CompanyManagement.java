/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import data.files.FileAccess;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class CompanyManagement {

    private List<Employee> empList = new ArrayList<>();

    public CompanyManagement(String path, String path1) throws Exception {
        this.empList = getEmployeeFromFile(path, path1);
    }

    public List<Employee> getEmployeeFromFile(String path, String path1) throws Exception {
        FileAccess fileAccess = new FileAccess(path);
        List<String> empData = fileAccess.readFile();
        List<Employee> empList = new ArrayList<>();
        for (String line : empData) {
            List<String> dataPart = Arrays.asList(line.split(","));
            Employee e = null;
            if (dataPart.get(1).contains("T")) {
                String empID = dataPart.get(1);
                String empName = dataPart.get(2);
                double bonusRate = Double.parseDouble(dataPart.get(3));
                String type = dataPart.get(4);
                int baseSal = Integer.parseInt(dataPart.get(5));
                e = new Tester(empID, empName, baseSal, bonusRate, type);
                empList.add(e);
            } else if (dataPart.get(1).contains("D")) {
                if (dataPart.size() == 6) {
                    String empID = dataPart.get(1);
                    String empName = dataPart.get(2);
                    String teamName = dataPart.get(3);
                    int expYear = Integer.parseInt(dataPart.get(4));
                    int baseSal = Integer.parseInt(dataPart.get(5));
                    e = new Developer(empID, empName, baseSal, teamName, expYear);
                    empList.add(e);
                } else if (dataPart.size() == 8) {
                    String empID = dataPart.get(1);
                    String empName = dataPart.get(2);
                    String teamName = dataPart.get(3);
                    int expYear = Integer.parseInt(dataPart.get(4));
                    double bonusRate = Double.parseDouble(dataPart.get(6));
                    int baseSal = Integer.parseInt(dataPart.get(7));
                    e = new TeamLeader(bonusRate, empID, empName, baseSal, teamName, expYear);
                    empList.add(e);
                }
            }
        }
        fileAccess = new FileAccess(path1);
        empData = fileAccess.readFile();
        for (String line : empData) {
            String empID = line.substring(0, 3);
            String programmingLanguages = line.substring(4);
            for (Employee e : empList) {
                if (e instanceof Developer && e.getEmpID().equals(empID)) {
                    ((Developer) e).setProgrammingLanguages(programmingLanguages);
                    break;
                }
            }
        }
        return empList;
    }

    public Employee getDeveloperByProgrammingLanguage(String pl) {
        for (Employee e : empList) {
            if (e instanceof Developer) {
                if (((Developer) e).getProgrammingLanguages().toUpperCase().contains(pl.toUpperCase())) {
                    return e;
                }
            }
        }
        return null;
    }

    public Tester getTestersHaveSalaryGreaterThan(double value) {
        for (Employee e : empList) {
            if (e instanceof Tester) {
                if (e.getSalary() > value) {
                    return (Tester) e;
                }
            }
        }
        return null;
    }

    public Employee getEmployeeWithHigestSalary() {
        List<Employee> list = sorted();
        return list.get(list.size() - 1);
    }

    public TeamLeader getLeaderWithMostEmployees() {
        Map<String, Integer> teamSize = new HashMap<>();
        int max = 0;
        for (Employee e : empList) {
            if (e instanceof Developer || e instanceof TeamLeader) {
                String team = ((Developer) e).getTeamName();
                if (teamSize.containsKey(team)) {
                    int size = teamSize.get(team) + 1;
                    teamSize.replace(team, size);
                    max = max < size ? size : max;
                } else {
                    teamSize.put(team, 1);
                    max = max < 1 ? 1 : max;
                }
            }
        }
        for (Employee e : empList) {
            if (e instanceof TeamLeader) {
                String team = ((TeamLeader) e).getTeamName();
                if (teamSize.get(team) == max) {
                    return (TeamLeader) e;
                }
            }
        }
        return null;
    }

    public List<Employee> sorted() {
        List<Employee> list = new ArrayList<>(empList);
        Collections.sort(list);
        return list;
    }

    public void printEmpList() {
        for (Employee e : empList) {
            System.out.println(e);
        }
    }

    public void printEmpList(List<Employee> list) {
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    public void writeFile(String path, List<Employee> list) throws Exception {
        FileAccess f = new FileAccess(path);
        List<String> data = new ArrayList<>();
        for (Employee e : list) {
            data.add(e.toString());
        }
        f.writeFile(data);
    }

    public void writeFile(String path, Employee employee) throws Exception {
        FileAccess f = new FileAccess(path);
        List<String> data = new ArrayList<>();
        data.add(employee.toString());
        f.writeFile(data);
    }
}
