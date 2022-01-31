package dyplomowka;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;
import java.awt.*; //abstract window toolkit
import java.awt.event.*;
import java.awt.image.ImageConsumer;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestoweNetBeansy {

    public void testowe() {
//        new Ramka("MojaRamka").setVisible(true);
//        new UkladGraficzny().setVisible(true);
//        new MojFlowLayout().setVisible(true);
//        new MojGroupLayout().setVisible(true);
        new MojeZdarzenia().setVisible(true);  //KURS NR 64 - POWTÓRZYĆ OD CZASU 13:30 - WPROWADZANIE KLAS ABSTRAKCYJNYCH
        new MojeEtykiety().setVisible(true);
        new MojePrzelaczniki().setVisible(true);
//        new MojeCheckBox().setVisible(true);
        new MojeMenu().setVisible(true);
////        //new MojJTextFrame().setVisible(true);
        new MojeTexArea().setVisible(true);
////        //new MojePrzeszukiwaczTekstu().setVisible(true);
//        new MojeListyKombinowane().setVisible(true);
        new MojeZdarzeniaOkna().setVisible(true);
        new MojeWieleRamek().setVisible(true);
//        new MojeObramowkiIkrawedzie().setVisible(true);
//        new MojeSuwak().setVisible(true);
        new MojePasekMenu1().setVisible(true);
        new MojeMenuKontekstowe().setVisible(true);
        new MojePasekNarzedzi().setVisible(true);
    }
}

/*class MojeCos extends JFrame{

    public MojeCos(){
        super("Zdarzenia");
        this.setBounds(600,400,600,400);
        initComponents();
        this.setDefaultCloseOperation(3);
    }

    public void initComponents()
    {
    }
}*/


class MojePasekNarzedzi extends JFrame{

    public MojePasekNarzedzi(){
        super("MojePasekNarzedzi");
        this.setBounds(600,400,600,400);
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents()
    {

        pasekNarzedzi.add(new KolorowyButton(new ActionColor("Zmienia kolor na zielony", new ImageIcon("zielony.gif"), Color.GREEN)));
        pasekNarzedzi.add(new KolorowyButton(new ActionColor("Zmienia kolor na niebieski", new ImageIcon("niebieski.gif"), Color.BLUE)));
        pasekNarzedzi.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                aktywny = null;
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (aktywny != null)
                panel.setBackground((Color) aktywny.getAction().getValue("kolor"));
            }
        });

        this.getContentPane().add(pasekNarzedzi, BorderLayout.NORTH);
        this.getContentPane().add(panel);

    }

    private JToolBar pasekNarzedzi = new JToolBar("Nazwa nowej ramki");
    private JButton button = new JButton("Wyłącz malowanie");
    private JPanel panel = new JPanel();
    private KolorowyButton aktywny = null;

    private class ActionColor extends AbstractAction{

        public ActionColor(String toolTip, Icon icon, Color colour) {
            this.putValue(Action.SHORT_DESCRIPTION, toolTip);
            this.putValue(Action.SMALL_ICON, icon);
            this.putValue("kolor", colour);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            aktywny = (KolorowyButton) e.getSource();
        }
    }

    private class KolorowyButton extends JButton     {
        public KolorowyButton(ActionColor actionColor)        {
            super(actionColor);

            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < pasekNarzedzi.getComponentCount(); i++) {
                        if (pasekNarzedzi.getComponent(i) instanceof KolorowyButton) {
                            KolorowyButton tmp = (KolorowyButton)pasekNarzedzi.getComponent(i);
                            tmp.setBackground(Color.WHITE);
                            tmp.setZaznaczony(false);
                            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("czerwony.gif").getImage(), new Point(0,0), "nasz kursorek"));
                        }

                    }
                    ten.setBackground((Color)actionColor.getValue("kolor"));
                    ten.setZaznaczony(true);
                }
            });
        }
        public void setZaznaczony(boolean zazn){
            this.zaznaczony = zazn;
        }

        KolorowyButton ten = this;
        boolean zaznaczony = false;
    }
}

class MojeMenuKontekstowe extends JFrame{

