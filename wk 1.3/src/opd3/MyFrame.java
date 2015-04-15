package opd3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener
{
 private JButton b;
private JPanel p;
 public MyFrame() {
 setLayout(new FlowLayout());
p = new JPanel();
p.setPreferredSize(new Dimension(300, 200));
 p.setBackground(Color.WHITE);
 add(p);
 b = new JButton("Press me");
 add(b);
 b.addActionListener(this);
 setSize(400, 300);
 setVisible(true);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
 public void actionPerformed(ActionEvent event) {
// (1)
 Graphics g = p.getGraphics();
// (2)
 g.drawLine(0, 0, 100, 100);
 g.drawRect(20, 60, 50, 150);
// (3)
 g.drawString( "( 100, 100 )", 80, 120);
 g.drawString("Dit is een tekening", 30, 100);
 g.drawOval(50, 50, 100, 100);
 }
}