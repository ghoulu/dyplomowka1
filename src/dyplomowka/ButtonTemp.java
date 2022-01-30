package dyplomowka;

import javax.swing.*;

public class ButtonTemp extends JButton {
    String butonName;
    int x;
    int y;
    int szer;
    int wys;
    double tempWysw;
    double tempZadana;

    public ButtonTemp(String butonName, int x, int y, int szer, int wys) {
        super(butonName);
        this.butonName = butonName;
        this.x = x;
        this.y = y;
        this.szer = szer;
        this.wys = wys;
//        new JButton(butonName);
        this.setBounds(x,y,szer,wys);
        this.addActionListener(new SluchaczPrzyciskowTemp());

    }
    JButton nowy = new JButton();
}