    public MojeMenuKontekstowe(){
        super("MojeMenuKontekstowe");
        this.setBounds(600,400,600,400);
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents()
    {
        JPopupMenu menuKontekstowe = new JPopupMenu();

        menuKontekstowe.add(new JMenuItem(new AbstractAction("Zamknij") {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }));
        menuKontekstowe.add(new JMenuItem("Kopiuj"));
        menuKontekstowe.add(new JMenuItem("Wklej"));
        menuKontekstowe.add(new JMenuItem("Wytnij"));

        testowiec.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("odcisłeś " + e.getButton());
                if (e.getClickCount() == 3 && e.getButton()==MouseEvent.BUTTON3 && e.isShiftDown())
                    JOptionPane.showMessageDialog(null,"Aleś się naklikał");

                if (e.isPopupTrigger()) //(e.getButton() == MouseEvent.BUTTON3)
                    menuKontekstowe.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        this.getContentPane().add(testowiec, BorderLayout.SOUTH);

    }

    private JButton testowiec = new JButton("test");
}


class MojePasekMenu1 extends JFrame{

    public MojePasekMenu1(){
        super("MojePasekMenu1");
        this.setBounds(600,400,600,400);
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents()
    {
        this.setJMenuBar(pasekMenu);

//        pasekMenu.add(new JMenu("Plik"));     //pierwsza metoda

//        JMenu menuPlik = new JMenu("Plik");  //druga metoda
//        pasekMenu.add(menuPlik);             //druga metoda

        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
        menuPlik.setMnemonic('P');

//        menuPlik.add("Nowy");       //pierwsza metoda
        JMenuItem podMenuNowy = menuPlik.add(new JMenuItem("Nowy")); //druga metoda
        podMenuNowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tu jest kod tworzączy podmenu Nowy");
            }
        });
        menuPlik.addSeparator();

//        final Action actionSave = new ActionSave("Zapisz", "Zapisuje do pamięci", "ctrl S", KeyEvent.VK_Z);
        final Action actionSave = new ActionSave("Zapisz", "Zapisuje do pamięci", "ctrl S", KeyEvent.VK_Z);
//        JMenuItem podMenuZapisz = menuPlik.add(new JMenuItem("Zapisz"));
        final JMenuItem podMenuZapisz = menuPlik.add(new JMenuItem(actionSave));
        przyciskZapisz = new JButton(actionSave);
//        podMenuZapisz.setEnabled(false);
        actionSave.setEnabled((false));

/*
        podMenuZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Zapisujemy na dysk !!!");
                podMenuZapisz.setEnabled(flagaObszaruTekstowego=false);
                przyciskZapisz.setEnabled(flagaObszaruTekstowego=false); //dodatkowe wyciągnięcie polecenia zapisz
            }
        });

        podMenuZapisz.setToolTipText("Zapisanie pliku na dysku");
        podMenuZapisz.setMnemonic('Z');
        podMenuZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
*/

        menuPlik.add(new JMenuItem("Wczytaj"));
        menuPlik.addSeparator();

        JMenuItem menuOpcje = menuPlik.add(new JMenu("Opcje"));
        menuOpcje.add(new JMenuItem("Opcja 1"));
        menuOpcje.add(new JMenuItem("Opcja 2"));

        //pasekMenu.add(podMenuZapisz); // //dodatkowe wyciągnięcie polecenia zapisz - duplikowanie przycisku by był na wierzchu

