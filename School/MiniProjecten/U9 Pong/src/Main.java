import javax.swing.JFrame;


public class Main
{
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		Pong p = new Pong();
		f.add(p);
		f.setTitle("Pong");
		f.addKeyListener(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
	}
}
