package dyplomowka;

import java.util.*;

public class Controller implements Subject {

    private static Controller instance = null;
    private List<Integer> temperatures = new ArrayList<>()  ;
    private ArrayList<Observer> observers;

    public Controller() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void deleteObserver(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);

        if (observerIndex >= 0) {
            observers.remove(observerIndex);
        }
    }

    @Override
    public void notifyObserver(Observer o) {
        for (int i =0; i <observers.size(); i++) {
            Observer observer = observers.get(i);
            // observer.update();
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public static Controller getInstance(){
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public List<Integer> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(ArrayList<Integer> temperatures) {
        this.temperatures = temperatures;
    }
}