        menuPlik.add(tylkoDoOdczytu);
        tylkoDoOdczytu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tylkoDoOdczytu.isSelected())
                    actionSave.setEnabled(false);
                else
                    actionSave.setEnabled(flagaObszaruTekstowego);
            }
        });

        JMenu menuPomoc = pasekMenu.add(new JMenu("Pomoc"));
        menuPomoc.add(new JMenuItem("FAQ"));

        obszarTekstowy.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
                if (tylkoDoOdczytu.isSelected())
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
                if (tylkoDoOdczytu.isSelected())
                    e.consume();
                else if(!(obszarTekstowy.getText() + e.getKeyChar()).equals(przedZmianaObszaruTekstoweg) && czyToAscii(e.getKeyChar())) {
                    przedZmianaObszaruTekstoweg = obszarTekstowy.getText()+ e.getKeyChar();
                    actionSave.setEnabled(flagaObszaruTekstowego=true);
//                przyciskZapisz.setEnabled(flagaObszaruTekstowego=true); //dodatkowe wyciągnięcie polecenia zapisz
                }
                System.out.println(obszarTekstowy.getText()+e.getKeyChar());
            }
        });

        menuPomoc.add(popUpMenu);
        pasekMenu.add(radioButtonMenu);
//        this.getContentPane().add(poleTekstowe, BorderLayout.CENTER);
        this.getContentPane().add(obszarTekstowy, BorderLayout.NORTH);
        this.getContentPane().add(przyciskZapisz);
    }

    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("Tylko do odczytu");
    private JPopupMenu popUpMenu = new JPopupMenu("PopUpMenu");
    private JRadioButtonMenuItem radioButtonMenu = new JRadioButtonMenuItem("RadioButtonMenu");
    private JTextArea obszarTekstowy = new JTextArea(10,3);
    private JButton przyciskZapisz;
    private boolean flagaObszaruTekstowego = false;
    private String przedZmianaObszaruTekstoweg = "";

    private class ActionSave extends AbstractAction{
        public ActionSave(String nazwa, String podpowiedz, String klawiaturySkrot, int znak) {
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, podpowiedz);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturySkrot));
            this.putValue(Action.MNEMONIC_KEY, znak);
        }
        public void actionPerformed (ActionEvent e) {
            System.out.println("ZAPISUJEMY NA DYSKU2");
            this.setEnabled(flagaObszaruTekstowego=false);
        }
    }

    private boolean czyToAscii(char zn) {

        for (int i=0; i<255f; i++)
            if (zn == i)
                return true;
        return false;

    }

    //private JTextComponent poleTekstowe = new JTextArea("przykładowy tekst początkowy", 5, 20);
}

class MojePasekMenu extends JFrame{

    public MojePasekMenu(){
        super("MojePasekMenu");
        this.setBounds(600,400,600,400);
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents()
    {
        this.setJMenuBar(pasekMenu);

//        pasekMenu.add(new JMenu("Plik"));     //pierwsza metoda

//        JMenu menuPlik = new JMenu("Plik");  //druga metoda
//        pasekMenu.add(menuPlik);             //druga metoda

        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
//        menuPlik.add("Nowy");       //pierwsza metoda
        JMenuItem podMenuNowy = menuPlik.add(new JMenuItem("Nowy")); //druga metoda
        podMenuNowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tu jest kod tworzączy podmenu Nowy");
            }
        });
        menuPlik.addSeparator();
        JMenuItem podMenuZapisz = menuPlik.add(new JMenuItem("Zapisz"));
        menuPlik.add(new JMenuItem("Wczytaj"));
        menuPlik.addSeparator();

        JMenuItem menuOpcje = menuPlik.add(new JMenu("Opcje"));
        menuOpcje.add(new JMenuItem("Opcja 1"));
        menuOpcje.add(new JMenuItem("Opcja 2"));

        menuPlik.add(tylkoDoOdczytu);
        tylkoDoOdczytu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tylkoDoOdczytu.isSelected())
                    podMenuZapisz.setEnabled(false);
                else
                    podMenuZapisz.setEnabled(true);
            }
        });

        JMenu menuPomoc = pasekMenu.add(new JMenu("Pomoc"));
        menuPomoc.add(new JMenuItem("FAX"));
        menuPomoc.add(popUpMenu);
        pasekMenu.add(radioButtonMenu);

    }

    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("Tylko do odczytu");
    private JPopupMenu popUpMenu = new JPopupMenu("PopUpMenu");
    private JRadioButtonMenuItem radioButtonMenu = new JRadioButtonMenuItem("RadioButtonMenu");
}

class MojeSuwak extends JFrame{

