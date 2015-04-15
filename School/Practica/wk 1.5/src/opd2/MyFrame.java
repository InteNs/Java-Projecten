package opd2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener
{
 private JButton b;
 private JPanel p;
 private JTextField tf;
 public MyFrame() {
 setLayout(new FlowLayout());
 p = new JPanel(); add(p);
 p.setPreferredSize(new Dimension(500, 500));
 p.setBackground(Color.WHITE);
 tf = new JTextField(20); add(tf);
 b = new JButton("Press me"); add(b);
 b.addActionListener(this);
 setSize(540, 180);
 setVisible(true);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
 public void actionPerformed(ActionEvent e) {
 String s = tf.getText();
 if (s.equals("")) {
 s = "Java";
 }
Graphics g = p.getGraphics();
   g.setColor(Color.WHITE);
   g.fillRect(0, 0, 500, 100);
   g.setColor(Color.BLACK);
   int x = 10, y = 50;
   for ( int i = 1 ; i <= 10 ; i = i + 1) {
     g.drawString(s, x, y);
     x = x + 1* s.length() + 5; // dwz: xnieuw = xoud + 7*lengte +15;
     y = y + 15;
   }
 }
}