package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Metier.Etudiant;

public class GestionEtuJDBC implements IGestionEtudiants {
	Connection cnx = SingletonConnection.getInstance();

	@Override
	public Etudiant ajouterEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = cnx.prepareStatement("insert into etudiant (nom,prenom,filiere,sexe) values(?,?,?,?)");
			stmt.setString(1, e.getNom());
			stmt.setString(2, e.getPrenom());
			stmt.setString(3, e.getFiliere());
			stmt.setString(4, e.getSexe());
			stmt.executeUpdate();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	
	return e;
	}

	@Override
	public List<Etudiant> rechercherParMC(String mc) {
		// TODO Auto-generated method stub
		List<Etudiant> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from etudiant where nom like ? or prenom like ? or filiere like ? or sexe like ?");
			ps.setString(1, "%" + mc + "%");
			ps.setString(2, "%" + mc + "%");
			ps.setString(3, "%" + mc + "%");
			ps.setString(4, "%" + mc + "%");
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e = new Etudiant();
				e.setId(rs.getInt(1));
				e.setNom(rs.getString(2));
				e.setPrenom(rs.getString(3));
				e.setFiliere(rs.getString(4));
				e.setSexe(rs.getNString(5));
				liste.add(e);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return liste;
		
	}

	@Override
	public void trierListeEtudiantsParNom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Etudiant> listeDesEtudiants() {
		// TODO Auto-generated method stub
		List<Etudiant> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from etudiant");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e = new Etudiant(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5));
				liste.add(e);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = cnx.prepareStatement("delete from etudiant where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	}