    public MojeSuwak(){
        super("MojeSuwak");
        this.setBounds(600,400,600,400);
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents()
    {
        suwak.setMajorTickSpacing(10);
        suwak.setMinorTickSpacing(5);
        suwak.setPaintTicks(true);
        suwak.setPaintLabels(true);
        suwak.setSnapToTicks(false );

        suwak.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //wartoscSuwaka.setText(""+suwak.getValue()); //moje rozwiązanie
                wartoscSuwaka.setText(""+((JSlider)e.getSource()).getValue());
                tekst.setFont((new Font(tekst.getFont().getFontName(), tekst.getFont().getStyle(), suwak.getValue())));
            }
        });

        wartoscSuwaka.setEditable(false);
        this.getContentPane().add(suwak,BorderLayout.NORTH);
        this.getContentPane().add(tekst, BorderLayout.CENTER);
        this.getContentPane().add(wartoscSuwaka, BorderLayout.SOUTH);
    }

    JSlider suwak = new JSlider(JSlider.HORIZONTAL,40);
    JTextField wartoscSuwaka = new JTextField(""+suwak.getValue());
    JLabel tekst = new JLabel("coś");
}

class MojeObramowkiIkrawedzie extends JFrame{

    public MojeObramowkiIkrawedzie(){

        super("MojeObramowkiIkrawedzie");
        this.setBounds(600,400,600,400);

        initComponents();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents()
    {
        dodajPrzelacznik("createEtchedBorder", BorderFactory.createEtchedBorder());
        dodajPrzelacznik("createLoweredBevelBorder", BorderFactory.createLoweredBevelBorder());
        panelRadio.setBorder((BorderFactory.createBevelBorder(BevelBorder.RAISED)));
        panelRadio.setBorder((BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Krawędzie", TitledBorder.RIGHT ,TitledBorder.BOTTOM)));

        this.getContentPane().setLayout(new GridLayout(2,1));

        this.add(panelRadio );
        this.add(panelKrawedzi);
    }

    private JPanel panelRadio = new JPanel();
    private JPanel panelKrawedzi = new JPanel();
    private ButtonGroup grupaRadio = new ButtonGroup();

    public void dodajPrzelacznik (final String nazwa, final Border kr)
    {
        JRadioButton przelacznik = new JRadioButton(nazwa);
        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelKrawedzi.setBorder(BorderFactory.createTitledBorder(kr, nazwa));
            }
        });

        grupaRadio.add(przelacznik);
        panelRadio.add(przelacznik);
    }
}

class MojeWieleRamek extends JFrame {

    public MojeWieleRamek() {

        super("MojeWieleRamek");
        this.setBounds(600, 400, 600, 400);

        initComponents();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        nowaRamka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new NewClass(taRamka).setVisible(true);
                new Dialog(taRamka).setVisible(true);
            }
        });
        this.getContentPane().add(nowaRamka);
    }
    private JFrame taRamka = this;
    JButton nowaRamka = new JButton("Stwórz ramkę");

}

class MojeZdarzeniaOkna extends JFrame implements WindowListener {

    public MojeZdarzeniaOkna() {

        super("MojeZdarzeniaOkna");
        this.setBounds(600, 400, 600, 400);

        initComponents();

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public void initComponents() {
        this.addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

        JOptionPane.showMessageDialog(rootPane, "Witaj");

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int opcja = JOptionPane.showConfirmDialog(rootPane, "czy chcesz zamknąć program? ");
        if (opcja == 0)
            this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("zapisuje dane");

    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("jestem minimalizowany");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("jestem przywracany");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("jestem aktywny");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("jestem nieaktywny");
    }
}

class MojeListyKombinowane extends JFrame {

