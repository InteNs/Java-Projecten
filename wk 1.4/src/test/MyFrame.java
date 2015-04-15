package test;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class MyFrame extends JFrame implements ActionListener
{
        private JPanel p;
        private JButton b1, b2;
 
        public MyFrame(){
                setLayout (new FlowLayout());
                p = new JPanel();                               add(p);
                p.setPreferredSize(new Dimension(200, 100));
                p.setBackground(Color.WHITE);
                b1= new JButton("Open");                add(b1);
                b1.addActionListener(this);
                b2= new JButton("Gesloten");    add(b2);
                b2.addActionListener(this);
                setSize(250, 200);
                setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        public void actionPerformed(ActionEvent event) {
                Graphics g = p.getGraphics();
                Font font = new Font("Serif", Font.ITALIC, 22);
                g.setFont(font);
 
                if(event.getSource()== b1); {
                        g.setColor(Color.WHITE);
                        g.fillRect(0, 0, 200, 100);
                        g.setColor(Color.BLUE);
                        g.drawString("Heden Open", 60,50);
                        b1.setEnabled(false);
                        b2.setEnabled(true);
                }
                if(event.getSource()== b2); {
                        g.setColor(Color.WHITE);
                        g.fillRect(0, 0, 200, 100);
                        g.setColor(Color.RED);
                        g.drawString("Morgen Gesloten", 60,50);
                        b1.setEnabled(true);
                        b2.setEnabled(false);
                }
        }
}

