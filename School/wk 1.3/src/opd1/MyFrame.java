package opd1;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
  private JButton b;
  private JTextField tf;
  private int aantal;

  public MyFrame() {
    setLayout(new FlowLayout());

    aantal = 0;
    tf = new JTextField("?", 20);
    add(tf);

    b = new JButton("Press me");
    add(b);
    b.addActionListener(this);

    setSize(300, 100);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent event) {
    aantal += 1;
    tf.setText ("Knop is "+aantal + " maal ingedrukt");
  }
}
