package com.TendaiMMutamba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryAdministrator implements Serializable {
    private static String author,title;
    private static int option()
    {
        System.out.printf("Hello, here is the menu: %n" + "To add a book to the library type 1 %n" +
                "To remove a book from the library type 2 %n" + "To exit the program type 3");
        int input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        return input;
    }
    public static void administratorMenu()
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        switch (option()) {
            case 1:
                try{
                    System.out.println("Enter the Title of the book");
                    title = bufferedReader.readLine();
                    System.out.println("Enter the author of the book");
                    author = bufferedReader.readLine();
                    Book book = new Book(title, author);
                    ArrayList<Book> books = new ArrayList<>(SaveHelper.load());
                    books.add(book);
                    SaveHelper.save(books);
                    System.out.printf("The book %s by %s has been successfully added to the library", book.getTitle(), book.getAuthor());
                }catch(IOException ioe) {
                    System.out.println("Sorry problem saving the file");
                }
                break;
            case 2:
                try
                {
                    System.out.println("Enter the title of the book you want to remove");
                    String bookTitle = bufferedReader.readLine();
                    for(Book book : SaveHelper.load())
                    {
                        if(book.getTitle().toLowerCase().trim().equals(bookTitle.toLowerCase().trim())){
                            title = book.getTitle();
                            author = book.getAuthor();
                            ArrayList books = new ArrayList<>(SaveHelper.load());
                            books.remove(book);
                            System.out.printf("Book %s by %s has been removed from the library",title,author);
                        }

                    }
                }
                catch (IOException ioe)
                {
                    System.out.println("Error removing book");
                }
                break;
            case 3:
                System.out.println("Now exiting.....");
                System.exit(1);
                break;
        }
    }
}
