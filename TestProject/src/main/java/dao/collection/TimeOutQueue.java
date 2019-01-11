package dao.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class TimeOutQueue<T> extends LinkedList<T> implements Queue<T> {

    private LinkedList<T> list;

    public TimeOutQueue() {
        super();
        list = new LinkedList<T>();
    }

    public boolean offer(final T t, long millis) throws NullPointerException {
        if (millis > 0) {
            list.add(t);
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask(){
                @Override
                public void run(){
                    list.remove(t);
                }
            };
            timer.schedule(timerTask, millis);
            return true;
        }
        throw new NullPointerException("Value must be more than zero");
    }

    public T poll(){
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public int size() {
        return list.size();
    }


}
