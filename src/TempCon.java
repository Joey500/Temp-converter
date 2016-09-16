import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.event.*;
import java.applet.Applet;
import java.awt.*;
import java.text.DecimalFormat;

public class TempCon extends Applet{

    //Variabelen
    Choice SelectBox = null;
    TextField txtInput;
    TextField lblResult;
    Button convert, clear;
    Label Welkom;
    Image pic;
    CheckboxGroup chkgrp = new CheckboxGroup();

    CheckboxGroup chkgrp1 = new CheckboxGroup();
    Checkbox Celcius, Fahrenheit;

    //fonts
    Font FontTitel = new Font("Impact", Font.BOLD, 42);

    Font Tekst = new Font("Arial", Font.BOLD, 18);
    Font Tekst1 = new Font("Arial", Font.PLAIN, 16);

    int rect1xco, rect1yco, rect1width, rect1height;
    boolean rect1Active;

    public void init() {
        setLayout(null);
        setSize(800, 600);
        //add listener

//        //add listener
        rect1xco = 440;
        rect1yco = 280;
        rect1width = 100;
        rect1height = 80;

        //eigenschappen van de objecten
        Welkom = new Label("Welkom bij Temperatuur Converter", Label.CENTER);
        Welkom.setBounds(0, 0, 800, 100);
        Welkom.setForeground(new Color(253, 249, 255));
        Welkom.setBackground(new Color(213, 21, 28));
        Welkom.setFont(FontTitel);
        add(Welkom);

        txtInput = new TextField(20);
        txtInput.setBounds(100, 250, 240, 30);
        txtInput.setFont(Tekst1);

        add(txtInput);

        lblResult = new TextField(10);
        lblResult.setBounds(100, 350, 240, 30);
        lblResult.setFont(Tekst1);
        add(lblResult);

        Celcius = new Checkbox("  celcius", chkgrp, false);
        Celcius.setBounds(420, 270, 80, 30);
        Celcius.setFont(Tekst1);
        Celcius.setBackground(Color.red);
        add(Celcius);


        Fahrenheit = new Checkbox(" Fahrenheit", chkgrp, false);
        Fahrenheit.setBounds(420, 310, 100, 30);
        Fahrenheit.setFont(Tekst1);
        Fahrenheit.setBackground(Color.LIGHT_GRAY);
        add(Fahrenheit);


        convert = new Button("Convert");
        convert.setBounds(250, 450, 100, 50);
        convert.setForeground(new Color(219, 255, 230));
        convert.setBackground(new Color(213, 25, 29));
        convert.setFont(Tekst);
        add(convert);

        clear = new Button("Clear");
        clear.setBounds(100, 450, 100, 50);
        clear.setForeground(new Color(219, 255, 230));
        clear.setBackground(new Color(213, 25, 29));
        clear.setFont(Tekst);
        add(clear);


        pic = getImage(getDocumentBase(), "tbg.jpg");
        SelectBox = new Choice();
        SelectBox.add("Select");
        SelectBox.add("Celcius");
        SelectBox.add("Fahrenheit");
        SelectBox.setBounds(420, 450, 150, 350);
        SelectBox.setFont(Tekst1);
        //add choice or combobox
        add(SelectBox);
      //  SelectBox.addItemListener(this);
        //answer eigenschappen


        //action events
        convert.addActionListener(new Fahr());
        convert.addActionListener(new Cel());
        clear.addActionListener(new Clear());

    }


    public void paint(Graphics g) {
        g.drawString("Enter your temperature: ", 100, 200);
        g.drawImage(pic, 0, 100, 800, 500, this);
        Font f = new Font("Arial", Font.BOLD, 26);
        g.setFont(f);
        g.drawString("Enter your temperature: ", 100, 200);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(400,250,250,100);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(400,400,250,100);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(80,220,600,300);

        }



    public class Fahr implements ActionListener, ItemListener{
        public void actionPerformed(ActionEvent e) {

            DecimalFormat d = new DecimalFormat("#.##");
            if (e.getSource() == convert) {
                if (Celcius.getState() && SelectBox.getSelectedItem()==("Fahrenheit")) {
                    String text = txtInput.getText();
                    double cel = Double.parseDouble(text);
                    double far = (cel * 1.8) + 32;
                    lblResult.setText("" + far + " °F");
                    JOptionPane.showMessageDialog(null, "Fahreinheit is " + far + " °F");

                }
            }
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            repaint();
        }
    }


    public class Cel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DecimalFormat df = new DecimalFormat("#.##");

            if (Fahrenheit.getState()&&SelectBox.getSelectedItem()==("Celcius")){
                String text = txtInput.getText();
                double far= Double.parseDouble(text);
                double cel = (far-32)*5/9;
                lblResult.setText(String.valueOf( cel+ " °F"));
                JOptionPane.showMessageDialog(null,"celcius is "+ cel+ " °C");

            }
        }
    }

    public class Clear implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clear) {
                txtInput.setText("");
                lblResult.setText("");

            }
        }
    }
}



