package Temp;


import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Celcius implements ActionListener{

    //variabelen
    TextField text,result;
    public Celcius(TextField text, TextField result) {
        this.text = text;
        this.result=result;


    }

    public Celcius(Converter converter) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double celString,CelTemp,far;
        celString = Integer.parseInt(text.getText());
        CelTemp=(celString-32)*5/9;
        result.setText(String.valueOf(CelTemp + "°C"));;
    }

    public void paint(Graphics g,Converter mc){

        mc.setBackground(Color.blue);
    }
}
