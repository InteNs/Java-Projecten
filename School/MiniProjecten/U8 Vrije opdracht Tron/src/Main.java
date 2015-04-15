import javax.swing.JFrame;


public class Main
{
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		Tron p = new Tron();
		f.add(p);
		f.setTitle("Tron");
		f.addKeyListener(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
	}
}
