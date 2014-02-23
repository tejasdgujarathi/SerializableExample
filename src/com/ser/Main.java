package com.ser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws Exception{
		Book book = new Book(1, "C", "Pravin");

		String filename = "o.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				new File(filename)));
		
		oos.writeObject(book);
		oos.close();
		
		
		FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Book b = (Book) in.readObject();
        in.close();
        
        System.out.println("Book name is " + b.getName());
        System.out.println("Author is " + b.getAuthor() + ", as author field is marked as transient.");
        fileIn.close();
		
		System.out.println("Done");

	}

}
