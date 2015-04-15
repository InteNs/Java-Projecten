import javax.swing.JFrame;


public class Main
{
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		Snake p = new Snake();
		f.add(p);
		f.setTitle("Snake");
		f.addKeyListener(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
	}
}
