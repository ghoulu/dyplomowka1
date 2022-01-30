package dyplomowka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SluchaczPrzyciskowTemp implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("nacisnieto przycisk ");
        new PanelTemp().setVisible(true);
    }

}