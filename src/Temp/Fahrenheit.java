package Temp;


import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Fahrenheit implements ActionListener{
    TextField text,result;

    public Fahrenheit(TextField text, TextField result) {
        this.text = text;
        this.result = result;

    }

    public Fahrenheit(Converter converter) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        DecimalFormat decfor=new DecimalFormat();
        String fahrString;
        double celString;
        double fahrTemp, celTemp;

        // Get Celsius temperature from textfield.
        celString = Integer.parseInt(text.getText());

        // Convert temperature to Fahrenheit.
        fahrTemp = 9 * celString/ 5 + 32;

        // Put Fahrenheit temperature into textfield.
        result.setText(String.valueOf(fahrTemp+ "°F"));

    }
}
