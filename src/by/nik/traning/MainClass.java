package by.nik.traning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import by.nik.traning.entity.Event;

public class MainClass {
	
	public static void main(String[] args) throws IOException {
		
		Event event = new Event();
		
			File file = new File("file.txt");
		
			try {
	            FileWriter fw = new FileWriter(file);
	            fw.write("Hello");
	            fw.close();
	       

	            String str = null;
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            str=br.readLine();
	            System.out.println(str);
	            br.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			FileOutputStream fos = new FileOutputStream("event.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(event);
			oos.close();

			FileInputStream fis = new FileInputStream("event.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				event = (Event) ois.readObject();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			ois.close();
			
		method();
	}
	
	public static void method() {
		
	}
	
}
