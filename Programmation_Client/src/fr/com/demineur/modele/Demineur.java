package fr.com.demineur.modele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Demineur extends JFrame {

	// La grille de jeu
	private int[][] grille;
	// La grille des cases ouvertes par le joueur
	private boolean[][] ouvertes;
	private boolean[][] isRedButton;
	
	private int largeur;
	private int hauteur;
	private int nombreBombes;
	private static int SIZE = 23;
	private static int MARGIN = 5;

	public Demineur(int largeur, int hauteur, int nombreBombes) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.nombreBombes = nombreBombes;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize((largeur+1)*SIZE, (hauteur+1)*SIZE + 5*MARGIN);
		setTitle("Demineur");
		setLayout(null);
		this.setResizable(false);		
		
		initialise();
		placerBombes();
		rafraichir();
		setVisible(true);
	}
	
	// Rafraichit la fenêtre en fonction de l'état courant de la grille
	private void rafraichir() {
		// Première étape : on supprime tous les composants déjà présents
		getContentPane().removeAll();
		
		// Deuxième étape : on construit la fenêtre en ajoutant les composants (boutons et labels)
		for(int i = 0; i<largeur; i++) {
			for(int j =0; j<hauteur; j++) {
				final int coordX = i;
				final int coordY = j;
				if(ouvertes[i][j]) {
					JLabel label = LabelFactory.createLabel(grille[i][j],MARGIN+i*SIZE + 6,MARGIN+j*SIZE, SIZE);
					MyMouseListener myListener = new MyMouseListener(JLabel.class, coordX, coordY, label);
					label.addMouseListener(myListener);
					add( label );					
				}else {
					JButton buton = ButtonFactory.createButton(MARGIN+i*SIZE, MARGIN+j*SIZE, SIZE, isRedButton[i][j]? Color.RED : Color.lightGray);
					MyMouseListener myListener = new MyMouseListener(JButton.class, coordX, coordY, buton );
					buton.addMouseListener(myListener);
					add(buton);
				}
			}
		}
		
		// A la fin, on appelle repaint()
		repaint();
		
	}
	
	// Ouvre une case et propage l'ouverture si elle vaut zéro
	private void ouvrirCaseEtPropager(int x, int y) {				
		if (x >= 0 && x < largeur && y >= 0 && y < hauteur && grille[x][y] == 0 && !ouvertes[x][y] && !isRedButton[x][y]){
			ouvertes[x][y] = true;
			ouvrirCaseEtPropager(x-1, y-1);
			ouvrirCaseEtPropager(x-1, y);
			ouvrirCaseEtPropager(x-1, y+1);
			ouvrirCaseEtPropager(x, y-1);
			ouvrirCaseEtPropager(x, y+1);
			ouvrirCaseEtPropager(x+1, y-1);
			ouvrirCaseEtPropager(x+1, y);
			ouvrirCaseEtPropager(x+1, y+1);
		}
		if(x >= 0 && x < largeur && y >= 0 && y < hauteur && !isRedButton[x][y]) ouvertes[x][y] = true;
	}

	private void ouvrirAutour(int x, int y) {
		boolean isOk = true;
		isOk &= isRedNormalButtonOk(x-1, y-1);
		isOk &= isRedNormalButtonOk(x-1, y);
		isOk &= isRedNormalButtonOk(x-1, y+1);
		isOk &= isRedNormalButtonOk(x, y-1);
		isOk &= isRedNormalButtonOk(x, y+1);
		isOk &= isRedNormalButtonOk(x+1, y-1);
		isOk &= isRedNormalButtonOk(x+1, y);
		isOk &= isRedNormalButtonOk(x+1, y+1);
		if(isOk) {
			ouvrirCaseEtPropager(x-1, y-1);
			ouvrirCaseEtPropager(x-1, y);
			ouvrirCaseEtPropager(x-1, y+1);
			ouvrirCaseEtPropager(x, y-1);
			ouvrirCaseEtPropager(x, y+1);
			ouvrirCaseEtPropager(x+1, y-1);
			ouvrirCaseEtPropager(x+1, y);
			ouvrirCaseEtPropager(x+1, y+1);
		}else {
			JOptionPane.showMessageDialog(this, "Perdu!");
			initialise();
			placerBombes();
		}
	}
	
	private boolean isRedNormalButtonOk(int x, int y) {
		boolean isOk = true;
		if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
			isOk = grille[x][y] == -1 && isRedButton[x][y] || grille[x][y] != -1 && !isRedButton[x][y] ? true: false;			
		}
		return isOk;
	}
	private void ouvrirCase(int x, int y) {
		if (x >= 0 && x < largeur && y >= 0 && y < hauteur && !isRedButton[x][y]) ouvertes[x][y]=true;
	}
	
	//Test les conditions de victoire sont remplies
	private boolean isVictory() {
		boolean isVictory = true;
		int comptRedButton = 0;
		for(int i = 0; i< largeur; i++) {
			for(int j= 0 ; j<hauteur; j++) {
				if( grille[i][j] != -1 && !ouvertes[i][j]) isVictory = false;
				if( isRedButton[i][j] && grille[i][j] == -1) comptRedButton++;
			}
		}
		if(comptRedButton == this.nombreBombes) isVictory =true;
		return isVictory;
	}
	
	// Place des bombes de façon aléatoire sur la grille
	private void placerBombes() {
		// On place autant de bombes que nombreBombes
		for (int i = 0; i < nombreBombes; i++) {
			
			int x = 0, y = 0;
			Random random = new Random();
			// On tire deux entiers tant qu'on tombe sur une bombe
			do {
				x = random.nextInt(largeur);
				y = random.nextInt(hauteur);
			} while (grille[x][y] == -1);
			
			// On pose la bombe
			grille[x][y] = -1;
			
			// On incrémente les cases adjacentes
			incremente(x-1, y-1);
			incremente(x-1, y);
			incremente(x-1, y+1);
			incremente(x, y-1);
			incremente(x, y+1);
			incremente(x+1, y-1);
			incremente(x+1, y);
			incremente(x+1, y+1);
		}
	}
	
	// Incremente une case si elle est valide : elle est bien dans la grille et elle ne contient pas déjà une bombe.
	public void incremente(int x, int y) {
		if (x >= 0 && x < largeur && y >= 0 && y < hauteur && grille[x][y] != -1) grille[x][y]++;
	}
	
	// Initialise la grile avec des zéros
	public void initialise() {
		grille = new int[largeur][hauteur];
		ouvertes = new boolean[largeur][hauteur];
		isRedButton = new boolean[largeur][hauteur];
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				// Aucune bombe à proximité : valeur zéro
				grille[i][j] = 0;
				// La case n'a pas été ouverte : valeur à false
				ouvertes[i][j] = false;
				isRedButton[i][j] = false;
			}
		}
	}

	// Affiche la grille
	public void afficher() {
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				System.out.print(grille[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
		
	class MyMouseListener<T extends Component> implements MouseListener {

		private Class<T> myClass;
		private final int x,y;
		private T component;
		
		public MyMouseListener(Class<T> myClass, final int x, final int y, T component) {
			this.myClass = myClass;
			this.x = x;
			this.y = y;
			this.component = component;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(myClass == JLabel.class) {
				if(SwingUtilities.isMiddleMouseButton(e)) {
					
					ouvrirAutour(x, y);
					if(isVictory()) {
						 JOptionPane.showMessageDialog(component.getParent(), "Gagné!");
						 initialise();
						 placerBombes();
					 }
					rafraichir();
				}				
			}else if(myClass == JButton.class) {
				if(SwingUtilities.isLeftMouseButton(e)){
					ouvrirCaseEtPropager(x,y);
					if(grille[x][y] == -1) {
						JOptionPane.showMessageDialog(component.getParent(), "Perdu!");
						initialise();
						placerBombes();
					}
					if(isVictory()) {
						 JOptionPane.showMessageDialog(component.getParent(), "Gagné!");
						 initialise();
						 placerBombes();
					 }
					rafraichir();
				}else if(SwingUtilities.isRightMouseButton(e)) {
					if(isRedButton[x][y] == true) {
						component.setBackground(Color.LIGHT_GRAY);
						isRedButton[x][y] = false;
					}else {
						component.setBackground(Color.RED);
						isRedButton[x][y] = true;
					}
					 //Test si gagné
					 if(isVictory()) {
						 JOptionPane.showMessageDialog(component.getParent(), "Gagné!");
						 initialise();
						 placerBombes();
					 }
					 rafraichir();
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
