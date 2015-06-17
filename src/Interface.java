import java.util.*;
import javax.swing.JFrame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Classe qui défini les fonctions liées à l'interface graphique 
 * */
@SuppressWarnings("serial")
public class Interface extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel labeltest;
	private JButton buttontest;
	private JTextField field;
	
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
		
		this.panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(new Color(120,120,120));
		
		labeltest = new JLabel("Fenetre de jeu");
		panel.add(labeltest);
		
		field = new JTextField();
		field.setColumns(10);
		panel.add(field);
		
		this.buttontest = new JButton("clicky clicky, YOU BITCH");
		buttontest.addActionListener(this);
		panel.add(buttontest);
		
		setContentPane(panel);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == buttontest)
			labeltest.setText(field.getText());
	}
	
	
	public void display()
	{
		setVisible(true);
	}
}
