import java.util.*;
import javax.swing.JFrame;

/**
 * Classe qui défini les fonctions liées à l'interface graphique 
 * */
public class Interface {
	public static void main(String[] args){

	    JFrame fenetre = new JFrame();

	    fenetre.setTitle("Risky");


	    fenetre.setSize(400, 100);

	    fenetre.setLocationRelativeTo(null);

	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        

	    fenetre.setVisible(true);
	}
}
