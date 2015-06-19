import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Classe qui définie les fonctions liées à l'interface graphique.
 * */
@SuppressWarnings("serial")
public class Interface extends JFrame implements ActionListener
{
	/* Le panel principal */
	private JPanel mainPanel;
	/* Les sous-panels globaux */
	private JPanel globalHPanel; /* Contient panelCarte et panelInfoJoueur */
	private JPanel globalVPanel; /* Contient panelCarte, panelActions et panelSelectPays */
	private JPanel globalBonusVPanel; /* Contient panelInfoJoueur et panelBonus */
	private JPanel globalBonusHPanel; /* Contient panelSelectPays, panelActions et panelBonus */
	
		/* Le panel contenant la carte */
		private JPanel panelCarte;
		/* Le panel contenant les infos sur le joueur */
		private JPanel panelInfoJoueur;
			private JLabel InfoJoueur_joueur;
			private JLabel InfoJoueur_nbSoldat;
				private JLabel InfoJoueur_nbSoldatContent;
			private JLabel InfoJoueur_nbCavalier;
				private JLabel InfoJoueur_nbCavalierContent;
			private JLabel InfoJoueur_nbCanon;
				private JLabel InfoJoueur_nbCanonContent;
			private JLabel InfoJoueur_nbUnit;
				private JLabel InfoJoueur_nbUnitContent;
			private JLabel InfoJoueur_nbPays;
				private JLabel InfoJoueur_nbPaysContent;
			private JLabel InfoJoueur_nbContinent;
				private JLabel InfoJoueur_nbContinentContent;
			private JButton InfoJoueur_utilCartes;
			private JButton InfoJoueur_finTour;
			private JPanel InfoJoueur_couleurJoueur;
		/* Le panel contenant les infos sur les bonus */
		private JPanel panelInfoBonus;
			private JLabel InfoBonus_BonusLabel;
			private JLabel InfoBonus_p1;
				private JLabel InfoBonus_p1Content;
			private JLabel InfoBonus_p2;
				private JLabel InfoBonus_p2Content;
			private JLabel InfoBonus_p3;
				private JLabel InfoBonus_p3Content;
			private JLabel InfoBonus_p4;
				private JLabel InfoBonus_p4Content;
			private JLabel InfoBonus_p5;
				private JLabel InfoBonus_p5Content;
			private JLabel InfoBonus_p6;
				private JLabel InfoBonus_p6Content;
		/* Le panel contenant les actions possibles */
		private JPanel panelActions;
			private JButton Actions_DepAttack;
			private JButton Actions_PlaceUnits;
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
			private JPanel SelectPays_colorPays;
	
	
	/*---------------- labels des "placeholders" ----------------*/
	private JLabel labelPlaceholderCarte;
	private JLabel labelPlaceholderInfoJoueur;
	private JLabel labelPlaceholderInfoBonus;
	private JLabel labelPlaceholderActions;
	private JLabel labelPlaceholderSelectPays;
	
	/**
	 * Constructeur avec arguments.
	 * @param title le titre de la fenêtre. (String)
	 * @param width la largeur de la fenêtre. (int)
	 * @param height la hauteur de la fenêtre. (int)
	 * */
	public Interface(String title, int width, int height)
	{
		super();
		
		build(title, width, height);
	}
	
	/**
	 * Méthode d'instance privée construisant le contenu de la fenêtre. 
	 * Est appellée par le constructeur.
	 * @param title le titre de la fenêtre. (String)
	 * @param width la largeur de la fenêtre. (int)
	 * @param height la hauteur de la fenêtre. (int) 
	 * */
	private void build(String title, int width, int height)
	{
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		/*---------------- GUI ----------------*/
		this.mainPanel = new JPanel();
			FlowLayout mainPanelLayout = new FlowLayout();
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
			this.panelSelectPays.setBackground(new Color(255,0,255));
			this.mainPanel.add(this.panelSelectPays);
		
		/*---------------- Mise en place de "placeholder" pour l'interface ----------------*/
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
	
	/**
	 * Méthode d'instance déclenchant des actions en fonction des boutons cliqués.
	 * @param e instance d'ActionEvent permettant de savoir quel bouton à été cliqué. (ActionEvent) 
	 * */
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == InfoJoueur_utilCartes)
		{
			/* appel les méthodes afin de traiter et utiliser les cartes du joueur courant */
		}
		else if(source == InfoJoueur_finTour)
		{
			/* appel les méthodes de fin de tour pour le joueur courant */
		}
		else if(source == Actions_DepAttack)
		{
			/* appel les méthodes de déplacement / attaque des unités du joueur courant */
		}
		else if(source == Actions_PlaceUnits)
		{
			/* appel les méthodes pour placer les unités disponibles du joueur courant */
		}
	}
	
	/**
	 * Méthode d'instance affichant la fenêtre. 
	 * */
	public void display()
	{
		setVisible(true);
	}
}
