package opd1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener
{
 private JButton b;
private JPanel p;
 public MyFrame() {
 setLayout(new FlowLayout());
p = new JPanel(); add(p);
 p.setPreferredSize(new Dimension(250, 100));
 p.setBackground(Color.WHITE);
 b = new JButton("go"); add(b);
 b.addActionListener(this);
 setSize(280, 180);
 setVisible(true);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
 public void actionPerformed(ActionEvent e) {
   Graphics g = p.getGraphics();
   int x = 10, y = 50;
   for ( int i = 0 ; i <= 50 ; i=i+5) {
     g.drawString("" + i, x, y);
     x = x + 20; // dwz: xnieuw = xoud + 20;
   }
 }
 }