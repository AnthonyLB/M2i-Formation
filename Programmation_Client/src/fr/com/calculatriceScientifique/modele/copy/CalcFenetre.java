package fr.com.calculatriceScientifique.modele.copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class CalcFenetre extends JFrame {

	private Calculatrice calculatrice;
	private JPanel container = new JPanel();
	private static int SIZE = 550;
	private Border raised, lowered;
	private List<IOperation> operations;
	
	public CalcFenetre() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SIZE,SIZE);
		setTitle("Calculatrice");
		
		//Bordure
		raised = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		lowered = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		container.setLayout(new BorderLayout());
		this.initAffichage();
		this.initInput();
//		this.initInputOperation();
//		this.initInputOperationSecondaire();
		this.setContentPane(container);
		setVisible(true);
	}
	
	public void initAffichage() {
		JPanel affichagePanel = new JPanel();		
		affichagePanel.setLayout(new GridLayout(2,1));
		
		Font police = new Font("Arial", Font.BOLD, 20);		
		Font policeArriere = new Font("Arial", Font.BOLD, 10);
		JLabel affichageArriere = new JLabel("");
		affichageArriere.setFont(policeArriere);
		affichageArriere.setPreferredSize(new Dimension(SIZE-50,SIZE/10));
		affichageArriere.setHorizontalAlignment(JLabel.RIGHT);
		affichagePanel.add(affichageArriere);
		
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
//		affichage.setBorder(lowered);
		affichagePanel.add(affichage);			
		affichagePanel.setBorder(lowered);		
		
		container.add(affichagePanel, BorderLayout.NORTH);
		this.calculatrice = new Calculatrice(affichage,affichageArriere);		
	}
	
	public void initInput() {
		JPanel inputNumber = new JPanel();
		inputNumber.setLayout(new GridLayout(5,7));
		
//		inputNumber.add(new BoutonDegree(calculatrice,"rad"));
//		inputNumber.add(new BoutonDegree(calculatrice,"deg"));
//		inputNumber.add(new BoutonFonction(calculatrice,"!","!"));
//		inputNumber.add(new BoutonFonction(calculatrice,"(","("));
//		inputNumber.add(new BoutonFonction(calculatrice,")",")"));
//		inputNumber.add(new BoutonFonction(calculatrice,"%","%"));
//		inputNumber.add(new BoutonClear(calculatrice,"CL"));
//		inputNumber.add(new BoutonFonction(calculatrice,"Inv",""));
//		inputNumber.add(new BoutonFonction(calculatrice,"sin","sin("));
//		inputNumber.add(new BoutonFonction(calculatrice,"ln","ln("));
//		inputNumber.add(new BoutonFonction(calculatrice,"7","7"));
//		inputNumber.add(new BoutonFonction(calculatrice,"8","8"));
//		inputNumber.add(new BoutonFonction(calculatrice,"9","9"));
//		inputNumber.add(new BoutonFonction(calculatrice,"/","/"));
//		inputNumber.add(new BoutonFonction(calculatrice,"Pi","Pi"));
//		inputNumber.add(new BoutonFonction(calculatrice,"cos","cos("));
//		inputNumber.add(new BoutonFonction(calculatrice,"log","log("));
//		inputNumber.add(new BoutonFonction(calculatrice,"4","4"));
//		inputNumber.add(new BoutonFonction(calculatrice,"5","5"));
//		inputNumber.add(new BoutonFonction(calculatrice,"6","6"));
//		inputNumber.add(new BoutonFonction(calculatrice,"�","�"));
//		inputNumber.add(new BoutonFonction(calculatrice,"e","e"));
//		inputNumber.add(new BoutonFonction(calculatrice,"tan","tan("));
//		inputNumber.add(new BoutonFonction(calculatrice,"V","V("));
//		inputNumber.add(new BoutonFonction(calculatrice,"1","1"));
//		inputNumber.add(new BoutonFonction(calculatrice,"2","2"));
//		inputNumber.add(new BoutonFonction(calculatrice,"3","3"));
//		inputNumber.add(new BoutonFonction(calculatrice,"-","-"));
//		inputNumber.add(new BoutonFonction(calculatrice,"Ans",""));
//		inputNumber.add(new BoutonFonction(calculatrice,"E","E"));
//		inputNumber.add(new BoutonFonction(calculatrice,"xy",""));
//		inputNumber.add(new BoutonFonction(calculatrice,"0","0"));
//		inputNumber.add(new BoutonFonction(calculatrice,".","."));
//		inputNumber.add(new BoutonEgal(calculatrice,"="));
//		inputNumber.add(new BoutonFonction(calculatrice,"+","+"));
		
		inputNumber.setPreferredSize(new Dimension(SIZE,SIZE));
		inputNumber.setBorder(raised);
		container.add(inputNumber, BorderLayout.CENTER);
	}
	
	public void initInputOperation(){
//		JPanel inputOperation = new JPanel();
//		inputOperation.setLayout(new GridLayout(4,2));
//		
//		String bck = new String(Character.toChars(8592));
//		inputOperation.add(new BoutonClear(calculatrice,"c"));
//		inputOperation.add(new BoutonEffacer(calculatrice,bck));
//		inputOperation.add(new BoutonOperation(calculatrice,"+", new OperationAddition()));
//		inputOperation.add(new BoutonOperation(calculatrice,"-", new OperationSoustraction()));
//		inputOperation.add(new BoutonOperation(calculatrice,"×", new OperationMultiplication()));
//		inputOperation.add(new BoutonOperation(calculatrice,"/", new OperationDivision()));
//		inputOperation.add(new BoutonOperation(calculatrice,"*", new OperationPuissance()));
//		inputOperation.add(new BoutonRacine(calculatrice,"√"));		
//		
//		inputOperation.setPreferredSize(new Dimension(2*SIZE/5,SIZE/2));	
//		
//		inputOperation.setBorder(raised);
//		container.add(inputOperation, BorderLayout.EAST);
	}
	
	public void initInputOperationSecondaire() {
//		JPanel inputOperation = new JPanel();
//		inputOperation.setLayout(new GridLayout(4,2));
//		
//		String bck = new String(Character.toChars(8592));
//		inputOperation.add(new BoutonClear(calculatrice,"c"));
//		inputOperation.add(new BoutonEffacer(calculatrice,bck));
//		inputOperation.add(new BoutonOperation(calculatrice,"cos", new OperationAddition()));
//		inputOperation.add(new BoutonOperation(calculatrice,"-", new OperationSoustraction()));
//		inputOperation.add(new BoutonOperation(calculatrice,"×", new OperationMultiplication()));
//		inputOperation.add(new BoutonOperation(calculatrice,"/", new OperationDivision()));
//		inputOperation.add(new BoutonOperation(calculatrice,"*", new OperationPuissance()));
//		inputOperation.add(new BoutonRacine(calculatrice,"√"));		
//		
//		inputOperation.setPreferredSize(new Dimension((int) 1.5 * SIZE/6,SIZE/3));	
//		
//		inputOperation.setBorder(raised);
//		container.add(inputOperation, BorderLayout.WEST);
	}
	
}
