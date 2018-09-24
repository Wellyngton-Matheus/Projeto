package biblioteca.comandos;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.emprestimoDAO;
import biblioteca.daos.alunoDAO;
import biblioteca.daos.livroDAO;
import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;

public class EmprestarLivro implements Comando{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
Emprestimo emprestimo = null;
		
		try {
			emprestimo = new Emprestimo();
			
			long idLivro = Long.parseLong(request.getParameter("livro"));
			Livro livro = new livroDAO().getById(idLivro);
			String matriAluno = request.getParameter("aluno");
			Aluno aluno = new alunoDAO().getMatricula(matriAluno);
			Calendar data = Calendar.getInstance();
			
			emprestimo.setLivro(livro);
			emprestimo.setAluno(aluno);
			emprestimo.setDataEmp(data);
		
			
			if (new emprestimoDAO().inserir(emprestimo)) {
				request.setAttribute
				("message", "Emprestimo para " + aluno.getNome() + " realisado com sucesso!");
			}else {
				request.setAttribute
				("message", "Sinto muito. O empréstimo não pôde ser relisado.");
			}
		} catch (Exception e) {
			request.setAttribute
			("message", "Sinto muito. Um erro inesperado ocorreu ao emprestar livro.");
		}
			
		return null;
	}

	}
	
