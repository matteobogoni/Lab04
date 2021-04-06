/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox <Corso> chbox;

    @FXML
    private Button doCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button doCheck;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button doCercaCorsi;

    @FXML
    private Button doIscrivi;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button doReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	
    	txtRisultato.clear();
    	Corso cors = chbox.getValue();
    	if(cors == null) {
    		txtRisultato.setText("Errore, selezionare un corso");
    		return;
    	}
    	List<Studente> studenti = model.getStudentiIscrittiAlCorso(cors.getCodins());
    	if (studenti.size() == 0) {
    		txtRisultato.setText("Nessuno studente presente in questo corso");
    		return;
    	}
    	
    	for(Studente s : studenti) {
    		txtRisultato.appendText(s.toString() + "\n");
    	}
    }

    @FXML
    void doCheck(ActionEvent event) {
    	String smatricola = txtMatricola.getText();
    	Integer matricola;
    	try {
    		matricola = Integer.parseInt(smatricola);
    	}catch(NumberFormatException ne) {
    		txtRisultato.setText("Devi inserire un numero");
    		return;
    	}catch(NullPointerException npe) {
    		txtRisultato.setText("Devi inserire un numero");
    		return;
    	}
    	
    	txtNome.setText(model.getStudentiByMatricola(matricola).getNome());
    	txtCognome.setText(model.getStudentiByMatricola(matricola).getCognome());
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }
    
    public void setModel(Model m) {
    	this.model = m;
       	chbox.getItems().addAll(model.getTuttiICorsi());
    	
       	doCheck.setStyle("-fx-background-color: green");
    	
    }
    @FXML
    void initialize() {
    	assert chbox != null : "fx:id=\"chbox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert doCercaIscritti != null : "fx:id=\"doCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert doCheck != null : "fx:id=\"doCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert doCercaCorsi != null : "fx:id=\"doCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert doIscrivi != null : "fx:id=\"doIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert doReset != null : "fx:id=\"doReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

