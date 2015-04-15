package opd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener
{
	private JButton tfstart, tfstop;
	private JPanel p;
	private int teller = 0;
	private Timer t;

	public MyFrame()
	{
		setLayout(new FlowLayout());

		p = new JPanel(); add(p);
		p.setPreferredSize(new Dimension(300, 250));
		p.setBackground(Color.WHITE);

		tfstart = new JButton("Start"); add(tfstart);
		tfstart.addActionListener(this);

		tfstop = new JButton("Stop"); add(tfstop);
		tfstop.addActionListener(this);

		t = new Timer(1000, this);

		setSize(300, 350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == t)
		{
			int randomnr1 = 1 + (int)(275 * Math.random());
			int randomnr2 = 1 + (int)(225 * Math.random());
			int randomkleurnr = 1 + (int)(5 * Math.random());

			Graphics g = p.getGraphics();
			switch(randomkleurnr)
			{
				case 1: g.setColor(Color.BLACK); break;
				case 2: g.setColor(Color.YELLOW); break;
				case 3: g.setColor(Color.BLUE); break;
				case 4: g.setColor(Color.RED); break;
				case 5: g.setColor(Color.GREEN); break;
			}
			g.fillOval(randomnr1, randomnr2, 15, 15);
		}

		if(e.getSource() == tfstart)
		{
			t.start();
			Graphics g = p.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 300, 250);

		}

		if(e.getSource() == tfstop)
		{
			t.stop();
		}
	}
}