    public MojeListyKombinowane() {

        super("MojeListyKombinowane - PoleTekstowe");
        this.setBounds(600, 400, 600, 400);

        initComponents();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        kombinacja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(((JComboBox)e.getSource()).getSelectedItem());
                //ColorHandler handler = (ColorHandler)((JComboBox)e.getSource()).getSelectedItem();
                ((JComboBox) e.getSource()).setBackground(((ColorHandler) ((JComboBox) e.getSource()).getSelectedItem()).getKolor());
            }
        });

        panel.add(kombinacja);
        kombinacja.addItem(new ColorHandler("Czarny", Color.BLACK));
        kombinacja.addItem(new ColorHandler("Niebieski", Color.BLUE));
        kombinacja.addItem(new ColorHandler("Zielony", Color.GREEN));
        kombinacja.addItem(new ColorHandler("Żółty", Color.YELLOW));
        this.getContentPane().add(panel);

    }

    private class ColorHandler {
        public ColorHandler(String colorName, Color kolor) {
            this.kolor = kolor;
            this.colorName = colorName;
        }

        public String toString() {
            return this.colorName;
        }

        public Color getKolor() {
            return kolor;
        }

        private Color kolor;
        private String colorName;
    }

    private JPanel panel = new JPanel();
    private JComboBox kombinacja = new JComboBox();


}

class MojeTexArea extends JFrame {

    public MojeTexArea() {

        super("MojeTexArea");
        this.setBounds(600, 400, 600, 400);

        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        panelSzukania.add(znajdz);
        panelSzukania.add(szukanie);
        panelSzukania.add(etykietaI);
        panelSzukania.add(zamien);
        panelSzukania.add(etykietaNa);
        panelSzukania.add(nowyTekst);
        szukanie.setColumns(6);
//        obszarTekstowy = new JTextArea();
//        suwak = new JScrollPane();
//        obszarTekstowy.add(suwak);

//        obszarTekstowy.selectAll(); // - zaznacza cały tekst
//        obszarTekstowy.select(2,4); // - zaznacza wskazany obszar
//        obszarTekstowy.replaceSelection("ddupadd"); // - zamienia wskazany obszar
//        obszarTekstowy.replaceRange("#dupa#",3,4); // - zasięg, podmieniamy string z podadnego obszaru
//        obszarTekstowy.insert("#dupa#",3); // - wstawianie tekstu na pozycji
//        obszarTekstowy.append("#dupa#"); // - dołączanie do końca
//        obszarTekstowy.select(obszarTekstowy.getText().indexOf("tekst"), obszarTekstowy.getText().indexOf("tekst")+"tekst".length());

        znajdz.addActionListener(new ZnajdowanieHandler());
        zamien.addActionListener(new ZamianaHandler());

        this.getContentPane().add(suwak, BorderLayout.NORTH);
        this.getContentPane().add(panelSzukania, BorderLayout.CENTER);
    }

    private JTextComponent obszarTekstowy = new JTextArea("to jest testowy tekst startowy o testowym charakterze", 5, 20);
    private JScrollPane suwak = new JScrollPane(obszarTekstowy);

    private JPanel panelSzukania = new JPanel();
    private JButton znajdz = new JButton("Znajdz");
    private JLabel etykietaI = new JLabel("i");
    private JButton zamien = new JButton("Zamien");
    private JLabel etykietaNa = new JLabel("na");


    private JTextField szukanie = new JTextField(4);
    private JTextField nowyTekst = new JTextField(4);

    private class ZnajdowanieHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            poczatekSzukanego = obszarTekstowy.getText().indexOf(szukanie.getText(), poczatekSzukanego + szukanie.getText().length());

            System.out.println("poczatekSzukanego = " + poczatekSzukanego);

            if (poczatekSzukanego == -1)
                poczatekSzukanego = obszarTekstowy.getText().indexOf(szukanie.getText());

            if (poczatekSzukanego >= 0 && szukanie.getText().length() > 0) {
                obszarTekstowy.requestFocus();
                String tekstSzukany = szukanie.getText();
//              obszarTekstowy.select(obszarTekstowy.getText().indexOf(tekstSzukany),40);
//              System.out.println("tekst szukanhy : " + tekstSzukany);
                obszarTekstowy.select(poczatekSzukanego, poczatekSzukanego + tekstSzukany.length());
            }

        }

        private int poczatekSzukanego = 0;
    }

    private class ZamianaHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd()) {
                obszarTekstowy.requestFocus();
                String tekstZastepowany = nowyTekst.getText();
                int opcja = JOptionPane.showConfirmDialog(null, "Czy chcesz zamienic '" + szukanie.getText() + "' na '" + nowyTekst.getText() + "'", "czy zmienic parametr", JOptionPane.YES_NO_OPTION);
                if (opcja == 0) {
                    obszarTekstowy.replaceSelection(tekstZastepowany);
                    znajdz.doClick();
                } else {
                    znajdz.doClick();
                }
            }
        }
    }


}

