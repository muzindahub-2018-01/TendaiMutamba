package com.TendaiMMutamba;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveHelper {

    public static void save(List<Book> books)
    {
        try(
                FileOutputStream fos = new FileOutputStream("LibraryBooks.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
        oos.writeObject(books);
        } catch(IOException ioe)
        {
            System.out.printf("We failed to save the file." +
                    "The following error was detected: %n");
            ioe.printStackTrace();
        }
    }
    public static ArrayList<Book> load()
    { // create the arrayList called books
        ArrayList<Book> book = new ArrayList<>();
        try(
            FileInputStream fis = new FileInputStream("LibraryBooks.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);


        ) {
            book =  (ArrayList<Book>) ois.readObject();

        }catch(IOException | ClassNotFoundException ioe)
        {
            System.out.printf("We failed to load the file." +
                    "The following error was detected: %n");
            ioe.printStackTrace();
        }


        return book;
    }
}
