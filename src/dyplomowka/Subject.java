package dyplomowka;

import java.util.Observer;

public interface Subject extends Observer {

    public void registerObserver(Observer o);
    public void deleteObserver(Observer o);
    public void notifyObserver(Observer o);
}
