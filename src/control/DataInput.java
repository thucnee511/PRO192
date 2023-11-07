package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public final class DataInput {

    public static int getNumber(String msg, String errorMsg)
            throws Exception {
        Scanner sc = new Scanner(System.in);
        int value = 0;
        try {
            System.out.print(msg);
            value = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            throw new Exception(errorMsg);
        }
        return value;
    }

    public static String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        String value = sc.nextLine();
        return value.trim();
    }
}