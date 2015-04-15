package opd2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
	private JLabel lab1, lab2;
	private JButton b1, b2, b3, b4;
	private JTextField tf;
	private final String wachtwoord ="123321";

	public MyFrame(){
		setLayout (new FlowLayout());

		lab1 = new JLabel("raad het password"); add(lab1);
		b1 = new JButton("1"); add(b1);
		  b1.addActionListener(this);
		b2 = new JButton("2"); add(b2);
		  b2.addActionListener(this);
		b3 = new JButton("3"); add(b3);
		  b3.addActionListener(this);
		tf = new JTextField(7); add(tf);
		lab2 = new JLabel("Hier komt de uitvoer"); add(lab2);
		b4 = new JButton("clear"); add(b4);
		  b4.addActionListener(this);

		setSize(200, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
public void actionPerformed(ActionEvent event) {
	if (event.getSource() == b1) {
	tf.setText(tf.getText()+"1");
}
if (event.getSource() == b2) {
	tf.setText(tf.getText()+"2");
}
if (event.getSource() == b3) {
	tf.setText(tf.getText()+"3");
}
if (event.getSource() ==b4) {
	tf.setText("");
}
String s = tf.getText();
if (s.equals(wachtwoord)) {
	lab2.setText("Yes! geraden");
}
else{
	lab2.setText("De kluis blijft dicht");
}
}
}