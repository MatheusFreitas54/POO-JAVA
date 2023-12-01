package br.com.fecaf.biblioteca.livros;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fecaf.biblioteca.repository.ConexaoMySql;

public class Livro {
	//Atributos da classe
	public String nome;
	public Autor autor;
	public String dataLancamento;
	public int qtdePaginas;
	public Editora editora;
	public String edicao;
	public Genero genero;
	public double valorCompra;
	private double valorVenda;
	public String ilustrador;
	public int avaliacao;
	private int qtdeEstoque;
	
	//Construtor da classe
	public Livro (Boolean acessoBancoDeDados) throws ClassNotFoundException, SQLException {
		if(acessoBancoDeDados) {
			//Instanciando a classe de conexÃ£o com o BD Mysql
		
			ConexaoMySql conexaoMysql = new ConexaoMySql();
				
			//Cria um objeto que Ã© referenciado no BD MYSQL
			this.conexao = conexaoMysql.getConnection();
		}
	}
	
	//Construtor padrÃ£o
	public Livro ()  {
		//System.out.println("Bem vindo a classe da Editora");
	}
	
	
	
	
	//obter o valor de venda apÃ³s calcular
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public int getQtdePaginas() {
		return qtdePaginas;
	}

	public void setQtdePaginas(int qtdePaginas) {
		this.qtdePaginas = qtdePaginas;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getIlustrador() {
		return ilustrador;
	}

	public void setIlustrador(String ilustrador) {
		this.ilustrador = ilustrador;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	
	//Metodos da classe
	public void setCalcularValorVenda() {
		
		// margem de lucro de 20%
	    double margemLucroPercentual = 0.20;
	    
	    // Calcula o valor de venda com base no valor de compra e na margem de lucro
	    this.valorVenda = this.valorCompra * (1 + margemLucroPercentual);
		
	}
	
	public double getValorVenda() {
	    
		// Certifica-se de que o valor de venda foi calculado antes de retornÃ¡-lo
	    if (this.valorVenda == 0) {
	    // Se o valor de venda nÃ£o foi calculado, chama o mÃ©todo para calcular
	        setCalcularValorVenda();
	    }

	    return this.valorVenda;
	}
	
	public void setAtualizarEstoque(int quantidadeVendida) {
	    // Certifica-se de que a quantidade em estoque Ã© maior ou igual Ã  quantidade a ser vendida
	    if (this.qtdeEstoque >= quantidadeVendida) {
	        // Atualiza o estoque apÃ³s a venda
	        this.qtdeEstoque -= quantidadeVendida;
	        System.out.println("Estoque atualizado: " + this.qtdeEstoque + " unidades restantes.");
	    } else {
	        System.out.println("Quantidade insuficiente em estoque.");
	    }
	}
	
	public void setDebitarEstoque(int quantidadeDebitar) {
	    // Certifica-se de que a quantidade a ser debitada nÃ£o seja negativa
	    if (quantidadeDebitar >= 0) {
	        // Debita a quantidade do estoque
	        this.qtdeEstoque -= quantidadeDebitar;
	        System.out.println("Estoque debitado: " + quantidadeDebitar + " unidades.");
	        System.out.println("Estoque atualizado: " + this.qtdeEstoque + " unidades restantes.");
	    } else {
	        System.out.println("Quantidade invÃ¡lida para dÃ©bito em estoque.");
	    }
	}
	
	public int getQtdeEstoque() {
	    return this.qtdeEstoque;
	}
	
	public String getStatusEstoque() {
	    if (this.qtdeEstoque > 0) {
	        return "Em estoque";
	    } else {
	        return "Sem estoque";
	    }
	}
	
	public void getDadosLivro() {

        System.out.println("* Dados do Livro **");
        System.out.println("Nome da Livro:" + getNome());
        System.out.println("Autor do Livro:" + getAutor());
        System.out.println("Editora do Livro:" + getEditora());
        System.out.println("GÃªnero do Livro:" + getGenero());
        System.out.println("Data de lanÃ§amento:" + getDataLancamento());
        System.out.println("Quantidade de pÃ¡ginas:" + getQtdePaginas());
        System.out.println("EdiÃ§Ã£o do Livro:" + getEdicao());
        System.out.println("Valor de Compra do Livro:" + getValorCompra());
        System.out.println("Valor de Venda do Livro:" + getValorVenda());
        System.out.println("Ilustrador do Livro:" + getIlustrador());
        System.out.println("AvaliaÃ§Ã£o do Livro:" + getAvaliacao());
        System.out.println("Quatidade de Estoque do Livro:" + getQtdeEstoque());
 
	}
	
	//Metodo para inserir uma livro no Banco de Dados
    public void setNewLivro () throws ClassNotFoundException, SQLException {


        //Cria um objeto que vai encaminhar scriptSQL para o BD
        PreparedStatement stmNewLivro = this.conexao.prepareStatement("insert into tbl_livro (nome, autor, dataLancamento, qtdePaginas, editora, edicao, genero, valorCompra, valorVenda, ilustrador, avaliacao, qtdeEstoque) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        //Colocando os valores da classe para o scriptSQL
        stmNewLivro.setString(1, this.getNome());
        stmNewLivro.setString(2, this.getAutor());
        stmNewLivro.setString(3, this.getDataLancamento());
        stmNewLivro.setString(4, this.getQtdePaginas());
        stmNewLivro.setString(5, this.getEditora());
        stmNewLivro.setString(6, this.getEdicao());
        stmNewLivro.setString(7, this.getGenero());
        stmNewLivro.setString(8, this.getValorCompra());
        stmNewLivro.setString(9, this.getValorVenda());
        stmNewLivro.setString(10, this.getIlustrador());
        stmNewLivro.setString(11, this.getAvaliacao());
        stmNewLivro.setString(12, this.getQtdeEstoque());

        //Executa o script SQL no BD
        stmNewLivro.execute();
        stmNewLivro.close();

    }
	
    public void getListLivros() throws ClassNotFoundException, SQLException {

        PreparedStatement stmListLivros = this.conexao.prepareStatement("select * from tbl_livro");

        //Cria um objeto com todos os itens do BD
        ResultSet rsLivros = stmListLivros.executeQuery();

        while (rsLivros.next()) {
            //Criando um objeto do livro para cada item do BD
            Livro livro = new Livro();
            //Adicionado os dados do BD em um objeto
           livro.setNome(rsLivros.getString("nome"));
           livro.setAutor(rsLivros.getString("autor"));
           livro.setDataLancamento(rsLivros.getString("dataLancamento"));
           livro.setQtdePaginas(rsLivros.getString("qtdePaginas"));
           livro.setEditora(rsLivros.getString("editora"));
           livro.setEdicao(rsLivros.getString("edicao"));
           livro.setGenero(rsLivros.getString("genero"));
           livro.setValorCompra(rsLivros.getString("valorCompra"));
           livro.setValorVenda(rsLivros.getString("valorVenda"));
           livro.setIlustrador(rsLivros.getString("ilustrador"));
           livro.setAvaliacao(rsLivros.getString("avaliacao"));
           livro.setQtdeEstoque(rsLivros.getString("qtdeEstoque"));

            livro.getDadosLivro();
        }

    }
    
}