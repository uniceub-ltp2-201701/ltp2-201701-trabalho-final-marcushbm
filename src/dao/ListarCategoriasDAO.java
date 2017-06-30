package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.out;

public class ListarCategoriasDAO {

	private Connection conexao;

	public ListarCategoriasDAO(Connection conexao){
		this.conexao = conexao;
	}

	public ArrayList<String> getTodasCategorias(){
		ArrayList<String> categorias = new ArrayList<String>();
		String[] unique = null;

		PreparedStatement ps = null;

		try{

			ps = conexao.prepareStatement("select filme.categoria from filme");

			ResultSet rs = ps.executeQuery();

			String c = "";

			while (rs.next()){
				c += rs.getString("categoria") + ",";
			}

			String[] sep;

			sep = c.split(",");

			unique = Arrays.stream(sep).distinct().toArray(String[]::new);

		}catch(Exception e){

		}

		for(int i=0; i<unique.length; i++){
			categorias.add(unique[i]);
		}

		return categorias;
	}

}
