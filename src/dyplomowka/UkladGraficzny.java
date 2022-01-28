package dyplomowka;

import javax.swing.*;
import java.awt.*;

class UkladGraficzny extends JFrame {

    public UkladGraficzny() {
        super("Układ graficzny (Layout)");
        this.setBounds(600, 400, 600, 400);

        initComponents();
//        this.pack();
        this.setDefaultCloseOperation(3);
    }

    public void initComponents() {
        centrum = new JButton("Hejka");
        gora = new JButton("jestem na gorze");


        Container kontener = this.getContentPane();
        kontener.add(panel2);
/*         kontener.add(centrum, BorderLayout.CENTER);
        kontener.add(gora, BorderLayout.PAGE_START);
        kontener.add(dol, BorderLayout.PAGE_END);
        kontener.add(prawa, BorderLayout.LINE_END);
        kontener.add(lewa, BorderLayout.LINE_START);*/
        centrum.setBounds(0,0,200,100);

        kontener.setLayout(null);

        kontener.add(centrum);
    }

    JButton centrum;
    JButton gora;

    ObrazPanel panel2 = new ObrazPanel();
    JPanel panel1 = new ObrazPanel();
}