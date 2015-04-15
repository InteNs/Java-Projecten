package opd5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
	private JPanel p;
	private JButton b;

	public MyFrame()
	{
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

	public void actionPerformed(ActionEvent event)
	{
		Graphics g = p.getGraphics();
		g.setColor(Color.BLUE);
		g.drawString("1994", 30, 170);
		g.fillRect(30, 50, 35, 100);

		g.setColor(Color.RED);
		g.drawString("1995", 110, 170);
		g.fillRect(110, 30, 35, 120);

		g.setColor(Color.YELLOW);
		g.drawString("1996", 190, 170);
		g.fillRect(190, 70, 35, 80);
	}
}