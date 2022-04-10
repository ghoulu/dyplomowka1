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

        ParametryTemp parTemp1 = new ParametryTemp(18,12);
        parTemp1.setTempZadana(14);
        System.out.println(parTemp1.getTempZadana());
    

        Container kontener = this.getContentPane();

        setLayout(new FlowLayout());
        kontener.setLayout(null);

        przyciskTemp1.setBounds(300, 405, 100, 30);
//        przyciskTemp2.setBounds(450, 335, 100, 50);
//        przyciskTemp3.setBounds(775, 360, 100, 50);
//        przyciskTemp4.setBounds(1000, 490, 100, 50);
//        przyciskTemp5.setBounds(1170, 550, 100, 50);
//        przyciskTemp6.setBounds(1025, 735, 100, 50);
//        przyciskTemp7.setBounds(700, 560, 100, 50);
//        przyciskTemp8.setBounds(1280, 820, 100, 50);
        d1check.setBounds(1700, 700, 50, 50);
        d1radio.setBounds(1700,800,50,50);
        panel.setBounds(0, 0, 1680, 1050);

        przyciskTemp1.addActionListener(new SluchaczPrzyciskowTemp(700,355));

//        kontener.add(new ButtonTemp("T1", 300, 405, 100, 30, 20,21));
        ButtonTemp buttonTempT2 = new ButtonTemp("T2", 500, 355, 100, 30, 16, 17);
        kontener.add(buttonTempT2);
        //kontener.add(new ButtonTemp("T2", 500, 355, 100, 30, 19, 20));
        kontener.add(new ButtonTemp("T3", 775, 360, 100, 30,18,19));
        kontener.add(new ButtonTemp("T4", 1000, 490, 100, 30,19,20));
        kontener.add(new ButtonTemp("T5", 1170, 550, 100, 30,19,20));
        kontener.add(new ButtonTemp("T6", 1015, 740, 100, 30,19,20));
        kontener.add(new ButtonTemp("T7", 690, 560, 100, 30,19,20));
        kontener.add(new ButtonTemp("T8", 1280, 820, 100, 30,19,20));
        kontener.add(new Detector("D1",300, 465));
        kontener.add(new Detector("D2",500, 355));
        kontener.add(new Detector("D3",775, 360));
        kontener.add(new Detector("D4",1000, 490));
        kontener.add(new Detector("D5",1170, 550));
        kontener.add(new Detector("D6",1015, 740));
        kontener.add(new Detector("D7",690, 560));
        kontener.add(new Detector("D8",1280, 820));


        kontener.add(przyciskTemp1);

/*        kontener.add(przyciskTemp2);
        kontener.add(przyciskTemp3);
        kontener.add(przyciskTemp4);
        kontener.add(przyciskTemp5);
        kontener.add(przyciskTemp6);
        kontener.add(przyciskTemp7);
        kontener.add(przyciskTemp8);*/
        kontener.add(new ButtonTemp("testowyX", 1700,950,100,50));
        kontener.add(d1radio);
        kontener.add(d1check);

        kontener.add(panel);

        System.out.println("temperatury: "+ "");

//        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    JPanel panel = new ObrazPanel();
    JRadioButton d1radio = new JRadioButton("aaa");
    JCheckBox d1check = new JCheckBox("bbb");
    JButton przyciskTemp1 = new JButton("T_1: ");
//    JButton przyciskTemp2 = new JButton("Temp2: ");
//    JButton przyciskTemp3 = new JButton("Temp3: ");
//    JButton przyciskTemp4 = new JButton("Temp4: ");
//    JButton przyciskTemp5 = new JButton("Temp5: ");
//    JButton przyciskTemp6 = new JButton("Temp6: ");
//    JButton przyciskTemp7 = new JButton("Temp7: ");
//    JButton przyciskTemp8 = new JButton("Temp8: ");

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
