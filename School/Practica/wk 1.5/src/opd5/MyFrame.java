package opd5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {
	private JButton tfstart, tfstop;
	private JTextField input;
	private JLabel lab;
	private JPanel p;
	private int shapesPerMs;
	private Timer t;
	private int randomX, randomY, R, G, B, shape, size1, size2;

	public MyFrame() throws FontFormatException, IOException {
		setLayout(new FlowLayout());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight() - 20;
		Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("digital-7.ttf")).deriveFont(20f);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("digital-7.ttf")));
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(width, height - 80));
		p.setBackground(Color.WHITE);
		lab = new JLabel("shapes/Ms: ");
		lab.setFont(customFont);
		add(lab);
		input = new JTextField(5);
		add(input);
		tfstart = new JButton("Start");
		add(tfstart);
		tfstart.addActionListener(this);
		tfstop = new JButton("Stop");
		add(tfstop);
		tfstop.addActionListener(this);
		t = new Timer(1, this);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == t) {
			Graphics g = p.getGraphics();
			for (int i = 0; i <= shapesPerMs; i++) {
				randomize();
				g.setColor(new Color(R, G, B));
				if (shape == 1)
					g.fillOval(randomX, randomY, size1, size2);
				else
					g.fillRect(randomX, randomY, size1, size2);
			}
		}

		if (e.getSource() == tfstart) {
			shapesPerMs = Integer.parseInt(input.getText());
			Graphics g = p.getGraphics();
			t.start();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 1920, 990);

		}

		if (e.getSource() == tfstop) {
			t.stop();
		}
	}

	public void randomize() {
		@SuppressWarnings("unused")
		Graphics g = p.getGraphics();
		shape = (int) (Math.random() * 2);
		size1 = (int) (40 * Math.random());
		size2 = (int) (40 * Math.random());
		randomX = (int) (1920 * Math.random());
		randomY = (int) (1020 * Math.random());
		R = (int) (255 * Math.random());
		G = (int) (255 * Math.random());
		B = (int) (255 * Math.random());

	}
}