import java.util.*;

<<<<<<< HEAD
/**
 * Classe qui défini les fonctions liées à l'interface graphique 
 * */
public class Interface {

=======
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Classe qui définie les fonctions liées à l'interface graphique 
 * */
@SuppressWarnings("serial")
public class Interface extends JFrame implements ActionListener{
	/* Le panel principal */
	private JPanel mainPanel;
		/* Le panel contenant la carte */
		private JPanel panelCarte;
		/* Le panel contenant les infos sur le joueur */
		private JPanel panelInfoJoueur;
		/* Le panel contenant les infos sur les bonus */
		private JPanel panelInfoBonus;
		/* Le panel contenant les actions possibles */
		private JPanel panelActions;
		/* Le panel contenant les infos sur le pays sélectionné */
		private JPanel panelSelectPays;
			private JLabel SelectPays_labelPays;
				private JLabel SelectPays_labelPaysContent;
			private JLabel SelectPays_labelContinent;
				private JLabel SelectPays_labelContinentContent;
			private JLabel SelectPays_labelJoueur;
				private JLabel SelectPays_labelJoueurContent;
			private JLabel SelectPays_labelUnite;
				private JLabel SelectPays_labelUniteContent;			
	
	
	private JLabel labelPlaceholderCarte;
	private JLabel labelPlaceholderInfoJoueur;
	private JLabel labelPlaceholderInfoBonus;
	private JLabel labelPlaceholderActions;
	private JLabel labelPlaceholderSelectPays;
	
	public Interface(String title, int width, int height)
	{
		super();
		
		build(title, width, height);
	}
	
	private void build(String title, int width, int height)
	{
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		/*---------------- GUI ----------------*/
		this.mainPanel = new JPanel();
			FlowLayout mainPanelLayout = new FlowLayout(FlowLayout.LEADING);
			mainPanelLayout.setAlignOnBaseline(true);
			this.mainPanel.setLayout(mainPanelLayout);
			
		
		this.panelCarte = new JPanel();
			this.panelCarte.setLayout(new FlowLayout());
			this.panelCarte.setBackground(new Color(255,0,0));
			this.mainPanel.add(this.panelCarte);

		this.panelInfoJoueur = new JPanel();
			this.panelInfoJoueur.setLayout(new FlowLayout());
			this.panelInfoJoueur.setBackground(new Color(0,255,0));
			this.mainPanel.add(this.panelInfoJoueur);
		
		this.panelInfoBonus = new JPanel();
			this.panelInfoBonus.setLayout(new FlowLayout());
			this.panelInfoBonus.setBackground(new Color(0,0,255));
			this.mainPanel.add(this.panelInfoBonus);
			
		this.panelActions = new JPanel();
			this.panelActions.setLayout(new FlowLayout());
			this.panelActions.setBackground(new Color(255,255,255));
			this.mainPanel.add(this.panelActions);
		
		this.panelSelectPays = new JPanel();
			this.panelSelectPays.setLayout(new FlowLayout());
			this.panelSelectPays.setBackground(new Color(0,0,0));
			this.mainPanel.add(this.panelSelectPays);
			
		labelPlaceholderCarte = new JLabel("Carte");
		this.panelCarte.add(labelPlaceholderCarte);
		
		labelPlaceholderInfoJoueur = new JLabel("InfoJoueur");
		this.panelInfoJoueur.add(labelPlaceholderInfoJoueur);
		
		labelPlaceholderInfoBonus = new JLabel("InfoBonus");
		this.panelInfoBonus.add(labelPlaceholderInfoBonus);
		
		labelPlaceholderActions = new JLabel("Actions");
		this.panelActions.add(labelPlaceholderActions);
		
		labelPlaceholderSelectPays = new JLabel("SelectPays");
		this.panelSelectPays.add(labelPlaceholderSelectPays);
		
		setContentPane(mainPanel);
	}
	
	public void actionPerformed(ActionEvent e)
	{
			
	}
	
	
	public void display()
	{
		setVisible(true);
	}
>>>>>>> 95ad7718ca16e283c9671ce018f6eac1e1e9dbd2
}
