package fr.com.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetreTest extends JFrame{
	
	public FenetreTest() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setTitle("Fenetre de test");
		setLayout(null);
		
		JButton buton = new JButton("Bouton de test");
		buton.setBounds(10,20,100,20);
		add(buton);
		buton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("zpqelf");
			}			
		});
		
		buton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Clicked");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Entered");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Exited");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Pressed");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Released");
			}
			
		});
		
		JLabel label = new JLabel("Zone de texte");
		label.setBounds(10,50,200,20);
		add(label);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FenetreTest();
	}
}
