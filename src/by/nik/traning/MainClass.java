package by.nik.traning;

import java.io.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.nik.traning.collection.TimeOutQueue;
import by.nik.traning.entity.Event;
import by.nik.traning.entity.Role;
import by.nik.traning.entity.User;
import by.nik.traning.exceptions.EventException;
import by.nik.traning.exceptions.PhoneNumberException;

public class MainClass {
	
	public static void main(String[] args) throws IOException {

		//создать свой параметризированный класс TimeOutQueue<T> должен работать со всеми типами данных . 2 метода
		//  offer (T t, long millis) время жизни в очереди, помещает в очередь элемент
		// T poll() вернуть следующий в очереди элемент пока он еще живой, проходит по списку элементов и если у кого-то закончилдось время его удаляют и возвращает живые! согласно FIFO!
		// size() проверить сколько элементов  в очереди

		Timer t = new Timer();
		TimeOutQueue<String> queue = new TimeOutQueue<String>();

		queue.offer("a1", 1000);
		queue.offer("b2", 1500);
		queue.offer("c3", 2000);
		queue.offer("d4", 4000);
		queue.offer("d5", 5000);
		queue.offer("e6", 6000);
		queue.offer("f7", 7000);
		queue.offer("g8", 8000);
		queue.offer("h9", 9000);

		t.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(queue.poll());
				if (queue.size() == 0) {
					cancel();
				}
			}
		}, 0, 2000);


	}


}
	

	

