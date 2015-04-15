package opd2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
  private JButton b;
  private JButton b1;
  private JTextField tf;

  public MyFrame() {
    setLayout(new FlowLayout());

    tf = new JTextField(" ", 10);
    add(tf);

    b = new JButton("Knop1");
    add(b);
    b.addActionListener(this);

    b1= new JButton("Knop2");
    add(b1);
    b1.addActionListener(this);


    setSize(200, 100);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == b) {
      tf.setText ("Knop1");
      }
    if (event.getSource() == b1) {
	        tf.setText ("Knop2");
      }
}
}
