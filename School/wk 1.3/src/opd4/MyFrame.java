package opd4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener
  {
  private JTextField tf1, tf2, tfUit;
  private JLabel l;
  private JButton b;

  public MyFrame() {
 setLayout(new FlowLayout() );
 tf1 = new JTextField(3);	add(tf1);
 l = new JLabel("+"); 		add(l);
 tf2 = new JTextField(3); 	add(tf2);
 b = new JButton("="); 		add(b);
 	b.addActionListener(this);
 tfUit = new JTextField(4); add(tfUit);
 	tfUit.setEditable(false);

 setSize (300, 100);
 setVisible(true);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public void actionPerformed(ActionEvent event) {
	String s1 = tf1.getText();
	int getal1 = Integer.parseInt(s1);
	String s2 = tf2.getText();
	int getal2 = Integer.parseInt(s2);

    int uitkomst = getal1+getal2;
    tfUit.setText(""+uitkomst);
}
}
