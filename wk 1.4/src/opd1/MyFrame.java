package opd1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
  private JLabel lab1, lab2;
  private JButton b;
  private JTextField tf;

  public MyFrame() {
    setLayout(new FlowLayout());

    lab1 = new JLabel("tik maandnummer in"); add(lab1);
    tf = new JTextField(5); add(tf);
    b = new JButton ("Lees In"); add(b);
    b.addActionListener(this);
    lab2 = new JLabel("Hier komt de Maand"); add(lab2);

    setSize(100, 150);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent event) {
   int maandnr = Integer.parseInt(tf.getText());
   String S;
   switch(maandnr) {
	   case 1: S = "Januari"; break;
	   case 2: S = "Februari"; break;
	   case 3: S = "Maart"; break;
	   case 4: S = "April"; break;
	   case 5: S = "Mei"; break;
	   case 6: S = "Juni"; break;
	   case 7: S = "Juli"; break;
	   case 8: S = "Augustus"; break;
	   case 9: S = "September"; break;
	   case 10: S = "Oktober"; break;
	   case 11: S = "November"; break;
	   case 12: S = "December"; break;
	   default: S = "ongeldig"; break;
   }
   lab2.setText(S);
}

}
