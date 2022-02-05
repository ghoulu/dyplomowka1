package dyplomowka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class PanelTemp extends JFrame {
    int x,y;
    int tempAkt = 0;
    int tempZad=0;

    int tempNew = 0;

    private final Controller controller = Controller.getInstance();

    public PanelTemp(int x, int y, int tempAkt){
        this.x = x;
        this.y = y;
        this.setBounds(x,y,200,150);

        initComponents();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        this.tempAkt = tempAkt;
    }
    public PanelTemp(int tempAkt){
        this.setBounds(this.x,this.y,200,150);

        initComponents();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        this.tempAkt = tempAkt;
    }

    public  PanelTemp() {
        this.setBounds(this.x,this.y,200,150);

        initComponents();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    public void setTempZad(Integer tempZad) {
        this.tempZad = tempZad;
    }

    public void initComponents() {
        panelTemp.add(etykietaTempAkt);
        panelTemp.add(etykietaTempZad);
        panelTemp.add(zmianaTempZad);
        panelTemp.add(poleZmainaTempZad);
        panelTemp.add(buttonZatwierdz);

        buttonZatwierdz.addActionListener(new ZmianaHandler());

        this.getContentPane().add(panelTemp);
    }

    private JPanel panelTemp = new JPanel();
    private JLabel etykietaTempAkt = new JLabel("Aktualna temperatura: "+tempAkt+" stC");
    private JLabel etykietaTempZad = new JLabel("Zadana temperatura:   "+tempZad+" stC");
    private JLabel zmianaTempZad = new  JLabel("Zmień temp. zad.:   ");
    private JTextField poleZmainaTempZad = new JTextField(2);
    private JButton buttonZatwierdz = new JButton("OK");



     class ZmianaHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var source = e.getSource();
            poleZmainaTempZad.requestFocus();
     //       String tekstZastepowany = poleZmainaTempZad.getText();
            setTempZad(Integer.parseInt(poleZmainaTempZad.getText()));
            System.out.println("tempZad = " + tempZad);

            tempNew = Integer.parseInt(poleZmainaTempZad.getText());

            controller.getTemperatures().add(tempNew);
            etykietaTempZad.setText("Zadana temperatura:   "+poleZmainaTempZad.getText()+" stC");

        }
    }

    void zmienWartoscParam(ParametryTemp zm, int a) {
        setTempZad(a);
    }

    public int getTempNew() {
        return tempNew;
    }

    public void setTempAkt(int tempAkt) {
        this.tempAkt = tempAkt;
    }
}
