package dyplomowka;

import java.io.ObjectOutputStream;
import java.util.Observer;

public interface ChangeView extends Observer {

    public void changeView(Observer observer);
    public void updateView(Observer observer);

}
