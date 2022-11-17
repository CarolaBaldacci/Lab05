package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.Dao.AnagrammiDAO;

public class Model {

	AnagrammiDAO anagrammaDao= new AnagrammiDAO();
	
	public Set<String> trovaAnagrammi(String parola) {
		Set<String> anagrammi = new HashSet<String>();
		anagrammiRicorsione("",parola,0,anagrammi);
		return anagrammi;
	}
	
	
	public boolean anagrammaEsistente(String anagramma) {
		return anagrammaDao.anagrammaEsistente(anagramma);
	}
	
	
	private void anagrammiRicorsione(String parziale, String rimanenti, int livello,Set <String> anagrammi ) {
		if(livello==rimanenti.length()) {
			anagrammi.add(parziale);
			return;
		}else {
			for(int pos=0; pos<rimanenti.length(); pos++) {
				String nuova_parziale=parziale+rimanenti.charAt(pos);
				String nuova_rimanenti= rimanenti.substring(0, pos)+rimanenti.substring(pos+1);
				anagrammiRicorsione(nuova_parziale, nuova_rimanenti, livello+1, anagrammi);
			}
		}
	}
}
