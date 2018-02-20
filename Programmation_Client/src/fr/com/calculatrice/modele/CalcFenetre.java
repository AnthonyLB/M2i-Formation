package fr.com.calculatrice.modele;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class CalcFenetre extends JFrame {

	private Calculatrice calculatrice;
	private JPanel container = new JPanel();
	private static int SIZE = 400;
	private Border raised, lowered;
	
	public CalcFenetre() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SIZE,SIZE);
		setTitle("Calculatrice");
		
		//Bordure
		raised = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		lowered = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		this.initAffichage();
		this.initInputNumber();
		this.initInputOperation();
//		this.initInputOperationSecondaire();
		this.setContentPane(container);
		setVisible(true);
	}
	
	public void initAffichage() {
		container.setLayout(new BorderLayout());	
		Font police = new Font("Arial", Font.BOLD, 20);		
		JLabel affichage = new JLabel("0") {
			public String getText() {
				String text = super.getText();
				if(text.endsWith(".0")) {
					text = text.substring(0, text.length()-2);
				}
				if(text.contains("E")) {
					text = text.replace("E", "e");
				}
				return text;
			}
		};
		affichage.setFont(police);
		affichage.setPreferredSize(new Dimension(SIZE-35,SIZE/10));
		affichage.setHorizontalAlignment(JLabel.RIGHT);
		JPanel affichagePanel = new JPanel();
		affichagePanel.add(affichage);			
		affichagePanel.setBorder(lowered);		
		
		container.add(affichagePanel, BorderLayout.NORTH);
		this.calculatrice = new Calculatrice(affichage);	
	}
	
	public void initInputNumber() {
		JPanel inputNumber = new JPanel();
		inputNumber.setLayout(new GridLayout(4,3));
		
		inputNumber.add(new BoutonNombre(calculatrice,"1"));
		inputNumber.add(new BoutonNombre(calculatrice,"2"));
		inputNumber.add(new BoutonNombre(calculatrice,"3"));
		inputNumber.add(new BoutonNombre(calculatrice,"4"));
		inputNumber.add(new BoutonNombre(calculatrice,"5"));
		inputNumber.add(new BoutonNombre(calculatrice,"6"));
		inputNumber.add(new BoutonNombre(calculatrice,"7"));
		inputNumber.add(new BoutonNombre(calculatrice,"8"));
		inputNumber.add(new BoutonNombre(calculatrice,"9"));
		inputNumber.add(new BoutonNombre(calculatrice,"0"));
		inputNumber.add(new BoutonVirgule(calculatrice,"."));
		inputNumber.add(new BoutonEgal(calculatrice,"="));
		
		inputNumber.setPreferredSize(new Dimension(3*SIZE/5,SIZE/2));
		inputNumber.setBorder(raised);
		container.add(inputNumber, BorderLayout.CENTER);
	}
	
	public void initInputOperation(){
		JPanel inputOperation = new JPanel();
		inputOperation.setLayout(new GridLayout(4,2));
		
		String bck = new String(Character.toChars(8592));
		inputOperation.add(new BoutonClear(calculatrice,"c"));
		inputOperation.add(new BoutonEffacer(calculatrice,bck));
		inputOperation.add(new BoutonOperation(calculatrice,"+", new OperationAddition()));
		inputOperation.add(new BoutonOperation(calculatrice,"-", new OperationSoustraction()));
		inputOperation.add(new BoutonOperation(calculatrice,"×", new OperationMultiplication()));
		inputOperation.add(new BoutonOperation(calculatrice,"/", new OperationDivision()));
		inputOperation.add(new BoutonOperation(calculatrice,"*", new OperationPuissance()));
		inputOperation.add(new BoutonRacine(calculatrice,"√"));		
		
		inputOperation.setPreferredSize(new Dimension(2*SIZE/5,SIZE/2));	
		
		inputOperation.setBorder(raised);
		container.add(inputOperation, BorderLayout.EAST);
	}
	
	public void initInputOperationSecondaire() {
		JPanel inputOperation = new JPanel();
		inputOperation.setLayout(new GridLayout(4,2));
		
		String bck = new String(Character.toChars(8592));
		inputOperation.add(new BoutonClear(calculatrice,"c"));
		inputOperation.add(new BoutonEffacer(calculatrice,bck));
		inputOperation.add(new BoutonOperation(calculatrice,"cos", new OperationAddition()));
		inputOperation.add(new BoutonOperation(calculatrice,"-", new OperationSoustraction()));
		inputOperation.add(new BoutonOperation(calculatrice,"×", new OperationMultiplication()));
		inputOperation.add(new BoutonOperation(calculatrice,"/", new OperationDivision()));
		inputOperation.add(new BoutonOperation(calculatrice,"*", new OperationPuissance()));
		inputOperation.add(new BoutonRacine(calculatrice,"√"));		
		
		inputOperation.setPreferredSize(new Dimension((int) 1.5 * SIZE/6,SIZE/3));	
		
		inputOperation.setBorder(raised);
		container.add(inputOperation, BorderLayout.WEST);
	}
}
