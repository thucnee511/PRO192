/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.CompanyManagement;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        try {
            CompanyManagement cm = new CompanyManagement("/input/ListOfEmployees.txt", "/input/PLInfo.txt");
            while (true) {

            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
