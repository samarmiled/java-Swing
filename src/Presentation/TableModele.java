package Presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Metier.Etudiant;

public class TableModele extends AbstractTableModel{
	private List<Etudiant> liste;
	private String colonnes[]=  {"Id","Nom","Prenom","Filiere","Sexe",};
	
public TableModele () {
	liste = new ArrayList<>();
}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return liste.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0:
			return liste.get(rowIndex).getId();
		case 1:
			return liste.get(rowIndex).getNom();
		case 2:
			return liste.get(rowIndex).getPrenom();
		case 3:
			return liste.get(rowIndex).getFiliere();
		case 4:
			return liste.get(rowIndex).getSexe();
		}
		
		return null;
	}
	@Override
public String getColumnName(int column) {
	return colonnes[column];
}
	public void charger(List<Etudiant> l) {
		this.liste=l;
		fireTableDataChanged();
	}
	
}
