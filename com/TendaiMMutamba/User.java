package com.TendaiMMutamba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.Serializable;



public class User implements Serializable {
    private static String bookTitle;

    private static int option() {
        System.out.printf("Hello. Here is the menu: %nTo check-out a book type 1 %n" +
                "To return a book type 2 %nTo exit type 3");
        int input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();


        return input;

    }

    public static void userMenu() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        switch (option()) {
            case 1:
                try {
                    System.out.println("Enter the title of the book you want to check out:");
                    bookTitle = bufferedReader.readLine();
                }
                catch(IOException ioe)
                {
                    System.out.println("Sorry, error reading your input, the system will now exit");
                    System.exit(1);
                }
                int isFound = 0;
                for (Book book : SaveHelper.load()) {
                    if (book.mInStock && bookTitle.equals(book.getTitle())) {
                        System.out.printf("%s is in the library", book.getTitle());
                        book.setInStock(false);
                        isFound = 1;
                        break;
                    }

                }
                if (isFound == 0) {
                    System.out.println("Sorry the book has not been found");
                }
                break;
            case 2:
                System.out.println("Please enter the title of the book");
                try {
                    bookTitle = bufferedReader.readLine();
                } catch (IOException ioe) {
                    System.out.println("Error reading your text");
                    ioe.printStackTrace();
                }

                for (Book book : SaveHelper.load()) {
                    if (book.getTitle().toLowerCase().trim().equals(bookTitle.toLowerCase().trim())) {
                        book.setInStock(true);
                        break;
                    }

                }
                break;
            case 3:
                System.out.println("Now exiting....");
                System.exit(1);
                break;
            default:
                System.out.println("Sorry, incorrect input.");
                break;

        }

    }
}