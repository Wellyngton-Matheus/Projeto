package biblioteca.comandos;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.livroDAO;
import biblioteca.models.Livro;

public class BuscarLivro implements Comando {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		livroDAO dao = new livroDAO();
		List<Livro> livro = dao.getLista();
		
		
		
		request.setAttribute("livros", livro);
		
		return "lista.jsp";
		
	}

}
