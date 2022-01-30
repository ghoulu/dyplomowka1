package dyplomowka;

import javax.swing.*;

public class PanelTemp extends JFrame {
    int x=100,y=200;
    double tempAkt = 18, tempZad=20;

    public PanelTemp(){
        this.setBounds(this.x,this.y,300,300);

        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void initComponents() {
        panelTemp.add(etykietaTempAkt);
        panelTemp.add(etykietaTempZad);
        panelTemp.add(zmainaTempZad);

        this.getContentPane().add(panelTemp);
    }

    private JPanel panelTemp = new JPanel();
    private JLabel etykietaTempAkt = new JLabel("Aktualna temperatura: "+tempAkt+" stC");
    private JLabel etykietaTempZad = new JLabel("Zadana temperatura:   "+tempZad+" stC");
    private JLabel zmainaTempZad = new  JLabel("Zmiana temperatury:   "+tempZad+" stC");

}
