package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    private JLabel husyLabel;

    private JLabel kraliciLabel;

    private JLabel pocetHlavLabel;

    private JLabel pocetNohouLabel;

    private JTextField husyField;

    private JTextField kraliciField;

    private JTextField pocetHlavField;

    private JTextField pocetNohouField;

    private JButton vypocitatButton;

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání
        add(createButtonBar(), "span");

        pack();

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyField);
        add(husyLabel);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciField);
        add(kraliciLabel);



        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavField);
        add(pocetHlavLabel);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);


        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('N');
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouField);
        add(pocetNohouLabel);
        pocetNohouField.setEnabled(false);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);

        pack();

        getRootPane().setDefaultButton(vypocitatButton);
        vypocitatButton.addActionListener(this::handleVypocitat);



    }




    private JPanel createButtonBar(){

        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }





    private void handleVypocitat(ActionEvent vypocitejto){
        String husy = husyField.getText();
        String kralici = kraliciField.getText();

        int husypocet = Integer.parseInt(husy);
        int kralicipocet = Integer.parseInt(kralici);

        int pocetHlav = husypocet +  kralicipocet;
        int pocetNohou = (2*husypocet)+ (4* kralicipocet);

        System.out.println("Počet hlav: " + pocetHlav);
        System.out.println("Počet nohou: " + pocetNohou);

        pocetHlavField.setText(String.valueOf(pocetHlav));
        pocetNohouField.setText(String.valueOf(pocetNohou));





    }







}