class MojeMenu extends JFrame {

    public MojeMenu() {

        super("MojeMenu");
        this.setBounds(600, 400, 600, 400);

        initComponents();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        panelMenu.setLayout(new GridLayout(4, 1));
        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);
        panelMenu.add(menu4);
        //panelMenu.add(new MenuButton("4. Wyjdz"));
        kontener.add(panelMenu);
    }

    private Container kontener = this.getContentPane();
    private JPanel panelMenu = new JPanel();
    MenuButton menu1 = new MenuButton("1. Dodaj");
    MenuButton menu2 = new MenuButton("2. Usun");
    MenuButton menu3 = new MenuButton("3. Zmien");
    MenuButton menu4 = new MenuButton("4. Wyjdz");
    private int i = 0;

    private class MenuButton extends JButton implements FocusListener, ActionListener {
        public MenuButton(String nazwa) {
            super(nazwa);
            this.addFocusListener(this);
            this.addActionListener(this);
            this.addKeyListener(new KeyAdapter() {
                //gdy kliknę jakąś litereę to najpierw jest wywoływane KeyPressed, następnie KeyTyped, ostatecznie KeyReleased

                @Override
                public void keyPressed(KeyEvent e) {
                    keyPressedHandler(e);
                }
            });
            this.setBackground(kDefault);
        }

        @Override
        public void focusGained(FocusEvent e) {
            this.setBackground(kFocusGained);

        }

        @Override
        public void focusLost(FocusEvent e) {
            this.setBackground(kDefault);
        }

        private void keyPressedHandler(KeyEvent e) {
            int dlMenu = panelMenu.getComponentCount();
            if (i == 0) i = dlMenu;
            if (e.getKeyCode() == KeyEvent.VK_DOWN) panelMenu.getComponent(++i % dlMenu).requestFocus();
            else if (e.getKeyCode() == KeyEvent.VK_UP) panelMenu.getComponent(--i % dlMenu).requestFocus();

            else if (e.getKeyCode() == KeyEvent.VK_ENTER) ((MenuButton) e.getSource()).doClick();

        }

        private Color kFocusGained = Color.RED;
        private Color kDefault = Color.BLUE;


        @Override
        public void actionPerformed(ActionEvent e) {
//            JOptionPane.showMessageDialog(panelMenu, "komunikat testowy");
            JOptionPane.showMessageDialog(this, ((MenuButton) e.getSource()).getText());
        }
    }

}

class MojeCheckBox extends JFrame {

    public MojeCheckBox() {

        super("MojeCheckBox");
        this.setBounds(600, 400, 600, 400);
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        ActionListener sluchacz = new CheckBoxHandler();

        etykieta1.setFont(new Font("Monospaced", Font.PLAIN, 42));

        pogrubiony.addActionListener(sluchacz);
        pochylony.addActionListener(sluchacz);
        panel1.add(pogrubiony);
        panel1.add(pochylony);

        panel2.add(etykieta1);

        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
    }

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JCheckBox pogrubiony = new JCheckBox("Pogrubiony");
    JCheckBox pochylony = new JCheckBox("Pochylony");
    JLabel etykieta1 = new JLabel("Jestem piękna");

    public class CheckBoxHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" stała się akcja ");
            int style = Font.PLAIN;
            if (pogrubiony.isSelected()) style += Font.BOLD;
            if (pochylony.isSelected()) style += Font.ITALIC;

            etykieta1.setFont(new Font(etykieta1.getFont().getFamily(), style, etykieta1.getFont().getSize()));

        }
    }

}

class MojePrzelaczniki extends JFrame {

