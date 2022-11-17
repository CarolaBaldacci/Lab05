package it.polito.tdp.anagrammi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AnagrammiDAO {

	public boolean anagrammaEsistente(String anagramma) {
		String sql="SELECT nome FROM parola WHERE nome=?";
		boolean result= false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);

			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				result=true;
			}
			conn.close();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}


	
	
}
