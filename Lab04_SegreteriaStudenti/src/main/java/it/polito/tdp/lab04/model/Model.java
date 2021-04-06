package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsodao;
	private StudenteDAO studentedao;
	
	public Model() {
		this.corsodao = new CorsoDAO();
		this.studentedao = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi (){
		return corsodao.getTuttiICorsi();
	}
	
	public Studente getStudentiByMatricola(Integer matricola){
		return studentedao.getNomeByMatricola(matricola);
	}
	
	public Corso getCorso (Corso corso) {
		return corsodao.getCorso(corso);
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(String codins){
		return corsodao.getStudentiIscrittiAlCorso(new Corso(codins, null, null, null));
	}
}
