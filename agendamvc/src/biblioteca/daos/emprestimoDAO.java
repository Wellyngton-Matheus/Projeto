package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;

public class emprestimoDAO {


		private Connection connection;

		public emprestimoDAO() {
			connection = ConnectionFactory.getConnection();
		}

		public boolean inserir(Emprestimo emprestimo) {

			String sql = "insert into emprestimo (aluno, livro, dataEmp) values (?, ?, ?);";

			try {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setLong(1, emprestimo.getAluno().getId());
				stmt.setLong(2, emprestimo.getLivro().getId());
				

				stmt.setDate(3, new java.sql.Date(emprestimo.getDataEmp().getTimeInMillis()));

				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}

			return true;
		}

		public List<Emprestimo> getLista() {
			List<Emprestimo> result = new ArrayList<>();

			try {
				PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo;");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					
					Emprestimo emprestimo = new Emprestimo();
					
					
					Aluno aluno = new Aluno();
					aluno.setId(rs.getLong("aluno"));
					
					Livro livro = new livroDAO().getById(rs.getLong("livro"));
					emprestimo.setAluno(aluno);
					emprestimo.setLivro(livro);
					
					Calendar dataEmp = Calendar.getInstance();
					dataEmp.setTime(rs.getDate("dataEmp"));
					emprestimo.setDataEmp(dataEmp);

					Calendar dataDev = null;
					dataDev = (Calendar) dataEmp.clone();
					dataDev.add(Calendar.DAY_OF_MONTH , Emprestimo.DURACAO);
					
					emprestimo.setDataEmp(dataEmp);
					emprestimo.setDataDev(dataDev);

					
					result.add(emprestimo);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return result;
		}

		public boolean alterar(Emprestimo emprestimo) {
			String sql = "insert into emprestimo (aluno, livro, dataEmp) values (?, ?, ?);";			
			
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setLong(1, emprestimo.getAluno().getId());
				stmt.setLong(2, emprestimo.getLivro().getId());
				stmt.setDate(4, new java.sql.Date(emprestimo.getDataEmp().getTimeInMillis()));

				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public boolean remover(Emprestimo emprestimo) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from aluno where id=?;");
				stmt.setLong(1, emprestimo.getLivro().getId());
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public boolean removerLivro(Livro livro) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where livro=?");
				stmt.setLong(1, livro.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

	}
