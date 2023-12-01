package br.com.fecaf.biblioteca.livros;

import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Instancia da classe Editora
		Editora editora1 = new Editora();
		Editora editora2 = new Editora();
		
		//Cadastrando dados no objeto editora1
		editora1.setNome("Editora FECAF");
		editora1.setTelefone("011 47798985");
		editora1.setCnpj("123456789789");
		editora1.setLogradouro("Rua Elton Silva, 10");
		editora1.setBairro("São Paulo");
		editora1.setCep("06478100");
		editora1.setCidade("São Paulo");
		editora1.setEstado("SP");
		editora1.setEmail("editorasaraiva@gmail.com");
		
		editora1.setNewEditora();
		
		//Cadastrando dados no objeto editora1
		editora2.setNome("Editora Erica");
		editora2.setTelefone("011 47798985");
		editora2.setCnpj("123456789789");
		editora2.setLogradouro("Rua Elton Silva, 10");
		editora2.setBairro("São Paulo");
		editora2.setCep("06478100");
		editora2.setCidade("São Paulo");
		editora2.setEstado("SP");
		editora2.setEmail("erica@gmail.com");
		
		//Metodo que imprime os dados da editora
		editora1.getListEditoras();;
		
	
		

	}

}
