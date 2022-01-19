package Metier;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Etudiant implements Comparable<Etudiant>{
private int id;
private String nom;
private String prenom;
private String sexe;
private String filiere;
private static int  auto;
public Etudiant( int id ,String nom, String prenom, String filiere, String sexe) {
	//id = ++auto;
	this.id=id;
	this.nom = nom;
	this.prenom = prenom;
	this.filiere = filiere;
	this.sexe = sexe;
	
}
public Etudiant( String nom, String prenom, String filiere, String sexe) {
	//id = ++auto;
	this.nom = nom;
	this.prenom = prenom;
	this.filiere = filiere;
	this.sexe = sexe;
	
}
public Etudiant () {
	//id = ++auto;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getFiliere() {
	return filiere;
}
public void setFiliere(String filiere) {
	this.filiere = filiere;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Etudiant other = (Etudiant) obj;
	return id == other.id;
}



@Override
public String toString() {
	return "Etudiant " + nom + " "+ prenom +  " existe";
}
@Override
public int compareTo(Etudiant o) {
	// TODO Auto-generated method stub
	return this.nom.compareTo(o.nom);
};

}
