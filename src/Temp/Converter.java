package Temp;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
public class Converter extends Applet implements Runnable {

    //variabelen
    TextField text,text2,result;
    Label Welkom;
    Celcius b;
    Fahrenheit F;
    Font FontTitel = new Font("TimesRoman", Font.BOLD, 42);
    Font Tekst1 = new Font("Arial", Font.PLAIN, 16);
    Font Tekst = new Font("Arial", Font.BOLD, 18);
    public void init(){
        setLayout(null);
        Welkom = new Label("Welkom bij Temperatuur Converter", Label.CENTER);
        Welkom.setBounds(0, 0, 800, 100);
        Welkom.setForeground(Color.WHITE);
        Welkom.setBackground(Color.RED);
        Welkom.setFont(FontTitel);
        add(Welkom);


        //maak textfields
        this.text=new TextField(20);
        this.text2=new TextField(10);
        this.result=new TextField(10);
        b=new Celcius(this);
        F=new Fahrenheit(this);
        setSize(800, 600);

        text.setBounds(100, 250, 240, 30);
        text.setFont(Tekst1);

        result.setBounds(400, 250, 240, 30);
        result.setFont(Tekst1);
        //maak object voor button
        Button convert= new Button("Convert to Celcius");
        convert.setBounds(540, 380, 200, 50);
        convert.setFont(Tekst);


        Button convert1= new Button("Convert to Fahrenheit");
        convert1.setBounds(340, 380, 200, 50);
        convert1.setFont(Tekst);

        //voeg de elementen
        this.add(text);
        this.add(text2);
        this.add(result);
        this.add( convert);
        this.add( convert1);


        Celcius C=new Celcius(text,result);
        Fahrenheit F=new Fahrenheit (text,result);
        convert.addActionListener(C);
        convert1.addActionListener(F);

    }

    @Override
    public void run() {
        while (true) {
            repaint();

            try {
                Thread.sleep(17);


            } catch (InterruptedException e) {
                System.out.println("hi");
            }
        }
    }

    public void paint(Graphics g) {
        b.paint(g,this);


        }
    }
