import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Lingo extends JFrame implements ActionListener
{
	private JPanel pnl;
	private JTextField txt;
	private char[][] chars;
	private int regel, score1, score2;
	private String[] woorden;
	private String geheimeWoord;
	private boolean teamAanDeBeurt;
	private JLabel lblAanDeBeurt, lblScore1, lblScore2;
	
	public Lingo()
	{
		BufferedReader r = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("woordenlijst.txt")));
		try
		{
			ArrayList<String> woordenLijst = new ArrayList<String>();
			String woord;
			while((woord = r.readLine()) != null)
			{
				woordenLijst.add(woord.toUpperCase());
			}
			woorden = woordenLijst.toArray(new String[woordenLijst.size()]);
			r.close();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
			return;
		}
		
		setLayout(new FlowLayout());
		lblAanDeBeurt = new JLabel();
		add(lblAanDeBeurt);
		pnl = new JPanel();
		pnl.setMinimumSize(new Dimension(201, 201));
		pnl.setMaximumSize(new Dimension(201, 201));
		pnl.setPreferredSize(new Dimension(201, 201));
		add(pnl);
		lblScore1 = new JLabel();
		add(lblScore1);
		txt = new JTextField(5);
		txt.addActionListener(this);
		add(txt);
		lblScore2 = new JLabel();
		add(lblScore2);
		
		score1 = 0;
		score2 = 0;
		
		beginRonde();
		
		setTitle("Lingo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(210, 285);
		setVisible(true);
		pnl.setBackground(Color.BLUE);
		repaint();
	}
	
	public static void main(String[] args)
	{
		new Lingo();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		paint();
	}
	
	private void paint() 
	{
		Graphics g = pnl.getGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, getWidth(), getHeight());
		/**
		 * i = regelnummer
		 * j = kolomnummer
		 * l = letter van te raden woord
		 */
		for(int i=0; i < 5; i++) {
			HashMap<Character, Boolean> alGeraden = new HashMap<Character, Boolean>(); 
			for (int j = 0; j < 5; j++) {
				if(chars[i][j] == geheimeWoord.charAt(j))
				{
					alGeraden.put(chars[i][j], true);
				}
			}
			for (int j = 0; j < 5; j++) {
				
				if(chars[i][j] == geheimeWoord.charAt(j))
				{
					
					g.setColor(Color.RED);
					g.fillRoundRect(j*40, i*40, 40, 40, 20, 20);
					g.setColor(Color.WHITE);
					
					if(regel-1 == i)
					{
						g.setColor(Color.RED);
						g.fillRoundRect(j*40, (i+1)*40, 40, 40, 20, 20);
						g.setColor(Color.WHITE);
						g.drawString("" + chars[i][j], j*40 + 17, (i+1)*40 + 26);
					}
				}
				else
				{
					g.setColor(Color.WHITE);
					for (int l = 0; l < 5; l++) {
							if(chars[i][j] == geheimeWoord.charAt(l) && !alGeraden.getOrDefault(chars[i][j], false)) {
								g.setColor(Color.YELLOW);
								g.fillOval(j*40, i*40, 40, 40);
								g.setColor(Color.BLACK);
							}
					}
				}

				g.drawString("" + chars[i][j], j*40 + 17, i*40 + 26);
				g.setColor(Color.WHITE);
				g.drawRect(j*40, i*40, 40, 40);
				
			}
		}
	}
	
	private void beginRonde() {
		teamAanDeBeurt = !teamAanDeBeurt;
		chars = new char[5][5];
		regel = 0;
		
		geheimeWoord = woorden[(int)(woorden.length*Math.random())].toUpperCase();
		
		chars[0][0] = geheimeWoord.charAt(0);
		
		updateLabels();
		
	}

	private void updateLabels() {
		lblAanDeBeurt.setText("Team "+(teamAanDeBeurt?"1":"2")+" is aan de beurt");
		lblScore1.setText("€"+score1);
		lblScore2.setText("€"+score2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String woord = txt.getText().toUpperCase();
		txt.setText("");
		
		if(woord.length() != 5) {
			
			JOptionPane.showMessageDialog(this, woord + " is niet 5 letters lang.");
			beginRonde();
			repaint();
			return;
		}
		
		if(woord.charAt(0) != geheimeWoord.charAt(0)) {
			
			JOptionPane.showMessageDialog(this, woord + " begint niet met een "+geheimeWoord.charAt(0)+".");
			beginRonde();
			repaint();
			return;
		}
		
		if(woord.equals(geheimeWoord))
		{
			JOptionPane.showMessageDialog(this, "Gefeliciteerd! "+woord+" is goed!");
			if(teamAanDeBeurt)score1+=25;
			else score2+=25;
			if(regel == 5)
			{
				teamAanDeBeurt = !teamAanDeBeurt;
			}
			beginRonde();
			repaint();
			return;
		}
		
		boolean bestaand = false;
		
		for (int i = 0; i < woorden.length; i++) {
			
			if(woorden[i].equals(woord)) {
				
				bestaand = true;
			}
		}
		
		if(!bestaand) {
			
			JOptionPane.showMessageDialog(this, woord + " is geen bestaand woord.");
			beginRonde();
			paint();
			return;
		}
		

		if(regel == 5)
		{
			for(int i=1;i<chars.length;i++)
			{
				chars[i-1] = chars[i];
			}
			chars[regel-1] = woord.toUpperCase().toCharArray();
		}
		else
		{
			chars[regel] = woord.toUpperCase().toCharArray();
		}
		regel++;
		if(regel == 5)
		{
			teamAanDeBeurt = !teamAanDeBeurt;
			updateLabels();
		}
		else if(regel == 6)
		{
			teamAanDeBeurt = !teamAanDeBeurt;
			updateLabels();
			for(int i=1;i<chars.length;i++)
			{
				chars[i-1] = chars[i];
			}
			chars[regel-2] = geheimeWoord.toUpperCase().toCharArray();
			JOptionPane.showMessageDialog(this, geheimeWoord+" is het woord!");
			beginRonde();
		}
		
		paint();
		
	}
}
