package biblioteca.comandos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.livroDAO;
import biblioteca.models.Livro;

public class InserirLivro implements Comando {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		int edicao = Integer.parseInt(request.getParameter("edicao"));
		String dataEmTexto = request.getParameter("anoPublicado");
		
		Calendar data = null;
		try {
			Date dataProvisoria = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			data = Calendar.getInstance();
			data.setTime(dataProvisoria);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setEdicao(edicao);
		livro.setAnoPublicado(data);
		
		livroDAO dao = new livroDAO();
		dao.inserir(livro);
		
		return "livro-adicionado.jsp";
		
	}

}
