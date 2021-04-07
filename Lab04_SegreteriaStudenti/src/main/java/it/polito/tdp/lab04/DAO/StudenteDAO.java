package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	
	public Studente getNomeByMatricola(Integer matricola) {
		
		String sql = "SELECT * "
				+ "FROM studente "
				+ "WHERE matricola = ?";
		Studente s = null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				s = new Studente(rs.getInt("matricola"), rs.getString("nome"), rs.getString("cognome"), rs.getString("cds"));
			}
			rs.close();
			st.close();
			conn.close();
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		return s;
	}
	
	public boolean esisteMatricola(Studente studente) {
		String sql = "SELECT * FROM Studente s WHERE s.matricola =?";
		
			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1, studente.getMatricola());
				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					rs.close();
					st.close();
					conn.close();
					return true;
				}
				else {
					rs.close();
					st.close();
					conn.close();
					return false;

				}
			}catch (SQLException e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<Corso> getCorsiOfStudenti(Studente studente){
		
		String sql = "SELECT c.codins, c.crediti, c.nome, c.pd "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins=i.codins AND i.matricola=?";
		
		List<Corso> corsistudente = new ArrayList<Corso>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, studente.getMatricola());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				corsistudente.add(c);
				
			}
			rs.close();
			st.close();
			conn.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
			}
		return corsistudente;
	}



}


