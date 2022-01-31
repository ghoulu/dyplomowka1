package dyplomowka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTemp extends JFrame {
    int x=100,y=200;
    Integer tempAkt = 18, tempZad=20;

    public PanelTemp(){
        this.setBounds(this.x,this.y,300,150);

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

    private class ZmianaHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            poleZmainaTempZad.requestFocus();
            String tekstZastepowany = poleZmainaTempZad.getText();

/*                int opcja = JOptionPane.showConfirmDialog(null, "Czy chcesz zamienic '" + tempZad + "' na '" + poleZmainaTempZad.getText() + "'", "czy zmienic parametr", JOptionPane.YES_NO_OPTION);
                if (opcja == 0) {
                    tempZad = Integer.parseInt(poleZmainaTempZad.getText());
                    buttonZatwierdz.doClick();
                } else {
                    buttonZatwierdz.doClick();
                }*/
            setTempZad(Integer.parseInt(poleZmainaTempZad.getText()));
            System.out.println("tempZad = " + tempZad);

        }
    }
}
