package com.TendaiMMutamba;


import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {
    public static void main(String[] args) {
        System.out.printf("Hello%n If you are a user type 1.%n If you are an administrator type 2. %n");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()){
            case 1:
                User.userMenu();
                break;
            case 2:
                LibraryAdministrator.administratorMenu();
                break;

            default:
                System.out.println("Sorry that value is not recognised");
        }





    }
}










