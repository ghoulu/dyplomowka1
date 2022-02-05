package dyplomowka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SluchaczPrzyciskowTemp implements ActionListener {
    int x;
    int y;
    SluchaczPrzyciskowTemp(int x, int y){
        this.x = x;
        this.y = y;
    }

    private PanelTemp panelTemp = new PanelTemp();
    private int newTemp = 0;
    private Controller controller = Controller.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.getTemperatures().add(newTemp);
        System.out.println("nacisnieto przycisk ");

        new PanelTemp(x,y,controller.getTemperatures().get(0)).setVisible(true);
        controller.getTemperatures().remove(0);
    }

}