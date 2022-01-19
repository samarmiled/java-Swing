package Presentation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import DAO.GestionEtuJDBC;
import DAO.GestionEtudiants;

import java.awt.event.*;

import Metier.Etudiant;

import java.awt.*;

public class Model extends JFrame implements ActionListener{
	JPanel ph = new JPanel(new BorderLayout());
	JPanel pb = new JPanel(new BorderLayout());
	JPanel pinfo = new JPanel(new GridLayout(2,2));
	JPanel pnom = new JPanel(new FlowLayout());
	JPanel pprenom = new JPanel(new FlowLayout());
	JPanel psexe = new JPanel(new FlowLayout());
	JPanel pfiliere = new JPanel(new FlowLayout());
	JPanel pbouton = new JPanel(new FlowLayout());
	JPanel pRecherche = new JPanel(new FlowLayout());
	JPanel ptable = new JPanel(new GridLayout(1,1));
	JPanel psupprimer=new JPanel();
	JLabel nom = new JLabel("Nom :");
	JLabel prenom = new JLabel("Prenom :");
	JLabel filiere = new JLabel("Filiere :");
	JLabel sexe = new JLabel("Sexe :");
	JLabel chercher = new JLabel("Chercher par mot clé");
	
	JTextField tnom = new JTextField(13);
	JTextField tprenom = new JTextField(13);
	JTextField tchercher = new JTextField(13);
	
	JComboBox<String> lfiliere = new JComboBox<>(new String [] {"Telecom","Informatique","Electrique","Mécanique","Génie Civil","Architecture","Electro-Mécanique"}); 
	
	ButtonGroup bg = new ButtonGroup();
	JRadioButton homme = new JRadioButton("H");
	JRadioButton femme = new JRadioButton("F");
	
	
	JButton ajouter = new JButton("Ajouter");
	JButton annuler = new JButton("Annuler");
	JButton bchercher = new JButton("Chercher");
	JButton supprimer = new JButton("Supprimer");
	GestionEtuJDBC gestionEtu = new GestionEtuJDBC();
	TableModele tm = new TableModele();
	JTable table = new JTable(tm);
	JScrollPane jsp = new JScrollPane(table);
	int n =-1;
	

	
	
public Model() {
	super("Gestion Etudiants");
	tm.charger(gestionEtu.listeDesEtudiants());
	this.setLayout(new GridLayout(2,1));
	ph.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),"Informations Etudiant"));
	pnom.add(nom);
	pnom.add(tnom);
	tnom.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if(!(Character.isAlphabetic(c))) {
				e.consume();
			}
		}
		
	});
	pprenom.add(prenom);
	pprenom.add(tprenom);
	
	pfiliere.add(filiere);
	pfiliere.add(lfiliere);
	
	psexe.add(sexe);
	bg.add(homme);
	bg.add(femme);
	homme.setActionCommand("H");
	femme.setActionCommand("F");
	psexe.add(homme);
	psexe.add(femme);
	
	pinfo.add(pnom);
	pinfo.add(pprenom);
	pinfo.add(pfiliere);
	pinfo.add(psexe);
	
	pbouton.add(ajouter);
	pbouton.add(annuler);
	
	ph.add(pinfo,BorderLayout.NORTH);
	ph.add(pbouton,BorderLayout.SOUTH);
	this.add(ph);
	pb.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),"Liste des étudiants"));

	pRecherche.add(chercher);
	pRecherche.add(tchercher);
	pRecherche.add(bchercher);
	bchercher.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
String mc = tchercher.getText();
tm.charger(gestionEtu.rechercherParMC(mc));
		}
		
	});
	ptable.add(jsp);
	
	pb.add(pRecherche,BorderLayout.NORTH);
	pb.add(ptable,BorderLayout.CENTER);
	supprimer.setBackground(Color.RED);
table.addMouseListener(new MouseListener() {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		n= table.getSelectedRow();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
});
supprimer.addActionListener(e->{
	if(n==-1)
		JOptionPane.showMessageDialog(null,"selectioner un etudiant");
	else {
		int res=JOptionPane.showConfirmDialog(null, "voulez-vous supprimer cet Etudiant");
		if(res==0) {
		int id = (int) tm.getValueAt(n, 0);
		gestionEtu.remove(id);
		tm.charger(gestionEtu.listeDesEtudiants());
		n=-1;}
		
	}
});
	
	psupprimer.add(supprimer);
	pb.add(psupprimer,BorderLayout.SOUTH);
	
	this.add(pb);
	
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.pack();
	setVisible(true);
	ajouter.addActionListener(this);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Model();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(tnom.getText().equals("") || tprenom.getText().equals(""))
			JOptionPane.showMessageDialog(this, "Erreur de saisie");
		
		
		else {
			int res=JOptionPane.showConfirmDialog(
					this,
					"nom:"+tnom.getText()+"\nPrenom:"+tprenom.getText()+"\n\nVoulez vous ajouter cet Etudiant?",
					"Ajouter Etudiant",
					JOptionPane.YES_NO_OPTION
					);
			if(res==0) {
			Etudiant etudiant;
			etudiant = gestionEtu.ajouterEtudiant(
					new Etudiant(
							tnom.getText(), tprenom.getText(), (String) lfiliere.getSelectedItem(), bg.getSelection().getActionCommand()));
			if(etudiant != null)
				tm.charger(gestionEtu.listeDesEtudiants());
		}
		}
		
	}

}
