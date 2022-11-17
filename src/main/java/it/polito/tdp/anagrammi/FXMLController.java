package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtParolaInput;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	String parola= txtParolaInput.getText();
    	if(parola==null || parola=="" || parola.length()<2 || parola.length()>8) {
    		txtCorretti.appendText("E' necessario inserire una parola di minimo 2 e massimo 8 caratteri per calcolare l'anagramma!");
    		return;
    	}
    	Set<String> anagrammi= this.model.trovaAnagrammi(parola);
    	for(String a: anagrammi) {
    		if(model.anagrammaEsistente(a)) {
    			txtCorretti.appendText(a+"\n");
    		}
    		if(!model.anagrammaEsistente(a)) {
    			txtErrati.appendText(a+"\n");
    		}
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParolaInput.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParolaInput != null : "fx:id=\"txtParolaInput\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}

}
