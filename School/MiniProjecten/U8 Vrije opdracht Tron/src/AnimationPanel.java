import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener,
		KeyListener {
	private Timer timer;

	public AnimationPanel(int ms) {
		setMaximumSize(new Dimension(801, 601));
		setMinimumSize(new Dimension(801, 601));
		setPreferredSize(new Dimension(801, 601));
		timer = new Timer(ms, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			update();
			repaint();
		}
	}

	public void update() {
	}

	public int getWidth() {
		return 801;
	}

	public int getHeight() {
		return 601;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
