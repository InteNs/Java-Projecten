package opd3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
	private JButton b1, b2, b3;
	private JTextField tf1, tf2, tf3;
	private int worp1, worp2;
	private String uitkomst;

	public MyFrame(){
		setLayout (new FlowLayout());
		b1 = new JButton("werp steen1"); add(b1);
			b1.addActionListener(this);
		tf1 = new JTextField(5); add(tf1);
			tf1.setEditable(false);
		b2 = new JButton("werp steen2"); add(b2);
			b2.addActionListener(this);
		tf2 = new JTextField(5); add(tf2);
			tf2.setEditable(false);
		b3 = new JButton("bereken uitkomst"); add(b3);
			b3.addActionListener(this);
		tf3 = new JTextField(7); add(tf3);
			tf3.setEditable(false);

		setSize(200, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private int worp() {
		return  1 + (int)(6 * Math.random());
	}
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == b1) {
			b1.setEnabled(false);
			worp1=worp();
			tf1.setText(Integer.toString(worp1));
		}
		if (event.getSource() == b2) {
			b2.setEnabled(false);
			worp2=worp();
			tf2.setText(Integer.toString(worp2));
		}
		if (event.getSource() == b3) {
			b1.setEnabled(true);
			b2.setEnabled(true);
			if (worp1 == worp2){
				tf3.setText("WIN");
			}
			else {
				tf3.setText("TRY AGAIN");
		 	}
		}
	}
}

