import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;


public class Bddfenetre extends JFrame implements ActionListener {
//Encore une victoire pour canard	
//panels
private JPanel pan1;
private JPanel pan2;
private JPanel pan22;
private JPanel pan3;
//Menu
private JMenuBar Menu;
private JMenu Menucontact;
private JMenuItem ajouter;
private JMenuItem afficher;

//Labels
private JLabel lblliste;
private JLabel lblnumero;
private JLabel lblnom;
private JLabel lblprenom;
private JLabel lblemail;
private JLabel lblsucces;
private JLabel lblcommentaires;
//Zones de texte
private JTextField txtnumero;
private JTextField txtnom;
private JTextField txtprenom;
private JTextField txtemail;
private JTextField txtcommentaires;
//Boutons
private JButton btnvalid;
//Base de donnée

//Tableaux
private JTable tab;
private JScrollPane scroll;
private String[] titre = {"Numéro" , "Nom", "Prénom", "Email", "Commentaire"};
private Object[][] data;


Bddfenetre(ArrayList<Contact> LesContacts ) {
	
	this.setTitle("Accueil");
	this.setSize(450, 450);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(true);
	//Panels
	pan1 = new JPanel();
	pan2 = new JPanel();
	pan22 = new JPanel();
	pan3 = new JPanel();
	//Déclaration du Layout
	pan1.setLayout(new BorderLayout());
	pan22.setLayout(new GridLayout(5, 2));
	//Declarations des composants
	Menu = new JMenuBar();
	Menucontact = new JMenu("Contact");
	ajouter = new JMenuItem("ajouter un contact");
	afficher = new JMenuItem("afficher les contacts");
	lblnumero = new JLabel("Numero");
	txtnumero = new JTextField();
	lblnom = new JLabel("Nom");
	txtnom = new JTextField();
	lblprenom = new JLabel("Prenom");
	txtprenom = new JTextField();
	lblemail = new JLabel("email");
	txtemail = new JTextField();
	lblcommentaires = new JLabel("Commentaires");
	txtcommentaires = new JTextField();
	lblliste = new JLabel("liste des contacts");
	btnvalid = new JButton("valider");
	lblsucces= new JLabel("");
	data = new Object[LesContacts.size()][5];
	for (int i =0; i<LesContacts.size(); i++){
		data[i][0]=LesContacts.get(i).getNumero();
		data[i][1]=LesContacts.get(i).getNom();
		data[i][2]=LesContacts.get(i).getPrenom();
		data[i][3]=LesContacts.get(i).getEmail();
		data[i][4]=LesContacts.get(i).getCommentaire();
	}
	tab = new JTable(data, titre);
	scroll = new JScrollPane(tab);
	//Ajout des composants

	Menucontact.add(ajouter);
	Menucontact.add(afficher);
	Menu.add(Menucontact);
	pan1.add(Menu, BorderLayout.NORTH);
	pan2.add(pan22);
	pan22.add(lblnumero);
	pan22.add(txtnumero);
	pan22.add(lblnom);
	pan22.add(txtnom);
	pan22.add(lblprenom);
	pan22.add(txtprenom);
	pan22.add(lblemail);
	pan22.add(txtemail);
	pan22.add(lblcommentaires);
	pan22.add(txtcommentaires);
	pan2.add(btnvalid);
	pan2.add(lblsucces);
	pan3.add(lblliste);
	pan3.add(tab);
	//Actionlistener
	ajouter.addActionListener(this);
	afficher.addActionListener(this);
	btnvalid.addActionListener(new ActionItem());
	
	//Ajout du panel
	
	this.getContentPane().add(pan1);
	this.setVisible(true);
}
public void actionPerformed ( ActionEvent e ) {
	if ( e.getSource() == ajouter) {
		this.setVisible(false);
		this.getContentPane().remove(pan1);
		this.getContentPane().add(pan2);
	}
	if ( e.getSource() == afficher) {
		this.setVisible(false);
		this.getContentPane().remove(pan1);
		this.getContentPane().add(pan3);
	}
	
	this.setVisible(true);
}
class ActionItem implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		int n = Integer.parseInt(txtnumero.getText());
		connectDB.ajoutercontact(n , txtnom.getText(), txtprenom.getText(), 
		txtemail.getText(), txtcommentaires.getText());
		lblsucces.setText("Insertion réussi");
	}
}

}
