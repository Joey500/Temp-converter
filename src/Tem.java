
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Tem extends Applet {
    TextField cel, fahr;
    Label celLabel, fahrLabel, title;
    Button button;

    public void init() {
        setLayout(null);
        setSize(1024, 768);

        title = new Label("temperature converter");
        title.setBounds(500, 20, 300, 30);
        add(title);

        title.setAlignment(title.CENTER);
        title.setForeground(Color.red);
        Font mycustomefont = new Font("Arial", Font.BOLD, 25);
        title.setFont(mycustomefont);

        cel = new TextField(1);
        cel.setBounds(150, 50, 100, 20);


        celLabel = new Label("Celcius");
        celLabel.setBounds(20, 50, 100, 20);


        fahr = new TextField(5);
        fahr.setBounds(150, 90, 100, 20);


        fahrLabel = new Label("Fahrenheit");
        fahrLabel.setBounds(20, 90, 100, 20);


        button = new Button("Convert");
        button.setBounds(150, 150, 100, 40);
        button.setBackground(Color.green);

        add(cel);
        add(celLabel);
        add(fahr);
        add(fahrLabel);
        add(button);


        String celString, fahrString;
        int celTemp, fahrTemp;
        Scanner in = new Scanner(System.in);

        System.out.println("1 enter celcius temp or fahrenheit");
        String i = in.next();


        switch (i) {
            case "celcius":
                System.out.println("enter your temp");
                int a = in.nextInt();
                System.out.println(a);
                cel.setText(String.valueOf(a));
                celString = cel.getText();

                // Convert temperature to Fahrenheit.
                celTemp = Integer.parseInt(celString);
                fahrTemp = 9 * celTemp / 5 + 32;
                fahrString = String.valueOf(fahrTemp);

                // Put Fahrenheit temperature into textfield.
                fahr.setText(fahrString);
                break;


            case "fahrenheit":
                System.out.println("enter your fahrenheit");
                int b = in.nextInt();
                System.out.println(b);
                fahr.setText(String.valueOf(b));
                celString = fahr.getText();

                // Convert temperature to Fahrenheit.
                celTemp = Integer.parseInt(celString);
                fahrTemp = celTemp * 9 / 5 + 32;
                fahrString = String.valueOf(fahrTemp);

                // Put Fahrenheit temperature into textfield.
                cel.setText(fahrString);
                JOptionPane.showMessageDialog(null, "Fahrenheit is " + celString);
            default:
                JOptionPane.showMessageDialog(null, "try again");


        }
    }
}
