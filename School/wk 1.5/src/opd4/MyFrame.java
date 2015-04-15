package opd4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener
{
 private JButton b;
 private JPanel p;
 private JTextField tf1, tf2;
 private JLabel l1, l2;

	 public MyFrame() {
		 setLayout(new FlowLayout());
		 p = new JPanel(); add(p);
		 p.setPreferredSize(new Dimension(500,350));
		 p.setBackground(Color.WHITE);
		 l2 = new JLabel("Aantal treden"); add(l2);
		 tf2 = new JTextField(10); add(tf2);
		 b = new JButton("Press me"); add(b);
		 b.addActionListener(this);

		 setSize(540, 420);
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public void actionPerformed(ActionEvent e) {
		int hor = 5;
		int u = 1;
		int ver = 5;
			String s2 = tf2.getText();
		ver = Integer.parseInt(s2);

		Graphics g = p.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 350);
			g.setColor(Color.BLACK);
			int x = 10, y = 20;
			for (int i1 = 1; i1 <= ver; i1++){
				for (int i2 = 1; i2 <= u; i2++){
					g.drawRect(x, y, 5, 5);
					x += 50;
				}
				u += 1;
				x = 10;
				y += 40;
			}

}}