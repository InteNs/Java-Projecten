package opd3alt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	private static JFrame mainWindow = new JFrame();
	private static JTextField textField = new JTextField();
	private static JButton acceptButton = new JButton();
	private static JPanel contentPanel = new JPanel();
	public static void main (String[] args) {
		Insets insets = mainWindow.getInsets();
		acceptButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        		Shapes shapes = new Shapes();
        		int decrementValue = 600 / (Integer.parseInt(textField.getText()));
        		for (int i = 0; i < (Integer.parseInt(textField.getText())); i++) {
            		shapes.addRectangle(new Point2D(0 + ((decrementValue / 2) * i), 0 + ((decrementValue / 2) * i)), new Size2D(600 - (decrementValue * i), 600 - (decrementValue * i)));
        		}
        		shapes.getGraphics(contentPanel);
            }
        });
		textField.setSize(140, 40);
		textField.setLocation(new Point(2, (800 - 80)));
		acceptButton.setSize(140, 40);
		acceptButton.setLocation(new Point((800 - 157), (800 - 80)));
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setSize(601, 601);
		contentPanel.setLocation(new Point(100, 50));
		mainWindow.add(acceptButton);
		mainWindow.add(textField);
		mainWindow.add(contentPanel);
		mainWindow.setLayout(null);
		mainWindow.pack();
		mainWindow.setTitle("faggot");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(new Dimension(insets.left + insets.right + 800, insets.top + insets.bottom + 800));
		mainWindow.setVisible(true);
	}
	
}
