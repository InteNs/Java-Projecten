package opd2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	private JLabel l1, l2;
	private JTextField tf;
	private JButton b1, b2;
	private int beurt;
	private int getal;
	private int randomGetal = (int)(13 * Math.random() + 17);
	public MyFrame() {
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			beurt = beurt +1;
			getal = Integer.parseInt(tf.getText());
			if(getal >= 17 && getal <=30) {
				if (getal == randomGetal){
					l2.setText("Getal" + randomGetal + "geraden in" + beurt + "beurten");
				}
				else {
					if (getal > randomGetal) {
						l2.setText("kies een getal lager dan" + getal);
					}
					else {
						l2.setText("kies een getal hoger dan" + getal);
					}
				}
			}
			else {
				l2.setText(getal + "ligt niet tussen 17 en 30:voer een getal in");
			}
		}
		if (e.getSource() ==b2) {
			beurt = 0;
			tf.setText("");
			l2.setText("voer een getal in en druk op de knop");

		}
	}
}


