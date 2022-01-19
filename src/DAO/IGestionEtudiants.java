package DAO;

import java.util.List;

import Metier.Etudiant;

public interface IGestionEtudiants {
	 Etudiant ajouterEtudiant(Etudiant e);
	 List<Etudiant> rechercherParMC(String mc);
	 void trierListeEtudiantsParNom();
	 List<Etudiant> listeDesEtudiants();
	 
	 void remove(int id);
}
