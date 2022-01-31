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

        setLayout(new FlowLayout());
        kontener.setLayout(null);

//        panel.add(przyciskTemp1);
//        przyciskTemp1.setSize(100,40);
        przyciskTemp1.setBounds(450, 405, 100, 50);
        przyciskTemp2.setBounds(450, 335, 100, 50);
        przyciskTemp3.setBounds(775, 360, 100, 50);
        przyciskTemp4.setBounds(1000, 490, 100, 50);
        przyciskTemp5.setBounds(1170, 550, 100, 50);
        przyciskTemp6.setBounds(1025, 735, 100, 50);
        przyciskTemp7.setBounds(700, 560, 100, 50);
        przyciskTemp8.setBounds(1280, 820, 100, 50);
        panel.setBounds(0, 0, 1680, 1050);
//        przyciskTemp1.setLocation(new Point(500,500));

        przyciskTemp1.addActionListener(new SluchaczPrzyciskowTemp());

        kontener.add(przyciskTemp1);
        kontener.add(przyciskTemp2);
        kontener.add(przyciskTemp3);
        kontener.add(przyciskTemp4);
        kontener.add(przyciskTemp5);
        kontener.add(przyciskTemp6);
        kontener.add(przyciskTemp7);
        kontener.add(przyciskTemp8);
//        kontener.add(przyciskTemp8.setBounds(200,200,100,40));
        kontener.add(new ButtonTemp("testowyX", 1500,950,100,50));
        kontener.add(panel);

        System.out.println("temperatury: "+ "");

//        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    JPanel panel = new ObrazPanel();
    JButton przyciskTemp1 = new JButton("Temp1: ");
    JButton przyciskTemp2 = new JButton("Temp2: ");
    JButton przyciskTemp3 = new JButton("Temp3: ");
    JButton przyciskTemp4 = new JButton("Temp4: ");
    JButton przyciskTemp5 = new JButton("Temp5: ");
    JButton przyciskTemp6 = new JButton("Temp6: ");
    JButton przyciskTemp7 = new JButton("Temp7: ");
    JButton przyciskTemp8 = new JButton("Temp8: ");
    ParametryTemp parTemp1 = new ParametryTemp(18,12);


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
