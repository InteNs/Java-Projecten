package opd3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	private JLabel lab1;
	private JButton b1;
	private JPanel p1;
	private JTextField tf1;
	public MyFrame(){
		 setLayout(new FlowLayout());
		 p1 = new JPanel(); add(p1);
		 p1.setPreferredSize(new Dimension(501,501));
		 p1.setBackground(Color.WHITE);
		 tf1 = new JTextField(5); add(tf1);
		 b1 = new JButton("press me"); add(b1);
		 	b1.addActionListener(this);
		 setSize(600, 600);
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
	public void actionPerformed(ActionEvent e){
		Graphics g = p1.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 501, 501);
		g.setColor(Color.BLACK);
		int amount = Integer.parseInt(tf1.getText());
		//super.setTitle(Integer.toString(amount));
		for (int i = 1; i <= amount; i++) {
			int size = 500/amount;
			int x = 250-(i * size)/2;
			g.drawRect(x,x , i*size,i*size);
		}
		
	}
}
