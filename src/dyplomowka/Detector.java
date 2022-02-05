package dyplomowka;

import javax.swing.*;

public class Detector extends JCheckBox{
    String detectorName;
    int x;
    int y;
    boolean stan=false;

    public Detector(String detectorName, int x, int y) {
        super(detectorName);
        this.detectorName = detectorName;
        this.x = x;
        this.y = y;

        new JCheckBox(detectorName);
        this.setBounds(x+30,y-30,40,30);
//        this.addActionListener(new SluchaczPrzyciskowTemp());

    }
}
