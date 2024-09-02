package br.com.sistemabiblioteca.crud;
 
import java.awt.JobAttributes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
 
import br.com.sistemabiblioteca.jdbc.ConnectionFactory;
import br.com.sistemabiblioteca.model.Biblioteca;
 
public class CrudBiblioteca {

	//method to create a new book

	public static void create() {

		try {

			//Import connection class with database

			Connection conexao = ConnectionFactory.createConnection();

			//Import transition data class database

			Biblioteca biblioteca = new Biblioteca();

			//send data to class library

			biblioteca.setTitulo (JOptionPane.showInputDialog("Insira o título do livro: "));
			biblioteca.setAutor(JOptionPane.showInputDialog("Insira o autor do livro: "));
			biblioteca.setAno_publicacao(Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de publicação do livro: ")));
			biblioteca.setIsbn(JOptionPane.showInputDialog("Insira o ISBN do livro: "));
			biblioteca.setEditora(JOptionPane.showInputDialog("Insira a editora do livro: "));

			String[] generos = {
				"Aventura",
				"Autoajuda",
				"Biografia",
				"Culinária",
				"Didático",
				"Drama",
				"Fantasia",
				"Ficção Científica",
				"História",
				"Infantil",
				"Literatura Clássica",
				"Mistério",
				"Não-Ficção",
				"Outros",
				"Poesia",
				"Romance",
				"Suspense",
				"Terror"
			};
			
			String generoSelecionado = (String) JOptionPane.showInputDialog(null,
					"Selecioneo o gênero do livro: ",
					"Escolha de Gênero: ",
					JOptionPane.QUESTION_MESSAGE,
					null,
					generos,
					generos[0]
					);
			
			biblioteca.setGenero(generoSelecionado);
			
			// criar o SQL para inserir os bancos de dados 
			
			String sql = "INSERT INTO livros( titulo, autor,"
					+ "ano_publicacao, isbn, editora, genero) VALUES (?,?,?,?,?,?);";

			//criando um comando para passar o sql
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, biblioteca.getTitulo());
			cmd.setString(2, biblioteca.getAutor());
			cmd.setInt(3, biblioteca.getAno_publicacao());
			cmd.setString(4, biblioteca.getIsbn());
			cmd.setString(5, biblioteca.getEditora());
			cmd.setString(6, biblioteca.getGenero());
			
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Livro inserido com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
		public static void read() {
			try {
				Connection conexao = ConnectionFactory.createConnection();
				
				Biblioteca biblioteca = new Biblioteca();
				
				String sql = "select * from livros;";
				
				PreparedStatement cmd = conexao.prepareStatement(sql);
				
				ResultSet resultado = cmd.executeQuery();
						
				String livros;
				
				livros = "<< Livros Encontrados >>\n\n";
				
				while(resultado.next()) {
					livros += " ID: " + resultado.getInt("id") + "\n"
					+ " Titulo: " + resultado.getString("titulo") + "\n"
					+ " Autor: " + resultado.getString("autor") + "\n"
					+ " ISBN: " + resultado.getString("isbn") + "\n"
					+ "\n ------------------------------------------- \n";
				}
				
				JOptionPane.showMessageDialog(null, livros);
				cmd.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	

	//method to read all the books


	//method to read one book

	public static void readone() {

		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			Biblioteca biblioteca = new Biblioteca();
			
			biblioteca.setIsbn(JOptionPane.showInputDialog("Entre com ISBN"));
			
			String sql = "select * from livros where isbn = ?;";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			cmd.setString(1, biblioteca.getIsbn());
			
			ResultSet resultado = cmd.executeQuery();
					
			String livros;
			
			livros = "  << Livros Encontrados >>\n\n";
			
			while(resultado.next()) {
				livros += "\n ID: " + resultado.getInt("id")
				+ "\n"
				+ "\n Titulo: " + resultado.getString("titulo")
				+ "\n Autor: " + resultado.getString("autor")
				+ "\n -------------------------------------------"
				+ "\n Editora: " + resultado.getString("editora")
				+ "\n Gênero: " + resultado.getString("genero")
				+ "\n -------------------------------------------"
				+"\n ISBN: " + resultado.getString("isbn");
			}
			
			JOptionPane.showMessageDialog(null, livros);
			cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//method to update the book

	public static void update() {
		
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			Biblioteca biblioteca = new Biblioteca();
			
			biblioteca.setTitulo (JOptionPane.showInputDialog("Insira o título do livro: "));
			biblioteca.setAutor(JOptionPane.showInputDialog("Insira o autor do livro: "));
			biblioteca.setAno_publicacao(Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de publicação do livro: ")));
			biblioteca.setIsbn(JOptionPane.showInputDialog("Insira o ISBN do livro: "));
			biblioteca.setEditora(JOptionPane.showInputDialog("Insira a editora do livro: "));

			String[] generos = {
				"Aventura",
				"Autoajuda",
				"Biografia",
				"Culinária",
				"Didático",
				"Drama",
				"Fantasia",
				"Ficção Científica",
				"História",
				"Infantil",
				"Literatura Clássica",
				"Mistério",
				"Não-Ficção",
				"Outros",
				"Poesia",
				"Romance",
				"Suspense",
				"Terror"
			};
			
			String generoSelecionado = (String) JOptionPane.showInputDialog(null,
					"Selecioneo o gênero do livro: ",
					"Escolha de Gênero: ",
					JOptionPane.QUESTION_MESSAGE,
					null,
					generos,
					generos[0]
					);
			
			biblioteca.setGenero(generoSelecionado);
			
			String sql = "UPDATE livros SET titulo=? ,autor=? ,ano_publicacao=? ,editora=?,"
					+ ",genero=? WHERE isbn=?";
			
			//criando um comando para passar o sql
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, biblioteca.getTitulo());
			cmd.setString(2, biblioteca.getAutor());
			cmd.setInt(3, biblioteca.getAno_publicacao());
			cmd.setString(4, biblioteca.getIsbn());
			cmd.setString(5, biblioteca.getEditora());
			cmd.setString(6, biblioteca.getGenero());
			
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Livro inserido com sucesso!");
			cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		}

	//method to delete the book

	public static void delete() {

	try {
		Connection conexao = ConnectionFactory.createConnection();
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.setIsbn(JOptionPane.showInputDialog("Entre com ISBN so livro: "));
		
		String sql = "delete from livros where isbn = ?";
		
		PreparedStatement cmd = conexao.prepareStatement(sql);
		cmd.setString(1, biblioteca.getIsbn());
		cmd.execute();
		
		JOptionPane.showMessageDialog(null, "Registro deletado com sucesso!");
		
		cmd.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}	

	}


}
 