    public MojePrzelaczniki() {

        super("MojePrzelaczniki - Grupy Przelacznikow Radio");
        this.setBounds(600, 400, 600, 400);

        initComponents();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
//        this.setTitle("Grupy Przelacznikow Radio");
        panel2.add(etykieta);


        JRadioButton malyPrzelacznik = new JRadioButton("mały", true);
        groupSize.add(malyPrzelacznik); //definiowanie elementu do danej grupy
        malyPrzelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etykieta.setFont(new Font("Monospaced", Font.BOLD, 30));
            }
        });
        panel1.add(malyPrzelacznik);

        zbudujPrzelacznikRozmiar("sredni", 45);
        zbudujPrzelacznikRozmiar("duzy", 60);
        zbudujPrzelacznikKolor("czerwony", Color.red);
        zbudujPrzelacznikKolor("niebieski", Color.blue);
        zbudujPrzelacznikKolor("zielony", Color.green);

        this.getContentPane().add(panel1, BorderLayout.NORTH);
        panel1.setBackground(Color.pink);
        //malyPrzelacznik.setBackground(Color.red);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        panel2.setBackground(Color.lightGray);
        this.getContentPane().add(panel3, BorderLayout.SOUTH);
    }

    public void zbudujPrzelacznikRozmiar(String nazwa, final int rozmiar) {
        JRadioButton przelacznik = new JRadioButton(nazwa);
        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etykieta.setFont(new Font("Monospaced", Font.BOLD, rozmiar));
            }
        });
        groupSize.add(przelacznik);
        panel1.add(przelacznik);
    }

    public void zbudujPrzelacznikKolor(String nazwa, final Color k) {
        JRadioButton przelacznik = new JRadioButton(nazwa);
        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etykieta.setForeground(k);
            }
        });
        groupColor.add(przelacznik);
        panel3.add(przelacznik);
    }

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel etykieta = new JLabel("coś");
    ButtonGroup groupSize = new ButtonGroup(); //grupuje przelączniki w jeden logiczny zestaw (tak by móc wybrać tylko jedną opcję)
    ButtonGroup groupColor = new ButtonGroup(); //grupuje przelączniki w jeden logiczny zestaw (tak by móc wybrać tylko jedną opcję)

}

class MojeEtykiety extends JFrame {

    public MojeEtykiety() {

        super("Zegarek");
        this.setBounds(600, 400, 600, 400);

        initComponents();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        panel.add(etykieta);
        panel.add(czas);

        ActionListener stoper = new Zegar();

        Timer zegar = new Timer(1000, stoper);

        zegar.start();

        //czas.setText("12:24:10");
        this.getContentPane().add(panel);
    }

    JPanel panel = new JPanel();
    JLabel etykieta = new JLabel("Czas");
    JLabel czas = new JLabel();

    private class Zegar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //czas.setText(Integer.toString(i++));
            GregorianCalendar kalendarzyk = new GregorianCalendar();
            String h = "" + kalendarzyk.get(Calendar.HOUR_OF_DAY);
            String m = "" + kalendarzyk.get(Calendar.MINUTE);
            String s = "" + kalendarzyk.get(Calendar.SECOND);

            if (Integer.parseInt(h) < 10) h = "0" + h;
            if (Integer.parseInt(m) < 10) m = "0" + m;
            if (Integer.parseInt(s) < 10) s = "0" + s;

            czas.setText("" + h + ":" + m + ":" + s);
        }
    }

    static int i = 1;
}

class MojeZdarzenia extends JFrame {

    public MojeZdarzenia() {

        super("Zdarzenia");
        this.setBounds(600, 400, 600, 400);

        initComponents();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        kolorCzerwony = new JButton("Czerwony");
        kolorCzarny = new JButton("Czarny");

        kolorCzerwony.addActionListener(new sluchaczKolorow(Color.red));
        kolorCzarny.addActionListener(new sluchaczKolorow(Color.black));

        panel.add(kolorCzerwony);
        panel.add(kolorCzarny);

        budujButton("Rozowy", Color.pink);
        budujButton("Niebieski", Color.blue);

        this.getContentPane().add(panel);

    }

