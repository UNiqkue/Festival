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
import java.util.Collections;

import by.nik.traning.entity.Event;
import by.nik.traning.entity.Role;
import by.nik.traning.entity.User;

public class MainClass {
	
	public static void main(String[] args) throws IOException {
		
		Event event = new Event(1, "Night Event", "2018-01-01", "Kiseleva 7", 500, 0);
		User user = new User(1, "V", "X", 24);
		user.setRole(Collections.singleton(Role.User));

		try {
			if (event.getCountPlace() > event.getCountUser()){
				event.addUser();
			}
		} catch (EventException e){
			e.getMessage();
		}

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
//
//			FileOutputStream fos = new FileOutputStream("event.ser");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(event);
//			oos.close();
//
//			FileInputStream fis = new FileInputStream("event.ser");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			try {
//				event = (Event) ois.readObject();
//			} catch (ClassNotFoundException e) {
//
//				e.printStackTrace();
//			}
//			ois.close();
			

	}
	

	
}
