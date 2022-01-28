package dyplomowka;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelGlowny extends JFrame {

    public PanelGlowny() {
        super("Panel główny");
        this.setBounds(100, 20, 1680, 1050);


        Container kontener = this.getContentPane();
//                kontener.add(panel);
//                JButton button2 = new JButton("Button2");
//                button2.setBounds(50,50,100,100);
//                kontener.add(button2);
//                panel.setLayout(new FlowLayout());
//                kontener.setLayout(new FlowLayout());





//        setLayout(new FlowLayout());
//        panel.add(przyciskTemp1);
//        przyciskTemp1.setSize(100,40);
        przyciskTemp1.setBounds(100, 100, 100, 100);
        panel.setBounds(0, 0, 1680, 1050);
//        przyciskTemp1.setLocation(new Point(500,500));
        kontener.setLayout(null);
        kontener.add(przyciskTemp1);
        kontener.add(panel);

//        przyciskTemp1
//        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    JPanel panel = new ObrazPanel();
    JButton przyciskTemp1 = new JButton();
    JButton przyciskTemp2 = new JButton();

    public void budujButton(String nazwa) {
        JButton przycisk = new JButton(nazwa);
//        przycisk.addActionListener(new sluchaczTemp(a));
        panel.add(przycisk);
    }

    private class sluchaczTemp implements ActionListener {
        public sluchaczTemp() {
//            this.par1 = "kolor";
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println("slucham przeciez");

        }

    }
}
