package by.nik.traning;

import java.io.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.nik.traning.entity.Event;
import by.nik.traning.entity.Role;
import by.nik.traning.entity.User;
import by.nik.traning.exceptions.EventException;
import by.nik.traning.exceptions.PhoneNumberException;

public class MainClass {
	
	public static void main(String[] args) throws IOException {

		User user = new User();
		System.out.println("Введите номер телефона: \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();

		try {
			user.verifyPhoneNumber(number);
			user.verifyPhoneNumber("+375298723434");
			user.verifyPhoneNumber("379872343434"); // invalid
		} catch (PhoneNumberException e) {
			e.printStackTrace();
		}


//		String str = new String();
//		str = "Good";
//		str = str.concat("Morning");
//		System.out.println(str);
//
//		StringBuilder sbl = new StringBuilder("Good");
//		sbl = sbl.append("Day");
//		System.out.println(sbl);
//
//		StringBuffer sbf = new StringBuffer("Good");
//		sbf = sbf.append("Night");
//		System.out.println(sbf);
//
//		Calendar c = Calendar.getInstance();
//		Date date = new Date();
//		c.setTime(date);
//		c.add(c.MONTH, -9);
//		Date date2 = c.getTime();
//		System.out.println(c.getFirstDayOfWeek() == c.MONDAY);
//		System.out.println(c.get(c.DAY_OF_WEEK));
//		System.out.println(date2);
//
//		DateFormat dataf = new SimpleDateFormat("dd.MM.yyyy");
//		System.out.println(dataf.format(date2));
//		try {
//			date2 = dataf.parse("09.02.2018");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(date2);
//
//		DateFormat dataf2 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
//		DateFormat dataf3 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH);
//		DateFormat dataf4 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
//		System.out.println(dataf2.format(date2));
//		System.out.println(dataf3.format(date2));
//		System.out.println(dataf4.format(date2));
//
//
//
//		Pattern pattern = Pattern.compile("((80|\\+375)[\\s|-]?(29|25|33|44))[\\s|-]?(\\d{7}|\\d{3}[\\s|-]?\\d{2}[\\s|-]?\\d{2})");
//		Matcher matcher = pattern.matcher("qwdhqkbdwbqjwdkwqjndkjqnwdkj");
//		System.out.println(matcher.find());
//		//System.out.println(matcher.group());
//		System.out.println(matcher.matches());
//
//		String sspl = "2345 2347 23498234 23842347 2343";
//		String[] sspls = sspl.split("\\.");
//		System.out.println(sspls.length);
//
//		Scanner sc = new Scanner("123 true ajhwdkjawabababwqabc");
//		//sc.useDelimiter(",");
//		boolean b = false;
//		int i = 0;
//		String s = "";
//		while (sc.hasNext()) {
//			if (sc.hasNextBoolean()) {
//				b = sc.nextBoolean();
//			} else {
//				if (sc.hasNextInt()) {
//					i = sc.nextInt();
//				} else {
//					s = sc.next();
//				}
//			}
//		}
//
//		System.out.println(b);
//		System.out.println(s);
//		System.out.println(i);
//
//		System.out.printf("%d - %d \n", 2, 3);
//
//		MessageFormat mf = new MessageFormat("{0} - {1}");
//		System.out.println(mf.format("{0} - {1}", 2, 3));





//		Event event = new Event(1, "Night Event", "2018-01-01", "Kiseleva 7", 500, 0);
//		User user = new User(1, "V", "X", 24);
//		user.setRole(Collections.singleton(Role.User));
//
//		try {
//			if (event.getCountPlace() > event.getCountUser()){
//				event.addUser();
//			}
//		} catch (EventException e){
//			e.getMessage();
//		}
//
//		File file = new File("file.txt");
//
//			try {
//	            FileWriter fw = new FileWriter(file);
//	            fw.write("Hello");
//	            fw.close();
//
//	            String str = null;
//	            BufferedReader br = new BufferedReader(new FileReader(file));
//	            str=br.readLine();
//	            System.out.println(str);
//	            br.close();
//
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
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
