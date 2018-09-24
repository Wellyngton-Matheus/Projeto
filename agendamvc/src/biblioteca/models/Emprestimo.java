package biblioteca.models;

import java.util.Calendar;

public class Emprestimo {

	public final static int QNTD_LIVRO = 3;
	public final static int DURACAO = 14;
	
	
	private Calendar dataEmp;
	private Calendar dataDev;
	private Livro livro;  
	private Aluno aluno;	
	private boolean status;
	public Calendar getDataEmp() {
		return dataEmp;
	}
	public void setDataEmp(Calendar dataEmp) {
		this.dataEmp = dataEmp;
	}
	public Calendar getDataDev() {
		return dataDev;
	}
	public void setDataDev(Calendar dataDev) {
		this.dataDev = dataDev;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
