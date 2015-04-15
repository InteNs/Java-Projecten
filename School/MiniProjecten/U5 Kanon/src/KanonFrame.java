import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class KanonFrame extends JFrame implements ActionListener
{
	private JPanel pnl;
	private JButton btnLinks, btnRechts, btnStart, btnSchiet, btnStop;
	private Timer timer;
	private int kanonX;
	private int doelX, doelY;
	private ArrayList<Kogel> kogels;
	private int frame, score, explosieTijd;
	
	public KanonFrame()
	{
		setTitle("Hit the balloon");
		timer = new Timer(16, this);
		setLayout(new FlowLayout());
		pnl = new JPanel();
		pnl.setPreferredSize(new Dimension(640, 400));
		pnl.setBackground(Color.WHITE);
		add(pnl);
		btnLinks = new JButton("Draai naar links");
		add(btnLinks);
		btnLinks.addActionListener(this);
		btnRechts = new JButton("Draai naar rechts");
		add(btnRechts);
		btnRechts.addActionListener(this);
		btnStart = new JButton("Start");
		add(btnStart);
		btnStart.addActionListener(this);
		btnSchiet = new JButton("Schiet");
		add(btnSchiet);
		btnSchiet.addActionListener(this);
		btnStop = new JButton("Stop");
		add(btnStop);
		btnStop.addActionListener(this);
		setSize(new Dimension(640, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == timer) //update en teken het spel
		{
			for(int i=0;i<kogels.size();i++) //loop langs alle kogels
			{
				Kogel k = kogels.get(i);
				//check of de kogel het doel raakt
				double dx = k.getX()-doelX;
				double dy = k.getY()-doelY;
				if(Math.hypot(dx, dy) <= 23 && explosieTijd == -1)
				{
					score++;
					explosieTijd = 20;
				}
				//verplaats de kogel
				k.setX(k.getX()+k.getDx());
				k.setY(k.getY()-2);
				//verwijder kogels die uit het scherm zijn
				if(k.getX() < -5 || k.getX() > pnl.getWidth()+5 || k.getY() < -5)
				{
					kogels.remove(k);
				}
			}
			frame++; //update de tijd. De tijd is in 1/60 seconden
			if(frame >= 60*60) //check of de tijd verstreken is
			{
				stopGame();
				return;
			}
			//wis het scherm
			Graphics g = pnl.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, pnl.getWidth(), pnl.getHeight());
			if(explosieTijd == -1) //wanneer er geen explosie is
			{
				g.setColor(Color.RED);
				g.drawOval(doelX-20, doelY-20, 40, 40);
			
			}
			else //wanneer er wel een explosie is
			{
				g.setColor(Color.BLUE);
				//teken de vier cirkels van de explosie
				g.drawOval(doelX-10-(40-explosieTijd*2), doelY-10-(40-explosieTijd*2), 20, 20);
				g.drawOval(doelX-20+(40-explosieTijd*2), doelY-20-(40-explosieTijd*2), 40, 40);
				g.drawOval(doelX-20-(40-explosieTijd*2), doelY-20+(40-explosieTijd*2), 40, 40);
				g.drawOval(doelX-10+(40-explosieTijd*2), doelY-10+(40-explosieTijd*2), 20, 20);
				explosieTijd--;
				if(explosieTijd == -1) //aan het eind van de explosie
				{
					doelX = (int)(Math.random()*pnl.getWidth());
					doelY = (int)(Math.random()*(pnl.getHeight()-100));
				}
			}
			//teken het kanon
			g.setColor(Color.BLACK);
			if(kanonX == 0)
			{
				g.fillRect(pnl.getWidth()/2-5, pnl.getHeight()-50, 10, 50);
			}
			else
			{
				g.drawLine(pnl.getWidth()/2-5, pnl.getHeight(), pnl.getWidth()/2-5+kanonX, pnl.getHeight()-50);
				g.drawLine(pnl.getWidth()/2+5, pnl.getHeight(), pnl.getWidth()/2+5+kanonX, pnl.getHeight()-50);
			}
			//teken alle kogels
			for(Kogel k: kogels)
			{
				g.fillOval((int)k.getX()-3, (int)k.getY()-3, 6, 6);
			}
		}
		else if(e.getSource() == btnStart)
		{
			timer.start();
			btnStart.setEnabled(false);
			doelX = (int)(Math.random()*pnl.getWidth());
			doelY = (int)(Math.random()*(pnl.getHeight()-100));
			kanonX = 0;
			frame = 0;
			score = 0;
			kogels = new ArrayList<Kogel>();
			explosieTijd = -1;
		}
		else if(e.getSource() == btnStop)
		{
			stopGame();
		}
		else if(e.getSource() == btnLinks)
		{
			kanonX -= 5;
		}
		else if(e.getSource() == btnRechts)
		{
			kanonX += 5;
		}
		else if(e.getSource() == btnSchiet)
		{
			kogels.add(new Kogel(pnl.getWidth()/2, pnl.getHeight()-5, kanonX/25.0));
		}
	}

	/**
	 * stopt het spel en laat een berichtje zien
	 */
	private void stopGame()
	{
		timer.stop();
		Graphics g = pnl.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, pnl.getWidth(), pnl.getHeight());
		g.setColor(Color.GREEN);
		g.drawString("De speeltijd is verstreken; je hebt "+score+" ballon(nen) geraakt", 100, 200);
		btnStart.setEnabled(true);
	}
}