    JPanel panel = new JPanel();
    JButton kolorCzerwony = new JButton("Czerwony");
    JButton kolorCzarny = new JButton("Czarny");

    public void budujButton(String nazwa, Color k) {
        JButton przycisk = new JButton(nazwa);
        przycisk.addActionListener(new sluchaczKolorow(k));
        panel.add(przycisk);
    }

    private class sluchaczKolorow implements ActionListener {
        public sluchaczKolorow(Color kolor) {
            this.kolor = kolor;
        }

        public void actionPerformed(ActionEvent e) {
            //System.out.println("slucham przeciez");
            panel.setBackground(kolor);

        }

        Color kolor;
    }

}

class MojeGroupLayout extends JFrame {

    public MojeGroupLayout() {

        this.setBounds(600, 400, 600, 400);

        initComponents();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(button1) //, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,200)
                        .addGroup(
                                layout.createParallelGroup().addComponent(button2).addComponent(button4)
                        )
                        .addComponent(button3)
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(button5)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup().addComponent(button1).addComponent(button2).addComponent(button3)
                        )
                        .addComponent(button4)
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(button5)
        );

/*
        button1.setPreferredSize(new Dimension(100,100));
        button2.setPreferredSize(button2.getPreferredSize());
        button3.setPreferredSize(button3.getPreferredSize());
        button4.setPreferredSize(button4.getPreferredSize());
        button5.setPreferredSize(button4.getPreferredSize());
*/
        pack();
    }

    JButton button1 = new JButton("Button1");
    JButton button2 = new JButton("Button2");
    JButton button3 = new JButton("Button3");
    JButton button4 = new JButton("Button4");
    JButton button5 = new JButton("Anuluj");

}

class MojeFlowLayout extends JFrame {

    public MojeFlowLayout() {
//        super("Układ graficzny (Layout)");
        this.setBounds(600, 400, 600, 400);

        initComponents();
//        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        button1.setPreferredSize(new Dimension(100, 100));
        button2.setPreferredSize(button2.getPreferredSize());
        button3.setPreferredSize(button3.getPreferredSize());
        button4.setPreferredSize(button4.getPreferredSize());
        panel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);

        this.getContentPane().add(panel1, BorderLayout.CENTER);

    }

    JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton button1 = new JButton("Button1");
    JButton button2 = new JButton("Button2");
    JButton button3 = new JButton("Button3");
    JButton button4 = new JButton("Button4");

}

class MojeUkladGraficzny extends JFrame {

    public MojeUkladGraficzny() {
        super("Układ graficzny (Layout)");
        this.setBounds(600, 400, 600, 400);

        initComponents();
//        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        centrum = new JButton("Hejka");
        gora = new JButton("jestem na gorze");
        dol = new JButton("jestem na dole");
        prawa = new JButton("jestem na prawo");
        lewa = new JButton("jestem po lewo");

        Container kontener = this.getContentPane();
//         kontener.add(centrum, BorderLayout.CENTER);
//        kontener.add(gora, BorderLayout.PAGE_START);
//        kontener.add(dol, BorderLayout.PAGE_END);
//        kontener.add(prawa, BorderLayout.LINE_END);
//        kontener.add(lewa, BorderLayout.LINE_START);
        centrum.setLocation(100, 50);
        centrum.setSize(150, 20);
        kontener.setLayout(null);
        kontener.add(centrum);
    }

    JButton centrum;
    JButton gora;
    JButton dol;
    JButton prawa;
    JButton lewa;
}

class MojeRamka extends JFrame {

    public MojeRamka(String nazwa) {
/* Teraz już niepotrzebne bo klasa Main extends JFrame
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLocation(new Point(300,100));
        frame.setTitle("tytuł ramki gulczasa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage( );
*/
        this.setTitle(nazwa);
        int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(szer / 2, wys / 2);

        int szerRamki = this.getSize().width;
        int wysRamki = this.getSize().height;
        this.setLocation((szer - szerRamki) / 2, (wys - wysRamki) / 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}