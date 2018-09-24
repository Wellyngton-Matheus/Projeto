package biblioteca.comandos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.emprestimoDAO;
import biblioteca.daos.livroDAO;
import biblioteca.models.Livro;

public class Devolucao implements Comando {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		Livro livro = new livroDAO().getById(id);

		try {
			if (new emprestimoDAO().removerLivro(livro)) {
				request.setAttribute("O livro" + livro.getTitulo() + " foi devolvido", livro);
			} else {
				request.setAttribute("O livro" + livro.getTitulo() + " não pode ser devolvido.", livro);
			}
		} catch (Exception e) {
			request.setAttribute("null", "Desculpe. Ocorreu um problema ao devolver o livro.");
		}
		return null;
	}
}
