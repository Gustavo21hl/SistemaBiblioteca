package br.com.sistemabiblioteca.model;
 
public class Biblioteca {
	private Integer id; 
	private String titulo;
	private String autor;
	private Integer ano_publicacao; 
	private String isbn; 
	private String editora;
	private String genero; 
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getAno_publicacao() {
		return ano_publicacao;
	}
	public void setAno_publicacao(Integer ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getId() {
		return id;
	}
}