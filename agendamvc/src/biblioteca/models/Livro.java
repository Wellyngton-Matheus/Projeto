package biblioteca.models;

import java.util.Calendar;




public class Livro {
		private Long id;
	
		private String titulo;
		private String autor;
		private String editora;
		private int edicao;
		private Calendar anoPublicado;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
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
		public String getEditora() {
			return editora;
		}
		public void setEditora(String editora) {
			this.editora = editora;
		}
		public int getEdicao() {
			return edicao;
		}
		public void setEdicao(int edicao) {
			this.edicao = edicao;
		}
		public Calendar getAnoPublicado() {
			return anoPublicado;
		}
		public void setAnoPublicado(Calendar anoPublicado) {
			this.anoPublicado = anoPublicado;
		}
		
}
		
		
