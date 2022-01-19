package DAO;

import java.util.*;

import Metier.Etudiant;

public class GestionEtudiants implements IGestionEtudiants{
	List<Etudiant>liste=new ArrayList<>();
	@Override
	public Etudiant ajouterEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		if(e != null)
			liste.add(e);
		return e;
	}

	@Override
	public List<Etudiant> rechercherParMC(String mc) {
		// TODO Auto-generated method stub
		List<Etudiant> listeInt =new ArrayList<>();
		for (int i = 0; i < liste.size(); i++) {
			if ((liste.get(i).getNom().contains(mc)) || (liste.get(i).getPrenom().contains(mc)) || (liste.get(i).getFiliere().contains(mc))) {
				listeInt.add(liste.get(i));
			}
			
		}
		return listeInt;
	}

	@Override
	public void trierListeEtudiantsParNom() {
		// TODO Auto-generated method stub
		liste.sort((x,y)->x.getNom().compareTo(y.getNom()));
	}

	@Override
	public List<Etudiant> listeDesEtudiants() {
		// TODO Auto-generated method stub
		return liste;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getId()==(id)) {
				liste.remove(i);
				
				
			}
			
			
		}
		
	}

}
