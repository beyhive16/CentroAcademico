package br.com.cacomp.domain;
public class Administradores {
	private int codigo;
	private String nome;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString(){
		String saida = codigo + " - " + nome;
		return super.toString();
	}
}
