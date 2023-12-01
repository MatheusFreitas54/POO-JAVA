package br.com.fecaf.biblioteca.livros;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fecaf.biblioteca.repository.ConexaoMySql;

public class Editora {
	//Atributos da Classe
	private String nome;
	private String cnpj;
	private String logradouro;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
	
	//Encapsulamento dos atributos
	
	//Setter do nome
	public void setNome (String nome) {
		if (nome.length() > 1)
			this.nome = nome.toUpperCase();
	}
	
	//Getter do nome
	public String getNome () {
		return this.nome;
	}
	
	//Setter do cnpj
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	//Getter do cnpj
	public String getCnpj() {
		return this.cnpj;
	}
	
	//Setter do logradouro
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	//Getter do logradouro
	public String getLogradouro() {
		return this.logradouro;
	}
	
	//Setter do bairro
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	//Getter do bairro
	public String getBairro() {
		return this.bairro;
	}
	
	//Setter do cep
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	//Getter do cep
	public String getCep() {
		return this.cep;
	}
	
	//Setter do cidade
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	//Getter do cidade
	public String getCidade() {
		return this.cidade;
	}
	
	//Setter do estado
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	//Getter do estado
	public String getEstado() {
		return this.estado;
	}
	
	//Setter do telefone
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//Getter do telefone
	public String getTelefone() {
		return this.telefone;
	}
	
	//Setter do email
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Getter do email
	public String getEmail() {
		return this.email;
	}
	
	public String getEndereco() {
		return getLogradouro() + "," + getBairro() + "-" 
				+ getCidade() + "/" + getEstado(); 
	}
	
	//Metodos da classe
	public void getDadosEditora() {
		
		System.out.println("************* Dados da Editora **********");
		System.out.println("Nome da Editora:" + getNome());
		System.out.println("CNPJ da Editora:" + getCnpj());
		System.out.println("Endereço:" + getEndereco());
		System.out.println("CEP:" + getCep());
		System.out.println("Telefone" + getTelefone());
		System.out.println("Email:" + getEmail());
	}
	
	
	//Metodo para inserir uma editora no Banco de Dados
	public void setNewEditora () throws ClassNotFoundException, SQLException {
		//Instanciando a classe de conexão com o BD Mysql
		ConexaoMySql conexaoMysql = new ConexaoMySql();
		
		//Cria um objeto que é referenciado no BD MYSQL
		Connection conexao = conexaoMysql.getConnection();
		
		//Cria um objeto que vai encaminhar scriptSQL para o BD
		PreparedStatement stmNewEditora = conexao.prepareStatement("insert into tbl_editora (nome, cnpj, logradouro, bairro, cep, cidade, telefone, email) values (?, ?, ?, ?, ?, ?, ?, ?)");
		
		//Colocando os valores da classe para o scriptSQL
		stmNewEditora.setString(1, this.getNome());
		stmNewEditora.setString(2, this.getCnpj());
		stmNewEditora.setString(3, this.getLogradouro());
		stmNewEditora.setString(4, this.getBairro());
		stmNewEditora.setString(5, this.getCep());
		stmNewEditora.setString(6, this.getCidade());
		stmNewEditora.setString(7, this.getTelefone());
		stmNewEditora.setString(8, this.getEmail());
		
		//Executa o script SQL no BD
		stmNewEditora.execute();
		stmNewEditora.close();
		
	}
	
	public void getListEditoras() throws ClassNotFoundException, SQLException {
		//Instanciando a classe de conexão com o BD Mysql
		ConexaoMySql conexaoMysql = new ConexaoMySql();
				
		//Cria um objeto que é referenciado no BD MYSQL
		Connection conexao = conexaoMysql.getConnection();
		
		PreparedStatement stmListEditoras = conexao.prepareStatement("select * from tbl_editora");
		
		//Cria um objeto com todos os itens do BD
		ResultSet rsEditoras = stmListEditoras.executeQuery();
		
		while (rsEditoras.next()) {
			//Criando um objeto da Editora para cada item do BD
			Editora editora = new Editora();
			//Adicionado os dados do BD em um objeto
			editora.setNome(rsEditoras.getString("nome"));
			editora.setCnpj(rsEditoras.getString("cnpj"));
			editora.setLogradouro(rsEditoras.getString("logradouro"));
			editora.setBairro(rsEditoras.getString("bairro"));
			editora.setCep(rsEditoras.getString("cep"));
			editora.setCidade(rsEditoras.getString("cidade"));
			editora.setTelefone(rsEditoras.getString("telefone"));
			editora.setEmail(rsEditoras.getString("email"));
			
			editora.getDadosEditora();
		}
		
	}
	
	
	
}
